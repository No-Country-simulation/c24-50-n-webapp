<template>
<div class="flex relative">
    <img src="@/assets/img-girl-cell.jpg" class="w-[80%]" alt="chicha con celular confiando en noBank">

    <div class="absolute bg-white rounded-lg shadow h-70 w-120 right-[-4%] top-1/2 transform -translate-y-1/2">
        <div class="m-6">
            <p class="text-4xl font-medium">¿Listo para el Futuro? ¡Regístrate y Usa NoBank!</p>
            <p class="text-gray-600 font-thin mt-6 ">¡Regístrate y Usa Nuestra Plataforma!</p>
            <BaseButton
                class="mt-6"
                :buttonClass="' border border-gray-200 h-18 w-40 py-1 rounded-lg bg-white text-black-900 text-lg cursor-pointer transition-opacity hover:bg-[#B6B3EB]'">
                Abrir Cuenta
            </BaseButton>
        </div>
    </div>
</div>

</template>
<script setup>
import BaseButton from '@/components/ui/BaseButton.vue';

</script>