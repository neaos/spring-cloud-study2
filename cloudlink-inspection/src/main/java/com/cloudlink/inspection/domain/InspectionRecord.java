package com.cloudlink.inspection.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * description: none
 *
 * @author xiefayang
 * 2019/4/3 10:52
 */
@Entity
@Data
public class InspectionRecord {

    @Id
    private String id;

    private String code;
    
    private Integer mileage;

    private String inspectionUserId;

    @Transient
    private String inspectionUserName;

    private Date createTime;

    private Date updateTime;

    public InspectionRecord(String code, Integer mileage, String inspectionUserId) {
        this.code = code;
        this.mileage = mileage;
        this.inspectionUserId = inspectionUserId;
    }
}
