<script setup>
import { ref, onMounted } from 'vue';
import NotificationItem from '../UI/NotificationItem.vue'; // Asegúrate de importar el componente de notificación
import IconoTransferencia from '@/components/icons/iconTransferNotification.vue';
import IconoSeguridad from '@/components/icons/IconShield.vue';
import { useStore } from '@/modules/homePage/store';

const store = useStore();


onMounted(async () => {
  await store.fetchPersonaDatosFromToken();
  await store.fetchNotificacionesFromId(store.personaDatos.id_Cuenta);
});

const iconos = {
  'Transferencia': IconoTransferencia,
  'Seguridad': IconoSeguridad
};

const toggleNotification = (id) => {
    store.notificaciones.forEach(notificacion => {
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
            v-for="notificacion in store.notificaciones" 
            :key="notificacion.id" 
            :notificacion="notificacion"
            :toggle="toggleNotification"
            :icon="iconos[notificacion.type]" 
        />
    </div>
</template>
