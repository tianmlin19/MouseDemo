package com.tml.mouseDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -4489033966046239802L;

    private Long id;

    private String userName;

    private String password;

    private Integer status;

    private Date createTime;

}
