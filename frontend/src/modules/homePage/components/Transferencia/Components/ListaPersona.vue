<script setup>
    import { ref, computed } from 'vue';
    import personaItem from '../ui/PersonaItem.vue';
    import BaseInput from '@/components/ui/BaseInput.vue';
    const personaList = [
        { name: 'Andree', numberaccount: '1234567890' },
        { name: 'Carlos', numberaccount: '9876543210' },
        { name: 'Elena', numberaccount: '4561237890' },
        { name: 'Lucía', numberaccount: '7890123456' },
        { name: 'Fernando', numberaccount: '3216549870' },
        { name: 'Gabriela', numberaccount: '6549873210' },
        { name: 'Martín', numberaccount: '1472583690' },
        { name: 'Sofía', numberaccount: '3692581470' },
        { name: 'Raúl', numberaccount: '8529637410' },
        { name: 'Valeria', numberaccount: '7531594820' },
        { name: 'Jorge', numberaccount: '9517534680' },
        { name: 'Ana', numberaccount: '1239876540' },
        { name: 'Ana', numberaccount: '1239876540' },
        { name: 'Ana', numberaccount: '1239876540' },
        { name: 'Ana', numberaccount: '1239876540' },
        { name: 'Ana', numberaccount: '1239876540' },
        { name: 'Ana', numberaccount: '1239876540' },

        

    ];
    const filterText = ref('');

    const filteredPersonas = computed(() => {
        return personaList.filter(persona => 
            persona.name.toLowerCase().includes(filterText.value.toLowerCase()) ||
            persona.numberaccount.includes(filterText.value)
        );
    });
</script>
<template>
    <div class="w-full h-full min-h-[400px] flex flex-col">
        <div class=" pb-4" >
            <BaseInput v-model="filterText" placeholder="Buscar persona " class="w-full h-10 border border-gray-300 rounded-lg px-4 bg-gray-100 focus:outline-none focus:ring-2 focus:ring-purple-600" />
        </div>
        <div class="flex-1 overflow-y-auto space-y-4 h-[calc(100%-40px)]">
            <personaItem v-for="(persona, index) in filteredPersonas" 
                :key="index"
                :persona="persona"
                >
            </personaItem>
        </div>
    </div>
</template>
<style scoped> 
    /* .list-container {
        display: flex;
        flex-direction: column;
        height: 552px;
        width: 100%;
        overflow-y: auto;
        gap: 24px;
        }
        
    .list-container::-webkit-scrollbar {
        display: none;
    }

        
    .list-container {
        scrollbar-width: none; 
    }

    .content-transferencia {
        height: 707px;
        width: 360px;
    }
    .search {
        display: flex;
        justify-content: center;
        margin: 32px 0;
        width: 100%;
    }
    .search input {
        width: 100%;
        height: 36px;
        border: 1px solid #E0E0E0;
        border-radius: 10px;
        padding: 0 16px;
        background-color: #0000001f;
    } */

</style>