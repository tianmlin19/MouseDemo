package com.tml.mouseDemo.service.impl;

import cn.hutool.core.date.DateUtil;
import com.google.gson.Gson;
import com.tml.mouseDemo.mapper.UserMapper;
import com.tml.mouseDemo.model.InvestDetail;
import com.tml.mouseDemo.model.User;
import com.tml.mouseDemo.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private Gson gson;

    @Autowired
    private TransactionTemplate transactionTemplate;


    /**
     * 测试spring的编程式事务管理
     * 1.一般编程式事务管理是使用TransactionTemplate来进行操作
     * 2.优点：相比于声明式事务管理，编程式事务管理更加的灵活多变，能最小粒度的控制事务
     * 3.缺点：与业务代码耦合度较高
     *
     * @param oneRecord
     */
    @Override
    public void testTransactionTemplate(InvestDetail oneRecord) {
        log.info("do something here!");
        doTransaction(oneRecord);

    }

    private void doTransaction(InvestDetail oneRecord) {

    }

    /**
     * 1.验证InnoDB事务能正确回滚
     * 2.修改对应表的引擎为MyISAM，验证事务不会回滚
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void testMysqlEngine(InvestDetail oneRecord) {
        log.info("updateTax:{}", 1);
        throw new RuntimeException("testMysqlEngine fail");
    }

    /**
     * 1.验证单数据源的事务回滚情况，单数据源的事务都能正常回滚 (单数据源事务需要对应相应的事务管理器)
     * 2.验证多数据源的事务回滚情况，多数据源的事务默认是主数据源的事务回滚,若指定了事务管理器，则指定的事务管理器的事务会回滚
     * <p>
     * transactionManager = "data2TransactionManager"
     * <p>
     * investDetailMapper对应的数据源为tml,同时设置了tml为主数据源
     * <p>
     * userMapper对应的数据源为mouse
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void testDistributeTransaction(User oneUser, InvestDetail oneRecord) {

        String now = DateUtil.now();
        int updatePwd = userMapper.updatePwd(now, oneUser.getId());
        log.info("updatePwd:{}", updatePwd);
        log.info("updateTax:{}", 1);
        throw new RuntimeException("testDistributeTransaction fail");
    }

    /**
     * 1. 验证运行时异常的事务回滚
     * 2. 验证检测异常时的事务回滚
     *
     * @param oneRecord
     * @throws IOException
     * @Transactional 默认回滚运行时异常，若需要回滚检测异常需要加上 rollbackFor = Exception.class
     */
    @Override
    @Transactional
    public void testRollbackException(InvestDetail oneRecord) throws IOException {
        log.info("updateTax:{}", 1);
        //throw new NullPointerException();

        throw new IOException();
    }


    /**
     * 1. 不修改事务的默认超时，验证事务的执行情况（默认是-1，永不超时）
     * 2、修改超时为1，单位为秒，验证事务的执行情况 timeout = 1
     *
     * @param oneRecord
     * @throws Exception
     */
    @Override
    @Transactional(timeout = 1)
    public void testTransactionTimeOut(InvestDetail oneRecord) throws Exception {

        Thread.sleep(2000);
        log.info("updateTax:{}", 1);
    }


    /**
     * 事务只读
     * 表示这个事务只读取数据但不更新数据, 这样可以帮助数据库引擎优化事务
     * 若更新了数据会有异常
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = true)
    public void testReadOnlyTransaction(InvestDetail oneRecord) {
        log.info("updateTax:{}", 1);
        throw new RuntimeException("testDistributeTransaction fail");
    }


    /**
     * 测试事务代理的具体实现
     * 1. springboot中默认使用cglib代理，可通过spring.aop.proxy-target-class=false 修改为jdk动态代理
     * 2. 关于代理的正确使用
     * final static private
     *
     * @param oneRecord
     */
    @Override
    @Transactional
    public void testAopImplement(InvestDetail oneRecord) {
        log.info("updateTax:{}", 1);
        throw new RuntimeException("testDistributeTransaction fail");
    }

}
