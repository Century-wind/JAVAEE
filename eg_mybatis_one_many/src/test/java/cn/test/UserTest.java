package cn.test;

import cn.dao.IUserDao;
import cn.domain.User;
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

public class UserTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private IUserDao userDao;

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
        userDao = sqlSession.getMapper(IUserDao.class);

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
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("--------每个account的信息------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
}
