package com.web.onlineLibrary.domain;

import lombok.*;

/**
 * @author TCW
 * 内容实体类
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private Integer id;
    private String title;
    private Integer author;
    private byte[] markdown;
    private String recommend;
    private String classify;

}
