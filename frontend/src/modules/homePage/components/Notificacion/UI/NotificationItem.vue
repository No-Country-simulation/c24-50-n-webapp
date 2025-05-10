<script setup>
import { computed } from "vue";

const props = defineProps({
    notificacion: Object,
    toggle: Function,
    icon: Object
});

const typeClass = computed(() => {
    return props.notificacion.type === "Transferencia" ? "text-blue-500" : "text-red-500";
});

const toggleMessage = () => {
    props.toggle(props.notificacion.id);
};
</script>

<template>
    <div class="p-2 border-b border-gray-300">
        <div class="flex items-center cursor-pointer justify-between" @click="toggleMessage">
            <div>
                <component :is="icon"></component>
            </div>
            <div>
                <component :is="props.notificacion.type === 'Transferencia' ? 'IconoTransferencia' : 'IconoSeguridad'" class="w-6 h-6 text-gray-600" />
            </div>
            <div class="text-start block ml-2">
                <span :class="[typeClass, 'block text-[16px] text-[#343434]']">{{ props.notificacion.type }}</span>
            </div>
        </div>
        
    
        <div v-if="props.notificacion.abierto" class="mt-2 text-[14px] text-[#343434] p-2 border-l-4 border-blue-500">
            {{ props.notificacion.mensaje }}
        </div>
    </div>
</template>
