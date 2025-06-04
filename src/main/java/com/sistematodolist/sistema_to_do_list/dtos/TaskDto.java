package com.sistematodolist.sistema_to_do_list.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sistematodolist.sistema_to_do_list.enums.TaskStatus;
import lombok.*;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) utilizado para enviar datos de la entidad Task al cliente.
 * Este objeto encapsula todos los campos relevantes para mostrar información de una tarea.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    /**
     * Identificador único de la tarea.
     */
    private Long id;

    /**
     * Nombre o título de la tarea.
     */
    private String nombre;

    /**
     * Descripción detallada de la tarea.
     */
    private String descripcion;

    /**
     * Estado actual de la tarea (CREADO, EN_CURSO, FINALIZADO).
     */
    private TaskStatus status;

    /**
     * Fecha en la que se registró la tarea.
     * Se serializa/deserializa en formato "yyyy-MM-dd".
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    /**
     * Fecha compromiso para finalizar la tarea.
     * Se serializa/deserializa en formato "yyyy-MM-dd".
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaCompromiso;
}
