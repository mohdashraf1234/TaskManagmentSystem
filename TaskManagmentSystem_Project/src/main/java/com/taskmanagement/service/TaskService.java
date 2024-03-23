// TaskService.java
package com.taskmanagement.service;

import java.util.List;
import com.taskmanagement.model.Task;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    void saveTask(Task task);
    void updateTask(Task task);
    void deleteTask(Long id);
    void completeTask(Long id);
    List<Task> getCompletedTasks();
}


