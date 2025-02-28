<script setup>
    import iconVolver from '@/components/icons/IconVolver.vue';
    import { useStore } from '../../../store';

    const store = useStore();

    const handleVolver = () => {
        if (store.slotContent === 'DetallesEnvio') {
            store.setSlotContent('ListaPersona');
        } else {
        
        }
    };
</script>
<template>
    <div class="header-transferencia">
        
        <iconVolver class="icon-volver" @click="handleVolver" />
        <div>Tranferir dinero a</div>
    </div>
</template>
<style scoped> 
    .header-transferencia {
        display: flex;
        align-items: center;
        justify-content: space-between;
        height: 36px;
        width: 360px;
        }
    .header-transferencia div {
        font-size: 20px;
        font-weight: 500;
        
        width: 80%;
    }
    .icon-volver {
        cursor: pointer;
    }

</style>