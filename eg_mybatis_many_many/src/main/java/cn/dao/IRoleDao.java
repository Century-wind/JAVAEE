package cn.dao;

import cn.domain.Role;

import java.util.List;

public interface IRoleDao {

    //查询所有
    List<Role>  findAll();
}
