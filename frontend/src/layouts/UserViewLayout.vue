<template>
  <HeaderTitle :properties="'color: #65558F'" />

  <div class="bg-[#FFFDFF] flex justify-center">
    <userCard>

      <div class="auth-layout">
        <!-- <div class="p-4 sm:p-6 md:p-8 lg:p-10 font-poppins"> -->
        <div class="font-poppins">
          <slot></slot>
        </div>
      </div>
      <BottomNavbar/>
    </userCard>
  </div>
</template>

<script setup>
import HeaderTitle from '@/components/common/HeaderTitle.vue';
import userCard from '@/components/user/userCard.vue';
import BottomNavbar from '@/components/layout/BottomNavbar.vue'

</script>

<style scoped>
.auth-layout {
  min-height: 80vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 20px;
}

</style>