package com.coderpwh.dao;

import com.coderpwh.model.DaoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author coderpwh
 */
@Repository
public interface UserDao extends JpaRepository<DaoUser, Long> {


    /***
     * 通过姓名查找
     * @param username
     * @return
     */
    DaoUser findByUsername(String username);

}