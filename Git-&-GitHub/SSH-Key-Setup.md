
---

## 🔐 9) SSH Key Setup

**Secure authentication without passwords**

| Step | Command | Purpose |
|------|---------|---------|
| 1️⃣ | `ssh-keygen -t ed25519 -C "your@email.com"` | Generate SSH key |
| 2️⃣ | Press Enter | Save to default location |
| 3️⃣ | `eval "$(ssh-agent -s)"` | Start SSH agent |
| 4️⃣ | `ssh-add ~/.ssh/id_ed25519` | Add key to agent |
| 5️⃣ | `cat ~/.ssh/id_ed25519.pub` | Display public key |
| 6️⃣ | Copy to GitHub → Settings → SSH Keys | Add to GitHub |
| 7️⃣ | `ssh -T git@github.com` | Test connection |

**🔑 Complete Setup:**
