package cn.test;

import cn.server.IServer;
import cn.entity.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试，测试本次实验：
 *      运用xml注解配置ioc容器实现数据的增删改查
 */
public class ServiceTest {

    @Test
    public void testFindAll(){
        //1. 获取容器
        ApplicationContext appcon = new ClassPathXmlApplicationContext("bean.xml");
        //2. 得到业务层对象
        IServer is = appcon.getBean("Service", IServer.class);
        //3. 执行方法
        List<Account> accounts = is.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }


    @Test
    public void testFindOne(){
        //1. 获取容器
        ApplicationContext appcon = new ClassPathXmlApplicationContext("bean.xml");
        //2. 得到业务层对象
        IServer is = appcon.getBean("Service", IServer.class);
        //3. 执行方法
        Account account = is.findAccountByid(1);
        System.out.println(account);

    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("test");
        account.setMoney(123f);
        //1. 获取容器
        ApplicationContext appcon = new ClassPathXmlApplicationContext("bean.xml");
        //2. 得到业务层对象
        IServer is = appcon.getBean("Service", IServer.class);
        //3. 执行方法
        is.saveAccount(account);
        System.out.println("保存成功！");
    }

    @Test
    public void testUpdate(){
        //1. 获取容器
        ApplicationContext appcon = new ClassPathXmlApplicationContext("bean.xml");
        //2. 得到业务层对象
        IServer is = appcon.getBean("Service", IServer.class);
        //3. 执行方法
        Account account = is.findAccountByid(3);
        account.setMoney(234f);
        is.updateAccount(account);
    }

    @Test
    public void testDelete(){
        //1. 获取容器
        ApplicationContext appcon = new ClassPathXmlApplicationContext("bean.xml");
        //2. 得到业务层对象
        IServer is = appcon.getBean("Service", IServer.class);
        //3. 执行方法
        is.deleteAccount(4);
    }

}
