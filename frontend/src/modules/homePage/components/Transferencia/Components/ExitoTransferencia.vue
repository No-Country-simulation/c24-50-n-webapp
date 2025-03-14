<script setup>
import BaseButton from '@/components/ui/BaseButton.vue';
import IconCheck from '@/components/icons/IconCheck.vue';
import { useStore } from '../../../store';
import { useRouter } from 'vue-router';
import { computed } from 'vue';
import { formatToUSD } from '../../../../../utils/jwtid';

const router = useRouter();
const store = useStore();

const volverInicio = () => {
    store.resetStore();
    router.push('/user-home');
};

const formattedAmount = computed(() => {
    return formatToUSD(store.formData.amount);
});

</script>
<template>
        <div class="flex flex-col items-center justify-between h-full w-full py-8">
            <div class="flex flex-col items-center justify-center h-[100%] w-full gap-[32px]">
                <div>
                    <IconCheck />
                </div>
                <div class="text-2xl text-[#65558F]">Haz enviado <br />
                    {{ formattedAmount }} <br />
                    a <br /> 
                    {{ store.personaSeleccion.nombre}}</div>
            </div>
            <div class="flex flex-col items-center justify-center h-[40%] w-full p-4">
                <div class="h-[56px]">Ver Comprobante</div>
                <BaseButton @click="volverInicio" class="w-full py-1 rounded-xl bg-gradient text-white text-lg cursor-pointer transition-opacity hover:opacity-80 h-[56px]" >Volver al inicio</BaseButton>
            </div>
        </div>
</template>
<style>
</style>