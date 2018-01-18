package com.alchemistscode.nornas.api.service.impl;

import com.alchemistscode.nornas.api.exception.builder.ExceptionBuilder;
import com.alchemistscode.nornas.api.entity.Job;
import com.alchemistscode.nornas.api.properties.ErrorProperties;
import com.alchemistscode.nornas.api.repositories.JobRepository;
import com.alchemistscode.nornas.api.service.JobService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService{
    @Autowired
    private JobRepository repository;

    @Autowired
    private ExceptionBuilder exBuilder;

    @Override
    public List<Job> findAll(){
        List<Job> response = new ArrayList<Job>();

        for (Job Job : repository.findAll()) {
            response.add(Job);
        }

        if(response.size() == 0){
            throw exBuilder.getBuilder("general").
                    codidgoError("EMPTY").mensaje("No hay información a mostrar").build();
        }
        return response;
    }

    @Override
    public List<Job> findActive(){
        List<Job> response = new ArrayList<Job>();

        for (Job Job : repository.findActive()) {
            response.add(Job);
        }

        if(response.size() == 0){
            throw exBuilder.getBuilder("general").
                    codidgoError("EMPTY").mensaje("No hay información a mostrar").build();
        }
        return response;
    }

    @Override
    public Job find(Integer id){
        Job response = repository.findOne(id);
        if(response == null){
            throw exBuilder.getBuilder("general").
                    codidgoError("EMPTY").mensaje("No hay información a mostrar").build();
        }
        return response;
    }

    @Override
    public void register(Job job){
        repository.save(job);
    }

    @Override
    public void update(Job job){
        repository.save(job);
    }

    @Override
    public void delete(Integer id){
        repository.delete(id);
    }
}