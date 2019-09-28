package cn.service.impl;

import cn.service.IService;
import org.springframework.stereotype.Service;


@Service("Service")
public class ServiceImpl implements IService {
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
