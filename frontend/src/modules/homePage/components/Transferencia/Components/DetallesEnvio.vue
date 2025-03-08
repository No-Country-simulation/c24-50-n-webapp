<script setup>
import { useStore } from '../../../store';
import { ref, watchEffect } from 'vue';
import IconDown from '@/components/icons/iconDown.vue';
import BaseInput from '@/components/ui/BaseInput.vue';
import BaseButton from '@/components/ui/BaseButton.vue';
import IconStar from '@/components/icons/IconStar.vue';

const store = useStore();
const formData = ref({
    numberaccount: '',
    amount: '',
    menssage: ''
});

const emit = defineEmits(['irConfirmacion']);

const irConfirmacion = () => {
    store.setSlotContent('DetallesConfirmacion');
    store.setFormData(formData.value);
    emit('irConfirmacion');
};


watchEffect(() => {
    if (store.personaSeleccion) {
        formData.value.numberaccount = store.personaSeleccion.numberaccount || '';
    }
});

</script>

<template>
    <div class="detalles-envio h-full">
        <div class="flex items-center justify-end h-[5%]">
            <div class="text-end">Favoritos</div>
            <IconStar class="ml-2" />
        </div>
        
        <form class="form-transferencia flex flex-col h-[95%]">
            <BaseInput 
            class='border border-[#CBCBCB] text-sm p-1 py-2 w-full rounded-xl my-1 px-4'
            type="text"
            v-model="formData.numberaccount"
            placeholder="Número de cuenta"
            />
            <BaseInput 
            class='border border-[#CBCBCB] text-sm p-1 py-2 w-full rounded-xl my-1 px-4'
            type="number"
            v-model="formData.amount"
            placeholder="Monto"
            />
            <textarea class='border border-[#CBCBCB] text-sm p-1 py-2 w-full h-[98px] rounded-xl my-1 px-4 resize-none min-h-[40px]' 
            placeholder="Mensaje"
            v-model="formData.menssage"
            
            >
                
            </textarea>
            <div class="my-4">Selecciona cuenta de origen</div>

            <div class="card flex items-center p-4 ">
                <div>
                    <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="icono persona" width="30" height="30">
                </div>
                <div class="content-card flex flex-col justify-center items-start ml-4">
                    <div>**** 2236</div>
                    <div>balance: $ 120.000</div>
                </div>
                <IconDown class="icon-down ml-auto" />
            </div>
            <div class="mt-auto ">

                <BaseButton   @click="irConfirmacion"  class="w-full py-1 rounded-xl bg-gradient text-white text-lg cursor-pointer transition-opacity hover:opacity-80 h-[56px]">
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

    /* .detalles-envio {
        height: 100%;
    }
    .form-transferencia {
        height: 100%;
        max-height: 650px;
        display: flex;
        flex-direction: column;

    }
    
    .card {
        display: flex;
        align-items: center;
        width: 327px;
        border-radius: 15px;
        margin: 16px 0;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.08), 
                0 -4px 8px rgba(0, 0, 0, 0.08), 
                4px 0 8px rgba(0, 0, 0, 0.08), 
                -4px 0 8px rgba(0, 0, 0, 0.08);
        background: #fff;
        padding: 16px;
        box-shadow: #CBCBCB;
    }

    .content-card {
        margin-left: 16px;
        text-align: start;
    }

    .icon-down {
        margin-left: auto;
    }

    .input-container {
        display: flex;
        align-items: center;
        width: 327px;
        border-radius: 15px;
        margin: 16px 0;
        border: 1px solid #CBCBCB;
        background: #fff;
    }

    input, textarea {
        width: 100%;
        border: none;
        outline: none;
        padding: 12px 16px;
        font-size: 16px;
        font-family: inherit;
    }

    .input-container {
        height: 44px;
    }

    .description {
        height: 88px;
    }

    textarea {
        resize: none;
        height: 100%;
        word-wrap: break-word;
        overflow-wrap: break-word;
        white-space: pre-wrap;
    }

    .button-container {
        display: flex;
        align-items: end;
        margin-top: auto;
        
    }
    /* button {
        width: 327px;
        height: 44px;
        border-radius: 15px;
        background: #000;
        color: #fff;
        font-size: 16px;
        font-weight: 500;
        cursor: pointer;
    } */ 

</style>
