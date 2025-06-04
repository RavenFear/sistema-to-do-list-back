# Sistema TaskPilot+ - Backend (Spring Boot)

Este proyecto es el backend de un sistema de gestión de tareas (To-Do List) desarrollado con **Spring Boot**.
Proporciona una API REST para la creación, actualización, consulta y eliminación de tareas, con soporte para paginación
y filtrado.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- Base de datos H2 (o cualquier otra configurada)
- Lombok
- Maven
- Jakarta Persistence (JPA)
- Spring Web (REST API)

---

## Estructura del proyecto

- **entities**: Clases de entidad JPA que representan las tablas de la base de datos.
- **enums**: Enumeraciones para estados de tareas.
- **repository**: Interfaces para el acceso a datos extendiendo JpaRepository y JpaSpecificationExecutor.
- **services**: Lógica de negocio y acceso a datos a través de los repositorios.
- **dtos**: Objetos de transferencia de datos para interacción con la API REST.
- **controllers**: Controladores REST que exponen los endpoints para consumir la API.

---

## Funcionalidades principales

- Crear, consultar, actualizar y eliminar tareas.
- Paginación y filtros para búsqueda eficiente de tareas.
- Estado de tarea con enum (`CREADO`, `EN_CURSO`, `FINALIZADO`).
- Fechas de registro y compromiso.
- Transformación entre entidad y DTO para mantener buena práctica de diseño.

---

## Endpoints principales

| Método | URL             | Descripción                                 |
|--------|-----------------|---------------------------------------------|
| GET    | `/lista-tareas` | Obtener lista de tareas paginada y filtrada |
| POS    
