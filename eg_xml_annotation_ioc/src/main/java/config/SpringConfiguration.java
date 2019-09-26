package config;

import org.springframework.context.annotation.*;


/**
 * 配置类，作用和bean.xml一样
 spring中的新注解:

 *  Configuration
 *      作用：指定当前类是配置类
 *      细节：
 *          当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写。
 *
 *  ComponentScan
 *      作用：用于通过注解指定spring 在创建容器时要扫描的包"cn""config"
 *      属性：
 *          value:和basePackages的作用一样，指定需要扫描的报案
 *　Bean
 *     作用：将方法的返回值作为bean对象存入spring的ioc容器
 *     属性：
 *          name：指定bean的id，不写默认为当前方法名称
 *     细节：
 *          当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
 *          查找的方式和Autowired注解的作用是一样的
 *  Import:
 *      作用：用于导入其他的配置类
 *      属性：
 *          value：用于指定其他配置类的字节码。
 *      细节：
 *          当我们使用Import的注解之后，有Import注解的类就父配置类，而导入的都是子配置类
 *
 *  PropertySource
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value：指定文件的名称和路径。
 *          关键字：classpath，表示类路径下
 *
 */

// 主配置文件
//@Configuration
@ComponentScan({"cn"})
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
