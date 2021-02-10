package com.equadesign.loginPage.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class loginController {

    public String loginCreationForm(){
        return "login";
    }
}
