package com.tml.mouseDemo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -4489033966046239802L;

    private Long id;

    private String userName;

    private String password;
}
