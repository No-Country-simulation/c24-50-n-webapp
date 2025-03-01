<template>
  <HeaderTitle :properties="'color: #65558F'" />

  <div class="bg-[#FFFDFF] flex justify-center">
    <userCard>

      <div class="auth-layout max-h-70 h-full">
        <div class="font-poppins w-full h-full ">
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