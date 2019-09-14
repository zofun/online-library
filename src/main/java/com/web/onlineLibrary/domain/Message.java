package com.web.onlineLibrary.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Message {
    private int id;
    private String commentatorName;
    private String info;
    private Date time;
    private String replier;
    private String reply;

}
