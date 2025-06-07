import { defineStore } from 'pinia';

export const useVisitorsStore = defineStore('visitors', {
  state: () => ({
    visitors: [],
  }),
  actions: {
    setVisitors(visitors) {
      this.visitors = visitors;
    },
  },
});
