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
    public List<Scheduler> allScheduler(){
        List<Scheduler> response = new ArrayList<Scheduler>();

        for (Scheduler scheduler : repository.findAll()) {
            response.add(scheduler);
        }

        if(response.size() == 0){
            throw exBuilder.getBuilder("general").
                    codidgoError("EMPTY").mensaje("No hay información a mostrar").build();
        }
        return response;
    }
}