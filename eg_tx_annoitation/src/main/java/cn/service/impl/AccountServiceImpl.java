package cn.service.impl;

import cn.dao.IAccountDao;
import cn.domain.Account;
import cn.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)// 只读型事务
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;


    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public Account findAccountByName(String accountName) {
        return accountDao.findAccountByName(accountName);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false) //配置读写型事务
    public void tranfer(String sourceName, String targetName, Float money) {
        //2.1 根据名字查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2 根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);

        //事务控制
//        int i =1/0;

        //2.5更新转出账户
        accountDao.updateAccount(source);
        //2.6更新转入账户
        accountDao.updateAccount(target);

        System.out.println("转账成功！");

    }
}
