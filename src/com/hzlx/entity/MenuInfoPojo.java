package com.hzlx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/5/31 15:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuInfoPojo {
    private Integer id;
    private String title;
    private String icon;
    private String href;
    private Integer pId;
    private Date createTime;
    private Integer status;
}
