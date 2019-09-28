package cn.jdbctemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 * 最基本用法
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {

        //1.获取容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        //2.获取对象
        JdbcTemplate template = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        //3.执行操作
        template.execute("insert into account(name,money)values('ccc',1000)");
    }
}
