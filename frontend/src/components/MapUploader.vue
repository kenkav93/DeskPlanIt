<template>
  <div class="mb-4">
    <label class="form-label">Upload Office Map (SVG/PNG/PDF)</label>
    <input type="file" class="form-control" @change="onFileChange" accept=".svg,.png,.pdf" />
    <div v-if="previewUrl" class="mt-3">
      <label class="form-label">Preview:</label>
      <img v-if="isImage" :src="previewUrl" alt="Map Preview" class="img-fluid border" style="max-height:300px;" />
      <span v-else>File ready to upload: {{ file?.name }}</span>
    </div>
    <button class="btn btn-primary mt-2" :disabled="!file" @click="upload">Upload</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { uploadMap } from '../api/maps';

const file = ref(null);
const previewUrl = ref('');
const isImage = ref(false);

function onFileChange(e) {
  const f = e.target.files[0];
  file.value = f;
  if (f && f.type.startsWith('image/')) {
    previewUrl.value = URL.createObjectURL(f);
    isImage.value = true;
  } else {
    previewUrl.value = '';
    isImage.value = false;
  }
}

async function upload() {
  if (!file.value) return;
  const formData = new FormData();
  formData.append('file', file.value);
  await uploadMap(formData);
  alert('Map uploaded!');
}
</script>
