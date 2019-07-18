package com.biege.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private String phone;
}