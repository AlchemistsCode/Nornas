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
        name = "CXT_TRIGGERS",
        schema = "ALCHEMY"
)
public class Trigger{
    @Id
    @Column(name = "CXI_TRIGGER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "TRIGGER_NAME")
    private String triggerName;

    @Basic
    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;

    @Basic
    @Column(name = "SCHEDULER")
    private Integer scheduler;

    @Basic
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Basic
    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @Basic
    @Column(name = "STATUS")
    private boolean status;
}