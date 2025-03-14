<script setup>
import MovementList from './components/MovementList.vue';
import { useStore } from '../../store'; // Corrige la importación
import { onMounted, computed } from 'vue';

const store = useStore();

const componentes = {
    MovementList
};


const paginaActual = computed(() => store.slotContent);

onMounted(() => {
    store.resetStore();
    store.setSlotContent('MovementList');
});
</script>

<template>
    <component :is="componentes[paginaActual]"></component>
</template>

<style scoped>
</style>