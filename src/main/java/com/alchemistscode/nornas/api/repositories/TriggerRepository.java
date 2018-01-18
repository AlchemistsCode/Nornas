package com.alchemistscode.nornas.api.repositories;

import com.alchemistscode.nornas.api.entity.Trigger;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.beans.factory.annotation.Autowired;

public interface TriggerRepository extends
        PagingAndSortingRepository <Trigger , Integer>{

    @Query( value = "SELECT t FROM Trigger t WHERE t.status = true")
    public List<Trigger> findActive();
}