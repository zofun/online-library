package com.web.onlineLibrary.base.entity;

import lombok.*;

/**
 * @author TCW
 * layui数据表格结果
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TableInfo {
    private Integer code;
    private String message;
    private Integer count;
    private Object[] data;
}
