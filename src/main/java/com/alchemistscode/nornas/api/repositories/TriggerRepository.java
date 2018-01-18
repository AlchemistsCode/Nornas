package com.alchemistscode.nornas.api.repositories;

import com.alchemistscode.nornas.api.entity.Trigger;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface TriggerRepository extends
        PagingAndSortingRepository <Trigger , Integer>{

}