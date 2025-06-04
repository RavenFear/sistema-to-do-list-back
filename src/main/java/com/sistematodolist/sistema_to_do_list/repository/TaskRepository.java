package com.sistematodolist.sistema_to_do_list.repository;

import com.sistematodolist.sistema_to_do_list.entities.Task;
import com.sistematodolist.sistema_to_do_list.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad Task.
 * Extiende JpaRepository para proporcionar operaciones CRUD y funcionalidades adicionales
 * de acceso a datos sin necesidad de implementar métodos manualmente.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

     /**
      * Busca todas las tareas que coincidan con un estado específico.
      * Este método se genera automáticamente por Spring Data JPA a partir del nombre.
      *
      * @param status Estado de la tarea (por ejemplo: PENDIENTE, EN_PROGRESO, COMPLETADA).
      * @return Lista de tareas que tienen el estado indicado.
      */
     List<Task> findByStatus(TaskStatus status);
}
