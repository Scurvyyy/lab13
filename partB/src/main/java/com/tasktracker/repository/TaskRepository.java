package com.tasktracker.repository;

import com.tasktracker.model.Task;
import com.tasktracker.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByPriority(Priority priority);

}