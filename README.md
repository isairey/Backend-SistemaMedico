# 🏥 Sistema Médico API

<div align="center">

# ⚕️ Backend para la Gestión Integral de Consultas Médicas

### API REST desarrollada con Spring Boot, Java y MySQL

<p align="center">

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=for-the-badge&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity)
![JWT](https://img.shields.io/badge/JWT-Authentication-000000?style=for-the-badge&logo=jsonwebtokens)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-success?style=for-the-badge)

</p>

</div>

---

# 📌 Descripción

**Sistema Médico API** es el backend de una plataforma de administración clínica desarrollado con **Spring Boot**, diseñado para gestionar de manera segura y eficiente la información relacionada con pacientes, médicos, citas, diagnósticos, tratamientos e historiales clínicos.

La API implementa una arquitectura REST moderna, autenticación mediante JWT, acceso basado en roles y persistencia de datos utilizando Spring Data JPA y MySQL.

---

# 🚀 Características

## 🔐 Autenticación y Seguridad

- Inicio de sesión mediante JWT.
- Registro de usuarios.
- Spring Security.
- Contraseñas cifradas con BCrypt.
- Roles y permisos.
- Protección de endpoints.
- Control de sesiones.
- Validación de credenciales.

---

## 👨‍⚕️ Gestión de Médicos

- Registrar médicos.
- Editar información.
- Especialidades.
- Consultorios.
- Disponibilidad.
- Eliminación lógica.
- Búsqueda por especialidad.

---

## 🧑‍🦱 Gestión de Pacientes

- Registro de pacientes.
- Actualización de datos.
- Expediente clínico.
- Información de contacto.
- Historial de consultas.
- Consulta rápida.

---

## 📅 Gestión de Citas

- Agendar citas.
- Reprogramar citas.
- Cancelar citas.
- Consultar disponibilidad.
- Historial de citas.
- Estados de la cita.
- Recordatorios.

---

## 🩺 Diagnósticos

- Registro de diagnósticos.
- Observaciones médicas.
- Enfermedades detectadas.
- Evolución del paciente.
- Notas clínicas.

---

## 💊 Tratamientos

- Registro de tratamientos.
- Prescripción médica.
- Medicamentos.
- Indicaciones.
- Seguimiento.

---

## 📋 Historial Clínico

- Consultas anteriores.
- Diagnósticos.
- Tratamientos.
- Recetas.
- Estudios médicos.
- Evolución clínica.

---

## 💉 Especialidades Médicas

- Medicina General
- Pediatría
- Cardiología
- Neurología
- Ginecología
- Traumatología
- Dermatología
- Psicología
- Odontología
- Oftalmología

---

## 📊 Reportes

- Pacientes registrados.
- Citas por día.
- Citas por médico.
- Historial médico.
- Diagnósticos realizados.
- Estadísticas generales.

---

## 🔔 Notificaciones

- Próximas citas.
- Cancelaciones.
- Nuevos pacientes.
- Recordatorios médicos.

---

# 🏗️ Arquitectura

El proyecto implementa una arquitectura multicapa siguiendo las mejores prácticas de Spring Boot.

- Controller
- Service
- Repository
- Entity
- DTO
- Mapper
- Configuration
- Security
- Exception
- Validation

---

# 🛠️ Tecnologías Utilizadas

## Backend

- Java 21
- Spring Boot 3
- Spring MVC
- Spring Data JPA
- Hibernate
- Spring Security
- JWT
- Lombok
- Maven

## Base de Datos

- MySQL
- PostgreSQL (Compatible)

## Documentación

- Swagger / OpenAPI

## Herramientas

- IntelliJ IDEA
- Visual Studio Code
- Postman
- Git
- GitHub

---

# 📂 Estructura del Proyecto

```text
SistemaMedicoAPI/
│
├── src/
│   ├── main/
│   │
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── sismedico/
│   │
│   │               ├── config/
│   │               ├── controller/
│   │               ├── dto/
│   │               ├── entity/
│   │               ├── mapper/
│   │               ├── repository/
│   │               ├── security/
│   │               ├── service/
│   │               ├── exception/
│   │               ├── util/
│   │               └── SistemaMedicoApplication.java
│   │
│   └── resources/
│       ├── application.properties
│       ├── static/
│       └── templates/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

# 📡 API REST

## Autenticación

- `POST /api/auth/login`
- `POST /api/auth/register`
- `POST /api/auth/refresh-token`

---

## Usuarios

- `GET /api/usuarios`
- `GET /api/usuarios/{id}`
- `POST /api/usuarios`
- `PUT /api/usuarios/{id}`
- `DELETE /api/usuarios/{id}`

---

## Médicos

- `GET /api/medicos`
- `POST /api/medicos`
- `PUT /api/medicos/{id}`
- `DELETE /api/medicos/{id}`

---

## Pacientes

- `GET /api/pacientes`
- `POST /api/pacientes`
- `PUT /api/pacientes/{id}`
- `DELETE /api/pacientes/{id}`

---

## Citas

- `GET /api/citas`
- `POST /api/citas`
- `PUT /api/citas/{id}`
- `DELETE /api/citas/{id}`

---

## Diagnósticos

- `GET /api/diagnosticos`
- `POST /api/diagnosticos`
- `PUT /api/diagnosticos/{id}`
- `DELETE /api/diagnosticos/{id}`

---

## Tratamientos

- `GET /api/tratamientos`
- `POST /api/tratamientos`
- `PUT /api/tratamientos/{id}`
- `DELETE /api/tratamientos/{id}`

---

# ⚙️ Instalación

## 1. Clonar el repositorio

```bash
git clone https://github.com/usuario/sistema-medico-api.git
```

Entrar al proyecto

```bash
cd sistema-medico-api
```

---

## 2. Crear la base de datos

```sql
CREATE DATABASE sistema_medico;
```

---

## 3. Configurar el archivo `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sistema_medico

spring.datasource.username=root

spring.datasource.password=tu_password

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true
```

---

## 4. Instalar dependencias

```bash
mvn clean install
```

---

## 5. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

o

```bash
./mvnw spring-boot:run
```

---

## 6. Acceder a la API

```text
http://localhost:8080
```

---

# 📖 Documentación de la API

Si Swagger está habilitado:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON:

```text
http://localhost:8080/v3/api-docs
```

---

# 🔒 Seguridad

- JWT Authentication.
- Spring Security.
- BCrypt Password Encoder.
- Protección por roles.
- Validación de datos.
- Manejo global de excepciones.
- Protección de endpoints.
- Arquitectura segura para APIs REST.

---

# 📊 Módulos

| Módulo | Estado |
|---------|:------:|
| Autenticación | ✅ |
| Usuarios | ✅ |
| Roles | ✅ |
| Médicos | ✅ |
| Pacientes | ✅ |
| Especialidades | ✅ |
| Citas | ✅ |
| Diagnósticos | ✅ |
| Tratamientos | ✅ |
| Historial Clínico | ✅ |
| Reportes | ✅ |
| Seguridad | ✅ |

---

# 🚀 Funcionalidades Futuras

- 📱 Aplicación móvil.
- ☁️ Despliegue en Docker.
- 🐳 Kubernetes.
- 📄 Generación de recetas PDF.
- 📅 Calendario médico.
- 📧 Notificaciones por correo.
- 📲 Recordatorios por WhatsApp.
- 💳 Gestión de pagos.
- 🧠 Inteligencia Artificial para apoyo al diagnóstico.
- 📊 Dashboard analítico.
- 🌍 Multiidioma.
- 🔔 WebSockets para notificaciones en tiempo real.

---

# 🤝 Contribuciones

Las contribuciones son bienvenidas.

1. Haz un **Fork** del proyecto.
2. Crea una nueva rama.

```bash
git checkout -b feature/nueva-funcionalidad
```

3. Realiza tus cambios.

```bash
git commit -m "Nueva funcionalidad"
```

4. Envía tus cambios.

```bash
git push origin feature/nueva-funcionalidad
```

5. Abre un **Pull Request**.

---

# 📜 Licencia

Este proyecto se distribuye bajo la licencia **MIT**, permitiendo su uso, modificación y distribución para proyectos personales, académicos y comerciales.

---

# 👨‍💻 Autor

Desarrollado como el backend de un **Sistema Médico** utilizando **Java**, **Spring Boot**, **Spring Security**, **Spring Data JPA**, **Hibernate** y **MySQL**, implementando una API REST escalable, segura y preparada para integrarse con aplicaciones web y móviles.

---

<div align="center">

# 🏥 Sistema Médico API

### Backend Inteligente para la Gestión Clínica

**Pacientes • Médicos • Citas • Diagnósticos • Tratamientos • Seguridad**

⭐ Si este proyecto te resulta útil, no olvides darle una estrella en GitHub.

</div>
