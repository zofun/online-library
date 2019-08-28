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
    private Integer status;
    private String message;
    private Integer total;
    private Object[] data;
}
