package com.taskmanagement.controller;

import com.taskmanagement.model.Task;
import java.util.List;
import com.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

   
    @GetMapping("/")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", taskService.getAllTasks());
        return "task-form";
    }


    @PostMapping("/save")
    public String saveTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/";
    }

    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "edit-task";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute Task task) {
        taskService.updateTask(task);
        return "redirect:/";
    }
   

    
    @RequestMapping(value = "/deletetask", method = RequestMethod.POST)
    public String deleteTask(@RequestParam("taskId") Long taskId) {
    	System.out.println("53---------------.");
        taskService.deleteTask(taskId);
        return "redirect:/"; 
    }


    @PostMapping("/complete")
    public String completeTask(@RequestParam("id") Long id) {
        taskService.deleteTask(id); 
        return "redirect:/"; 
    }



    
    @GetMapping("/completedTasks")
    public String showCompletedTasks(Model model) {
        List<Task> completedTasks = taskService.getCompletedTasks();
        System.out.println("--------------"+completedTasks);
        model.addAttribute("completedTasks", completedTasks);
        return "completedTask";
    }




}
