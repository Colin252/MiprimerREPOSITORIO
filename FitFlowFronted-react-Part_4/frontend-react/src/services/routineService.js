// src/services/routineService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/routines';

export const getAllRoutines = () => axios.get(API_URL);
export const createRoutine = (routine) => axios.post(API_URL, routine);
export const updateRoutine = (id, routine) => axios.put(`${API_URL}/${id}`, routine);
export const deleteRoutine = (id) => axios.delete(`${API_URL}/${id}`);
