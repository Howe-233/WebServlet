package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.RequestParameter;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.RoleInfoService;
import com.hzlx.service.impl.RoleInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/7 15:59
 */
@Controller
@RequestMapping("/api/role")
public class RoleInfoController {
    RoleInfoService roleInfoService = new RoleInfoServiceImpl();
    /**
     * @description: 角色管理菜单展示
     * @param: Web请求对象
     * @return: 页面地址
     * @author Howe
     */
    @RequestMapping("/showRole")
    @RequestParameter
    public String roles(HttpServletRequest request) {
        return roleInfoService.showRolesInfo(request);
    }
    /** 
     * @description: 修改数据时数据回显
     * @param: 
     * @return: 
     * @author Howe
     */ 
    @RequestMapping("/modify")
    @RequestParameter
    @ResponseBody
    
    public String modifyRoleInfo(HttpServletRequest request){
        return roleInfoService.modifyRoleInfo(request);
    }
    /**
     * @description: 修改数据直接修改数据库
     * @param: 需要修改的ID
     * @return: 是否成功
     * @author Howe
     */
    @RequestMapping("/updateInfo")
    @RequestParameter
    @ResponseBody
    public String updateRoleInfo(HttpServletRequest request){
        return roleInfoService.updateRoleInfo(request);
    }
    /**
     * @description: 删除单条数据方法(修改状态未注销)
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/deleteOne")
    @RequestParameter
    @ResponseBody
    public String deleteOne(HttpServletRequest request){
        return roleInfoService.deleteOne(request);
    }
    /**
     * @description: 删除多条数据的方法(修改用户状态)
     * @param: qingqiushuju
     * @return: 是否成功
     * @author Howe
     */
    @RequestMapping("/deleteInfo")
    @RequestParameter
    @ResponseBody
    public String deleteInfo(HttpServletRequest request){
        return roleInfoService.deleteInfo(request);
    }
    @RequestMapping("/createRole")
    @RequestParameter
    @ResponseBody
    public String createRoleInfo(HttpServletRequest request){
        return roleInfoService.createRoleInfo(request);
    }
}
