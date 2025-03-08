<script setup>
import { computed } from "vue";

const props = defineProps({
    movement: Object,
    icon: Object
});

// Formateo del monto en USD con signo adecuado
const formattedAmount = computed(() => {
    const amount = props.movement.amount;
    const formatted = new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
        minimumFractionDigits: 2, // Para mostrar los decimales
    }).format(Math.abs(amount));

    return amount > 0 ? `+${formatted}` : `-${formatted}`;
});

// Clases dinámicas para cambiar el color
const amountClass = computed(() => {
    return props.movement.amount > 0 ? "text-blue-500" : "text-red-500";
});
</script>

<template>
    <div class="flex items-center">
        <div>
            <component :is="icon"></component>
        </div>
        <div class="text-start block">
            <span class="block text-[16px] text-[#343434]">{{ movement.name }}</span>
            <span class="block text-[12px] text-[#989898]">{{ movement.type }}</span>
        </div>
        <div class="ml-auto">
            <span :class="amountClass">{{ formattedAmount }}</span>
        </div>
    </div>
</template>
