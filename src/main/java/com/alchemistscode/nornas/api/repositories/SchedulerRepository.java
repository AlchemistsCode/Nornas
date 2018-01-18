package com.alchemistscode.nornas.api.repositories;

import com.alchemistscode.nornas.api.entity.Scheduler;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface SchedulerRepository extends
        PagingAndSortingRepository <Scheduler , Integer>{

}