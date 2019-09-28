package test;

import cn.service.IService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    public static void main(String[] args) {
        // 1.获取容器
        ApplicationContext appcon = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IService is = (IService) appcon.getBean("Service");
        //3.执行方法
        is.saveAccount();
    }
}
