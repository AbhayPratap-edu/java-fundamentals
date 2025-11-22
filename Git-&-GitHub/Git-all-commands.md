# Git & GitHub Commands Cheat Sheet

This document organizes Git and GitHub commands category-wise for easy reference.

---

## 1) Basic Git Beginning Commands

| Command / Instruction | Description / Use | Example / Demonstration |
|---|---|---|
| `git --version` | Show installed Git version | `git --version` |
| `git status` | Show current repository state | `git status` |
| `git config --global user.email "email"` | Set global email for commits | `git config --global user.email "test@mail.com"` |
| `git config --global user.name "name"` | Set global username for commits | `git config --global user.name "John Doe"` |
| `git config --list` | Show configuration values | `git config --list` |
| `git init` | Initialize a Git repo | `git init` |
| `git add <file>` | Stage specific files | `git add index.html` |
| `git add .` | Stage all changes | `git add .` |
| `git rm --cached <file>` | Unstage a file | `git rm --cached app.js` |
| `git commit -m "message"` | Commit staged changes | `git commit -m "Initial commit"` |
| `git log` | Show commit history | `git log` |
| `git log --oneline` | Compact commit history | `git log --oneline` |
| `git config --global core.editor "code --wait"` | Set VS Code as default Git editor | `git config --global core.editor "code --wait"` |
| `.gitignore` | List files for Git to ignore | Add `node_modules/` |
| `.gitkeep` | Keep empty folders under Git | Create `.gitkeep` inside folder |

---

## 2) Branch Commands

| Command / Instruction | Description / Use | Example / Demonstration |
|---|---|---|
| `git branch` | List branches | `git branch` |
| `git branch <branch-name>` | Create a branch | `git branch dev` |
| `git switch <branch-name>` | Switch to a branch | `git switch dev` |
| `git switch -c <branch-name>` | Create and switch to a branch | `git switch -c feature-login` |
| `git checkout <branch-name>` | Old command to switch branches | `git checkout main` |
| `git merge <branch-name>` | Merge branch into current | `git merge dev` |
| `git branch -m <old> <new>` | Rename a branch | `git branch -m dev feature-backend` |
| `git branch -d <branch-name>` | Delete a branch | `git branch -d dev` |

---

## 3) Commands to Show Differences

| Command | Description / Use | Example / Demonstration |
|---|---|---|
| `git diff --staged` | Show staged diff | `git diff --staged` |
| `git diff <branch1> <branch2>` | Compare branches | `git diff main dev` |
| `git diff branch1..branch2` | Compare branches using range | `git diff feature-x..main` |
| `git diff <commit1>..<commit2>` | Compare two commits | `git diff a73bb2..c94d56` |

---

## 4) Git Stash Commands

| Command | Description / Use | Example / Demonstration |
|---|---|---|
| `git stash` | Save current changes | `git stash` |
| `git stash save "msg"` | Stash with message | `git stash save "half UI work"` |
| `git stash list` | List stash entries | `git stash list` |
| `git stash apply` | Apply latest stash | `git stash apply` |
| `git stash apply stash@{0}` | Apply specific stash | `git stash apply stash@{0}` |
| `git stash pop` | Apply and drop stash | `git stash pop` |
| `git stash drop` | Delete latest stash | `git stash drop` |
| `git stash apply stash@{0} <branch>` | Apply stash to a branch | `git stash apply stash@{0} dev` |
| `git stash clear` | Remove all stashes | `git stash clear` |

---

## 5) Git Tag Commands

| Command | Description / Use | Example / Demonstration |
|---|---|---|
| `git tag` | Show tags | `git tag` |
| `git tag <tag>` | Create lightweight tag | `git tag v1.0` |
| `git tag -a <tag> -m "message"` | Create annotated tag | `git tag -a v1.0 -m "Release 1.0"` |
| `git tag <tag> <commit>` | Tag specific commit | `git tag v2.0 a7cb9e` |
| `git push origin <tag>` | Push tag to remote | `git push origin v1.0` |
| `git tag -d <tag>` | Delete local tag | `git tag -d v1.0` |
| `git push origin :<tag>` | Delete remote tag | `git push origin :v1.0` |

---

## 6) Branch Rebase Commands

| Command | Description / Use | Example / Demonstration |
|---|---|---|
| `git checkout feature-branch` | Switch to branch | `git checkout feature-auth` |
| `git rebase main` | Rebase onto main | `git rebase main` |
| `git rebase <branch>` | Rebase onto another branch | `git rebase dev` |
| `git rebase --continue` | Continue after conflict resolution | `git rebase --continue` |

---

## 7) SSH Key Generation & Setup

| Command / Instruction | Description / Use | Example / Demonstration |
|---|---|---|
| `ssh-keygen -t ed25519 -C "email"` | Generate SSH key | `ssh-keygen -t ed25519 -C "me@mail.com"` |
| Press Enter | Save to default path | `/home/user/.ssh/id_ed25519` |
| `eval "$(ssh-agent -s)"` | Start SSH agent | |
| `ssh-add ~/.ssh/id_ed25519` | Add SSH key to agent | |
| `cat ~/.ssh/id_ed25519.pub` | Copy public key for GitHub | |

---

## 8) Remote Repository Commands

| Command | Description / Use | Example / Demonstration |
|---|---|---|
| `git remote -v` | Show remotes | `git remote -v` |
| `git remote add origin <url>` | Add a remote repo | `git remote add origin https://github.com/user/repo.git` |
| `git remote set-url origin <url>` | Change remote origin | `git remote set-url origin git@github.com:user/repo.git` |
| `git push origin <branch>` | Push branch to remote | `git push origin dev` |
| `git push -u origin main` | Push & track main | `git push -u origin main` |
| `git fetch <remote>` | Download remote data | `git fetch origin` |
| `git pull <remote> <branch>` | Pull from remote | `git pull origin main` |
| `git pull --rebase origin main` | Pull using rebase | `git pull --rebase origin main` |
| `git remote add upstream <url>` | Add upstream remote | `git remote add upstream https://github.com/org/repo.git` |
| `git clone <url>` | Clone repository | `git clone https://github.com/user/repo.git` |

---

## 9) Extra Useful Commands

| Command | Description / Use | Example / Demonstration |
|---|---|---|
| `git reset HEAD <file>` | Unstage a file | `git reset HEAD index.js` |
| `git restore <file>` | Remove local changes | `git restore index.js` |
| `git restore --staged <file>` | Unstage cleanly | `git restore --staged index.js` |
| `git clean -fd` | Remove untracked files/folders | `git clean -fd` |

---

### End of Cheat Sheet
