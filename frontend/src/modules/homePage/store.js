    import { defineStore } from "pinia";
    import { login, logout, getData, postData } from "../../api/index.js";
    import { decodeJWT } from "../../utils/jwtid.js";

    export const useStore = defineStore("transferencia", {
    state: () => ({
        slotContent: "",
        personaSeleccion: Object,
        formData: {},
        personaDatos: Object,
        movimientos: [],
        notificaciones: [],
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
            this.notificaciones = [];
        },
        async fetchMovimientos(id) {
            try {
                const data = await getData(`/transaccion/movimientos/${id}`);
                this.movimientos = data;
            } catch (error) {
                console.error("Error obteniendo movimientos", error);
            }
        },
        async fetchPersonaDatosFromToken() {
            const token = sessionStorage.getItem("token");
            if (token) {
                const decoded = decodeJWT(token);
                await this.fetchPersonaDatos(decoded.id);
            } else {
                console.log('fallo autentificación');
            }
        },
        async fetchPersonaDatos(id) {
            try {
                const data = await getData(`/usuarios/${id}`);
                this.personaDatos = data;
            } catch (error) {
                console.error("Error obteniendo datos de la persona", error);
            }
        },
        async fethPersonafromNumeroCuenta(numeroCuenta) {
            try {
                const data = await getData(`/cuenta/${numeroCuenta}`);
                this.personaSeleccion = data;
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
                const data = await postData("/transaccion", datos);
                console.log("Transferencia realizada", data);
            } catch (error) {
                console.error("Error realizando transferencia", error);
                throw error;
            }
        },
        async fetchNotificacionesFromId(id) {
            try {
                const data = await getData(`/notificaciones/${id}`);
                this.notificaciones = data;
            } catch (error) {
                console.error("Error obteniendo notificaciones", error);
            }
        }
    },
    });
