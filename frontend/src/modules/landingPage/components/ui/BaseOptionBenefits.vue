<template>
    <div class="rounded-xl m-3 bg-white shadow-md w-90 h-80 flex flex-col items-center justify-center cursor-pointer transition-all hover:shadow-lg"
        @click="navigate">
        <div :class="`rounded-lg w-15 h-15 flex items-center justify-center`">
            <component :is="icon" class="text-white w-15 h-15" />
        </div>
        <div class="m-4 text-center">
            <div>
                <p class="text-black ">{{ title }}</p>
                <p class="text-black font-thin mt-4 text-xs">{{ description }}</p>
            </div>
            <div class="flex items-center justify-end mt-10">
                <a class="text-sm hover:text-[#5D55FF] hover:ml-1" href="#">Más información</a>
                <IconArrow/>
            </div>
        </div>
    </div>
</template>

<script setup>
import IconArrow from '@/components/icons/IconArrow.vue';
import { useRouter } from 'vue-router';

const props = defineProps({
    title: String,
    description: String,
    bgColor: String,
    icon: Object,
    url: String
});

const router = useRouter();

const navigate = () => {
    if (props.url) {
        router.push(props.url);
    }
};
</script>