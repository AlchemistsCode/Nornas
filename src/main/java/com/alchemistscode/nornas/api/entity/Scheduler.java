package com.alchemistscode.nornas.api.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ALCHEMY.CXT_SCHEDULERS")
public class Scheduler {
    @Id
    @Column(name = "CXI_SCHEDULER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "INSTANCE_NAME")
    private String instanceName;

    @Basic
    @Column(name = "INSTANCE_CLASS")
    private String instanceClass;

    @Basic
    @Column(name = "THREAD_COUNT")
    private Integer threadCount;

    @Basic
    @Column(name = "PRIORITY")
    private Integer priority;

    @Basic
    @Column(name = "STATUS")
    private boolean status;
}