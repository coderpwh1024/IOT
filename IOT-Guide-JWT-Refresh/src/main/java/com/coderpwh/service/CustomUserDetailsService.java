package com.coderpwh.service;

import com.coderpwh.dao.UserDao;
import com.coderpwh.model.DaoUser;
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
    private UserDao userDao;

    @Resource
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;
        DaoUser user = userDao.findByUsername(username);
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
    public DaoUser save(UserDTO user) {
        DaoUser newUser = new DaoUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        return userDao.save(newUser);
    }


}
