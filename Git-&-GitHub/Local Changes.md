

---

## 📝 2) Local Changes

**Work with files in your repository**

| Command | Purpose | Example | Use Case |
|---------|---------|---------|----------|
| `git status` | Show repository state | `git status` | Check what changed |
| `git add <file>` | Stage specific file | `git add index.html` | Stage one file |
| `git add .` | Stage all changes | `git add .` | Stage everything |
| `git add -A` | Stage all (including deletions) | `git add -A` | Full stage |
| `git rm --cached <file>` | Unstage file | `git rm --cached app.js` | Remove from staging |
| `git restore <file>` | Discard local changes | `git restore index.js` | Undo changes |
| `git restore --staged <file>` | Unstage file | `git restore --staged index.js` | Modern unstage |
| `git reset HEAD <file>` | Unstage (older method) | `git reset HEAD index.js` | Legacy unstage |
| `git clean -fd` | Remove untracked files | `git clean -fd` | Clean directory |
| `git commit -m "message"` | Commit changes | `git commit -m "Add feature"` | Create commit |
| `git commit --amend` | Modify last commit | `git commit --amend` | Fix last commit |

**📦 .gitignore Example:**
