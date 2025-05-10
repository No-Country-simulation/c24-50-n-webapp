import { defineStore } from "pinia";

export const useAuthStore = defineStore("auth", {
  state: () => ({
    token: null,
  }),
  actions: {
    login(token) {
      this.token = token;
      sessionStorage.setItem("token", token);
    },
    logout() {
      this.token = null;
      sessionStorage.removeItem("token");
    },
    loadToken() {
      this.token = sessionStorage.getItem("token");
    }
  }
});
