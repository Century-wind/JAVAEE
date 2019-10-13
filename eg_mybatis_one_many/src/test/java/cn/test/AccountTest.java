package cn.test;

import cn.dao.IAccountDao;
import cn.domain.Account;
import cn.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before
    public void init() throws IOException {
        //1. 读取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //3. 使用工厂生产sqlSession对象
        sqlSession = factory.openSession();
        //4. 使用sqlSession创建Dao接口的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);

    }

    @After
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account : accounts){
            System.out.println("--------每个account的信息------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testFindAllAccountUser(){
        List<AccountUser> accountUsers = accountDao.findAllAccount();
        for (AccountUser accountUser:accountUsers){
            System.out.println(accountUser);
        }
    }
     /*public static void main(String[] args) throws Exception {
        //1. 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //3. 使用工厂生产sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4. 使用sqlSession创建Dao接口的代理对象
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        //5. 使用代理对象执行方法
        List<Account> accounts = accountDao.findAll();

        for (Account account:accounts){
            System.out.println(account);
        }
        //6. 释放资源
        sqlSession.close();
        inputStream.close();
    }*/
}
