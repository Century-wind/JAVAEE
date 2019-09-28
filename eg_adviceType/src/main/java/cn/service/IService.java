package cn.service;

public interface IService {

    // 模拟保存账户-无参无返回值
    void saveAccount();

    // 模拟更新账户-有参无返回值
    void updateAccount(int i);

    // 模拟删除账户-无参有返回值
    int deleteAccount();
}
