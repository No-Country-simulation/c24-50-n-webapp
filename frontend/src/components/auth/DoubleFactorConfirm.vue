<template>
    <div class="two-factor-auth">
      <div class="code-inputs flex justify-between space-x-2 mb-4 mx-5">
        <input
          v-for="(digit, index) in digits"
          :key="index"
          type="text"
          v-model="digits[index]"
          maxlength="1"
          @input="handleInput(index, $event)"
          @keydown.delete="handleBackspace(index, $event)"
          ref="inputs"
          class="w-12 h-12 text-center text-lg border border-gray-300 rounded-2xl focus:border-blue-500 focus:ring-2 focus:ring-blue-200 outline-none transition-all"
        />
      </div>
      <BaseButton @click="submitCode">Confirmar</BaseButton>
      <p v-if="error" class="text-red-500 text-sm text-center">{{ error }}</p>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import BaseButton from "@/components/ui/BaseButton.vue";
  import { useRouter } from 'vue-router';

  const router = useRouter();
  
  const digits = ref(Array(6).fill(''));
  const inputs = ref([]);
  const error = ref('');
  
  const handleInput = (index, event) => {
    const value = event.target.value;
  
    if (value && index < 5) {
      inputs.value[index + 1].focus();
    }
  
    if (digits.value.every((digit) => digit !== '')) {
      submitCode();
    }
  };
  
  const handleBackspace = (index, event) => {
    if (event.key === 'Backspace' && index > 0 && !digits.value[index]) {
      inputs.value[index - 1].focus();
    }
  };
  
  const submitCode = () => {
    goToChangePassword()
    const code = digits.value.join('');
    if (code.length === 6) {
      console.log('Código 2FA enviado:', code);
      error.value = '';
    } else {
      error.value = 'El código debe tener 6 dígitos.';
    }
  };

  const goToChangePassword = () => {
    router.push("/change-password")
}
  
  onMounted(() => {
    inputs.value[0].focus();
  });
  </script>