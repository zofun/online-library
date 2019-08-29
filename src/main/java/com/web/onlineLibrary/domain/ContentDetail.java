package com.web.onlineLibrary.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContentDetail {
    private Integer id;
    private String classify;
    private Integer classifyCode;
    private String markdown;
    private String title;
    private String recommend;
    private String author;
}
