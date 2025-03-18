# 🚀 **No Bank**

### Con No Bank, la gestión de tus finanzas nunca fue tan fácil, segura y rápida.
No Bank es una plataforma bancaria digital que permite a los usuarios gestionar sus cuentas bancarias de forma segura, realizar transferencias, ver su saldo y recibir notificaciones de seguridad en tiempo real. La misión de No Bank es proporcionar una experiencia de usuario eficiente y libre de complicaciones, centrada en la seguridad y usabilidad.

## 📌 **Tecnologías utilizadas**

- **Frontend:** Vue 3 + Vite + Pinia
- **Backend:** Java Spring Boot 3 - Maven
- **Base de datos:** Postgre (supabase)
- **Diseño:** Figma

## 📌 **Instalación Previa**

### Java 17

Si no tienes Java 17 instalado, sigue estos pasos:

1. Descarga e instala Java 17 desde su página oficial: https://www.oracle.com/java/technologies/javase/jdk17-0-13-later-archive-downloads.html.
2. Verifica la instalación ejecutando en la terminal:

    ```sh
    java -version
    ```
    
### Maven

Si no tienes Maven instalado, sigue estos pasos:

1. Descarga e instala Maven desde su página oficial: https://maven.apache.org/download.cgi.
2. Extrae el archivo descargado y agrega la carpeta `bin` a tu variable de entorno `PATH`.
3. Verifica la instalación ejecutando en la terminal:

    ```sh
    mvn -v
    ```

### Node.js

Si no tienes Node.js instalado, sigue estos pasos:

1. Descarga e instala Node.js desde su página oficial: https://nodejs.org/.
2. Verifica la instalación ejecutando en la terminal:

    ```sh
    node -v
    npm -v
    ```

## 📥 **Instalación**

### Repositorio
```sh
git clone https://github.com/No-Country-simulation/c24-50-n-webapp.git
```

### Backend

```sh
cd backend/nobank
mvn install
mvn spring-boot:run
```

### Frontend

```sh
cd frontend
npm install
npm run dev
```

## 📝 **Uso del Proyecto**

### 1. **Login**

- Los usuarios pueden iniciar sesión de forma segura en la plataforma utilizando sus credenciales.
- El sistema verifica las credenciales y asegura que el acceso esté protegido por medidas de seguridad.

### 2. **Transferencias Bancarias**

- Los usuarios pueden realizar transferencias de dinero a otras cuentas de forma rápida y segura.
- El sistema permite elegir el monto y la cuenta de destino, garantizando que la transacción se realice de manera eficiente.

### 3. **Notificaciones de Transferencia**

- Los usuarios reciben notificaciones cuando se realiza una transferencia de dinero desde o hacia su cuenta.
- Las alertas incluyen detalles sobre el monto transferido, la cuenta de destino o origen y la fecha y hora de la transacción.

### 4. **Notificaciones de Seguridad**

- Los usuarios reciben notificaciones sobre actividades sospechosas en su cuenta.
- Las alertas se activan para informar a los usuarios sobre accesos inusuales o intentos de transacciones no autorizadas.

### 5. **Visualización de Movimientos y Saldo**

- Los usuarios pueden ver su saldo y los movimientos de su cuenta en tiempo real.
- La plataforma muestra un historial detallado de las transacciones realizadas, permitiendo un seguimiento claro de las finanzas.



## 📌 **Casos de Uso**

### **Propuesta Inicial Casos de Uso**
![Casos de uso](https://github.com/user-attachments/assets/30750f3d-338a-40c7-9078-4698937b577f)
### **Propuesta Final Casos de Uso**
![Casos de uso2](https://github.com/user-attachments/assets/13a5828c-3876-466b-8887-42a5b1d6c447)

## 📌 **Product Backlog - MVP No Bank**

### 🟡 **Frontend**

#### Tareas - Diseño de Vistas

| Tarea                                          | Descripción General                                           | Persona Responsable     |
|------------------------------------------------|---------------------------------------------------------------|-------------------------|
| **Diseño de Landing Page**                     | Crear el diseño de la página de bienvenida que da acceso a la plataforma. | Andree L Suarez |
| **Diseño de Vista de Login**                   | Crear el diseño de la interfaz de inicio de sesión, donde los usuarios ingresan sus credenciales. | Andree L Suarez |
| **Diseño de Vista de Registro**                | Crear el diseño de la página de registro para nuevos usuarios, donde se capturan sus datos iniciales. | Andree L Suarez |
| **Diseño de Vista de Recuperación de Cuenta**  | Crear el diseño de la página para recuperar cuentas olvidadas, donde los usuarios pueden restablecer su contraseña. | Andree L Suarez |
| **Diseño de Vista de Home**                    | Crear el diseño de la página principal que muestra el saldo, movimientos recientes y accesos rápidos. | Andree L Suarez |
| **Diseño de Vista de Movimientos**             | Crear el diseño de la página que lista los movimientos bancarios recientes y permite filtrar y ver detalles. | Andree L Suarez |
| **Diseño de Vista de Transferencias**          | Crear el diseño de la página donde los usuarios pueden ingresar los detalles para realizar transferencias bancarias. | Andree L Suarez |
| **Diseño de Vista de Notificaciones**          | Crear el diseño de la página para mostrar notificaciones relacionadas con actividades sospechosas o alertas de seguridad. | Leodan Valda |



#### Tareas - Implementación de Vistas

| Tarea                                          | Descripción General                                           | Persona Responsable     |
|------------------------------------------------|---------------------------------------------------------------|-------------------------|
| **Vista de Landing Page**                      | Implementar la página de bienvenida que da acceso a la plataforma, siguiendo el diseño de la Landing Page. | Alejandro Ibarra |
| **Vista de Login**                             | Implementar la vista de inicio de sesión, donde los usuarios ingresan sus credenciales, siguiendo el diseño de la Vista de Login. | Alejandro Ibarra |
| **Vista de Registro**                          | Implementar la página de registro, donde los usuarios pueden crear una cuenta proporcionando sus datos iniciales, siguiendo el diseño de la Vista de Registro. | Alejandro Ibarra |
| **Vista de Recuperación de Cuenta**            | Implementar la página para recuperar cuentas olvidadas, permitiendo a los usuarios restablecer sus contraseñas, siguiendo el diseño de la Vista de Recuperación de Cuenta. | Alejandro Ibarra |
| **Vista de Home**                              | Implementar la página principal que muestra el saldo, los movimientos recientes y accesos rápidos a otras funcionalidades, siguiendo el diseño de la Vista de Home. | Alejandro Ibarra |
| **Vista de Movimientos**                       | Implementar la página que muestra los movimientos bancarios recientes, permitiendo filtrado y detalles, siguiendo el diseño de la Vista de Movimientos. | Leodan Valda |
| **Vista de Transferencias**                    | Implementar la página donde los usuarios pueden realizar transferencias bancarias, siguiendo el diseño de la Vista de Transferencias. | Leodan Valda |
| **Vista de Notificaciones**                    | Implementar la página que muestra alertas de seguridad y notificaciones sobre actividades sospechosas, siguiendo el diseño de la Vista de Notificaciones. | Leodan Valda |

#### Integración con la API

| Tarea                                          | Descripción General                                           | Persona Responsable     |
|------------------------------------------------|---------------------------------------------------------------|-------------------------|
| **Integración con API de Autenticación**       | Conectar la vista de login con la API de autenticación para validar las credenciales del usuario. | Alejandro Ibarra |
| **Integración con API de Consultas de saldo**  | Conectar la vista de Dashboard con la API de consultas de saldo y movimientos. | Leodan Valda |
| **Integración con API de Transferencias**      | Conectar la vista de transferencias con la API para realizar las transferencias entre cuentas. | Leodan Valda |
| **Integración con API de Notificaciones**      | Conectar la vista de notificaciones con la API para mostrar alertas de actividades sospechosas. | Leodan Valda |

### 🟡 **Backend**

#### Módulos

| Tarea                                          | Descripción General                                           | Persona Responsable     |
|------------------------------------------------|---------------------------------------------------------------|-------------------------|
| **Módulo de Autenticación de Usuario**         | Implementar autenticación segura para los usuarios, incluyendo login y registro | Leodan Valda |
| **Módulo de Consultas de Cuenta**              | API para consultar el saldo, los movimientos y el estado de la cuenta del usuario. | Leodan Valda |
| **Módulo de Transferencias**                   | API para realizar transferencias bancarias entre cuentas, asegurando la correcta validación y ejecución de las transacciones. | Leodan Valda |
| **Módulo de Notificaciones**                   | Sistema para generar y enviar notificaciones sobre actividades sospechosas, alertas de seguridad o transacciones importantes. | Leodan Valda |
| **Módulo de Gestión de Cuentas**               | API para crear y leer cuentas de usuarios. Esto incluye la creación de nuevas cuentas y la gestión de la información del usuario. | Leodan Valda |
| **Módulo de Seguridad (Protección de Datos)**  | Implementación de medidas de seguridad como cifrado de datos y protección contra accesos no autorizados. | Leodan Valda |
| **Base de Datos (Modelo de Datos)**            | Estructurar la base de datos para almacenar las cuentas bancarias, transacciones, datos de los usuarios, y otros elementos esenciales. | Leodan Valda - Walther Smith |

## 📌 **Integrantes del Proyecto**

| Integrante        | Rol                                                                 |
|-------------------|---------------------------------------------------------------------|
| Luis Flores       | Team Leader |
| Andree L. Suarez  | Front end |
| Alejandro Ibarra  | Front end |
| Leodan Valda      | Front end |
| Walther Smith     | Back end |
| Alejandro Rua     | Back end |
| Juan Quiroz       | Back end |

## 📌 **Link de Interes**

### **Diseño Web**
- [Diseño Web - Figma](https://www.figma.com/design/syibDUBwJXCzSBsk0Gq75U/Banca-Digital)  
  - **Detalles**: Accede a los diseños de la plataforma en Figma para ver el diseño visual de la interfaz web, incluyendo la disposición de las vistas y los elementos interactivos.

### **Frontend**
- [Plataforma Web - Frontend](https://sparkling-bubblegum-c0488d.netlify.app/)
  - **Detalles**: Accede a la plataforma desde cualquier navegador. Al iniciar sesión con un usuario de prueba, es posible que necesites esperar un breve momento hasta que el backend esté activado.
  - **Recomendación**: Usa el siguiente usuario y contraseña de prueba para acceder a la plataforma:
    - **Usuario**: `12825111-1`
    - **Contraseña**: `leo123...`
  - **Observación**: Si al intentar iniciar sesión no tienes acceso inmediato, espera unos minutos. El servidor backend se detiene automáticamente si no recibe peticiones, por lo que es necesario darle un poco de tiempo para que se reactive. Una vez activo, podrás ingresar a la plataforma sin problemas.


### **Backend**
- [API - Backend - Swagger UI](https://nobank-falling-morning-9215.fly.dev/swagger-ui/index.html#/)
  - **Detalles**: Utiliza la interfaz Swagger UI para interactuar con las API del backend y probar los endpoints disponibles.
  - **Recomendación**: Para obtener un token de autenticación, primero debes realizar el login utilizando las credenciales de prueba.
  
  - **Proceso para obtener el token**:
    1. **Login**: Realiza una petición `POST` al endpoint `/login` con el siguiente cuerpo de solicitud:
       ```json
       {
         "login": "12825111-1",
         "password": "leo123..."
       }
       ```
    2. **Respuesta**: Si las credenciales son correctas, recibirás un **token de acceso** que podrás usar para realizar peticiones autenticadas a las API.
  
  - **Importante**:
    - Los métodos `POST` de login (autenticación de usuario) y la creación de usuario (registro) están **liberados para usarse sin token**, por lo que podrás probar estos métodos sin necesidad de estar autenticado.
  
  - **Observaciones**:
    - **Tiempo de espera**: El servidor que aloja la aplicación se detiene automáticamente si no recibe peticiones. Por lo tanto, es necesario esperar un poco antes de que el link funcione correctamente.
    - Una vez que obtengas el token, podrás realizar peticiones autenticadas a las API del backend utilizando dicho token en el encabezado `Authorization: Bearer <token>`.

  - **Nota adicional**: Si tienes algún problema con el servidor, te sugerimos esperar unos minutos y volver a intentar acceder a la API.
    
## 📜 **Licencia**

Este proyecto está bajo la licencia MIT.

