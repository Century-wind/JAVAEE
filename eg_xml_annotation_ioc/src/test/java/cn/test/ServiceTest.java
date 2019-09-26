package cn.test;

import cn.service.IService;
import cn.entity.Account;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试本次实验：
 * Spring整合junit的配置:
 *      1、导入spring整合junit的jar
 *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *          @Runwith
 *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *          ContextConfiguration:
 *              locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *              classes：指定注解类所在地位置
 *  当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class ServiceTest {

    @Autowired
    private IService is = null;

/*
    private ApplicationContext appcon;
    private IService is;

    @Before
    public void init(){
        //1. 获取容器
        appcon = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2. 得到业务层对象
        is = appcon.getBean("accountService", IService.class);
    }
    */

    @Test
    public void testFindAll(){
/*
        //1. 获取容器
        ApplicationContext appcon = new ClassPathXmlApplicationContext("bean.xml"); xml方式注入
            // 配置文件注入
        ApplicationContext appcon = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2. 得到业务层对象
        IService is = appcon.getBean("accountService", IService.class);
*/
        //3. 执行方法
        List<Account> accounts = is.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }


    @Test
    public void testFindOne(){
        Account account = is.findAccountByid(1);
        System.out.println(account);

    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("test");
        account.setMoney(123f);
        //3. 执行方法
        is.saveAccount(account);
        System.out.println("保存成功！");
    }

    @Test
    public void testUpdate(){
        //3. 执行方法
        Account account = is.findAccountByid(3);
        account.setMoney(234f);
        is.updateAccount(account);
    }

    @Test
    public void testDelete(){
        //3. 执行方法
        is.deleteAccount(4);
    }

}
