
---

## 🌳 3) Branches

**Create and manage branches**

| Command | Purpose | Example | When to Use |
|---------|---------|---------|------------|
| `git branch` | List branches | `git branch` | See all branches |
| `git branch <name>` | Create branch | `git branch feature-auth` | Start new feature |
| `git switch <name>` | Switch branch | `git switch dev` | Change branch |
| `git switch -c <name>` | Create & switch | `git switch -c feature-login` | Shortcut |
| `git checkout <name>` | Switch (old) | `git checkout main` | Legacy command |
| `git branch -m <old> <new>` | Rename branch | `git branch -m dev development` | Rename |
| `git branch -d <name>` | Delete branch (safe) | `git branch -d feature-auth` | After merge |
| `git branch -D <name>` | Force delete | `git branch -D experimental` | Delete without merge |
| `git merge <name>` | Merge branch | `git merge feature-auth` | Combine branches |

**🌿 Branch Workflow:**
