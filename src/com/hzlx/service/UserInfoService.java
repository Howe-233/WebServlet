package com.hzlx.service;

import com.hzlx.entity.UserInfoPojo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserInfoService {
    /**
     * @description: 用户登录方法
     * @param: request http请求用户获取用提交的数据、response 服务器给http的响应
     * @return: String
     * @author Howe
     */
    String UserLogin(HttpServletRequest request);
//    String checkCaptcha(HttpServletRequest request);
    /**
     * @description: 用户管理页面展示
     * @param:
     * @return: 页面地址
     * @author Howe
     */
    String showUserMessage(HttpServletRequest request);
    /**
     * @description: 用户添加页面展示
     * @param:
     * @return: 页面地址
     * @author Howe
     */

    String showAddUser(HttpServletRequest request);
    /**
     * @description: 用户添加方法
     * @param:
     * @return:
     * @author Howe
     */

    String register(HttpServletRequest request);
    /**
     * @description: 通过Id删除用户信息（修改状态）
     * @param:
     * @return:
     * @author Howe
     */
    String deleteUserInfo(HttpServletRequest request);

    /**
     * @description: 通过id获取用户信息（用于修改信息时展示原有信息）
     * @param:
     * @return:
     * @author Howe
     */
    String modifyUserInfo(HttpServletRequest request);
    /**
     * @description: 用户信息修改
     * @param:
     * @return:
     * @author Howe
     */

    String userUpdate(HttpServletRequest request);
    /** 
     * @description: 删除单个用户（）修改状态
     * @param:
     * @return:
     * @author Howe
     */ 
    String deleteOne(HttpServletRequest request);
}
