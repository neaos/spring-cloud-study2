package com.cloudlink.inspection.dto;

import lombok.Data;

import java.util.Date;

/**
 * description: 与cloudlink-user中的entity保持一致
 *
 * 实际这里的共享对象应该是DTO, 为了方便用entity
 *
 * @author xiefayang
 * 2019/4/3 10:31
 */
@Data
public class PriUser {

    private String id;

    private String name;

    private Integer age;

    private Date createTime;

    private Date updateTime;

    public PriUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
