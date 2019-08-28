package com.web.onlineLibrary.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ContentInfo {
    private Integer id;
    private String title;
    private Date time;
    private String author;
    private String classify;
}
