package com.tml.mouseDemo.service;

import com.tml.mouseDemo.model.InvestDetail;
import com.tml.mouseDemo.model.User;

import java.io.IOException;

public interface TransactionService {

    /**
     *
     * 测试Mysql引擎
     * 通过SHOW ENGINES 查看不同数据库引擎的差别，在多个引擎中，仅InnoDB支持事务管理
     *
     * 测试
     *
     */
    void testMysqlEngine(InvestDetail oneRecord);


    /**
     * 测试mysql的分布式事务
     */
    void testDistributeTransaction(User oneUser, InvestDetail oneRecord);


    /**
     * 测试异常事务回滚
     * @param oneRecord
     * @throws IOException
     */
    void testRollbackException(InvestDetail oneRecord) throws IOException;


    /**
     * 测试事务的超时
     * @param oneRecord
     */
    void testTransactionTimeOut(InvestDetail oneRecord) throws Exception;

    /**
     * 测试事务只读
     *
     * @param oneRecord
     */
    void testReadOnlyTransaction(InvestDetail oneRecord);


    /**
     * 测试springboot 中aop代理的具体实现
     * @param oneRecord
     */
    void testAopImplement(InvestDetail oneRecord);





    InvestDetail getOne(Long investId);

    /**
     * 单个事务
     */
    void transeactionrollback(InvestDetail oneRecord);


    /**
     * 多个数据源的事务
     */
    void distributeTransaction(InvestDetail oneRecord);

}
