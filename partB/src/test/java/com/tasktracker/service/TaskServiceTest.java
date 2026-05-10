package com.tasktracker.service;

import com.tasktracker.model.Priority;
import com.tasktracker.model.Task;
import com.tasktracker.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    private Task sampleTask;

    @BeforeEach
    void setUp() {
        sampleTask = new Task();
        sampleTask.setId(1L);
        sampleTask.setTitle("Study");
        sampleTask.setDescription("Do assignment");
        sampleTask.setStatus(false);
        sampleTask.setPriority(Priority.HIGH);
        sampleTask.setLabel("school");
    }

    @Test
    void createTask_shouldSaveTask() {
        when(repository.save(sampleTask)).thenReturn(sampleTask);

        Task result = service.createTask(sampleTask);

        assertNotNull(result);
        assertEquals("Study", result.getTitle());
        verify(repository, times(1)).save(sampleTask);
    }

    @Test
    void getAllTasks_shouldReturnAllTasks() {
        when(repository.findAll()).thenReturn(List.of(sampleTask));

        List<Task> result = service.getAllTasks();

        assertEquals(1, result.size());
        assertEquals("Study", result.get(0).getTitle());
        verify(repository, times(1)).findAll();
    }

    @Test
    void updateTask_shouldUpdateExistingTask() {
        Task updated = new Task();
        updated.setTitle("Updated");
        updated.setDescription("New desc");
        updated.setStatus(true);
        updated.setPriority(Priority.MEDIUM);
        updated.setLabel("work");

        when(repository.findById(1L)).thenReturn(Optional.of(sampleTask));
        when(repository.save(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Task result = service.updateTask(1L, updated);

        assertEquals("Updated", result.getTitle());
        assertEquals("New desc", result.getDescription());
        assertEquals(true, result.getStatus());
        assertEquals(Priority.MEDIUM, result.getPriority());
        verify(repository).findById(1L);
        verify(repository).save(any(Task.class));
    }

    @Test
    void deleteTask_shouldCallRepositoryDeleteById() {
        service.deleteTask(1L);

        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void filterByPriority_shouldReturnMatchingTasks() {
        when(repository.findByPriority(Priority.HIGH)).thenReturn(List.of(sampleTask));

        List<Task> result = service.filterByPriority(Priority.HIGH);

        assertEquals(1, result.size());
        assertEquals(Priority.HIGH, result.get(0).getPriority());
        verify(repository, times(1)).findByPriority(Priority.HIGH);
    }

    @Test
    void createTask_shouldPassCorrectDataToRepository() {
        when(repository.save(any(Task.class))).thenReturn(sampleTask);

        service.createTask(sampleTask);

        ArgumentCaptor<Task> captor = ArgumentCaptor.forClass(Task.class);
        verify(repository).save(captor.capture());
        assertEquals("Study", captor.getValue().getTitle());
    }
}