
---

## 🔧 Common Mistakes & Fixes

| Problem | Solution |
|---------|----------|
| Committed to wrong branch | `git reset --soft HEAD~1` then `git stash` |
| Forgot to stage files | `git add .` then `git commit --amend` |
| Want to undo last commit | `git reset --soft HEAD~1` |
| Lost commits | `git reflog` to find, then `git reset --hard <hash>` |
| Merge conflicts | Edit files, `git add .`, then `git commit` |
| Wrong commit message | `git commit --amend -m "New message"` |

---

## 📚 Resources

- [Official Git Documentation](https://git-scm.com/doc)
- [GitHub Docs](https://docs.github.com)
- [Interactive Git Learning](https://learngitbranching.js.org/)
- [GitHub Training Kit](https://github.github.com/training-kit/)


---

**Last Updated:** November 2025
