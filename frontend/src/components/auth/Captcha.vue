<template>

  </template>
  
  <script setup>
  import { ref, onMounted, nextTick } from "vue";
  
  const siteKey = import.meta.env.VITE_RECAPTCHA_SITE_KEY;
  const recaptchaContainer = ref(null);
  const captchaToken = ref("");
  
  const onCaptchaSuccess = (token) => {
    captchaToken.value = token;
    console.log("Token obtenido:", token);
  };
  

  const onCaptchaExpired = () => {
    console.log("Captcha expirado");
    captchaToken.value = "";
  };
  

  onMounted(async () => {
    await nextTick();
  
    const scriptId = "recaptcha-script";
    if (!document.getElementById(scriptId)) {
      const script = document.createElement("script");
      script.id = scriptId;
      script.src = "https://www.google.com/recaptcha/enterprise.js?render=explicit";
      script.async = true;
      script.defer = true;
      script.onload = () => {
        if (window.grecaptcha) {
          window.grecaptcha.enterprise.render(recaptchaContainer.value, {
            sitekey: siteKey,
            action: "LOGIN",
            callback: onCaptchaSuccess,
            "expired-callback": onCaptchaExpired,
          });
        } else {
          console.error("reCAPTCHA Enterprise no cargó correctamente.");
        }
      };
      document.head.appendChild(script);
    } else {
      console.log("El script de reCAPTCHA Enterprise ya está cargado.");
    }
  });
  
  const onSubmit = () => {
    if (!captchaToken.value) {
      alert("Por favor, completa el captcha");
      return;
    }
    alert("Formulario enviado correctamente con token: " + captchaToken.value);
  };
  </script>
  