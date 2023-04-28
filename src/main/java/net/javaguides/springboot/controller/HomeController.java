
package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
	
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home - Forensic Management System");
        return "home";
    }

    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("title", "Sign Up - Forensic Management System");
        return "signUp";
    }

    @PostMapping("/signUp")
    public String doSignUp(@RequestParam String username, @RequestParam String password, Model model) {
        // perform user authentication logic here, such as checking against a database
        if (username.equals("admin") && password.equals("password")) {
            // if authentication is successful, redirect to home page
            return "redirect:/home2";
        } else {
            // if authentication fails, return error message to sign up page
            model.addAttribute("error", "Invalid username or password");
            return "signUp";
}
    }
    
    @GetMapping("/home2")
    public String dashboard(Model model) {
        model.addAttribute("title", "Dashboard - Forensic Management System");
        return "home2";
    }
}

    
    
    
    