import { createRouter, createWebHistory } from 'vue-router';

import Dashboard from './pages/Dashboard.vue';
import Maps from './pages/Maps.vue';
import Seating from './pages/Seating.vue';
import Users from './pages/Users.vue';
import Login from './pages/Login.vue';

const routes = [
  { path: '/', name: 'Dashboard', component: Dashboard },
  { path: '/maps', name: 'Maps', component: Maps },
  { path: '/seating', name: 'Seating', component: Seating },
  { path: '/users', name: 'Users', component: Users },
  { path: '/login', name: 'Login', component: Login },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
