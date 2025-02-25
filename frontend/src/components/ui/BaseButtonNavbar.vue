<template>
  <div 
    @click="navigate"
    class="flex items-center cursor-pointer transition-all p-2 rounded-3xl "
    :class="isSelected ? 'bg-gradient text-white' : 'text-gray-500'"
  > 
    <component :is="icon" class="w-6 h-6 mx-2"/>
    <p v-if="isSelected" class="text-xs font-light"> {{ title }} </p>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router';
defineProps({
title: String,
icon: Object,
url: String,
isSelected: Boolean
});

const router = useRouter();

const navigate = () => {
if (url) {
  router.push(url);
}
};
</script>
