<template>
    <div class="w-100 flex flex-col items-center justify-center ">
        <IllustrationSucess class=""/>

        <p class="secondary-color font-semibold">¡Cambió la contraseña exitosamente!</p>

        <p class="text-sm my-6">Ha cambiado correctamente la contraseña. Utilice la nueva contraseña al iniciar sesión.</p>

        <BaseButton>
            Iniciar Sesión
        </BaseButton>
    </div>
</template>

<script setup>
import IllustrationSucess from '../ui/IllustrationSucess.vue';
import BaseButton from '@/components/ui/BaseButton.vue';
</script>