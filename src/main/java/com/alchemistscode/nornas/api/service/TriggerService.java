package com.alchemistscode.nornas.api.service;

import com.alchemistscode.nornas.api.entity.Trigger;

import java.util.List;

public interface TriggerService{
    List<Trigger> findAll();
    List<Trigger> findActive();
    Trigger find(Integer id);
    List<Trigger> findByScheduler(Integer scheduler);
    void register(Trigger trigger);
    void update(Trigger trigger);
    void delete(Integer id); 
}