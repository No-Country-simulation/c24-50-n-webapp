<script setup>
import NotificationList from './components/NotificationList.vue';
import { useStore } from '../../store'; // Corrige la importación
import { onMounted, computed } from 'vue';

const store = useStore();

const componentes = {
    NotificationList
};


const paginaActual = computed(() => store.slotContent);

onMounted(() => {
    store.resetStore();
    store.setSlotContent('NotificationList');
});
</script>

<template>
    <component :is="componentes[paginaActual]"></component>
</template>

<style scoped>
</style>