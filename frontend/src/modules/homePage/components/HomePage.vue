<template>

        <h1 class="font-medium text-3xl text-left ml-6">!Buenos días, <br> {{first_name}}!</h1>
        <CardComponent/>
        <OptionsGroup/>


</template>

<script setup>

import CardComponent from '../components/CardComponent.vue';
import OptionsGroup from './OptionsGroup.vue';

const first_name = 'Andree'

</script>