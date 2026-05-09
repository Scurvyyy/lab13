package com.tasktracker.service;

import com.tasktracker.model.Task;
import com.tasktracker.model.Priority;
import com.tasktracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task updateTask(Long id, Task newTask) {
        Task task = repository.findById(id).orElseThrow();
        task.setTitle(newTask.getTitle());
        task.setDescription(newTask.getDescription());
        task.setPriority(newTask.getPriority());
        task.setStatus(newTask.getStatus());
        return repository.save(task);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public List<Task> filterByPriority(Priority priority) {
        return repository.findByPriority(priority);
    }
}