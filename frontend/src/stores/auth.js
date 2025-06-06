import { defineStore } from 'pinia';

export const useAuthStore = defineStore('auth', {
  state: () => ({
    user: null,
    token: null,
    loading: false,
    error: null,
  }),
  actions: {
    async login(username, password) {
      this.loading = true;
      this.error = null;
      try {
        // Replace with your backend login API
        // const response = await axios.post('/api/auth/login', { username, password });
        // this.user = response.data.user;
        // this.token = response.data.token;
        // For now, mock login:
        this.user = { username };
        this.token = 'mock-token';
      } catch (e) {
        this.error = 'Login failed';
      } finally {
        this.loading = false;
      }
    },
    logout() {
      this.user = null;
      this.token = null;
    },
  },
});
