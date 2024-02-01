package com.coderpwh.model;


import lombok.Data;
import lombok.ToString;

/**
 * @author coderpwh
 */
@Data
@ToString
public class UserDTO {

    private String username;

    private String password;

    private String role;

}
