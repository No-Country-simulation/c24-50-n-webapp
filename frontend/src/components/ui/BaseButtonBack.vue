<template>
    <div @click="$router.back()" class="flex">
      <button class="mr-2 cursor-pointer">
        <IconBack />
      </button>
      <a class="font-poppins font-medium cursor-pointer">{{ text }}</a>
    </div>
  </template>
  
  <script setup>
  import IconBack from '../icons/IconBack.vue';

  defineProps({
    text: {
      type: String,
      default: 'Regresar',
    },
  });
  </script>
  