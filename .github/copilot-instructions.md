<!-- Use this file to provide workspace-specific custom instructions to Copilot. For more details, visit https://code.visualstudio.com/docs/copilot/copilot-customization#_use-a-githubcopilotinstructionsmd-file -->


# Copilot Instructions for DeskPlanIt Monorepo

## Project Structure
- `backend/`: Java Spring Boot (API, authentication, business logic)
- `frontend/`: Vue 3 (Vite) app (UI, state management, API calls)
- `.github/`: CI/CD workflows, Copilot instructions

## Coding Guidelines
- **Respect the monorepo structure**: Backend and frontend are separate but share API contracts and documentation.
- **Backend**: Use Java 21, Spring Boot 3+, JPA/Hibernate, H2 (demo) or PostgreSQL/MySQL (prod), Spring Security (form login, HTTP Basic, LDAP/AD ready), RESTful endpoints, OpenAPI docs.
- **Frontend**: Use Vue 3, Pinia, Vue Router, Bootstrap, Axios. All API calls should use `withCredentials: true` for authentication.
- **Authentication**: Enforce role-based access (ADMIN, USER, etc.) in both backend (Spring Security) and frontend (UI controls, route guards).
- **Map Upload/Seating**: Support SVG/PNG/PDF uploads, interactive map viewer, drag-and-drop seat placement, seat assignment, and persistence.
- **Booking**: Support CRUD for desk/room bookings, with user/seat/time relationships.
- **User Management**: CRUD endpoints, role assignment, and AD/LDAP integration ready.
- **Error Handling**: Show user-friendly error messages in the UI. Use proper HTTP status codes in the backend.
- **Documentation**: Keep `README.md`, `DESIGN.md`, and `PROJECT_INFO.md` up to date. Use code comments and Javadoc where appropriate.
- **Testing**: Write unit/integration tests for backend and frontend where possible.

## Feature Priorities
1. Map upload, interactive map, seat placement, and assignment
2. User authentication and role-based access
3. Booking system (desk/room)
4. Admin tools, analytics, visitor management
5. Calendar integration, notifications, mobile/PWA support

## Style
- Use clear, modern, and maintainable code.
- Prefer composition and modularity (Vue components, Spring services/repositories).
- Use async/await for frontend API calls.
- Use DTOs for backend API responses if needed.

---

See `README.md`, `DESIGN.md`, and `PROJECT_INFO.md` for more details and always follow the latest project requirements.
