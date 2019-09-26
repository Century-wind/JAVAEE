package cn.service.impl;

import cn.dao.IDao;
import cn.service.IService;
import cn.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现类
 */

@Service("accountService")
public class ServiceImpl implements IService {

    @Autowired
    private IDao dao;

/*  Autowired：　消除get,set方法，按Bean类型自动装配
    public void setDao(IDao dao) {
        this.dao = dao;
    }
*/

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
