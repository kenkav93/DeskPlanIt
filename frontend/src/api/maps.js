// src/api/maps.js
import axios from 'axios';

const API_BASE = '/api/maps';

export const fetchMaps = () => axios.get(API_BASE);
export const uploadMap = (formData) => axios.post(API_BASE + '/upload', formData);
export const deleteMap = (id) => axios.delete(`${API_BASE}/${id}`);
