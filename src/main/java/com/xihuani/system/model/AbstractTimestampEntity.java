package com.xihuani.system.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class AbstractTimestampEntity {
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;

    @PrePersist
    protected void onCreate() {
    	updatedDate = createdDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    	updatedDate = new Date();
    }
}
