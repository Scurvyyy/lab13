package com.tasktracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tasktracker.model.Priority;
import com.tasktracker.model.Task;
import com.tasktracker.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TaskService service;

    private Task buildTask() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Study");
        task.setDescription("Do assignment");
        task.setStatus(false);
        task.setPriority(Priority.HIGH);
        task.setLabel("school");
        return task;
    }

    @Test
    void createTask_shouldReturnCreatedTask() throws Exception {
        Task task = buildTask();
        when(service.createTask(task)).thenReturn(task);

        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Study"))
                .andExpect(jsonPath("$.priority").value("HIGH"));
    }

    @Test
    void getAllTasks_shouldReturnList() throws Exception {
        when(service.getAllTasks()).thenReturn(List.of(buildTask()));

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Study"));
    }

    @Test
    void updateTask_shouldReturnUpdatedTask() throws Exception {
        Task task = buildTask();
        task.setTitle("Updated");
        when(service.updateTask(1L, task)).thenReturn(task);

        mockMvc.perform(put("/tasks/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated"));
    }

    @Test
    void deleteTask_shouldReturnOk() throws Exception {
        mockMvc.perform(delete("/tasks/1"))
                .andExpect(status().isOk());
    }

    @Test
    void filterByPriority_shouldReturnFilteredList() throws Exception {
        when(service.filterByPriority(Priority.HIGH)).thenReturn(List.of(buildTask()));

        mockMvc.perform(get("/tasks/priority/HIGH"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].priority").value("HIGH"));
    }
}