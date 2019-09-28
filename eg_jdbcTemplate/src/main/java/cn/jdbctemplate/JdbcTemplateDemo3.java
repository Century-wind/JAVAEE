package cn.jdbctemplate;

import cn.domain.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * CRUD操作
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {

        //1.获取容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        //2.获取对象
        JdbcTemplate template = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        //3.执行操作
        //保存
        template.update("insert into account(name,money)values(?,?)","eee",3333f);
        //更新
        template.update("update account set name=?,money=? where id=?","test",4567,7);
        //删除
        template.update("delete from account where id=?",8);
        //查询所有
//        List<Account> accounts = template.query("select * from account where money > ?",new AccountRowMapper(),1000f);
//        spring内部自带的封装BeanPropertyRowMapper
        List<Account> accounts = template.query("select * from account where money > ?",new BeanPropertyRowMapper<Account>(Account.class),1000f);
        for(Account account : accounts){
            System.out.println(account);
        }

        //查询一个
        List<Account> account = template.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
        System.out.println(accounts.isEmpty()?"没有内容":account.get(0));

        //查询返回一行一列（使用聚合函数，但不加group by子句）
        Long count = template.queryForObject("select count(*) from account where money > ?",Long.class,1000f);
        System.out.println(count);

    }
}
/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account> {
    /**
     * 把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     */
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}