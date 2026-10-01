param(
    [Parameter(Mandatory=$true)]
    [string]$Chapter,          # e.g. "04" or "ch04"

    [Parameter(Mandatory=$true)]
    [string]$Description,       # e.g. "function arguments"

    [switch]$WhatIf
)

# Normalize chapter argument to "chNN" form
$Chapter = $Chapter -replace '^ch', ''
$Branch   = "ch$Chapter"
$Tag      = "ch${Chapter}-done"
$MergeMsg = "merge ${Branch}: $Description"
$TagMsg   = "Chapter $([int]$Chapter) complete"

function Invoke-Git {
    param([Parameter(ValueFromRemainingArguments=$true)] [string[]]$Args)
    if ($script:WhatIf) {
        Write-Host "DRY RUN: git $($Args -join ' ')"
    } else {
        & git @Args
    }
}

# Sanity: are we on the expected branch?
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

$readmeDirty = git status --porcelain README.md
if (-not $readmeDirty) {
    Write-Error "README.md is not modified. Edit it before running this script."
    exit 1
}

$dirty = git status --porcelain
$dirtyFiles = $dirty | Where-Object { $_ -notmatch 'README\.md$' }
if ($dirtyFiles) {
    Write-Error "Working tree has changes other than README.md:"
    $dirtyFiles | ForEach-Object { Write-Host "  $_" }
    exit 1
}

# 1. README tick
# Edit README.md: chNN -> [x], save.
Invoke-Git status
Invoke-Git commit -am "${Branch}: mark complete in README"

# 2. Rebase onto main (no-op habit)
Invoke-Git checkout main
Invoke-Git checkout $Branch
Invoke-Git rebase main

# 3. Merge
Invoke-Git checkout main
Invoke-Git merge --no-ff $Branch -m $MergeMsg

# 4. Tag
Invoke-Git tag -a $Tag -m $TagMsg

# 5. Verify
Invoke-Git log --graph --oneline --decorate --all

# 6. Push
Invoke-Git push origin main
Invoke-Git push origin $Tag