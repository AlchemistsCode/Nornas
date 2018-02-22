package com.alchemistscode.nornas.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView welcome(HttpServletRequest request){
        return new ModelAndView("index");
    }
}
