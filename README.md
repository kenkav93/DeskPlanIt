# DeskPlanIt

DeskPlanIt is a robust, in-house workplace management platform for interactive office maps, desk/room booking, analytics, and visitor management, designed to replace Robin and similar tools.

## Project Structure
- `frontend/` — Vue 3 (Vite) app for the user interface
- `backend/` — Java Spring Boot app for API, authentication, and business logic
- `.github/` — CI/CD workflows and Copilot instructions

## Key Features
- **Custom Map Uploads:** Upload and manage office floor plans (SVG, PNG, PDF)
- **Interactive Maps:** Drag-and-drop seat/room placement, clickable for booking/info
- **Desk & Room Booking:** Hot desking, assigned seating, recurring bookings, check-in/out
- **Calendar Integration:** Sync with Outlook/Google, show external events
- **Visitor Management:** Pre-registration, check-in, host notification, visitor log
- **Workplace Analytics:** Utilization, trends, exportable reports
- **Admin Tools:** Map/seat/room editor, user/role management, policy config
- **Role-Based Access:** Admin, manager, employee, visitor roles
- **Mobile & Web:** Responsive design, PWA support

## Integrations
- **Active Directory/LDAP:** Authentication and user sync
- **CI/CD:** GitHub Actions for linting, testing, building, and deployment
- **Calendar APIs:** Microsoft Graph, Google Calendar
- **Notifications:** Email, Teams, Slack

## Roadmap
1. **MVP:** Map upload, interactive map, desk/room booking, basic auth, admin UI
2. **Core Integrations:** Calendar sync, visitor management, analytics dashboard
3. **Advanced:** Mobile PWA, notifications, policy/workflow automation

## Advanced/Optional
- SAML/OAuth2 support
- Facilities management integration

---

See `PROJECT_INFO.md` and `frontend/DESIGN.md` for more details and technical architecture.
