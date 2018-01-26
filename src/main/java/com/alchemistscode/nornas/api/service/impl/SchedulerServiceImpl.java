package com.alchemistscode.nornas.api.service.impl;

import com.alchemistscode.nornas.api.exception.builder.ExceptionBuilder;
import com.alchemistscode.nornas.api.entity.Scheduler;
import com.alchemistscode.nornas.api.properties.ErrorProperties;
import com.alchemistscode.nornas.api.repositories.SchedulerRepository;
import com.alchemistscode.nornas.api.service.SchedulerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulerServiceImpl implements SchedulerService{
    @Autowired
    private SchedulerRepository repository;

    @Autowired
    private ExceptionBuilder exBuilder;

    @Override
    public List<Scheduler> findAll(){
        List<Scheduler> response = (List<Scheduler>)repository.findAll();

        if(response.size() == 0){
            throw exBuilder.getBuilder().
                    errorCode("EMPTY").message("No hay información a mostrar").build();
        }
        return response;
    }

    @Override
    public List<Scheduler> findActive(){
        List<Scheduler> response = (List<Scheduler>) repository.findActive();

        if(response.size() == 0){
            throw exBuilder.getBuilder().
                    errorCode("EMPTY").message("No hay información a mostrar").build();
        }
        return response;
    }

    @Override
    public Scheduler find(Integer id){
        Scheduler response = repository.findOne(id);
        if(response == null){
            throw exBuilder.getBuilder().
                    errorCode("EMPTY").message("No hay información a mostrar").build();
        }
        return response;
    }

    @Override
    public void register(Scheduler scheduler){
        repository.save(scheduler);
    }

    @Override
    public void update(Scheduler scheduler){
        repository.save(scheduler);
    }

    @Override
    public void delete(Integer id){
        repository.delete(id);
    }
}