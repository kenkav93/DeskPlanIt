
<script setup>
import { ref } from 'vue';
import { RouterView, RouterLink } from 'vue-router';
</script>

<template>
  <div class="container-fluid min-vh-100 d-flex flex-column bg-light p-0">
    <!-- Header -->
    <header class="navbar navbar-expand-lg navbar-dark bg-primary px-3">
      <RouterLink class="navbar-brand fw-bold" to="/">DeskPlanIt</RouterLink>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <RouterLink class="nav-link" to="/">Dashboard</RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/maps">Maps</RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/seating">Seating</RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/users">Users</RouterLink>
          </li>
        </ul>
      </div>
    </header>

    <!-- Main Content -->
    <main class="flex-fill d-flex flex-column align-items-center justify-content-center py-4 w-100">
      <div class="w-100" style="max-width: 900px;">
        <RouterView />
      </div>
    </main>

    <!-- Footer -->
    <footer class="bg-primary text-white text-center py-2 mt-auto">
      &copy; {{ new Date().getFullYear() }} DeskPlanIt
    </footer>
  </div>
</template>

<style scoped>
.navbar-brand {
  letter-spacing: 1px;
}
</style>
