<template>

    <userCard>
        <h1 class="font-medium text-3xl text-left ml-6">!Buenos días, <br> {{first_name}}!</h1>
        <CardComponent/>
        <OptionsGroup/>
    </userCard>


</template>

<script setup>

import userCard from '@/components/user/userCard.vue';
import CardComponent from '../components/CardComponent.vue';
import OptionsGroup from './OptionsGroup.vue';

const first_name = 'Andree'

</script>