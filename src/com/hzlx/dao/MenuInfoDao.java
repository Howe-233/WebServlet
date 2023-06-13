package com.hzlx.dao;

import com.hzlx.entity.MenuInfoPojo;
import com.hzlx.entity.UserInfoPojo;

import java.util.List;

public interface MenuInfoDao {
    /**
     * @description: 根据Pid查询菜单集合
     * @param:
     * @return: 带有查询pid菜单的集合
     * @author Howe
     */
    List<MenuInfoPojo> getMenuInfoForListByPid(Integer uId, Integer pId);


    List<MenuInfoPojo> getMenuInfoAll();

    MenuInfoPojo modifyMenuInfo(Integer id);

    int createMenuInfo(MenuInfoPojo menuInfoPojo);

    int updateMenuInfo(Integer id, String[] keys, String[] values);

    Integer deleteMenuOne(Integer id);

    int deleteMenu(Integer[] id);
}
