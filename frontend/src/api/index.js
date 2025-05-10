import axios from "axios";
import router from "@/router"; 

const api = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL, 
  headers: {
    "Content-Type": "application/json",
  },
});

api.interceptors.request.use((config) => {
  const token = sessionStorage.getItem("token"); 
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

api.interceptors.response.use(
  response => response, 
  error => {
    if (error.response) {
      if (error.response.status === 401) {
        sessionStorage.removeItem("token"); 
        router.push("/login");
      }
      if (error.response.status === 403) {
        sessionStorage.removeItem("token"); 
        router.push("/login"); 
      }
    }
    return Promise.reject(error);
  }
);


export const login = async (credentials) => {
  try {
    const response = await api.post("/login", credentials);
    const token = response.data.JWTtoken;

    sessionStorage.setItem("token", token); // Guarda el token en sessionStorage

    return token;
  } catch (error) {
    console.error("Error en login:", error);
    throw error;
  }
};

export const logout = () => {
  sessionStorage.removeItem("token");
  router.push("/login");
};

export const getData = async (endpoint) => {
  try {
    const response = await api.get(endpoint);
    return response.data;
  } catch (error) {
    console.error("Error en GET:", error);
    throw error;
  }
};

export const postData = async (endpoint, data) => {
  try {
    const response = await api.post(endpoint, data);
    return response.data;
  } catch (error) {
    console.error("Error en POST:", error);
    throw error;
  }
};

export default api;
