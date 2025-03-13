<script setup>
import { ref, computed, watch, nextTick, onMounted } from 'vue';
import IconSearch from '@/components/icons/IconSearch.vue';
import MovementItem from '../UI/MovementItem.vue';
import IconoTransferencia from '@/components/icons/IconTransferencia.vue';
import IconoServicios from '@/components/icons/IconService.vue';
import { useStore } from '@/modules/homePage/store';



const store = useStore();


onMounted(async () => {
  await store.fetchPersonaDatosFromToken();
  await store.fetchMovimientos(store.personaDatos.id_Cuenta);
});

const searchActive = ref(false);
const searchQuery = ref('');
const searchInput = ref(null);

watch(searchActive, (newVal) => {
  if (newVal) {
    nextTick(() => {
      searchInput.value?.focus();
    });
  }
});

const handleSearchClose = () => {
  searchActive.value = false;
};

const filteredMovements = computed(() => {
  const movements = store.movimientos;
  if (!searchQuery.value) return movements;
  return movements.filter(movement => 
    movement.name.toLowerCase().includes(searchQuery.value.toLowerCase()))
});

const iconos = {
  'Transferencia': IconoTransferencia,
  'Pago de servicios': IconoServicios
};
</script>

<template>
    <header class="flex gap-4 justify-between items-center px-2 py-4">
        <span v-if="!searchActive" class="text-lg font-semibold">
            Últimos Movimientos
        </span>

        <div v-if="searchActive" class="flex gap-2">
            <input 
                ref="searchInput"
                type="text" 
                v-model="searchQuery"
                placeholder="Buscar movimiento..."
                class="px-2 py-1 border rounded"
                @keyup.enter="handleSearchClose"
                @blur="handleSearchClose"
            />
        </div>
        <div>
            <IconSearch @click="searchActive = !searchActive" />
        </div>
    </header>

    <body class="overflow-y-auto h-[calc(100%-64px)]">
        <MovementItem 
            v-for="movement in filteredMovements" 
            :key="movement.id" 
            :movement="movement"
            :icon="iconos[movement.type]" 
        />
    </body>
</template>
