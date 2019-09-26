package cn.dao;

import cn.entity.Account;

import java.util.List;

public interface IDao {

    List<Account> findAllAccount();

    Account findAccountByid(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
