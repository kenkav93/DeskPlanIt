## Usage Notes (MVP)

- **Map Upload:** Use the Maps page to upload an SVG/PNG/PDF map. SVG is recommended for best interactivity.
- **Interactive Map:** Use the Seating page to view the map and place seats. Drag, label, assign, and remove seats. All seat data is persisted in local storage for demo purposes.
- **Seat Assignment:** Click the 👤 button on a seat to assign a user. Click ✎ to edit the label, × to remove.
- **Persistence:** Seat positions and assignments are saved locally. Backend API integration is ready for future expansion.
# DeskPlanIt — Design & Architecture (2025-06-05)

## Purpose
DeskPlanIt is an in-house workplace management platform for interactive office maps, desk/room booking, analytics, and visitor management, designed to replace Robin and similar tools.

## High-Level Architecture
- **Frontend:** Vue 3, Vue Router, Pinia, Bootstrap, Axios
- **Backend:** Java Spring Boot, JPA, Spring Security (LDAP/AD), REST API, OpenAPI docs
- **Monorepo:** Shared documentation, CI/CD, and code standards

## Core Modules & UI
1. **Interactive Map Management**
   - Map upload (SVG/PNG/PDF)
   - Map viewer with drag-and-drop seat/room placement
   - Clickable desks/rooms for booking/info
2. **Desk & Room Booking**
   - Calendar view and map-based booking
   - Hot desking, assigned seating, recurring bookings
   - Booking rules and check-in/check-out
3. **Calendar Integration**
   - Sync with Outlook/Google
   - Show external events
4. **Visitor Management**
   - Pre-registration, check-in, host notification
   - Visitor log
5. **Analytics Dashboard**
   - Utilization, trends, exportable reports
6. **Admin Tools**
   - Map/seat/room editor, user/role management, policy config

## UI/UX Principles
- Responsive (desktop/mobile)
- Accessible (WCAG 2.1)
- Modular, reusable components
- Clear navigation and feedback

## Component Structure
- `Header`, `Sidebar`, `Footer`
- `MapUploader`, `MapViewer`, `SeatGrid`, `RoomGrid`
- `BookingCalendar`, `BookingForm`, `UserList`, `VisitorForm`, `AnalyticsDashboard`

## Data Flow
- Pinia for state (maps, bookings, users)
- Axios for API calls
- Route guards for authentication/roles

---

See `PROJECT_INFO.md` for feature breakdown and roadmap.
