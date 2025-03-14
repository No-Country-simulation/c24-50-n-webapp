<template>
    <LandigPageLayout>
        <template #principalContent>
            <BackGroundLanding class="fixed inset-0 top-[-1%] bg-cover bg-center z-[-1] " />
            <div class="mx-50 mt-12">
                <div class="grid grid-cols-1 md:grid-cols-2">
                    <div>
                        <p class="text-3xl md:text-[55px] text-white font-bold">Tu Futuro Financiero en un Solo Lugar</p>
                        <p class="text-white font-thin text-[#B6B3EB] mt-16">Descubre una plataforma segura y moderna
                            diseñada para brindarte soluciones financieras adaptadas a tus necesidades.</p>

                        <div class="flex mt-14">
                            <BaseButton
                                :buttonClass="'h-18 w-40 py-1 rounded-xl bg-white text-blue-900 text-lg cursor-pointer transition-opacity hover:opacity-80'">
                                Abrir Cuenta
                            </BaseButton>
                            <BaseButton
                                :buttonClass="'h-18 w-50 ml-7 py-1 rounded-xl text-white border border-white text-lg cursor-pointer transition-opacity hover:bg-white hover:text-blue-900'">
                                Más información
                            </BaseButton>
                        </div>
                        <div class="grid grid-cols-3 mt-6">
                            <div>
                                <GeneralBenefits item="<0.1%" description="Comisiones por Transacción" />
                            </div>
                            <div>
                                <GeneralBenefits item="+14%" description="Ahorro Promedio" />
                            </div>
                            <div>
                                <GeneralBenefits item="+2.9M" description="Dueños de Negocios Confían en Nosotros" />
                            </div>

                        </div>
                    </div>
                    <div class="w-full ">
                        <div class="flex items-center">
                            <CellCardIllustration class="ml-30 mt-10 w-100 h-100" />
                        </div>
                    </div>
                </div>
            </div>

            <div class="pt-15 mt-15 bg-white">
                <div class="mx-50">
                    <InfoLandingPage />
                </div>
            </div>
            <div class="pt-20 bg-white">
                <div class="mx-50">
                    <BannerRegister />
                </div>
            </div>
        </template>
        <template #footerContent>
            <div class="w-full h-90 bg-purple-100 pt-15" >
                <div class="mx-50">
                    <FooterComponent/>
                </div>
            </div>
        </template>
    </LandigPageLayout>
</template>

<script setup>
import BackGroundLanding from '@/components/common/BackGroundLanding.vue';
import BaseButton from '@/components/ui/BaseButton.vue';
import LandigPageLayout from '@/layouts/LandigPageLayout.vue';
import GeneralBenefits from '../components/ui/GeneralBenefits.vue'
import CellCardIllustration from '@/components/common/CellCardIllustration.vue';
import InfoLandingPage from '../components/InfoLandingPage.vue'
import BannerRegister from '../components/BannerRegister.vue';
import FooterComponent from '../components/FooterComponent.vue';


</script>