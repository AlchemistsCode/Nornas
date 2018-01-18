package com.alchemistscode.nornas.api.repositories;

import com.alchemistscode.nornas.api.entity.Job;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface JobRepository extends
        PagingAndSortingRepository <Job , Integer>{

}