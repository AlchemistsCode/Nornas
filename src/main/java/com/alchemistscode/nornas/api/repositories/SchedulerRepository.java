package com.alchemistscode.nornas.api.repositories;

import com.alchemistscode.nornas.api.entity.Scheduler;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.beans.factory.annotation.Autowired;

public interface SchedulerRepository extends
        PagingAndSortingRepository <Scheduler , Integer>{

    @Query( value = "SELECT s FROM Scheduler s WHERE s.status = true")
    public List<Scheduler> findActive();

}