import { defineStore } from 'pinia';

export const useAnalyticsStore = defineStore('analytics', {
  state: () => ({
    utilization: [],
    trends: [],
  }),
  actions: {
    setUtilization(data) {
      this.utilization = data;
    },
    setTrends(data) {
      this.trends = data;
    },
  },
});
