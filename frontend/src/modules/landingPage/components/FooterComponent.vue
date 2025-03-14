<template>
    <div>
        <div class="grid grid-cols-1 md:grid-cols-2 md:mb-10">
            <div>
                <div class="md:w-120 h-50 bg-[#1D1C31] rounded-lg">
                    <div class="p-6">
                        <p class="text-2xl text-white">Suscríbete a Nuestro Newsletter</p>
                        <p class="text-sm text-white opacity-60 font-thin">Mantente informado con las últimas novedades.</p>
                        <div class="flex items-end mt-10">
                        <BaseInput 
                            v-model="email"
                            type="email"
                            :inputClass="'text-white border-b border-white w-60  md:w-70'"
                            placeholder="Ingresa tu email..." />
                            <BaseButton
                            :buttonClass="' border border-gray-200 md:h-14  w-40 ml-4 py-1 rounded-lg bg-white text-black-900 text-lg cursor-pointer transition-opacity hover:bg-[#B6B3EB]'"
                            >
                                Suscribirse
                            </BaseButton>
                        </div>
                    </div>
                </div>
            </div>
            <div> 
                <div class="flex justify-center mt-4">
                    <div class="mx-10">
                        <p class="font-semibold" >Menu</p>
                        <ul class="font-thin my-4 text-sm">
                            <li class="mb-4 text-sm">
                                Inicio
                            </li>
                            <li class="mb-4">
                                Beneficios
                            </li>
                            <li class="mb-4">
                                Abrir cuenta
                            </li>
                        </ul>
                    </div>
                    <div class="mx-10">
                        <p class="font-semibold" >Help</p>
                        <ul class="font-thin my-4 text-sm">
                            <li class="mb-4">
                                Nosotros
                            </li>
                            <li class="mb-4">
                                Contacto
                            </li>
                            <li class="mb-4">
                                Soporte
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <hr class="text-gray-900 opacity-10 pt-4 ">
        <div class="flex font-thin text-sm pb-3 ">
            <p class="">2025. Todos los derechos revervados</p>
            <p class="mx-auto opacity-60 hover:opacity-100 cursor-pointer">Políticas de Privacidad</p>
        </div>
    </div>
</template>

<script setup>
import BaseButton from "@/components/ui/BaseButton.vue";
import BaseInput from "@/components/ui/BaseInput.vue";

</script>