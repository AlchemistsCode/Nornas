package com.alchemistscode.nornas.api.entity;

import java.sql.Date;

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
@Table(
        name = "CXT_JOBS",
        schema = "ALCHEMY"
)
public class Job{
    @Id
    @Column(name = "CXI_JOB")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "JOB_NAME")
    private String jobName;

    @Basic
    @Column(name = "JOB_CLASS")
    private String jobClass;

    @Basic
    @Column(name = "DESCRIPTION")
    private String descripcion;

    @Basic
    @Column(name = "CRON_EXPRESSION")
    private String cronExpression;

    @Basic
    @Column(name = "PARAMETERS")
    private String parameters;

    @Basic
    @Column(name = "TRIGGER")
    private Integer trigger;

    @Basic
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Basic
    @Column(name = "FIRST_RUN_DATE")
    private Date firsTRunDate;

    @Basic
    @Column(name = "LAST_RUN_DATE")
    private Date lastRunDate;

    @Basic
    @Column(name = "NEXT_RUN_DATE")
    private Date nextRunDate;

    @Basic
    @Column(name = "STATUS")
    private boolean status;
}