<script setup>
import BaseButton from '@/components/ui/BaseButton.vue';
import IconCheck from '@/components/icons/IconCheck.vue';
import { useStore } from '../../../store';
import { useRouter } from 'vue-router';

const router = useRouter();
const store = useStore();

const volverInicio = () => {
    router.push('/user-home');
};

</script>
<template>
        <div class="flex flex-col items-center justify-between h-full w-full py-8">
            <div class="flex flex-col items-center justify-center h-[100%] w-full gap-[32px]">
                <div>
                    <IconCheck />
                </div>
                <div class="text-2xl text-[#65558F]">Haz enviado <br />
                    ${{ store.formData.amount }} <br />
                    a <br /> 
                    {{ store.personaSeleccion.name}}</div>
            </div>
            <div class="flex flex-col items-center justify-center h-[40%] w-full p-4">
                <div class="h-[56px]">Ver Comprobante</div>
                <BaseButton @click="volverInicio" class="w-full py-1 rounded-xl bg-gradient text-white text-lg cursor-pointer transition-opacity hover:opacity-80 h-[56px]" >Volver al inicio</BaseButton>
            </div>
        </div>
</template>
<style>
</style>