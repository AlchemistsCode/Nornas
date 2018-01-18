package com.alchemistscode.nornas.api.controller;

import com.alchemistscode.nornas.api.entity.Job;
import com.alchemistscode.nornas.api.service.JobService;

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
@RequestMapping("/job")
public class JobController{
    @Autowired
    private JobService service;

    @GetMapping("/all")
    public List<Job> findall(){
        return service.findAll();
    }

    @GetMapping("/active")
    public List<Job> findActive(){
        return service.findActive();
    }

    @GetMapping("{id}")
    public Job findJob(@PathVariable Integer id){
        return service.find(id);
    }

    @PutMapping("")
    public void JobRegister(@RequestBody Job job){
        service.register(job);
    }

    @PostMapping("")
    public void JobUpdate(@RequestBody Job job){
        service.update(job);
    }

    @DeleteMapping("{id}")
    public void JobDelete(@PathVariable Integer id){
        service.delete(id);
    }
}