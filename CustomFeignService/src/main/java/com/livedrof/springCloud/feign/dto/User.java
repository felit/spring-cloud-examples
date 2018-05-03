package com.livedrof.springCloud.feign.dto;


import java.util.Date;

public class User {
    private Integer id;
    private String username;
//    private Double salary;
//    private Date birthday;
//    private Long longVal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
