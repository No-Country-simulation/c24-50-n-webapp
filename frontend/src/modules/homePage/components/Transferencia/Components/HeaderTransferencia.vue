<script setup>
    import iconVolver from '@/components/icons/IconVolver.vue';
    import IconVolver from '@/components/ui/BaseButtonNavbar.vue'
    import { useStore } from '../../../store';

    const store = useStore();

    const handleVolver = () => {
        if (store.slotContent === 'DetallesEnvio') {
            store.setSlotContent('ListaPersona');
        } if (store.slotContent === 'DetallesConfirmacion') {
            store.setSlotContent('DetallesEnvio');
        }
    };
</script>
<template>
    <div class="header-transferencia flex flex-row items-center justify-between h-12 w-full">
        <iconVolver class="icon-volver" @click="handleVolver" />
        <div class="mr-4">Transferir dinero a</div>
    </div>
</template>
