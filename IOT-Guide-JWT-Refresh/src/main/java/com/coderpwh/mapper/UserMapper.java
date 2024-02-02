package com.coderpwh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coderpwh.entity.UserDomain;

/**
 * UserMapper继承基类
 *
 * @author coderpwh
 */
public interface UserMapper extends BaseMapper<UserDomain> {


    /***
     * 通过姓名查找
     * @param username
     * @return
     */
    UserDomain findByUsername(String username);
}