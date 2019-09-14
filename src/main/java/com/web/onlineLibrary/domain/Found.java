package com.web.onlineLibrary.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Found {
    private int id;
    private String name;
    private String time;
    private String info;
    private String status;

}
