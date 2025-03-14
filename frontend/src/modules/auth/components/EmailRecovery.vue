<template>
    <div>
        <RecoveryCard>
            <p class="text-gray-500 text-sm">Ingrese su correo electronico</p>
            <BaseInput placeholder="correo electronico"/>
            <p class="">Le enviaremos un código por email, escriba el correo con el que se registro.</p>
            <BaseButton class="mt-12 mb-3" @click="goToRecoverCode">
                Enviar
            </BaseButton>
        </RecoveryCard>
    </div>  
    
    <DiagonalCreditCard class="mt-8"/>
</template>

<script setup>
import RecoveryCard from './RecoveryCard.vue';
import BaseInput from '@/components/ui/BaseInput.vue'
import BaseButton from "@/components/ui/BaseButton.vue";
import DiagonalCreditCard from '@/components/common/DiagonalCreditCard.vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const goToRecoverCode = () => {
    router.push("/recover-code")
}
</script>