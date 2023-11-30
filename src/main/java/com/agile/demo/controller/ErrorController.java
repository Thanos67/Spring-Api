package com.agile.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import static com.sun.javafx.css.StyleManager.getErrors;


@Controller
public class ErrorController {

    // ...

    @GetMapping("/error")
    public String showErrorPage(Model model) {
        // Add error messages to the model
        //model.addAttribute("errors", getErrors());

        return "error";
    }
}