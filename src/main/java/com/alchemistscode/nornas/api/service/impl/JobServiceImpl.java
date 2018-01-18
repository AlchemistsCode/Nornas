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
    public List<Job> allJob(){
        List<Job> response = new ArrayList<Job>();

        for (Job job : repository.findAll()) {
            response.add(job);
        }

        if(response.size() == 0){
            throw exBuilder.getBuilder("general").
                    codidgoError("EMPTY").mensaje("No hay información a mostrar").build();
        }
        return response;
    }
}