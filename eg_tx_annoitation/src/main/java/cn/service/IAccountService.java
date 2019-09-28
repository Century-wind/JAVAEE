package cn.service;

import cn.domain.Account;

public interface IAccountService {

    Account findAccountById(Integer accountId);

    Account findAccountByName(String accountName);

    void updateAccount(Account account);

    /**
     * 转账
     */
    void tranfer(String sourceName,String targetName,Float money);
}
