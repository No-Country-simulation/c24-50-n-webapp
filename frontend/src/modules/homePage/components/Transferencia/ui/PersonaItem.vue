<script setup>
import iconGo from '@/components/icons/IconGo.vue';
const props = defineProps({
    nombre: String,
});


</script>
<template>
    <div class="persona-item">
        <div class="icono-persona">
            <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="icono persona" width="30" height="30">
        </div>
        <div>{{nombre}}</div>
        <iconGo class="icon-go" />
    </div>
</template>
<style scoped>

.icono-persona {
    margin-right: 16px;
}
.persona-item {
    display: flex;
    align-items: center;
    justify-content: start;
    height: 40px;
    width: 100%;
    }
.icon-go {
    cursor: pointer;
    margin-left: auto;
}
</style>