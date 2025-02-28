<script setup>
import { useStore } from '../../../store';
import { ref, watchEffect } from 'vue';
import IconDown from '@/components/icons/iconDown.vue';

const store = useStore();
const formData = ref({
    numberaccount: '',
    amount: '',
    menssage: ''
});

watchEffect(() => {
    if (store.personaSeleccion) {
        formData.value.numberaccount = store.personaSeleccion.numberaccount || '';
    }
});
</script>

<template>
    <div class="detalles-envio">
        <div>Favoritos</div>
        <form class="form-transferencia">
            <div class="input-container">
                <input id="numberaccount" v-model="formData.numberaccount" type="text" placeholder="Número de cuenta" />
            </div>
            <div class="input-container">
                <input id="amount" v-model="formData.amount" type="number" placeholder="Monto" />
            </div>
            <div class="input-container description">
                <textarea id="description" v-model="formData.menssage" placeholder="Mensaje"></textarea>
            </div>

            <div>Selecciona cuenta de origen</div>

            <div class="card">
                <div>
                    <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="icono persona" width="30" height="30">
                </div>
                <div class="content-card">
                    <div>number</div>
                    <div>balance: $ 120.000</div>
                </div>
                <IconDown class="icon-down"/>
            </div>
            <div class="button-container">
                <button type="submit">Enviar</button>
            </div>
        </form>
    </div>
</template>

<style scoped>
    .detalles-envio {
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
    button {
        width: 327px;
        height: 44px;
        border-radius: 15px;
        background: #000;
        color: #fff;
        font-size: 16px;
        font-weight: 500;
        cursor: pointer;
    }

</style>
