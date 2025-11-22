
---

## 🌐 8) Remote Repositories

**Connect and sync with GitHub**

| Command | Purpose | Example |
|---------|---------|---------|
| `git remote` | List remotes | `git remote` |
| `git remote -v` | List with URLs | `git remote -v` |
| `git remote add <name> <url>` | Add remote | `git remote add origin https://github.com/user/repo.git` |
| `git remote set-url <name> <url>` | Change URL | `git remote set-url origin git@github.com:user/repo.git` |
| `git remote remove <name>` | Remove remote | `git remote remove origin` |
| `git push origin <branch>` | Push branch | `git push origin main` |
| `git push -u origin <branch>` | Push & track | `git push -u origin dev` |
| `git push --all` | Push all branches | `git push --all` |
| `git fetch <remote>` | Download data | `git fetch origin` |
| `git pull <remote> <branch>` | Fetch & merge | `git pull origin main` |
| `git pull --rebase <remote>` | Pull with rebase | `git pull --rebase origin main` |
| `git remote add upstream <url>` | Add upstream | `git remote add upstream https://github.com/org/repo.git` |

**🔄 Collaboration Workflow:**
