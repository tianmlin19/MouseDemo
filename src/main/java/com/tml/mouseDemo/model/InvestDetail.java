package com.tml.mouseDemo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class InvestDetail implements Serializable {

    private Long id;

    private String userName;

    private String stockName;

    private Double stockNum;

    private Double stockPrice;

    private Double tax;

    private Integer purchaseFlag;

    private Date purchaseDate;

    private Date createTime;


}
