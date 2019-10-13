package cn.dao;

import cn.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    // 查询所有
    List<User> findAll();
}
