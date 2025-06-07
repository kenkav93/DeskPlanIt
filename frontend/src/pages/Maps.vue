<template>
  <div>
    <h2 class="mb-4">Maps</h2>
    <p>Upload and manage your office floor plans here.</p>
    <MapUploader />
    <MapViewer :mapUrl="currentMapUrl" />
  </div>
</template>

<script setup>
import MapUploader from '../components/MapUploader.vue';
import MapViewer from '../components/MapViewer.vue';
import { useMapsStore } from '../stores/maps';
import { computed } from 'vue';
const mapsStore = useMapsStore();
const currentMapUrl = computed(() => mapsStore.currentMap?.url || '');
</script>
