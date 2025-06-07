<template>
  <div>
    <h2 class="mb-4">Seating Chart</h2>
    <p>View and manage seating assignments on your uploaded maps.</p>
    <MapViewer :mapUrl="currentMapUrl" />
    <!-- Booking form/modal placeholder -->
    <div class="mt-4 alert alert-info">Booking form and drag-and-drop seat assignment coming soon.</div>
  </div>
</template>

<script setup>
import MapViewer from '../components/MapViewer.vue';
import { useMapsStore } from '../stores/maps';
import { computed } from 'vue';
const mapsStore = useMapsStore();
const currentMapUrl = computed(() => mapsStore.currentMap?.url || '');
</script>
