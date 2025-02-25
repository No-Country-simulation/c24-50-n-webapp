<template>
  <div 
    class="bg-[#FFFDFF]"
    >
    <HeaderTitle
      :properties="'color: #65558F'"
      />

    <div class="auth-layout">
      <div class="p-4 sm:p-6 md:p-8 lg:p-10 font-poppins">
        <slot></slot>
      </div>
    </div>
  </div>
</template>

<script setup>
import HeaderTitle from '@/components/common/HeaderTitle.vue';
</script>

<style scoped>
.auth-layout {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 20px;
}

.header {
  width: 100%;
  max-width: 400px;
  display: flex;
  align-items: center;
  color: white;
  padding: 10px;
  font-size: 18px;
}
</style>