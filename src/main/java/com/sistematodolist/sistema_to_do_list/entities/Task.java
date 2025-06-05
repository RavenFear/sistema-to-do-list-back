package com.sistematodolist.sistema_to_do_list.entities;

import com.sistematodolist.sistema_to_do_list.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entidad que representa una tarea dentro del sistema.
 * Se almacena en la base de datos y contiene información esencial
 * como nombre, descripción, fechas y estado.
 */
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    /**
     * Identificador único de la tarea.
     * Se genera automáticamente mediante la estrategia de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Fecha en la que se registró la tarea.
     */
    private LocalDate fechaRegistro;

    /**
     * Nombre o título de la tarea.
     */
    private String nombre;

    /**
     * Descripción detallada de la tarea.
     */
    @Column(columnDefinition="TEXT")
    private String descripcion;

    /**
     * Estado actual de la tarea (CREADO, EN_CURSO, FINALIZADO).
     */
    private TaskStatus status;

    /**
     * Fecha en la que se compromete a finalizar la tarea.
     */
    private LocalDate fechaCompromiso;
}
