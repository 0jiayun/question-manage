package com.example.questionairmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Acloud
 * @message
 * @date 2021/4/28 12:01
 **/
@Controller

public class IndexController {
    @RequestMapping(value = "")
    public String homePage(){
        return "login.html";
    }


}
