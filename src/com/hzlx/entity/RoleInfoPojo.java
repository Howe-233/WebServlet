package com.hzlx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/7 16:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleInfoPojo {
    private Integer id;
    private String name;
    private Date createTime;
    private Integer status;
}
