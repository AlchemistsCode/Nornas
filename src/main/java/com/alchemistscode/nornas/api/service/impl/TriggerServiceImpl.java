package com.alchemistscode.nornas.api.service.impl;

import com.alchemistscode.nornas.api.exception.builder.ExceptionBuilder;
import com.alchemistscode.nornas.api.entity.Trigger;
import com.alchemistscode.nornas.api.properties.ErrorProperties;
import com.alchemistscode.nornas.api.repositories.TriggerRepository;
import com.alchemistscode.nornas.api.service.TriggerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriggerServiceImpl implements TriggerService{
    @Autowired
    private TriggerRepository repository;

    @Autowired
    private ExceptionBuilder exBuilder;

    @Override
    public List<Trigger> allTrigger(){
        List<Trigger> response = new ArrayList<Trigger>();
        for (Trigger trigger : repository.findAll()) {
            response.add(trigger);
        }
        if(response.size() == 0){
            throw exBuilder.getBuilder("general").
                    codidgoError("EMPTY").mensaje("No hay información a mostrar").build();
        }

        return  response;
    }
}