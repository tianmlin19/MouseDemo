package com.tml.mouseDemo.service.impl;

import cn.hutool.core.date.DateUtil;
import com.google.gson.Gson;
import com.tml.mouseDemo.data.data1.mapper.InvestDetailMapper;
import com.tml.mouseDemo.data.data2.mapper.UserMapper;
import com.tml.mouseDemo.model.InvestDetail;
import com.tml.mouseDemo.model.User;
import com.tml.mouseDemo.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InvestDetailMapper investDetailMapper;

    @Autowired
    private Gson gson;


    /**
     * 1.验证InnoDB事务能正确回滚
     * 2.修改对应表的引擎为MyISAM，验证事务不会回滚
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void testMysqlEngine(InvestDetail oneRecord) {
        int updateTax = investDetailMapper.updateTax(oneRecord.getTax() + 1, oneRecord.getId());
        log.info("updateTax:{}", updateTax);
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


        int updateTax = investDetailMapper.updateTax(oneRecord.getTax() + 1, oneRecord.getId());
        log.info("updateTax:{}", updateTax);


        throw new RuntimeException("testDistributeTransaction fail");


    }

    /**
     *
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void distributeTransaction(InvestDetail oneRecord) {
        investDetailMapper.updateTax(oneRecord.getTax() + 1, oneRecord.getId());

        throw new RuntimeException("");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void transeactionrollback(InvestDetail oneRecord) {
        investDetailMapper.updateTax(oneRecord.getTax() + 1, oneRecord.getId());

    }


}
