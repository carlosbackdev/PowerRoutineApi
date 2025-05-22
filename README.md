# 💪 PowerRoutineApi

PowerRoutineApi es una API REST desarrollada en Java con Spring Boot, diseñada para servir como backend de la aplicación Android [PowerRoutine](https://github.com/carlosbackdev/PowerRoutine-App). La API gestiona usuarios, rutinas, ejercicios, músculos, objetivos, niveles y partes del cuerpo, almacenando toda la información en una base de datos PostgreSQL.

## ✨ Características Principales

- � Arquitectura limpia basada en capas: separación clara de responsabilidades para facilitar el mantenimiento y la escalabilidad.
- ☕ Desarrollo con Spring Boot: siguiendo las mejores prácticas de la arquitectura en capas.
- 🐘 Base de datos PostgreSQL: robusta y eficiente.
- 🔄 DTOs: transferencia eficiente y segura de datos entre el backend y el cliente Android.
- 🗂️ Estructura común de modelos:
  - `id`: identificador único (clave primaria).
  - `nombre`: nombre del objeto (ejercicio, músculo, rutina...).
  - `imagen`: URL o nombre del recurso asociado.
  - `descripcion`: detalles adicionales (según el modelo).
  - Otros campos según la entidad.

#### 🏗️ Desplegada en Contenedor Docker

## 🏛️ Arquitectura en Capas

La API está organizada siguiendo el patrón de arquitectura en capas, típico de aplicaciones Spring Boot:

Cliente (Android) 📱
⬇️
Controlador (Controller) 🎛️
⬇️
Servicio (Service) 🛠️
⬇️
Repositorio (Repository) 🗄️
⬇️
Base de datos (PostgreSQL) 🐘
⬆️
DTO (Data Transfer Object) 🔄
⬆️
Respuesta JSON para Android 📨
### 🏆 Ventajas de esta arquitectura

- � Escalabilidad: fácil de extender y mantener.
- ♻️ Reutilización de código: componentes desacoplados y reutilizables.
- 🧩 Organización: separación clara de lógica de negocio, acceso a datos y presentación.

## 🔗 Endpoints principales

Lista de los endpoints REST más relevantes.

### 👤 Usuarios (`/user`)

- `POST /user/login` — Iniciar sesión de usuario.
- `POST /user/register` — Registrar nuevo usuario.
- `POST /user/update` — Actualizar datos de usuario.
- `POST /user/delete` — Eliminar usuario.

### 📝 Rutinas (`/rutine`)

- `POST /rutine/getRutine` — Obtener rutinas recomendadas.
- `POST /rutine/saveRutineUser` — Guardar rutina para usuario.
- `POST /rutine/getRutineUser` — Consultar rutinas de un usuario.
- `POST /rutine/updateRutineUser` — Actualizar rutina de usuario.

### 🏋️ Ejercicios (`/ejercice`)

- `POST /ejercice/getEjercices` — Obtener ejercicios de una rutina.
- `GET /ejercice/getAllEjercices` — Listar todos los ejercicios.

### 💪 Músculos (`/muscle`)

- `GET /muscle/getMuscles` — Listar todos los músculos.

### 🎯 Objetivos (`/objetive`)

- `GET /objetive/getAllObjetives` — Listar todos los objetivos.

### 🥇 Niveles (`/level`)

- `GET /level/getAllLevels` — Listar todos los niveles.

### 🧍‍♂️ Partes del cuerpo (`/body`)

- `POST /body/getBodys` — Obtener datos de partes del cuerpo por ID.
- `GET /body/getAllBodys` — Listar todas las partes del cuerpo.

### 📈 Progreso del usuario (`/userCompletes`)

- `POST /userCompletes/getUserCompletes` — Consultar progreso de usuario.
- `POST /userCompletes/isComplete` — Marcar rutina como completada por usuario.

## 🔎 Consulta el código fuente

Para ver todos los endpoints disponibles:
[Ver controladores en GitHub](https://github.com)

## 📝 Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.

¿Necesitas ejemplos de uso de algún endpoint? ¡No dudes en pedirlos! 🚀
