<template>
    <div class="user-card">
      <slot></slot>
    </div>
  </template>
  
  <style scoped>
  .user-card {
    background: white;
    width: 90%;
    max-width: 400px;
    border-radius: 20px;
    padding: 20px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    text-align: center;
  }
  </style>