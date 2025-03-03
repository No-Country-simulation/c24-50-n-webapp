<template>
    <div class="input-group">
      <input 
        :class="inputClass"
        :type="type" 
        :placeholder="placeholder" 
        :value="modelValue"
        @input="$emit('update:modelValue', $event.target.value)"
      />
    </div>
  </template>
  
  <script setup>
  defineProps({
    modelValue: String,
    placeholder: String,
    type: { type: String, default: "text" },
    inputClass: {type: String, default: "rounded-lg my-2 border border-[#ddd] text-sm p-1 py-2 w-full" },
    classInputGroup: {type: String, default: ""}
  });
  
  defineEmits(["update:modelValue"]);
  </script>
  