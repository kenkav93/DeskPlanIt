// src/api/analytics.js
import axios from 'axios';

const API_BASE = '/api/analytics';

export const fetchUtilization = () => axios.get(`${API_BASE}/utilization`, { withCredentials: true });
export const fetchTrends = () => axios.get(`${API_BASE}/trends`, { withCredentials: true });
export const exportReport = (type) => axios.get(`${API_BASE}/export?type=${type}`, { withCredentials: true });
