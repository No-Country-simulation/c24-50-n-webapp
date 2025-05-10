<template>
    <div class="flex items-center justify-between">
      <div>
        <HeaderTitle />
      </div>
      <div class="flex justify-center">
        <nav class="flex">
          <BaseButtonNavbarLanding
            v-for="(option, index) in options"
            :key="index"
            :highlight="option.highlight"
            :title="option.title"
            :url="option.url"
            :isSelected="option.url === currentRoute"
          />
        </nav>
      </div>
    </div>
  </template>

<script setup>
import { computed } from 'vue';
import { useRoute } from 'vue-router';
import BaseButtonNavbarLanding from '@/components/ui/BaseButtonNavbarLanding.vue';
import HeaderTitle from '@/components/common/HeaderTitle.vue';


const route = useRoute();
const currentRoute = computed(() => route.path);

const options = [
    { title: "Home", url: "/user-home", highlight:false},
    { title: "Beneficios", url: "/transferencia",highlight: false },
    { title: "Iniciar Sesión", url: "/login", highlight:true }
];
</script>
