<script setup>
import IconSearch from '@/components/icons/IconSearch.vue';
import MovementList from './components/MovementList.vue';
import { useStore } from '../../store'; // Corrige la importación
import { onMounted, computed } from 'vue';

const store = useStore();

const componentes = {
    MovementList
};


const paginActual = computed(() => store.slotContent);

onMounted(() => {
    store.resetStore();
    store.setSlotContent('MovementList');
});
</script>

<template>
    <component :is="componentes[paginActual]"></component>
</template>

<style scoped>
</style>