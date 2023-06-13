package com.hzlx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/9 9:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessInfoPojo {
    private Integer id;
    private String storeName;
    private String notes;
    private String tel;
    private String address;
    private String avatar;
    private Date createTime;
    private Integer status;
}
