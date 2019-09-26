package cn.server.impl;

import cn.dao.IDao;
import cn.server.IServer;
import cn.entity.Account;

import java.util.List;

/**
 * 业务层实现类
 */

public class ServerImpl implements IServer {
    private IDao dao;

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    public List<Account> findAllAccount() {
        return dao.findAllAccount();
    }

    public Account findAccountByid(Integer accountId) {
        return dao.findAccountByid(accountId);
    }

    public void saveAccount(Account account) {
        dao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        dao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        dao.deleteAccount(accountId);
    }
}
