<template>
    <button :class="class" >
      <slot></slot>
    </button>
  </template>
    <script setup>
    defineProps({
      buttonClass: {type: String, default: "w-full py-1 rounded-xl bg-gradient text-white text-lg cursor-pointer transition-opacity hover:opacity-80" }
    });
    
    defineEmits(["update:modelValue"]);
    </script>
  
  