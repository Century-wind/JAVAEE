package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring配置类，相当于Bean.xml
 */


@Configuration //指明这是 一个配置类
@ComponentScan("cn") // 指明要扫描的包
@Import({JdbcConfig.class,TransactionConfig.class}) //导入其他子配置类
@PropertySource("jdbcConfig.properties") //指定配置文件
@EnableTransactionManagement //注解支持
public class SpringConfiguration {


}
