<template>
  <div
    class="rounded-xl bg-white shadow-md w-24 h-24 flex flex-col items-center justify-center cursor-pointer transition-all hover:shadow-lg"
    @click="navigate"
  >
    <div :class="`rounded-lg w-10 h-10 mb-2 flex items-center justify-center`">
      <component :is="icon" class="text-white w-6 h-6" />
    </div>
    <p class="text-gray-400 text-xs">{{ title }}</p>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router';

const props = defineProps({
  title: String,
  bgColor: String,
  icon: Object,
  url: String
});

const router = useRouter();

const navigate = () => {
  if (props.url) {
    router.push(props.url);
  }
};
</script>
