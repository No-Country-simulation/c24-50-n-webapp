<template>

    <header>
        <div class="mx-50">
            <HeaderNavbar />
        </div>
    </header>

    <section>
        <slot name="principalContent"></slot>
    </section>

    <footer>
        <slot name="footerContent" >

        </slot>
    </footer>


</template>
<script setup>
import HeaderNavbar from '@/components/layout/HeaderNavbar.vue';

</script>