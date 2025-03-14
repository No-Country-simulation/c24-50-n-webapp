<script setup>
import { useStore } from '../../store';
import { onMounted } from 'vue';
import HeaderTransferencia from './Components/HeaderTransferencia.vue';
import ContentTransferencia from './Components/ContentTransferencia.vue';
import ListaPersona from './Components/ListaPersona.vue';
import DetallesEnvio from './Components/DetallesEnvio.vue';
import DetallesConfirmacion from './Components/DetallesConfirmacion.vue';
import ExitoTransferencia from './Components/ExitoTransferencia.vue';


const store = useStore();

const components = {
    ListaPersona,
    DetallesEnvio,
    DetallesConfirmacion,
    ExitoTransferencia,
    
};
onMounted(async () => {
    store.resetStore();
    store.setSlotContent('DetallesEnvio');
    await store.fetchPersonaDatosFromToken();
});
</script>

<template>
    <div class="flex flex-col items-center h-full m-h-400">
        <template v-if="store.slotContent !== 'ExitoTransferencia'">
            <HeaderTransferencia />
            <ContentTransferencia>
                <template v-slot:content>
                    <component :is="components[store.slotContent]" />
                </template>
            </ContentTransferencia>
        </template>
        <template v-else>
            <component :is="components[store.slotContent]" />
        </template>
    </div>
</template>

<style scoped>
</style>