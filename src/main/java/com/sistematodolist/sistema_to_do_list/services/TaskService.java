package com.sistematodolist.sistema_to_do_list.services;

import com.sistematodolist.sistema_to_do_list.entities.Task;
import com.sistematodolist.sistema_to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar la lógica de negocio relacionada con las tareas (Task).
 * Utiliza el repositorio TaskRepository para acceder a la base de datos.
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * Obtiene todas las tareas registradas en la base de datos.
     * @return Lista de entidades Task.
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Busca una tarea por su identificador único.
     * @param id ID de la tarea.
     * @return Optional que contiene la tarea si se encuentra, o vacío si no existe.
     */
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    /**
     * Crea una nueva tarea en la base de datos.
     * @param task Objeto Task que se desea persistir.
     * @return Tarea creada y guardada con ID asignado.
     */
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Actualiza una tarea existente si se encuentra por su ID.
     * @param id ID de la tarea que se desea actualizar.
     * @param updatedTask Datos nuevos que se aplicarán a la tarea existente.
     * @return Optional con la tarea actualizada, o vacío si no se encontró la tarea.
     */
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setNombre(updatedTask.getNombre());
            task.setDescripcion(updatedTask.getDescripcion());
            task.setStatus(updatedTask.getStatus());
            task.setFechaRegistro(updatedTask.getFechaRegistro());
            task.setFechaCompromiso(updatedTask.getFechaCompromiso());
            return taskRepository.save(task);
        });
    }

    /**
     * Elimina una tarea por su ID si existe.
     * @param id ID de la tarea a eliminar.
     * @return true si la tarea fue eliminada, false si no existía.
     */
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
