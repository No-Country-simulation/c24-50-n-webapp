<script setup>
import { useStore } from '../../store';
import HeaderTransferencia from './Components/HeaderTransferencia.vue';
import ContentTransferencia from './Components/ContentTransferencia.vue';
import ListaPersona from './Components/ListaPersona.vue';
import DetallesEnvio from './Components/DetallesEnvio.vue';


const store = useStore();

const components = {
    ListaPersona,
    DetallesEnvio,
    
};
</script>

<template>
    <div class="container">
        <HeaderTransferencia />
        <ContentTransferencia>
            <template v-slot:content>
                <component :is="components[store.slotContent]" />
            </template>
        </ContentTransferencia>
    </div>
</template>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    
    height: 743px;
}   
</style>