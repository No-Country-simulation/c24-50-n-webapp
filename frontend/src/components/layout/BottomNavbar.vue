<template>
    <div class="flex justify-center">
        <nav class="flex">
            <BaseButtonNavbar 
                v-for="(option, index) in options" 
                :key="index"
                :title="option.title" 
                :icon="option.icon" 
                :url="option.url"
                :isSelected="option.url == currentRoute"
            />
        </nav>
    </div>
</template>

<script setup>
import { useRoute } from 'vue-router';
import BaseButtonNavbar from '../ui/BaseButtonNavbar.vue';
import IconGear from '../icons/IconGear.vue';
import IconHome from '../icons/IconHome.vue';
import IconLetter from '../icons/IconLetter.vue';
import IconMagnifyingGlass from '../icons/IconMagnifyingGlass.vue';

const route = useRoute();
const currentRoute = route.path; 

const options = [
  { title: "Inicio", icon: IconHome, url: "/user-home" },
  { title: "Buscar", icon: IconMagnifyingGlass, url: "/buscar" },
  { title: "Notificaciones", icon: IconLetter, url: "/" },
  { title: "Ajustes", icon: IconGear, url: "/" },
];
</script>
