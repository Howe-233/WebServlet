package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.RequestParameter;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.component.BGMSConfig;
import com.hzlx.entity.BusinessInfoPojo;
import com.hzlx.service.BusinessInfoService;
import com.hzlx.service.impl.BusinessInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/9 9:15
 */
@Controller
@RequestMapping("/api/business")
public class BusinessInfoController {
    private BusinessInfoService businessInfoService = new BusinessInfoServiceImpl();
    /**
     * @description: 商家管页面展示
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/showBusiness")
    @RequestParameter
    public String showBusinessManage(HttpServletRequest request){
        List<BusinessInfoPojo> businessInfoPojoList = businessInfoService.getBusinessInfoAll(request);
        request.getSession().setAttribute(BGMSConfig.BUSINESS_INFO_ALL,businessInfoPojoList);
        return "pages/business";
    }
    /**
     * @description: 修改数据时回显数据
     * @param: 需要修改的id
     * @return: json格式的数据
     * @author Howe
     */
    @RequestMapping("/modifyBusinessInfo")
    @RequestParameter
    @ResponseBody
    public String modifyBusinessInfo(HttpServletRequest request){
        return businessInfoService.modifyBusinessInfo(request);
    }
    /**
     * @description: 修改数据
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/updateBusinessInfo")
    @RequestParameter
    @ResponseBody
    public String updateBusinessInfo(HttpServletRequest request){
        return businessInfoService.updateBusinessInfo(request);
    }
    /**
     * @description:删除单个商家数据
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/deleteBusinessOne")
    @RequestParameter
    @ResponseBody
    public String deleteBusinessOne(HttpServletRequest request){
        return businessInfoService.deleteBusinessOne(request);
    }
    /**
     * @description: 商家新增方法
     * @param: 请求中的数据
     * @return: 是否成功
     * @author Howe
     */
    @RequestMapping("/createBusinessInfo")
    @RequestParameter
    @ResponseBody
    public String createBusinessInfo(HttpServletRequest request){
        return businessInfoService.createBusinessInfo(request);
    }
    /**
     * @description: 删除多个商家数据
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/deleteBusiness")
    @RequestParameter
    @ResponseBody
    public String deleteBusiness(HttpServletRequest request){
        return businessInfoService.deleteBusiness(request);
    }
}
