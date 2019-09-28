package cn.test;

import cn.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:bean.xml") //使用xml方式，导入扫描包
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as;


    @Test
    public void ServiceTest(){


        System.out.println(as.findAccountByName("aaa"));
        System.out.println(as.findAccountById(2));
        as.tranfer("aaa","bbb",100f);

    }
}
