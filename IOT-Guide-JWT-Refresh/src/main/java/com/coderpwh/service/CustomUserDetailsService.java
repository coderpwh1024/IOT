package com.coderpwh.service;


import com.coderpwh.entity.UserDomain;
import com.coderpwh.mapper.UserMapper;
import com.coderpwh.model.UserDTO;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author coderpwh
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;


    @Resource
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;
        UserDomain user = userMapper.findByUsername(username);
        if (Objects.nonNull(user)) {
            roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            return new User(user.getUsername(), user.getPassword(), roles);
        }
        throw new UsernameNotFoundException("User not found with the name" + username);
    }


    /***
     * 保存
     * @param user
     * @return
     */
    public UserDomain save(UserDTO user) {
        UserDomain newUser = new UserDomain();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        userMapper.insert(newUser);
        return newUser;
    }


}
