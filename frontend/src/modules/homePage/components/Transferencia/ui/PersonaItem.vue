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
    <div class="persona-item">
        <div class="icono-persona">
            <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="icono persona" width="30" height="30">
        </div>
        <div>{{ persona.name }}</div>
        <iconGo class="icon-go" @click="EnviarItem" />
    </div>
</template>
<style scoped>

.icono-persona {
    margin-right: 16px;
}
.persona-item {
    display: flex;
    align-items: center;
    justify-content: start;
    height: 40px;
    width: 100%;
    }
.icon-go {
    cursor: pointer;
    margin-left: auto;
}
</style>