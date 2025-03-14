<template>
    <svg :width="width" :height="height" viewBox="0 0 24 20" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M1.61401 1.55811L12 11.0001L22.385 1.55911" :stroke="color" stroke-width="1.5"
            stroke-miterlimit="10" />
        <path
            d="M21 1H3C1.89543 1 1 1.89543 1 3V17C1 18.1046 1.89543 19 3 19H21C22.1046 19 23 18.1046 23 17V3C23 1.89543 22.1046 1 21 1Z"
            :stroke="color" stroke-width="1.5" stroke-miterlimit="10" stroke-linecap="square" />
    </svg>
</template>

<script setup>
  defineProps({
    color: {
      type: String,
      default: '#fff',
    },
    width: {
        type: String,
        default: '20'
    },
    height: {
        type: String,
        default: '20'
    },
  });
</script>