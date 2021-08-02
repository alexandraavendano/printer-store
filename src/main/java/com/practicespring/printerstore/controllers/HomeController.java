package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.models.Client;
import com.practicespring.printerstore.service.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeController {

    private final ClientServices clientServices;

    @Autowired
    public HomeController(ClientServices clientServices){
        this.clientServices = clientServices;
    }

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String searchEmployeeByNumber(@RequestParam("email") String employeeEmail, Model model) throws ClassNotFoundException {
        Optional<Client> employee = clientServices.findBy(employeeEmail);
        employee.ifPresent(client -> model.addAttribute("employee", client));
        return "login";
    }
}
