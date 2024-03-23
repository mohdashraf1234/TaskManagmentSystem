// TaskServiceImpl.java
package com.taskmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taskmanagement.model.Task;
import com.taskmanagement.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void completeTask(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        System.out.println(task+"----------------->");
        if (task != null) {
            task.setCompleted(true);
            taskRepository.save(task);
        }
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public List<Task> getCompletedTasks() {
        return taskRepository.findByCompleted(false);
    }

}

