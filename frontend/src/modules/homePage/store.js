import { defineStore } from 'pinia';

export const useStore = defineStore('transferencia', {
    state: () => ({
        slotContent: 'ListaPersona',
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
            this.slotContent = 'ListaPersona';
            this.personaSeleccion = null;
            this.formData = {};
        }
        
    }
});