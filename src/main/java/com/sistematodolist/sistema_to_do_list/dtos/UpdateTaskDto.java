package com.sistematodolist.sistema_to_do_list.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sistematodolist.sistema_to_do_list.enums.TaskStatus;
import lombok.*;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) utilizado para la creación y actualización de tareas.
 * Este objeto encapsula los datos que se recibirán desde el cliente para modificar una entidad Task.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskDto {

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
     * Fecha de registro de la tarea.
     * Se espera en formato "yyyy-MM-dd".
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    /**
     * Fecha compromiso para la finalización de la tarea.
     * Se espera en formato "yyyy-MM-dd".
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaCompromiso;
}
