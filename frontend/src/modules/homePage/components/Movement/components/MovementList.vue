<script setup>
import { ref, computed, watch, nextTick } from 'vue';
import IconSearch from '@/components/icons/IconSearch.vue';
import MovementItem from '../UI/MovementItem.vue';
import IconoTransferencia from '@/components/icons/IconTransferencia.vue';
import IconoServicios from '@/components/icons/IconService.vue';

const movements = [
    { id: 1, name: 'Deposito Jane', type: 'Transferencia', amount: -50.00 },
    { id: 2, name: 'Pago de Luz', type: 'Pago de servicios', amount: -100.00 },
    { id: 3, name: 'Transferencia Marco', type: 'Transferencia', amount: 200.00 },
    { id: 4, name: 'Pago de Internet', type: 'Pago de servicios', amount: -30.00 },
    { id: 5, name: 'Pago de Gas', type: 'Pago de servicios', amount: -60.00 },
    { id: 6, name: 'Abono Cuenta Ahorros', type: 'Transferencia', amount: 500.00 },
    { id: 7, name: 'Pago Celular', type: 'Pago de servicios', amount: -40.00 },
    { id: 8, name: 'Transferencia Carlos', type: 'Transferencia', amount: -300.00 },
    { id: 9, name: 'Pago Netflix', type: 'Pago de servicios', amount: -15.00 },
    { id: 10, name: 'Pago Seguro', type: 'Pago de servicios', amount: -200.00 },
    { id: 11, name: 'Depósito Julio', type: 'Transferencia', amount: 1000.00 },
    { id: 12, name: 'Transferencia Ana', type: 'Transferencia', amount: 250.00 },
    { id: 13, name: 'Pago Gas', type: 'Pago de servicios', amount: -60.00 },
    { id: 14, name: 'Pago de Impuestos', type: 'Pago de servicios', amount: -100.00 },
    { id: 15, name: 'Transferencia Luis', type: 'Transferencia', amount: 300.00 },
    { id: 16, name: 'Transferencia Rosa', type: 'Transferencia', amount: 150.00 },
    { id: 17, name: 'Pago Impuestos', type: 'Pago de servicios', amount: -150.00 },
    { id: 18, name: 'Pago de Agua', type: 'Pago de servicios', amount: -80.00 },
    { id: 19, name: 'Depósito Pedro', type: 'Transferencia', amount: 450.00 },
    { id: 20, name: 'Pago Seguro', type: 'Pago de servicios', amount: -200.00 }
];

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