package com.xiaobai.information.model.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

/**
 * @author XinHuiChen
 */
@MappedSuperclass
@Data
@Slf4j
public class BaseEntity {
    /**
     * Create time.
     */
    @Column(name = "create_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * Update time.
     */
    @Column(name = "update_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    ///**
    // * Delete flag.
    // */
    //@Column(name = "deleted", columnDefinition = "TINYINT default 0")
    //private Boolean deleted = false;

    @PrePersist
    protected void prePersist() {
        //deleted = false;
        Date now = new Date();
        log.info("persist time: [{}]",now);
        if (createTime == null) {
            createTime = now;
        }

        if (updateTime == null) {
            updateTime = now;
        }
    }

    @PreUpdate
    protected void preUpdate() {
        updateTime = new Date();
        log.info("update time: [{}]",updateTime);
    }

    @PreRemove
    protected void preRemove() {
        updateTime = new Date();
        log.info("remove time: [{}]",updateTime);
    }
}
