package com.alchemistscode.nornas.api.controller;

import com.alchemistscode.nornas.api.entity.Trigger;
import com.alchemistscode.nornas.api.service.TriggerService;

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
@RequestMapping("/trigger")
public class TriggerController{
    @Autowired
    private TriggerService service;

    @GetMapping("/all")
    public List<Trigger> findall(){
        return service.findAll();
    }

    @GetMapping("/active")
    public List<Trigger> findActive(){
        return service.findActive();
    }

    @GetMapping("{id}")
    public Trigger findTrigger(@PathVariable Integer id){
        return service.find(id);
    }

    @PutMapping("")
    public void triggerRegister(@RequestBody Trigger trigger){
        service.register(trigger);
    }

    @PostMapping("")
    public void TriggerUpdate(@RequestBody Trigger trigger){
        service.update(trigger);
    }

    @DeleteMapping("{id}")
    public void TriggerDelete(@PathVariable Integer id){
        service.delete(id);
    }

}