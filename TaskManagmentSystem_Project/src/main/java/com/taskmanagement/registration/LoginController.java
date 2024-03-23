package com.taskmanagement.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taskmanagement.model.Task;
import com.taskmanagement.service.TaskService;
import com.taskmanagement.service.UserService;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login"; 
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) throws IOException {
        boolean authenticated = userService.authenticate(username, password);

        if (authenticated) {
        	System.out.println("32------------>");
            return "redirect:/task-form"; 
        } else {
            
        	System.out.println("36------------>");
            return "redirect:/login?error";
        }
    }
    @GetMapping("/forgot-password")
    public String showForgotPasswordPage() {
        return "forgot-password"; 
    }
    @Autowired
    private TaskService taskService;
    @GetMapping("/task-form")
    public String showDemoPage(Model model) {
    	 model.addAttribute("task", new Task());
         model.addAttribute("tasks", taskService.getAllTasks());
         return "task-form";
    }
}
