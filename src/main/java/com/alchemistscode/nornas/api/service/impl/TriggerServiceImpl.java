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
    public List<Trigger> findAll(){
        List<Trigger> response = (List<Trigger>) repository.findAll();

        if(response.size() == 0){
            throw exBuilder.getBuilder("general").
                    codidgoError("EMPTY").mensaje("No hay información a mostrar").build();
        }
        return response;
    }

    @Override
    public List<Trigger> findActive(){
        List<Trigger> response = (List<Trigger>) repository.findActive();

        if(response.size() == 0){
            throw exBuilder.getBuilder("general").
                    codidgoError("EMPTY").mensaje("No hay información a mostrar").build();
        }
        return response;
    }

    @Override
    public Trigger find(Integer id){
        Trigger response = repository.findOne(id);
        if(response == null){
            throw exBuilder.getBuilder("general").
                    codidgoError("EMPTY").mensaje("No hay información a mostrar").build();
        }
        return response;
    }

    @Override
    public List<Trigger> findByScheduler(Integer scheduler){
        List<Trigger> response = (List<Trigger>) repository.findByScheduler(scheduler);

        if(response.size() == 0){
            throw exBuilder.getBuilder("general").
                    codidgoError("EMPTY").mensaje("No hay información a mostrar").build();
        }
        return response;
    }

    @Override
    public void register(Trigger trigger){
        repository.save(trigger);
    }

    @Override
    public void update(Trigger trigger){
        repository.save(trigger);
    }

    @Override
    public void delete(Integer id){
        repository.delete(id);
    }
}