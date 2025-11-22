
---

## 🔍 5) Comparing Changes

**View differences**

| Command | Purpose | Example |
|---------|---------|---------|
| `git diff` | Show unstaged changes | `git diff` |
| `git diff --staged` | Show staged changes | `git diff --staged` |
| `git diff <branch1> <branch2>` | Compare branches | `git diff main dev` |
| `git diff <branch1>..<branch2>` | Range comparison | `git diff main..feature` |
| `git diff <commit1> <commit2>` | Compare commits | `git diff a73bb2 c94d56` |
| `git diff <file>` | File changes | `git diff index.js` |

---

## 📦 6) Stashing

**Temporarily save work**

| Command | Purpose | Example |
|---------|---------|---------|
| `git stash` | Save changes | `git stash` |
| `git stash save "message"` | Stash with message | `git stash save "WIP: UI work"` |
| `git stash list` | List stashes | `git stash list` |
| `git stash apply` | Apply latest stash | `git stash apply` |
| `git stash apply stash@{0}` | Apply specific | `git stash apply stash@{0}` |
| `git stash pop` | Apply & delete | `git stash pop` |
| `git stash drop` | Delete latest | `git stash drop` |
| `git stash drop stash@{0}` | Delete specific | `git stash drop stash@{0}` |
| `git stash clear` | Delete all | `git stash clear` |
| `git stash branch <name>` | Create branch from stash | `git stash branch bug-fix` |

**🎯 Stash Workflow:**
