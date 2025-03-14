<script setup>
import { useStore } from '../../../store';
import { ref, watchEffect, onMounted, computed } from 'vue';
import IconDown from '@/components/icons/iconDown.vue';
import BaseInput from '@/components/ui/BaseInput.vue';
import BaseButton from '@/components/ui/BaseButton.vue';
import IconStar from '@/components/icons/IconStar.vue';
import { formatToUSD } from '@/utils/jwtid';

const store = useStore();

const formData = ref({
    numberaccount: '',
    amount: '',
    menssage: ''
});

const formattedBalance = computed(() => {
    return formatToUSD(store.personaDatos.balance);
});

const formattedNumeroCuenta = computed(() => {
    return store.personaDatos.numeroCuenta?.replace(/(\d{4})/g, '$1 ').trim() || '';
});

const formatNumberAccount = (event) => {
    let rawValue = event.target.value.replace(/\D/g, ''); 
    rawValue = rawValue.slice(0, 16);

    formData.value.numberaccount = rawValue;
};

const formattedNumberAccount = computed({
    get: () => {
        return formData.value.numberaccount.replace(/(\d{4})/g, '$1 ').trim();
    },
    set: (value) => {
        formData.value.numberaccount = value.replace(/\D/g, '').slice(0, 16);
    }
});

const formattedAmount = computed({
    get() {
        const amount = formData.value.amount;
        if (amount === '') return '$';
        const numberString = amount.replace(/,/g, '');
        if (numberString === '') return '$';
        const parts = numberString.split('.');
        let integerPart = parts[0].replace(/^0+/, '');
        integerPart = integerPart === '' ? '0' : integerPart;
        integerPart = integerPart.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        const decimalPart = parts.length > 1 ? `.${parts[1].slice(0, 2)}` : '';
        return `$${integerPart}${decimalPart}`;
    },
    set(value) {
        const rawValue = value.replace(/[^0-9.]/g, '');
        const parts = rawValue.split('.');
        let integerPart = parts[0].replace(/^0+/, '');
        integerPart = integerPart === '' ? '' : integerPart;
        let decimalPart = parts.length > 1 ? parts[1].slice(0, 2) : '';
        const newValue = integerPart + (decimalPart ? `.${decimalPart}` : '');
        formData.value.amount = newValue;
    }
});


const errorMessage = ref('');

const emit = defineEmits(['irConfirmacion']);

const irConfirmacion = async () => {
    errorMessage.value = ''

    try {
        await store.fethPersonafromNumeroCuenta(formData.value.numberaccount); 

        if (!store.personaSeleccion) {
            errorMessage.value = 'No existe la cuenta seleccionada';
            return;
        }

        const balanceDisponible = store.personaDatos.balance || 0;
        const montoIngresado = parseFloat(formData.value.amount);

        if (isNaN(montoIngresado) || montoIngresado <= 0) {
            errorMessage.value = 'Ingresa un monto válido';
            return;
        }

        if (montoIngresado > balanceDisponible) {
            errorMessage.value = 'Saldo insuficiente';
            return;
        }

        store.setSlotContent('DetallesConfirmacion');
        store.setFormData(formData.value);
        emit('irConfirmacion');
    } catch (error) {
        errorMessage.value = 'Error al verificar la cuenta';
    }
};

</script>

<template>
    <div class="detalles-envio h-full">
        <div class="flex items-center justify-end h-[5%]">
            <div class="text-end">Favoritos</div>
            <IconStar class="ml-2" />
        </div>
        
        <form class="form-transferencia flex flex-col h-[95%]" @submit.prevent="irConfirmacion">
            <BaseInput 
                input-class='border border-[#CBCBCB] text-sm p-1 py-2 w-full rounded-xl my-1 px-4'
                type="text"
                v-model="formattedNumberAccount"
                @input="formatNumberAccount"
                placeholder="Número de cuenta"
            />
            <BaseInput 
        input-class='border border-[#CBCBCB] text-sm p-1 py-2 w-full rounded-xl my-1 px-4 text-start'
        type="text"
        v-model="formattedAmount"
        placeholder="Monto"
    />
            <textarea 
                class='border border-[#CBCBCB] text-sm p-1 py-2 w-full h-[98px] rounded-xl my-1 px-4 resize-none min-h-[40px]' 
                placeholder="Mensaje"
                v-model="formData.menssage"
            ></textarea>

            <div v-if="errorMessage" class="text-red-500 text-sm mt-1">{{ errorMessage }}</div>

            <div class="my-4">Selecciona cuenta de origen</div>

            <div class="card flex items-center p-4">
                <div>
                    <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="icono persona" width="30" height="30">
                </div>
                <div class="content-card flex flex-col justify-center items-start ml-4">
                    <div>{{ formattedNumeroCuenta }}</div>
                    <div>Balance: {{ formattedBalance }}</div>
                </div>
                <IconDown class="icon-down ml-auto" />
            </div>

            <div class="mt-auto">
                <BaseButton  
                    @click="irConfirmacion"  
                    class="w-full py-1 rounded-xl bg-gradient text-white text-lg cursor-pointer transition-opacity hover:opacity-80 h-[56px]"
                >
                    Enviar
                </BaseButton>
            </div>
        </form>
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
