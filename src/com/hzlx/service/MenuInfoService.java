package com.hzlx.service;

import com.hzlx.entity.vo.MenuInfoVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MenuInfoService {
    /**
     * @description: 根据用户角色获取获取对应的菜单列表
     * @param: 请求对象用来获取请求中Session
     * @return: 菜单列表集合
     * @author Howe
     */
    String homePage(HttpServletRequest request);
    /**
     * @description: 展示菜单管理页面
     * @param:
     * @return: 页面地址
     * @author Howe
     */
    String showMenuManage(HttpServletRequest request);

    /**
     * @description: 修改信息时数据回显
     * @param:
     * @return:
     * @author Howe
     */
    String modifyMenuInfo(HttpServletRequest request);
    /**
     * @description: 添加菜单方法
     * @param:
     * @return:
     * @author Howe
     */
    String createMenuInfo(HttpServletRequest request);
    /**
     * @description: 菜单数据修改
     * @param:
     * @return:
     * @author Howe
     */
    String updateMenInfo(HttpServletRequest request);
    /**
     * @description: 删除单条menu数据方法（修改状态）
     * @param:
     * @return:
     * @author Howe
     */
    String deleteMenuOne(HttpServletRequest request);
    /**
     * @description: 删除多条数据（修改状态）
     * @param:
     * @return:
     * @author Howe
     */
    String deleteMenu(HttpServletRequest request);
}
