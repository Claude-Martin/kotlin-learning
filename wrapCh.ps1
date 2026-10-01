# 1. README tick
# Edit README.md: ch04 -> [x] (or add a note), save.
git status
git commit -am "ch04: mark complete in README"

# 2. Rebase onto main (no-op habit)
git checkout main
git checkout ch04
git rebase main

# 3. Merge
git checkout main
git merge --no-ff ch04 -m "merge ch04: function arguments"

# 4. Tag
git tag -a ch04-done -m "Chapter 4 complete"

# 5. Verify
git log --graph --oneline --decorate --all

# 6. Push
git push origin main
git push origin ch04-done