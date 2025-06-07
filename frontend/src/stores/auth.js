import { defineStore } from 'pinia';
import axios from 'axios';

export const useAuthStore = defineStore('auth', {
  state: () => ({
    user: null,
    role: null,
    loading: false,
    error: null,
  }),
  actions: {
    async login(username, password) {
      this.loading = true;
      this.error = null;
      try {
        await axios.post('/login', new URLSearchParams({ username, password }), {
          headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
          withCredentials: true,
        });
        // Fetch user info/role after login
        const { data } = await axios.get('/api/users', { withCredentials: true });
        const found = data.find(u => u.username === username);
        this.user = found || { username };
        this.role = found?.role || null;
      } catch (e) {
        this.error = 'Login failed';
      } finally {
        this.loading = false;
      }
    },
    async logout() {
      await axios.post('/logout', {}, { withCredentials: true });
      this.user = null;
      this.role = null;
    },
  },
});
