package com.tml.mouseDemo.service;

import com.tml.mouseDemo.model.InvestDetail;
import com.tml.mouseDemo.model.User;

public interface TransactionService {


    /**
     * 单个事务
     */
    void transeactionrollback(InvestDetail oneRecord);


    /**
     * 多个数据源的事务
     */
    void distributeTransaction(InvestDetail oneRecord);


    /**
     *
     * 测试Mysql引擎
     * 通过SHOW ENGINES 查看不同数据库引擎的差别，在多个引擎中，仅InnoDB支持事务管理
     *
     */
    void testMysqlEngine(InvestDetail oneRecord);


    /**
     * 测试mysql的分布式事务
     */
    void testDistributeTransaction(User oneUser, InvestDetail oneRecord);
}
