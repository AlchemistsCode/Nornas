package com.alchemistscode.nornas.api.service;

import com.alchemistscode.nornas.api.entity.Job;

import java.util.List;

public interface JobService{
    List<Job> findAll();
    List<Job> findActive();
    Job find(Integer id);
    void register(Job job);
    void update(Job job);
    void delete(Integer id);
}