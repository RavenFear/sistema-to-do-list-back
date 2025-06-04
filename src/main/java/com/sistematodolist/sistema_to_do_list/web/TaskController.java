package com.sistematodolist.sistema_to_do_list.web;

import com.sistematodolist.sistema_to_do_list.dtos.TaskDto;
import com.sistematodolist.sistema_to_do_list.dtos.UpdateTaskDto;
import com.sistematodolist.sistema_to_do_list.entities.Task;
import com.sistematodolist.sistema_to_do_list.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST que gestiona las operaciones CRUD de las tareas (Task).
 * Define los endpoints de la API relacionados con la entidad Task.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * Obtiene la lista completa de tareas.
     * @return Lista de tareas en formato DTO con código HTTP 200 OK.
     */
    @GetMapping("/lista-tareas")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        List<TaskDto> dtos = tasks.stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    /**
     * Busca una tarea por su ID.
     * @param id Identificador de la tarea.
     * @return Tarea encontrada en formato DTO o 404 si no existe.
     */
    @GetMapping("/buscar-tarea/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(task -> ResponseEntity.ok(toDto(task)))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crea una nueva tarea a partir del cuerpo de la solicitud.
     * @param dto Objeto DTO con los datos de la nueva tarea.
     * @return Tarea creada en formato DTO con código HTTP 200 OK.
     */
    @PostMapping("/crear-tarea")
    public ResponseEntity<TaskDto> createTask(@RequestBody UpdateTaskDto dto) {
        Task task = toEntity(dto);
        Task created = taskService.createTask(task);
        return ResponseEntity.ok(toDto(created));
    }

    /**
     * Actualiza una tarea existente por su ID.
     * @param id Identificador de la tarea a actualizar.
     * @param dto Datos nuevos de la tarea.
     * @return Tarea actualizada o 404 si no se encuentra.
     */
    @PutMapping("/editar-tarea/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody UpdateTaskDto dto) {
        Task task = toEntity(dto);
        return taskService.updateTask(id, task)
                .map(updated -> ResponseEntity.ok(toDto(updated)))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Elimina una tarea por su ID.
     * @param id Identificador de la tarea.
     * @return HTTP 204 No Content si se elimina correctamente o 404 si no existe.
     */
    @DeleteMapping("/eliminar-tarea/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.deleteTask(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Convierte una entidad Task a un objeto DTO.
     * @param task Entidad de base de datos.
     * @return Objeto TaskDto.
     */
    private TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setNombre(task.getNombre());
        dto.setDescripcion(task.getDescripcion());
        dto.setStatus(task.getStatus());
        dto.setFechaCompromiso(task.getFechaCompromiso());
        dto.setFechaRegistro(task.getFechaRegistro());
        return dto;
    }

    /**
     * Convierte un DTO recibido desde el frontend a una entidad Task.
     * @param dto Objeto recibido en el request.
     * @return Entidad Task lista para ser persistida.
     */
    private Task toEntity(UpdateTaskDto dto) {
        Task task = new Task();
        task.setNombre(dto.getNombre());
        task.setDescripcion(dto.getDescripcion());
        task.setStatus(dto.getStatus());
        task.setFechaCompromiso(dto.getFechaCompromiso());
        task.setFechaRegistro(dto.getFechaRegistro());
        return task;
    }
}
