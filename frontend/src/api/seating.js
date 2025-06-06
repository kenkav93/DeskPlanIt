// src/api/seating.js
import axios from 'axios';

const API_BASE = '/api/seating';

export const fetchSeating = (mapId) => axios.get(`${API_BASE}?mapId=${mapId}`);
export const updateSeating = (mapId, seatingData) => axios.put(`${API_BASE}/${mapId}`, seatingData);
