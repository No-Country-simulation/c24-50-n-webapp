<script setup>
import { ref } from 'vue';
import NotificationItem from '../UI/NotificationItem.vue'; // Asegúrate de importar el componente de notificación
import IconoTransferencia from '@/components/icons/IconTransferencia.vue';
import IconoServicios from '@/components/icons/IconService.vue';

const notificaciones = ref([
    {
        id: 1,
        fecha: 'Hoy',
        mensaje: 'Se ha realizado una transferencia de $500.00 a tu cuenta',
        type: 'Transferencia',
        id_usuario: 1,
        abierto: false,
    },
    {
        id: 2,
        fecha: 'Ayer',
        mensaje: 'Se ha detectado un inicio de sesión en tu cuenta desde un dispositivo desconocido',
        type: 'Seguridad',
        id_usuario: 1,
        abierto: false,
    }
]);

const iconos = {
  'Transferencia': IconoTransferencia,
  'Seguridad': IconoServicios
};

const toggleNotification = (id) => {
    notificaciones.value.forEach(notificacion => {
        notificacion.abierto = notificacion.id === id ? !notificacion.abierto : false;
    });
};
</script>

<template>
    <header class="flex gap-4 justify-between items-center px-2 py-4">
        <span class="text-lg font-semibold">Notificaciones</span>
    </header>

    <div class="overflow-y-auto h-[calc(100%-64px)]">
        <NotificationItem 
            v-for="notificacion in notificaciones" 
            :key="notificacion.id" 
            :notificacion="notificacion"
            :toggle="toggleNotification"
            :icon="iconos[notificacion.type]" 
        />
    </div>
</template>
