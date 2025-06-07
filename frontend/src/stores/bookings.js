import { defineStore } from 'pinia';

export const useBookingsStore = defineStore('bookings', {
  state: () => ({
    bookings: [],
  }),
  actions: {
    setBookings(bookings) {
      this.bookings = bookings;
    },
  },
});
