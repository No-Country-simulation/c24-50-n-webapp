<script setup>
    import HeaderTransferencia from './Components/HeaderTransferencia.vue';
    import ContentTransferencia from './Components/ContentTransferencia.vue';
</script>

<template>
    <div class="container">
        <HeaderTransferencia />
        <ContentTransferencia />
    </div>
</template>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100%;
}   
</style>