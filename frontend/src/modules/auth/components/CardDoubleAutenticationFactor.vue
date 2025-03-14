<template>
    <RecoveryCard>
        <p class="text-gray-500 text-sm my-2">Ingrese el código</p>
        <p class="text-gray-500 m-3 text-lg">Le enviamos un código por mensaje de texto para verificar su número de teléfono <span class="secondary-color">(+54) ***********23</span> </p>
        <DoubleFactorConfirm class="mt-3"/>
        <p class="text-gray-500 mt-6">Este código caducará 10 minutos después de recibido este mensaje.</p>
        <div class="flex justify-center mt-12 mb-12"> 
            <a href="#" class="secondary-color">Reenviar codigo</a>  
            <span>|</span>
            <a href="#" class="secondary-color">Cambiar de numero</a>    
        </div>
    </RecoveryCard>
</template>

<script setup>
import DoubleFactorConfirm from '@/components/auth/DoubleFactorConfirm.vue';
import RecoveryCard from './RecoveryCard.vue';

</script>