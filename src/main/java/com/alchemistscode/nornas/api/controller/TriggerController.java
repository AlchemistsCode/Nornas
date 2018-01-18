package com.alchemistscode.nornas.api.controller;

import com.alchemistscode.nornas.api.entity.Trigger;
import com.alchemistscode.nornas.api.service.TriggerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trigger")
public class TriggerController{
    @Autowired
    private TriggerService service;

    @GetMapping("")
    public List<Trigger> findAll(){ return service.allTrigger();
    }

}