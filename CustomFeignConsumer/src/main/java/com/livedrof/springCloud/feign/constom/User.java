package com.livedrof.springCloud.feign.constom;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class User {
    private Integer id;
    private String username;
    private Double salary;
    private Date birthday;

//    private Long longVal;
}
