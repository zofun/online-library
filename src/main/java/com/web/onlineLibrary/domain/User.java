package com.web.onlineLibrary.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author TCW
 */
@Getter
@Setter
@ToString
public class User {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer userRole;
    private String salt;


}
