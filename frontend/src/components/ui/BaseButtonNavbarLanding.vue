<template>
    <div @click="navigate" class="flex items-center cursor-pointer transition-all p-2 rounded-sm"
        :class="['text-xs text-white', highlight ? 'bg-[#6E67FF] hover:bg-[#2D26C5]' : 'hover:text-gray-300']">
        <p class="">{{ title }}</p>
    </div>
</template>

<script setup>
import { useRouter } from 'vue-router';

const props = defineProps({
    title: String,
    url: String,
    isSelected: Boolean,
    highlight: Boolean
});

const router = useRouter();

const navigate = () => {
    if (props.url) {
        router.push(props.url);
    }
};
</script>
