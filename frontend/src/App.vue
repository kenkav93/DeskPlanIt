
<script setup>
import { ref } from 'vue';
import { RouterView, RouterLink, useRouter } from 'vue-router';
import { useAuthStore } from './stores/auth';
const auth = useAuthStore();
const router = useRouter();
const logout = async () => {
  await auth.logout();
  router.push('/login');
};
</script>

<template>
  <div class="container-fluid min-vh-100 d-flex flex-column bg-light p-0">
    <!-- Header -->
    <header class="navbar navbar-expand-lg navbar-dark bg-gradient px-3 shadow-sm" style="background: linear-gradient(90deg, #2563eb 60%, #22d3ee 100%);">
      <RouterLink class="navbar-brand fw-bold fs-3" to="/">DeskPlanIt</RouterLink>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto align-items-lg-center gap-lg-2">
          <li class="nav-item">
            <RouterLink class="nav-link d-flex align-items-center gap-1" to="/">
              <i class="bi bi-house-door"></i> Dashboard
            </RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link d-flex align-items-center gap-1" to="/maps">
              <i class="bi bi-map"></i> Maps
            </RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link d-flex align-items-center gap-1" to="/seating">
              <i class="bi bi-grid-3x3-gap"></i> Seating
            </RouterLink>
          </li>
          <li class="nav-item" v-if="auth.role === 'ADMIN'">
            <RouterLink class="nav-link d-flex align-items-center gap-1" to="/users">
              <i class="bi bi-people"></i> Users
            </RouterLink>
          </li>
          <li class="nav-item" v-if="auth.role === 'ADMIN'">
            <RouterLink class="nav-link d-flex align-items-center gap-1" to="/admin">
              <i class="bi bi-tools"></i> Admin
            </RouterLink>
          </li>
          <li class="nav-item" v-if="auth.role === 'ADMIN' || auth.role === 'USER'">
            <RouterLink class="nav-link d-flex align-items-center gap-1" to="/analytics">
              <i class="bi bi-bar-chart"></i> Analytics
            </RouterLink>
          </li>
          <li class="nav-item" v-if="auth.role === 'ADMIN' || auth.role === 'USER'">
            <RouterLink class="nav-link d-flex align-items-center gap-1" to="/visitors">
              <i class="bi bi-person-badge"></i> Visitors
            </RouterLink>
          </li>
          <li class="nav-item" v-if="!auth.user">
            <RouterLink class="nav-link d-flex align-items-center gap-1" to="/login">
              <i class="bi bi-box-arrow-in-right"></i> Login
            </RouterLink>
          </li>
          <li class="nav-item dropdown" v-if="auth.user">
            <a class="nav-link dropdown-toggle d-flex align-items-center gap-2" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              <i class="bi bi-person-circle fs-5"></i>
              {{ auth.user.displayName || auth.user.username }}
              <span v-if="auth.role" class="badge bg-secondary ms-2">{{ auth.role }}</span>
            </a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
              <li><a class="dropdown-item" href="#" @click.prevent="logout">Logout</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </header>
    <!-- Error/Status Messages -->
    <div v-if="auth.error" class="alert alert-danger position-fixed top-0 start-50 translate-middle-x mt-3 rounded-3 shadow" style="z-index:2000; min-width:300px; max-width:90vw;">
      <i class="bi bi-exclamation-triangle me-2"></i>{{ auth.error }}
    </div>

    <!-- Main Content -->
    <main class="flex-fill d-flex flex-column align-items-center justify-content-center py-4 w-100 bg-white shadow-sm rounded-4" style="min-height:60vh;">
      <div class="w-100 px-2 px-md-4" style="max-width: 1000px;">
        <RouterView />
      </div>
    </main>

    <!-- Footer -->
    <footer class="bg-gradient text-white text-center py-3 mt-auto shadow-sm" style="background: linear-gradient(90deg, #2563eb 60%, #22d3ee 100%);">
      <div class="container">
        <div class="d-flex flex-column flex-md-row justify-content-between align-items-center">
          <span>&copy; {{ new Date().getFullYear() }} DeskPlanIt</span>
          <span class="small">Modern workplace management &mdash; <a href="/" class="text-white text-decoration-underline">Home</a></span>
        </div>
      </div>
    </footer>
  </div>
</template>

<style scoped>
.navbar-brand {
  letter-spacing: 1px;
}
.bg-gradient {
  background: linear-gradient(90deg, #2563eb 60%, #22d3ee 100%) !important;
}
main {
  background: #fff;
  border-radius: 1.5rem;
  box-shadow: 0 2px 12px rgba(37,99,235,0.08);
}
</style>
