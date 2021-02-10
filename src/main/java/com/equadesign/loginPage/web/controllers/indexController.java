package com.equadesign.loginPage.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"","/"})
public class indexController {
    public String index(){
        return "index";
    }
}
