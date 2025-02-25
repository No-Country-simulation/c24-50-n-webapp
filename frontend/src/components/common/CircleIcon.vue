<template>
    <div class="relative w-42 h-42">
        <div class=" absolute inset-0 flex items-center justify-center rounded-full bg-indigo-100 my-6 mx-6">
            <slot></slot>
        </div>
        <div class="absolute top-4 left-10 w-2 h-2 rounded-full bg-indigo-800"></div>
        <div class="absolute top-3 right-1 l-4 w-6 h-6 rounded-full bg-red-500"></div>
        <div class="absolute bottom-10 left-6 w-5 h-5 rounded-full bg-yellow-500"></div>
        <div class="absolute bottom-10 right-6 w-2 h-2 rounded-full bg-blue-500"></div>
        <div class="absolute top-15 left-0 w-2 h-2 rounded-full bg-teal-300"></div>
    </div>
</template>