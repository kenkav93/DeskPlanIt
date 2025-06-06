<template>
  <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 60vh;">
    <div class="card p-4 shadow" style="max-width: 350px; width: 100%;">
      <h3 class="mb-3 text-center">Sign In</h3>
      <form @submit.prevent="onLogin">
        <div class="mb-3">
          <label for="username" class="form-label">Username</label>
          <input v-model="username" type="text" class="form-control" id="username" required />
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input v-model="password" type="password" class="form-control" id="password" required />
        </div>
        <button class="btn btn-primary w-100" :disabled="auth.loading" type="submit">
          <span v-if="auth.loading" class="spinner-border spinner-border-sm"></span>
          <span v-else>Login</span>
        </button>
        <div v-if="auth.error" class="alert alert-danger mt-3">{{ auth.error }}</div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useAuthStore } from '../stores/auth';

const auth = useAuthStore();
const username = ref('');
const password = ref('');

const onLogin = () => {
  auth.login(username.value, password.value);
};
</script>
