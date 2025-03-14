<template>
  <div :class="containerClass">
      <h1 :class="classTittle" :style="properties">NoBank</h1>
  </div>
</template>

<script setup>
defineProps({
classTittle: {
  type: String,
  default: 'font-bold fs-5 font-poppins',
},
containerClass: {
  type: String,
  default: 'p-4 text-xl',
},
properties: {
  type: String,
  default: 'color: #fff',
}
});
</script>
