<template>
  <div class="grid grid-cols-3 gap-4">
    <BaseOption 
      v-for="(option, index) in options" 
      :key="index"
      :title="option.title" 
      :bgColor="option.bgColor" 
      :icon="option.icon" 
      :url="option.url" 
    />
  </div>
</template>

<script setup>
import BaseOption from './ui/BaseOption.vue';

import IconFile from '@/components/icons/IconFile.vue';
import IconReceipt from '@/components/icons/IconReceipt.vue';
import IconTransfer from '@/components/icons/IconTransfer.vue';
import IconWallet from '@/components/icons/IconWallet.vue';
import IconWithdraw from '@/components/icons/IconWithdraw.vue';
import IconDeposit from '@/components/icons/IconDeposit.vue';

const options = [
  { title: "Mi cuenta", bgColor: "bg-yellow-600", icon: IconWallet, url: "/billetera" },
  { title: "Transferencia", bgColor: "bg-red-600", icon: IconTransfer, url: "/transferencia" },
  { title: "Retiro", bgColor: "bg-gray-600", icon: IconWithdraw, url: "/retiro" },
  { title: "Depositar", bgColor: "bg-purple-600", icon: IconDeposit, url: "/deposito" },
  { title: "Realizar pagos", bgColor: "bg-green-600", icon: IconReceipt, url: "/recibo" },
  { title: "Movimientos", bgColor: "bg-blue-600", icon: IconFile, url: "/archivo" },
];
</script>
