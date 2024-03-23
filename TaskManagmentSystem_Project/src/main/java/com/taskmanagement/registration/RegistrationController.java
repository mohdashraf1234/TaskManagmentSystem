package com.taskmanagement.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//RegistrationController
@Controller
public class RegistrationController {

 @Autowired
 private UserRepository userRepository;

 @GetMapping("/register")
 public String showRegistrationForm(Model model) {
     model.addAttribute("user", new User());
     return "registration"; 
 }

 @PostMapping("/register")
 public String registerUser(@Validated @ModelAttribute User user, BindingResult bindingResult, Model model) {
     if (bindingResult.hasErrors()) {
         return "registration";
     }

     if (userRepository.findByUsername(user.getUsername()) != null) {
         bindingResult.addError(new FieldError("user", "username", "Username already exists"));
         return "registration";
     }

     userRepository.save(user);
     model.addAttribute("successMessage", "Registration successful!");
     return "registration";
 }
}
