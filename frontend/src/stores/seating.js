import { defineStore } from 'pinia';

export const useSeatingStore = defineStore('seating', {
  state: () => ({
    seats: [],
    assignments: {},
  }),
  actions: {
    setSeats(seats) {
      this.seats = seats;
    },
    addSeat({ x, y }) {
      const id = Date.now() + Math.random();
      const label = String.fromCharCode(65 + this.seats.length); // A, B, C, ...
      this.seats.push({ id, x, y, label, assignedUser: '' });
      this.saveSeats();
    },
    moveSeat(id, x, y) {
      const seat = this.seats.find(s => s.id === id);
      if (seat) {
        seat.x = x;
        seat.y = y;
        this.saveSeats();
      }
    },
    removeSeat(id) {
      this.seats = this.seats.filter(s => s.id !== id);
      this.saveSeats();
    },
    editSeatLabel(id, label) {
      const seat = this.seats.find(s => s.id === id);
      if (seat) {
        seat.label = label;
        this.saveSeats();
      }
    },
    assignUser(id, user) {
      const seat = this.seats.find(s => s.id === id);
      if (seat) {
        seat.assignedUser = user;
        this.saveSeats();
      }
    },
    saveSeats() {
      localStorage.setItem('deskplanit-seats', JSON.stringify(this.seats));
    },
    loadSeats() {
      const data = localStorage.getItem('deskplanit-seats');
      if (data) {
        this.seats = JSON.parse(data);
      }
    },
    setAssignments(assignments) {
      this.assignments = assignments;
    },
  },
});
