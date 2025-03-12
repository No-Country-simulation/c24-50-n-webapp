<template>
  <div class="input-group" :class="classInputGroup">
    <label :for="uniqueId" :class="labelClass">{{ label }}</label>
    <div class="relative">
      <input :id="uniqueId" :class="inputClass" :type="typeInput" :placeholder="placeholder"
        :value="modelValue" @input="$emit('update:modelValue', $event.target.value)" ref="inputRef" />
      <button v-if="type === 'password'" type="button" class="absolute inset-y-0 right-3 flex items-center"
        @click="togglePasswordVisibility">
        <IconEye :show="showPassword" />
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref, nextTick, computed } from "vue";
import IconEye from "../icons/IconEye.vue";
const props = defineProps({
  modelValue: String,
  placeholder: String,
  type: {
    type: String,
    default: "text",
  },
  inputClass: {
    type: String,
    default: "rounded-lg my-2 border border-[#ddd] text-sm p-1 py-2 w-full",
  },
  classInputGroup: {
    type: String,
    default: "",
  },
  label: {
    type: String,
    default: "",
  },
  labelClass: {
    type: String,
    default: "",
  },
});

defineEmits(["update:modelValue"]);

const showPassword = ref(false);
const inputRef = ref(null);
const uniqueId = ref(`input-${Math.random().toString(36).substr(2, 9)}`);

const togglePasswordVisibility = () => {
  const cursorPosition = inputRef.value.selectionStart;
  showPassword.value = !showPassword.value;
  nextTick(() => {
    inputRef.value.setSelectionRange(cursorPosition, cursorPosition);
    inputRef.value.focus();
  });
};

const typeInput = computed(() => {
  if (props.type == "text") return "text";
  return showPassword.value ? "text" : "password";
});

</script>
