<template>
  <AuthCard>
    <h2 class="title secondary-color font-medium text-xl">Bienvenido</h2>
    <p class="text-pagraph text-sm font-poppins">Inicia sesión para continuar</p>

    <div class="flex justify-center">
      <CircleIcon>
        <IconPadlockGradient />
      </CircleIcon>
    </div>


    <BaseInput v-model="dni" type="text" placeholder="DNI" />
    <BaseInput v-model="password" type="password" placeholder="Contraseña" />

    <div class="flex justify-end mb-3">
      <p class="text-xs text-gray-500 cursor-pointer">¿Olvidaste la contraseña?</p>
    </div>
    <Captcha />
    
    <div class="mt-6 w-100">
      <BaseButton @click="login">Iniciar Sesión</BaseButton>
    </div>

    <div class="flex justify-center mt-1">
      <p class="text-pagraph text-sm">
        ¿No tienes cuenta? <span class="secondary-color cursor-pointer" @click="goToRegister">Registrarte</span>
      </p>
    </div>
  </AuthCard>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { login as apiLogin } from "@/api/index"; // Importa la función login
import { useAuthStore } from "@/stores/auth"; // Importa el store de autenticación
import BaseInput from "@/components/ui/BaseInput.vue";
import BaseButton from "@/components/ui/BaseButton.vue";
import CircleIcon from "../common/CircleIcon.vue";
import IconPadlockGradient from "../icons/IconPadlockGradient.vue";
import Captcha from "./Captcha.vue";

const dni = ref("");
const password = ref("");
const router = useRouter();
const authStore = useAuthStore();

const login = async () => {
  try {
    const token = await apiLogin({ login: dni.value, password: password.value });
    
    authStore.login(token);
    router.push("/user-home");
  } catch (error) {
    console.error("Error de autenticación:", error);
    alert("Error al iniciar sesión. Verifica tus credenciales.");
  }
};

const goToRegister = () => {
  router.push("/register");
};
</script>
