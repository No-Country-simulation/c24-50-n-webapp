<template>
    <header>
      <div class="container mx-auto px-4 py-4">
        <HeaderNavbar />
      </div>
    </header>
  
    <section>
      <slot name="principalContent"></slot>
    </section>
  
    <footer>
      <div >
        <slot name="footerContent"></slot>
      </div>
    </footer>
  </template>
  
  <script setup>
  import HeaderNavbar from '@/components/layout/HeaderNavbar.vue';
  </script>