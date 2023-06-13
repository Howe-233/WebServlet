package com.hzlx.service;

import javax.servlet.http.HttpServletRequest;

public interface RoleInfoService {
    /**
     * @description: 展示角色菜单
     * @param:
     * @return:
     * @author Howe
     */
    String showRolesInfo(HttpServletRequest request);
    /**
     * @description: 修改数据回显
     * @param:
     * @return: json格式的数据
     * @author Howe
     */
    String modifyRoleInfo(HttpServletRequest request);
    /** 
     * @description: 保存用户修改数据通过id直接修改库中内容
     * @param: 
     * @return: 
     * @author Howe
     */ 
    String updateRoleInfo(HttpServletRequest request);
    /** 
     * @description: 删除单条数据（修改用户状态）
     * @param: 
     * @return: 
     * @author Howe
     */ 
    String deleteOne(HttpServletRequest request);
    /** 
     * @description: 删除多条数据(修改用户状态)
     * @param: 
     * @return: 
     * @author Howe
     */ 
    String deleteInfo(HttpServletRequest request);
    /**
     * @description: 新增角色数据
     * @param:
     * @return:
     * @author Howe
     */
    String createRoleInfo(HttpServletRequest request);
}
