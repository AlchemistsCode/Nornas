package com.alchemistscode.nornas.api.repositories;

import com.alchemistscode.nornas.api.entity.Job;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends
        PagingAndSortingRepository <Job , Integer>{

    @Query( value = "SELECT j FROM Job j WHERE j.status = true")
    public List<Job> findActive();

    @Query( value = "SELECT j FROM Job j WHERE j.trigger = :trigger")
    public List<Job> findByTrigger(@Param("trigger") Integer trigger);
}