import { createRouter, createWebHistory } from 'vue-router';

import Dashboard from './pages/Dashboard.vue';
import Maps from './pages/Maps.vue';
import Seating from './pages/Seating.vue';
import Users from './pages/Users.vue';
import Login from './pages/Login.vue';
import Analytics from './pages/Analytics.vue';
import Visitors from './pages/Visitors.vue';
import Admin from './pages/Admin.vue';

const routes = [
  { path: '/', name: 'Dashboard', component: Dashboard },
  { path: '/maps', name: 'Maps', component: Maps },
  { path: '/seating', name: 'Seating', component: Seating },
  { path: '/users', name: 'Users', component: Users },
  { path: '/analytics', name: 'Analytics', component: Analytics },
  { path: '/visitors', name: 'Visitors', component: Visitors },
  { path: '/admin', name: 'Admin', component: Admin },
  { path: '/login', name: 'Login', component: Login },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
