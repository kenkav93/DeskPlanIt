
<template>
  <div class="position-relative border" style="min-height:400px; min-width:400px; background:#f8fafc;">
    <img v-if="mapUrl && !isSvg" :src="mapUrl" class="w-100 h-100" style="object-fit:contain;" alt="Office Map" />
    <div v-if="svgContent && isSvg" v-html="svgContent" class="w-100 h-100"></div>
    <div v-for="seat in seats" :key="seat.id"
      class="position-absolute seat-dot bg-primary rounded-circle"
      :style="seatStyle(seat)"
      @mousedown="startDrag(seat, $event)"
      @touchstart.prevent="startDrag(seat, $event)"
      title="Seat {{ seat.label }}">
      <span class="text-white small">{{ seat.label }}</span>
      <span v-if="seat.assignedUser" class="badge bg-info ms-1">{{ seat.assignedUser }}</span>
      <button class="btn btn-sm btn-light ms-1" style="position:absolute;top:-10px;right:-10px;z-index:2;" @click.stop="removeSeat(seat.id)">&times;</button>
      <button class="btn btn-sm btn-secondary ms-1" style="position:absolute;bottom:-10px;right:-10px;z-index:2;" @click.stop="editLabel(seat)">✎</button>
      <button class="btn btn-sm btn-info ms-1" style="position:absolute;bottom:-10px;left:-10px;z-index:2;" @click.stop="assignUser(seat)">👤</button>
    </div>
    <div v-if="!mapUrl" class="text-muted position-absolute top-50 start-50 translate-middle">No map loaded. Upload a map to begin.</div>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue';
import { useSeatingStore } from '../stores/seating';
const props = defineProps({ mapUrl: String });
const svgContent = ref('');
const isSvg = ref(false);

import { onMounted } from 'vue';
onMounted(() => {
  seatingStore.loadSeats();
});

function removeSeat(id) {
  seatingStore.removeSeat(id);
}

function editLabel(seat) {
  const label = prompt('Edit seat label:', seat.label);
  if (label !== null && label.trim() !== '') {
    seatingStore.editSeatLabel(seat.id, label.trim());
  }
}

function assignUser(seat) {
  const user = prompt('Assign user to seat:', seat.assignedUser || '');
  if (user !== null) {
    seatingStore.assignUser(seat.id, user.trim());
  }
}

const seatingStore = useSeatingStore();
const seats = seatingStore.seats;

watch(() => props.mapUrl, async (url) => {
  if (url && url.endsWith('.svg')) {
    const res = await fetch(url);
    svgContent.value = await res.text();
    isSvg.value = true;
  } else {
    svgContent.value = '';
    isSvg.value = false;
  }
}, { immediate: true });

function seatStyle(seat) {
  return {
    left: seat.x + 'px',
    top: seat.y + 'px',
    width: '32px',
    height: '32px',
    cursor: 'grab',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    userSelect: 'none',
    position: 'absolute',
  };
}

function addSeat() {
  seatingStore.addSeat({ x: 100, y: 100 });
}

let dragging = null;
let offset = { x: 0, y: 0 };

function startDrag(seat, event) {
  dragging = seat;
  if (event.type === 'touchstart') {
    offset.x = event.touches[0].clientX - seat.x;
    offset.y = event.touches[0].clientY - seat.y;
    window.addEventListener('touchmove', onDrag);
    window.addEventListener('touchend', stopDrag);
  } else {
    offset.x = event.clientX - seat.x;
    offset.y = event.clientY - seat.y;
    window.addEventListener('mousemove', onDrag);
    window.addEventListener('mouseup', stopDrag);
  }
}

function onDrag(event) {
  if (!dragging) return;
  let x, y;
  if (event.type.startsWith('touch')) {
    x = event.touches[0].clientX - offset.x;
    y = event.touches[0].clientY - offset.y;
  } else {
    x = event.clientX - offset.x;
    y = event.clientY - offset.y;
  }
  seatingStore.moveSeat(dragging.id, x, y);
}

function stopDrag() {
  dragging = null;
  window.removeEventListener('mousemove', onDrag);
  window.removeEventListener('mouseup', stopDrag);
  window.removeEventListener('touchmove', onDrag);
  window.removeEventListener('touchend', stopDrag);
}
</script>

<style scoped>
.seat-dot {
  width: 32px;
  height: 32px;
  display: flex;
  align-items: center;
  justify-content: center;
  position: absolute;
  border: 2px solid #fff;
  box-shadow: 0 2px 6px rgba(0,0,0,0.1);
  z-index: 1;
  transition: box-shadow 0.2s;
}
.seat-dot:active {
  box-shadow: 0 4px 12px rgba(37,99,235,0.3);
}
</style>
