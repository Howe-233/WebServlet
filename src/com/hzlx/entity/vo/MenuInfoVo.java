package com.hzlx.entity.vo;

import com.hzlx.entity.MenuInfoPojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/2 8:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuInfoVo extends MenuInfoPojo implements Serializable {
    private List<MenuInfoPojo> list;

}
