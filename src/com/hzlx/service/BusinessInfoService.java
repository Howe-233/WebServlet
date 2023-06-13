package com.hzlx.service;

import com.hzlx.entity.BusinessInfoPojo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BusinessInfoService {
    /**
     * @description: 获取商家所有信息存放到Session
     * @param:
     * @return:
     * @author Howe
     */
    List<BusinessInfoPojo> getBusinessInfoAll(HttpServletRequest request);
    /**
     * @description: 数据回显
     * @param:
     * @return:
     * @author Howe
     */
    String modifyBusinessInfo(HttpServletRequest request);
    /**
     * @description: 修改数据
     * @param:
     * @return:
     * @author Howe
     */
    String updateBusinessInfo(HttpServletRequest request);
    /**
     * @description: 删除单条数据方法
     * @param: 请求的id
     * @return: 是否成功
     * @author Howe
     */
    String deleteBusinessOne(HttpServletRequest request);
    /**
     * @description: 商家新增方法
     * @param:
     * @return:
     * @author Howe
     */
    String createBusinessInfo(HttpServletRequest request);
    /**
     * @description: 改变状态方法多选
     * @param:
     * @return:
     * @author Howe
     */

    String deleteBusiness(HttpServletRequest request);
}
