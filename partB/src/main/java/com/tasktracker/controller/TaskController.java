package com.tasktracker.controller;

import com.tasktracker.model.Task;
import com.tasktracker.model.Priority;
import com.tasktracker.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.createTask(task);
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTask(id);
    }

    @GetMapping("/priority/{priority}")
    public List<Task> filter(@PathVariable Priority priority) {
        return service.filterByPriority(priority);
    }
}