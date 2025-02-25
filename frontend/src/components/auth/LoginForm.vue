<template>
    <AuthCard>
      <h2 class="title secondary-color font-medium text-xl">Bienvenido</h2>
      <p class="text-pagraph text-sm font-poppins">Inicia sesión para continuar</p>
      
      <!-- <img src="@/assets/lock.png" class="lock-icon" alt="Lock" /> -->
      <div class="flex justify-center">
       <CircleIcon>
          <IconPadlockGradient/>
       </CircleIcon>
      </div>
  
  
      <BaseInput v-model="dni" placeholder="DNI" />
      <BaseInput v-model="password" type="password" placeholder="Contraseña" />
  
      <div class="flex justify-end mb-3">
        <p class="text-xs text-gray-500 cursor-pointer">¿Olvidaste la contraseña?</p>
      </div>
      <div class="mt-6">
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
    import BaseInput from "@/components/ui/BaseInput.vue"; 
    import BaseButton from "@/components/ui/BaseButton.vue";
    import CircleIcon from "../common/CircleIcon.vue";
    import IconPadlockGradient from "../icons/IconPadlockGradient.vue";
  
  const dni = ref("");
  const password = ref("");
  const router = useRouter();
  
  const login = () => {
    console.log("DNI:", dni.value, "Password:", password.value);
  };
  
  const goToRegister = () => {
    router.push("/register");
  };
  </script>
  