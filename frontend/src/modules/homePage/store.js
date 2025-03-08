import { defineStore } from 'pinia';

export const useStore = defineStore('transferencia', {
    state: () => ({
        slotContent: '',
        personaSeleccion: null,
        formData: {}
    }),
    actions: {
        setSlotContent(content) {
            this.slotContent = content;
        },
        setPersonaSeleccion(persona) {
            this.personaSeleccion = persona;
        },
        setFormData(data) {
            this.formData = data;
        },
        resetStore() {
            this.slotContent = '';
            this.personaSeleccion = null;
            this.formData = {};
        }
        
    }
});