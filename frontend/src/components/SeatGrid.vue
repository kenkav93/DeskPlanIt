<template>
  <div class="border p-3 bg-white mt-3">
    <div class="mb-2">(Drag-and-drop seat assignment UI placeholder)</div>
    <div class="d-flex flex-wrap gap-2">
      <div v-for="seat in seats" :key="seat.id" class="border rounded p-2 bg-light" style="width:80px; height:80px; display:flex; align-items:center; justify-content:center;">
        {{ seat.label }}
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
const props = defineProps({ seats: Array });
</script>
