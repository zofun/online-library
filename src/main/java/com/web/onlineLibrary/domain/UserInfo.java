package com.web.onlineLibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserInfo {

    private String username;
    private String name;
    private String role;
    private String roleMsg;

}
