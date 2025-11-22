
---

## ⚡ 10) Advanced Operations

**Power-user commands**

| Command | Purpose | Example | Risk |
|---------|---------|---------|------|
| `git reset --soft HEAD~1` | Undo commit (keep changes) | `git reset --soft HEAD~1` | 🟡 Medium |
| `git reset --mixed HEAD~1` | Undo & unstage | `git reset --mixed HEAD~1` | 🟡 Medium |
| `git reset --hard HEAD~1` | Undo & delete changes | `git reset --hard HEAD~1` | 🔴 High |
| `git revert <commit>` | Create undo commit | `git revert a73bb2` | 🟢 Safe |
| `git cherry-pick <commit>` | Copy commit | `git cherry-pick a73bb2` | 🟡 Medium |
| `git rebase <branch>` | Rebase branch | `git rebase main` | 🟡 Medium |
| `git rebase --continue` | Continue rebase | After resolving conflicts | 🟡 Medium |
| `git reflog` | Show all changes | `git reflog` | 🟢 Safe |

---

## 🎯 Quick Reference

### Daily Workflow
