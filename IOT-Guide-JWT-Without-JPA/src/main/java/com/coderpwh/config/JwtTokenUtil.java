package com.coderpwh.config;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.function.Function;


/***
 * 工具类
 * @author coderpwh
 */
@Component
public class JwtTokenUtil implements Serializable {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;


    /***
     * 通过token获取用户信息
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        return null;
    }


}
