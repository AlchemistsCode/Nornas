package com.alchemistscode.nornas.api.controller;

import com.alchemistscode.nornas.api.entity.Scheduler;
import com.alchemistscode.nornas.api.service.SchedulerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController{
    @Autowired
    private SchedulerService service;

    @GetMapping("/all")
    public List<Scheduler> findall(){
        return service.findAll();
    }

    @GetMapping("/active")
    public List<Scheduler> findActive(){
        return service.findActive();
    }

    @GetMapping("/{id}")
    public Scheduler findScheduler(@PathVariable Integer id){
        return service.find(id);
    }

    @PutMapping("")
    public void schedulerRegister(@RequestBody Scheduler scheduler){
        service.register(scheduler);
    }

    @PostMapping("")
    public void schedulerUpdate(@RequestBody Scheduler scheduler){
        service.update(scheduler);
    }

    @DeleteMapping("/{id}")
    public void schedulerDelete(@PathVariable Integer id){
        service.delete(id);
    }
}