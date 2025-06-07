// src/api/users.js
import axios from 'axios';

const API_BASE = '/api/users';

export const fetchUsers = () => axios.get(API_BASE, { withCredentials: true });
export const updateUser = (id, data) => axios.put(`${API_BASE}/${id}`, data, { withCredentials: true });
export const deleteUser = (id) => axios.delete(`${API_BASE}/${id}`, { withCredentials: true });
