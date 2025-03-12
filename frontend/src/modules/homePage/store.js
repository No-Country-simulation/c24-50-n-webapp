    import { defineStore } from "pinia";
    import axios from "axios";

    export const useStore = defineStore("transferencia", {
    state: () => ({
        slotContent: "",
        personaSeleccion: Object,
        formData: {},
        personaDatos: Object,
        movimientos: [],
    }),
    actions: {
        setSlotContent(content) {
            this.slotContent = content;
        },
        setPersonaSeleccion(persona) {
            this.personaSeleccion = persona;
        },
        setFormData(data) {
            this.formData = { ...data };
        },
        resetStore() {
            this.slotContent = "";
            this.personaSeleccion = {};
            this.personaDatos = {};
            this.formData = {};
            this.movimientos = []; 
        },
        async fetchMovimientos(id) {
            try {
                const { data } = await axios.get(`http://localhost:8080/transaccion/movimientos/${id}`);
                this.movimientos = data;
                console.log("Movimientos", this.movimientos);
            } catch (error) {
                console.error("Error obteniendo movimientos", error);
            }
        },
        async fetchPersonaDatos(id) {
            try {
                const { data } = await axios.get(`http://localhost:8080/usuarios/${id}`);
                this.personaDatos = data;
                console.log("Persona Datos", this.personaDatos);
            } catch (error) {
                console.error("Error obteniendo datos de la persona", error);
            }
        },
        async fethPersonafromNumeroCuenta(numeroCuenta) {
            try {
                const { data } = await axios.get(`http://localhost:8080/cuenta/${numeroCuenta}`);
                this.personaSeleccion = data;
                console.log("Persona Seleccion", this.personaSeleccion);
            } catch (error) {
                console.error("Error obteniendo datos de la persona", error);
                this.personaSeleccion = null; 
                throw error; 
            }
        },
        async tranferir() {
            try {
                const datos = {
                    cuentaOrigen: this.personaDatos.numeroCuenta,
                    cuentaDestino: this.formData.numberaccount,
                    monto: this.formData.amount,
                }
                const { data } = await axios.post("http://localhost:8080/transaccion", datos);
                console.log("Transferencia realizada", data);
            } catch (error) {
                console.error("Error realizando transferencia", error);
                throw error;
            }
        }
    },
    });
