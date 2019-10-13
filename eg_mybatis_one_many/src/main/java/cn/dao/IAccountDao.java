package cn.dao;

import cn.domain.Account;
import cn.domain.AccountUser;

import java.util.List;

public interface IAccountDao {

    // 查询所有账户
    List<Account> findAll();

    // 查询所有，带有用户名和地址信息
    List<AccountUser>  findAllAccount();
}
