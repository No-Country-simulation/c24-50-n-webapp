<template>
    <div class="flex">
        <BaseOptionBenefits
        v-for="(option, index) in options" 
        :key="index"
        :title="option.title" 
        :description="option.description"
        :bgColor="option.bgColor" 
        :icon="option.icon" 
        :url="option.url" 
        />
    </div>
</template>
<script setup>
import BaseOptionBenefits from './ui/BaseOptionBenefits.vue';
import IconBank from '@/components/icons/IconBank.vue';
import IconGraphic from '@/components/icons/IconGraphic.vue';
import IconShield from '@/components/icons/IconShield.vue';
const options = [
    { 
        title: "Servicios Financieros",
        description: "Desde cuentas de ahorro y cheques hasta tarjetas de crédito y préstamos. Todo lo que necesitas en un solo lugar.",
        bgColor: "bg-yellow-600",
        icon: IconBank,
        url: "/billetera",
    },
    { 
        title: "Seguridad y Protección",
        description: "Tu dinero está respaldado por protocolos de seguridad avanzados y regulaciones gubernamentales.",
        bgColor: "bg-yellow-600",
        icon: IconShield,
        url: "/billetera",
    },    { 
        title: "Estabilidad Económica",
        description: "Nuestra plataforma está diseñada para ayudarte a maximizar tus ahorros y optimizar tu bienestar financiero.",
        bgColor: "bg-yellow-600",
        icon: IconGraphic,
        url: "/billetera",
    }
];

</script>