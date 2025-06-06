# DeskPlanIt — Project Information

## Overview
DeskPlanIt is a monorepo application for managing office seating charts, integrating with Active Directory, and providing a modern, user-friendly interface for administrators and employees.

## Features
- **Custom Map Uploads:** Upload office floor plans (SVG, PNG, etc.)
- **Seating Placement:** Drag-and-drop UI for assigning seats
- **Active Directory Integration:** SSO and user sync
- **User Management:** Assign, move, and search users/seats
- **Audit Logs:** Track changes to seating assignments
- **Export/Import:** Download/upload seating charts (CSV, PDF)
- **Notifications:** Email or Teams/Slack integration for seat changes
- **API Documentation:** Swagger/OpenAPI for backend
- **Role-based Access Control:** Admin, manager, user roles

## Integrations
- **CI/CD:** GitHub Actions for linting, testing, building, and deployment
- **Pre-commit Hooks:** Lint, format, and test before commit
- **Dependabot:** Automated dependency updates

## Advanced/Optional
- SAML/OAuth2 support
- Analytics dashboard
- Facilities management integration
- Mobile-friendly UI

## Monorepo Structure
```
DeskPlanIt/
├── backend/      # Java Spring Boot API
├── frontend/     # Vue 3 (Vite) UI
├── .github/      # Workflows, Copilot instructions
├── README.md
└── PROJECT_INFO.md
```

## Getting Started
- See `README.md` for setup instructions.
- Each subproject contains its own setup and documentation.
