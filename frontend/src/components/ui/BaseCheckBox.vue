<template>
    <div class="flex items-start">
      <input
        type="checkbox"
        id="customCheckbox"
        :class="checkBoxClass"
      />
      <label 
        for="customCheckbox"
        :class="labelClass">
        {{ labelText }}
        <slot></slot>
      </label>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      labelText: {
        type: String,
        required: true,
      },
      checkBoxClass: {
        type: String,
        default:'form-checkbox h-[30px] w-[30px] mt-1 rounded-sm focus:ring-blue-500 transition duration-200 checked:bg-blue-600 checked:border-transparent'
      },
      labelClass: {
        type: String,
        default: 'ml-2 text-lg font-medium w-full'
      }
    },
  };
  </script>