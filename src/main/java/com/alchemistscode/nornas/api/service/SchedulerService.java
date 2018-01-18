package com.alchemistscode.nornas.api.service;

import com.alchemistscode.nornas.api.entity.Scheduler;

import java.util.List;

public interface SchedulerService{
    List<Scheduler> findAll();
    List<Scheduler> findActive();
    Scheduler find(Integer id);
    void register(Scheduler scheduler);
    void update(Scheduler scheduler);
    void delete(Integer id);
}