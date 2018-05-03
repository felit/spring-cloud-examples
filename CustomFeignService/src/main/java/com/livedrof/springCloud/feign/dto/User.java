package com.livedrof.springCloud.feign.dto;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private Double salary;
    private Date birthday;
    private Long longVal;
}
