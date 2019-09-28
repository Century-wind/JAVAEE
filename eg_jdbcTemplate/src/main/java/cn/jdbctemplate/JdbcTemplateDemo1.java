package cn.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 * 最基本 用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        // 准备数据源，spring的内置数据源
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setDriverClassName("com.mysql.jdbc.Driver");
        dmds.setUrl("jdbc:mysql://localhost:3306/day17");
        dmds.setUsername("root");
        dmds.setPassword("hang");

        //1.创建对象
        JdbcTemplate template = new JdbcTemplate();
        //设置数据源啊
        template.setDataSource(dmds);
        //2.执行操作
        template.execute("insert into account(name,money)values('ccc',1000)");
    }
}
