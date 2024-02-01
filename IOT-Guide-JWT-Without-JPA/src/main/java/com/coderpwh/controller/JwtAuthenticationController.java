package com.coderpwh.controller;

import com.coderpwh.config.JwtTokenUtil;
import com.coderpwh.model.JwtRequest;
import com.coderpwh.model.JwtResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author coderpwh
 */
@Slf4j
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private UserDetailsService jwtInMemoryUserDetailsService;

    @Resource
    private AuthenticationManager authenticationManager;


    /***
     * 授权
     * @param authenticationRequest
     * @return
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtInMemoryUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }


    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            log.info("authentication:{}", authentication);
        } catch (Exception e) {
            log.error("异常信息为:{}", e.getMessage());
        }
    }


}
