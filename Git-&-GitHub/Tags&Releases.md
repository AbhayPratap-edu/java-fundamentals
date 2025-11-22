
---

## 🏷️ 7) Tags & Releases

**Mark important commits**

| Command | Purpose | Example |
|---------|---------|---------|
| `git tag` | List tags | `git tag` |
| `git tag <name>` | Create lightweight tag | `git tag v1.0` |
| `git tag -a <name> -m "msg"` | Create annotated tag | `git tag -a v1.0 -m "Release 1.0"` |
| `git tag <name> <commit>` | Tag specific commit | `git tag v2.0 a7cb9e` |
| `git tag -d <name>` | Delete local tag | `git tag -d v1.0` |
| `git push origin <tag>` | Push tag | `git push origin v1.0` |
| `git push origin :<tag>` | Delete remote tag | `git push origin :v1.0` |
| `git push origin --tags` | Push all tags | `git push origin --tags` |

**📌 Release Workflow:**
