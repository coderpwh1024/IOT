package com.coderpwh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author
 */
@Data
@TableName(value = "t_user")
public class UserDomain implements Serializable {
    /**
     * 主键id
     */
    @Id
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 权限
     */
    private String role;

    private static final long serialVersionUID = 1L;


}