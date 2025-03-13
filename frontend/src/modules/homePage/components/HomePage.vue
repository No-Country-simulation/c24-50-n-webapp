<template>

        <h1 class="font-medium text-3xl text-left ml-6">!Buenos días, <br> {{store.personaDatos.nombre}}!</h1>
        <CardComponent
        :nombre = "store.personaDatos.nombre"
        :balance = "store.personaDatos.balance"
        :numeroCuenta = "store.personaDatos.numeroCuenta"
        />
        <OptionsGroup/>


</template>

<script setup>

import CardComponent from '../components/CardComponent.vue';
import OptionsGroup from './OptionsGroup.vue';
import { useStore } from '../store'
import { onMounted } from 'vue';

const store = useStore();

onMounted( async () => {
        await store.fetchPersonaDatosFromToken();
})

</script>