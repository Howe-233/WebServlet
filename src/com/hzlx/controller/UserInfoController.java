package com.hzlx.controller;

import com.google.gson.Gson;
import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.RequestParameter;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.UserInfoService;
import com.hzlx.service.impl.UserInfoServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/1 8:28
 */
@Controller
@RequestMapping("/api/user")
public class UserInfoController{

    //实例化Service对象调用其中方法
    private UserInfoService userInfoService=new UserInfoServiceImpl();

    /**
     * @description: 用户管理菜单展示
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/userManage")
    @RequestParameter
    public String userManage(HttpServletRequest request) {
        return userInfoService.showUserMessage(request);
    }
    /**
     * @description: 添加用户页面
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/addUser")
    @RequestParameter
    public String addUser(HttpServletRequest request){
        return userInfoService.showAddUser(request);
    }

    @RequestMapping("/login")
    @ResponseBody
    @RequestParameter
    /**
     * @description: 用户登录方法
     * @param: Web请求对象
     * @return: 异步信息
     * @author Howe
     */
    public String login(HttpServletRequest request){

        return userInfoService.UserLogin(request);
    }



    /**
     * @description: 用户添加
     * @param:
     * @return:
     * @author Howe
     */

    @RequestMapping("/register")
    @RequestParameter
    @ResponseBody
    public String register(HttpServletRequest request){
        return userInfoService.register(request);
    }
    /**
     * @description: 用户删除方法（更改状态）
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/deleteUserInfo")
    @RequestParameter
    @ResponseBody
    public String deleteUserInfo(HttpServletRequest request){
        return userInfoService.deleteUserInfo(request);
    }
    /**
     * @description: 获取当前用户数据（修改时数据填充）
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/modifyUserInfo")
    @RequestParameter
    @ResponseBody
    public String modifyUserInfo(HttpServletRequest request){
        return userInfoService.modifyUserInfo(request);
    }
    /**
     * @description: 用户信息修改
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/userUpdate")
    @RequestParameter
    @ResponseBody
    public String userUpdate(HttpServletRequest request){
        return userInfoService.userUpdate(request);
    }
    /**
     * @description: 用户删除，单个用户（修改状态）
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    @RequestParameter
    public String deleteOne(HttpServletRequest request){
        return userInfoService.deleteOne(request);
    }
}
