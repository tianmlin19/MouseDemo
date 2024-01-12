package com.tml.mouseDemo;

import com.tml.mouseDemo.mapper.UserMapper;
import com.tml.mouseDemo.model.InvestDetail;
import com.tml.mouseDemo.model.User;
import com.tml.mouseDemo.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
/**
 *
 * Spring Boot项目中默认不写版本引入的JUnit依赖应该是JUnit5，
 * 在JUnit5中@Before 和@After 被 @BeforeEach
 * 和@AfterEach给替代了. 还有一些其他的的注解也被替代了。
 *
 *
 */
public class MouseDemoApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TransactionService transactionService;

    private User userBefore = null;

    private InvestDetail investBefore = null;


    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testEs() {
        User oneUser = userMapper.getOneUser(1L);
        log.info("oneUser:{}", oneUser);
    }


    /**
     * 测试编程式事务管理
     */
    @Test
    public void testTransactionTemplate() {
        transactionService.testTransactionTemplate(investBefore);
    }

    /**
     * 测试 mysql 不同引擎对事务的影响
     */
    @Test
    public void testMysqlEngine() {
        transactionService.testMysqlEngine(investBefore);

    }

    /**
     * 测试多数据源 分布式事务
     */
    @Test
    public void testDistributeTranasaction() {
        transactionService.testDistributeTransaction(userBefore, investBefore);
    }


    /**
     * 测试事务回滚
     */
    @Test
    public void testRollbackException() throws Exception {
        transactionService.testRollbackException(investBefore);

    }

    /**
     * 测试aop实现
     */
    @Test
    public void testAopImplement() {
        transactionService.testAopImplement(investBefore);
    }


    /**
     * 测试事务超时
     *
     * @throws Exception
     */
    @Test
    public void testTransactionTimeOut() throws Exception {
        transactionService.testTransactionTimeOut(investBefore);
    }

    /**
     * 测试事务只读
     * <p>
     * 只读事务不允许修改数据，否则
     * java.sql.SQLException: Connection is read-only. Queries leading to data modification are not allowed
     */
    @Test
    public void testReadOnlyTransaction() {
        transactionService.testReadOnlyTransaction(investBefore);
    }


}
