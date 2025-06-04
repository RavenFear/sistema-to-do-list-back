package com.sistematodolist.sistema_to_do_list.enums;

/**
 * Enumeración que representa los diferentes estados posibles de una tarea.
 * Se utiliza para definir y restringir el valor del estado de una tarea dentro del sistema.
 */
public enum TaskStatus {

    /**
     * Indica que la tarea ha sido creada pero aún no ha comenzado.
     */
    CREADO,

    /**
     * Indica que la tarea está actualmente en proceso de ejecución.
     */
    EN_CURSO,

    /**
     * Indica que la tarea ha sido completada.
     */
    FINALIZADO
}
