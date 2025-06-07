// src/api/maps.js
import axios from 'axios';

const API_BASE = '/api/maps';

export const fetchMaps = () => axios.get(API_BASE, { withCredentials: true });
export const uploadMap = (formData) => axios.post(API_BASE + '/upload', formData, { withCredentials: true });
export const deleteMap = (id) => axios.delete(`${API_BASE}/${id}`, { withCredentials: true });
