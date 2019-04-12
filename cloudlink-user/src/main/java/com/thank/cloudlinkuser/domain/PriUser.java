package com.thank.cloudlinkuser.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * description: none
 *
 * @author xiefayang
 * 2019/4/3 10:31
 */
@Data
@Entity
public class PriUser {

    @Id
    private String id;

    private String name;

    private Integer age;

    private Date createTime;

    private Date updateTime;

    public PriUser() {
    }

    public PriUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
