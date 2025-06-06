# DeskPlanIt

A monorepo seating chart system for managing office desk assignments.

## Project Structure
- `frontend/` — Vue 3 (Vite) app for the user interface
- `backend/` — Java Spring Boot app for API, authentication, and business logic
- `.github/` — CI/CD workflows and Copilot instructions

## Key Features
- Custom map uploads (SVG, PNG, etc.)
- Drag-and-drop seating placement
- Active Directory integration (SSO, user sync)
- User management (assign, move, search)
- Audit logs for seat changes
- Export/import seating charts (CSV, PDF)
- Notifications (email, Teams/Slack)
- API documentation (Swagger/OpenAPI)
- Role-based access control

## Integrations
- GitHub Actions for CI/CD (lint, test, build, deploy)
- Pre-commit hooks
- Dependabot for dependency updates

## Advanced/Optional
- SAML/OAuth2 support
- Analytics dashboard
- Facilities management integration
- Mobile-friendly UI

---

See `PROJECT_INFO.md` for more details.
