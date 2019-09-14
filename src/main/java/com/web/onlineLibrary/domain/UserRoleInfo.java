package com.web.onlineLibrary.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRoleInfo {
    private int id;
    private String name;
    private String username;
    private String roleName;
}
