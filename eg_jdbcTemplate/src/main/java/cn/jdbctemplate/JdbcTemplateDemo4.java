package cn.jdbctemplate;

import cn.dao.IDao;
import cn.domain.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {

        //1.获取容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        //2.获取对象
//        JdbcTemplate template = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        IDao accountDao = applicationContext.getBean("accountDao", IDao.class);

        //3.执行操作
//        template.execute("insert into account(name,money)values('ccc',1000)");
        Account account = accountDao.findAccountById(1);
        System.out.println(account);

    }

}
