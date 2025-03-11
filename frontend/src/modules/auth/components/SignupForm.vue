<template>
  <AuthCard>
    <h2 class="title secondary-color font-medium text-xl">Bienvenido</h2>
    <p class="text-pagraph text-sm font-poppins">Complete los campos y crea una nueva cuenta.</p>

    <div class="flex justify-center">
      <CircleIcon>
        <IconCellUser />
      </CircleIcon>
    </div>
    <BaseInput v-model="dni" placeholder="Nombre" />
    <BaseInput v-model="dni" placeholder="DNI" />
    <BaseInput v-model="dni" placeholder="(+54) 9398829xxx" />
    <BaseInput v-model="password" type="password" placeholder="Contraseña" />
    <BaseInput v-model="password_confirm" type="password" placeholder="Confirma Contraseña" />
    <BaseCheckBox class="mt-2 w-100">
      <p class="font-light text-lg">Al crear una cuenta, estás de acuerdo a nuestros <a class="font-semibold secondary-color" href="#">Términos y condiciones</a></p>
    </BaseCheckBox>

    <div class="mt-6 w-100">
      <BaseButton @click="login">Iniciar Sesión</BaseButton>
    </div>

    <div class="flex justify-center mt-3">
      <p class="text-pagraph text-sm">
        ¿Ya tienes cuenta? <span class="secondary-color cursor-pointer" @click="goToRegister">Inicia Sesión</span>
      </p>
    </div>
  </AuthCard>
  
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import BaseInput from "@/components/ui/BaseInput.vue";
import BaseButton from "@/components/ui/BaseButton.vue";
import CircleIcon from "@/components/common/CircleIcon.vue";
import BaseCheckBox from "@/components/ui/BaseCheckBox.vue";
import IconCellUser from "@/components/icons/IconCellUser.vue";

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