package cn.service;

import cn.entity.Account;

import java.util.List;

/**
 * 业务层接口
 */

public interface IService {
    List<Account> findAllAccount();

    Account findAccountByid(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);


}
