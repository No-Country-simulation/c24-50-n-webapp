<script setup>
import { useStore } from '../../../store';
import BaseButton from '@/components/ui/BaseButton.vue';
import IconDown from '@/components/icons/iconDown.vue';
import { computed } from 'vue';
import { formatToUSD } from '@/utils/jwtid';

const store = useStore();

const emit = defineEmits(['enviar']);

const enviar = async () => {
    await store.tranferir()
    store.setSlotContent('ExitoTransferencia');
    emit('enviar');
};

const formattedAmount = computed(() => {
    return formatToUSD(store.formData.amount);
});

const formatNumberAccount = computed(() => {
    return store.formData.numberaccount.replace(/(\d{4})/g, '$1 ').trim();
});

const formattedNumberAccount = computed({
    get: () => {
        return store.personaDatos.numeroCuenta.replace(/(\d{4})/g, '$1 ').trim();
    },
    set: (value) => {
        store.formData.numberaccount = value.replace(/\D/g, '').slice(0, 16);
    }
});

const formattedBalance = computed(() => {
    return formatToUSD(store.personaDatos.balance);
    
});
</script>
<template>
    <div class="h-full flex flex-col items-center gap-[32px]">
        <div class="w-full">
            <div class="my-4">
                <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="icono persona" width="30" height="30" class="m-auto" />
            </div>
            <div class="mt-[32px]">{{ store.personaSeleccion.nombre}}</div>
            <div>{{ formatNumberAccount }}</div>
        </div>
        <div class="w-full my-4">
            <div>{{ formattedAmount }}</div>
            <div>Sin comisión</div>
        </div>
        <div class="w-full">

            <div class="w-full">
                Selecciona cuenta de origen
            </div>
            <div class="card flex items-center p-4  justify-start w-full mt-[12px]">
                    <div>
                        <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="icono persona" width="30" height="30">
                    </div>
                    <div class="content-card flex flex-col justify-center items-start ml-4">
                        <div>{{ formattedNumberAccount }}</div>
                        <div>balance: {{ formattedBalance }}</div>
                    </div>
                    <IconDown class="icon-down ml-auto" />
            </div>
        </div>
        <div class="mt-auto w-full">
            <BaseButton   @click="enviar"  class="w-full py-1 rounded-xl bg-gradient text-white text-lg cursor-pointer transition-opacity hover:opacity-80 h-[56px]">
                Enviar
            </BaseButton>
        </div>
    </div>
    <div>
        
    </div>
</template>
<style scoped>

    .card {
        border-radius: 15px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.08), 
                0 -4px 8px rgba(0, 0, 0, 0.08), 
                4px 0 8px rgba(0, 0, 0, 0.08), 
                -4px 0 8px rgba(0, 0, 0, 0.08);

        }
</style>

