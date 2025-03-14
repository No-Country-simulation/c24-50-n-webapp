<template>
    <p class="text-2xl text-white">{{ item }}</p>
    <p class="font-light text-[#B6B3EB] text-sm mt-2">{{ description }}</p>
</template>
<script setup>
defineProps({
    description: String,
    item: String

})
</script>