<template>
    <div class="w-100">
        <BaseInput 
            v-model="dni"
            placeholder="Contraseña"
            label="Ingrese contraseña nueva"
            type="password"
            labelClass="text-sm text-gray-500"
        />
        <BaseInput
            v-model="dniConfirm"
            placeholder="Confirma contraseña"
            label="Confirme la contraseña"
            type="password"
            labelClass="text-sm text-gray-500"
        />
        <BaseButton class="mt-12" @click="goToConfirm">
            Cambiar la contraseña
        </BaseButton>

    </div>
</template>

<script setup>
import { ref } from "vue";
import BaseInput from "@/components/ui/BaseInput.vue";
import BaseButton from "@/components/ui/BaseButton.vue";
import { useRouter } from 'vue-router';

const router = useRouter();
const dni = ref("");
const dniConfirm = ref("");

const goToConfirm = () => {
    router.push('/change-success')
}
</script>