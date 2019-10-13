package cn.dao;

import cn.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    // 查询所有,同时获取account下所有账户信息
    List<User> findAll();

    // 根据id 查询
    User findById(Integer userId);
}
