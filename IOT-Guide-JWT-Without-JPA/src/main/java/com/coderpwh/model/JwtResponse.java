package com.coderpwh.model;

import java.io.Serializable;

/**
 * @author coderpwh
 */
public class JwtResponse implements Serializable {

    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getJwttoken() {
        return jwttoken;
    }
}
