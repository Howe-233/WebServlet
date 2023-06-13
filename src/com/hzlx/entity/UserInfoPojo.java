package com.hzlx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/5/30 21:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoPojo {
    private Integer id;
    private String name;
    private String userName;
    private String password;
    private String tel;
    private String address;
    private Integer sex;
    private String avatar;
    private Date createTime;
    private Integer status;
}
