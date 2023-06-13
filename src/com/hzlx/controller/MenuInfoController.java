package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.RequestParameter;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.MenuInfoService;
import com.hzlx.service.impl.MenuInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/2 9:49
 */
@Controller
@RequestMapping("/api/menu")
public class MenuInfoController {
    private MenuInfoService menuInfoService = new MenuInfoServiceImpl();
    /**
     * @description: 展示主菜单
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/showMenu")
    @RequestParameter
    public String homePage(HttpServletRequest request) {
        return menuInfoService.homePage(request);
    }
    /**
     * @description: 展示菜单管理页面
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/showMenuManage")
    @RequestParameter
    public String showMenuManage(HttpServletRequest request){
        return menuInfoService.showMenuManage(request);
    }

    /**
     * @description: 修改菜单信息时回显数据
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/modifyMenuInfo")
    @RequestParameter
    @ResponseBody
    public String modifyMenuInfo(HttpServletRequest request){
        return menuInfoService.modifyMenuInfo(request);
    }
    /**
     * @description: 添加菜单方法
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/createMenuInfo")
    @RequestParameter
    @ResponseBody
    public String createMenuInfo(HttpServletRequest request){
        return menuInfoService.createMenuInfo(request);
    }
    /**
     * @description: 菜单修改数据
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/updateMenInfo")
    @RequestParameter
    @ResponseBody
    public String updateMenInfo(HttpServletRequest request){
        return menuInfoService.updateMenInfo(request);
    }
    /**
     * @description: 删除单条menu数据（修改状态）
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/deleteMenuOne")
    @RequestParameter
    @ResponseBody
    public String deleteMenuOne(HttpServletRequest request){
        return menuInfoService.deleteMenuOne(request);
    }
    /**
     * @description: 删除多个数据和(修改状态)
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/deleteMenu")
    @RequestParameter
    @ResponseBody
    public String deleteMenu(HttpServletRequest request){
        return menuInfoService.deleteMenu(request);
    }
}
