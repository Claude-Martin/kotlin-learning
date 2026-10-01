param(
    [Parameter(Mandatory=$true)]
    [string]$Chapter,

    [Parameter(Mandatory=$true)]
    [string]$Description
)

$Chapter = $Chapter -replace '^ch', ''
$Branch   = "ch$Chapter"
$Tag      = "ch${Chapter}-done"
$MergeMsg = "merge ${Branch}: $Description"
$TagMsg   = "Chapter $([int]$Chapter) complete"

# Guards
$current = (git rev-parse --abbrev-ref HEAD).Trim()
if ($current -ne $Branch) {
    Write-Error "Expected to be on '$Branch', but currently on '$current'. Aborting."
    exit 1
}

$tagExists = git tag -l $Tag | Out-String
if ($tagExists.Trim()) {
    Write-Error "Tag $Tag already exists. Chapter already wrapped?"
    exit 1
}

$dirtyFiles = git status --porcelain | Where-Object { $_ -notmatch 'README\.md$' }
if ($dirtyFiles) {
    Write-Error "Working tree has changes other than README.md:"
    $dirtyFiles | ForEach-Object { Write-Host "  $_" }
    exit 1
}

$readmeDirty = git status --porcelain README.md
if (-not $readmeDirty) {
    Write-Error "README.md is not modified. Edit it before running this script."
    exit 1
}

# Wrap
git status
git commit -am "${Branch}: mark complete in README"

git checkout main
git checkout $Branch
git rebase main

git checkout main
git merge --no-ff $Branch -m $MergeMsg

git tag -a $Tag -m $TagMsg

git log --graph --oneline --decorate --all

git push origin main
git push origin $Tag
