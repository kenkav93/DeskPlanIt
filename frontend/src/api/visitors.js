// src/api/visitors.js
import axios from 'axios';

const API_BASE = '/api/visitors';

export const registerVisitor = (data) => axios.post(API_BASE, data, { withCredentials: true });
export const fetchVisitors = () => axios.get(API_BASE, { withCredentials: true });
export const checkInVisitor = (id) => axios.post(`${API_BASE}/${id}/checkin`, {}, { withCredentials: true });
