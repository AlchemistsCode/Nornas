package com.alchemistscode.nornas.api.controller;

import com.alchemistscode.nornas.api.entity.Job;
import com.alchemistscode.nornas.api.service.JobService;

import java.util.List;

import java.lang.Iterable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController{
    @Autowired
    private JobService service;

    @GetMapping("")
    public List<Job> findall(){ return service.allJob();
    }

}