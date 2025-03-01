<script setup>
import iconGo from '@/components/icons/IconGo.vue';
import { useStore } from '../../../store';
const props = defineProps({
    persona: Object,
});

const store = useStore();

const emit = defineEmits(['EnviarItem']);

const EnviarItem = () => {
    store.setPersonaSeleccion(props.persona);
    store.setSlotContent('DetallesEnvio');
    emit('EnviarItem');
};


</script>
<template>
    <div class="persona-item flex flex-row items-center">
        <div class="icono-persona mr-4">
            <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="icono persona" width="30" height="30">
        </div>
        <div>{{ persona.name }}</div>
        <iconGo class="icon-go ml-auto h-[40px]" @click="EnviarItem" />
    </div>
</template>
<style scoped>

</style>