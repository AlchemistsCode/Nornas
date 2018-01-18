package com.alchemistscode.nornas.api.controller;

import com.alchemistscode.nornas.api.entity.Scheduler;
import com.alchemistscode.nornas.api.service.SchedulerService;

import java.util.List;

import java.lang.Iterable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController{
    @Autowired
    private SchedulerService service;

    @GetMapping("")
    public List<Scheduler> findall(){
        return service.allScheduler();
    }

}