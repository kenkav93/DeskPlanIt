// src/api/admin.js
import axios from 'axios';

const API_BASE = '/api/admin';

export const fetchSettings = () => axios.get(`${API_BASE}/settings`);
export const updateSettings = (settings) => axios.put(`${API_BASE}/settings`, settings);
export const fetchRoles = () => axios.get(`${API_BASE}/roles`);
export const updateRole = (id, data) => axios.put(`${API_BASE}/roles/${id}`, data);
