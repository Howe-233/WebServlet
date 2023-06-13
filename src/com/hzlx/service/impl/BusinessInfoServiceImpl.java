package com.hzlx.service.impl;

import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.dao.impl.BusinessInfoDaoImpl;
import com.hzlx.entity.BusinessInfoPojo;
import com.hzlx.service.BusinessInfoService;
import com.hzlx.utils.BaseResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/9 9:16
 */
public class BusinessInfoServiceImpl implements BusinessInfoService {
    private BusinessInfoDao businessInfoDao = new BusinessInfoDaoImpl();

    @Override
    public List<BusinessInfoPojo> getBusinessInfoAll(HttpServletRequest request) {

        List<BusinessInfoPojo> list = businessInfoDao.getBusinessInfoAll();
        if (list != null) {
            return list;
        } else {

            return new ArrayList<>();
        }

    }

    @Override
    public String modifyBusinessInfo(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        BusinessInfoPojo businessInfoPojo = businessInfoDao.modifyBusinessInfo(id);
        if (businessInfoPojo != null) {
            return BaseResponse.success(businessInfoPojo);
        } else {
            return BaseResponse.error(100001, "回显失败");
        }

    }

    @Override
    public String updateBusinessInfo(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, String> newMap = mapZH(parameterMap);
        Integer id = Integer.valueOf(newMap.remove("id"));
        String keys[] = new String[newMap.size()];
        String values[] = new String[newMap.size()];
        int i = 0;
        for (Map.Entry<String, String> stringStringEntry : newMap.entrySet()) {
            keys[i] = stringStringEntry.getKey();
            values[i] = stringStringEntry.getValue();
            i++;
        }
        int rows = businessInfoDao.updateBusinessInfo(id, keys, values);
        if (rows > 0) {
            return BaseResponse.success();
        } else {
            return BaseResponse.error(10001, "保存失败");
        }
    }

    @Override
    public String deleteBusinessOne(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        int rows = businessInfoDao.deleteBusinessInfo(id);
        if (rows > 0) {
            return BaseResponse.success();
        } else {
            return BaseResponse.error(10001, "删除失败");
        }
    }

    @Override
    public String createBusinessInfo(HttpServletRequest request) {
        BusinessInfoPojo businessInfo = new BusinessInfoPojo();
        businessInfo.setStoreName(request.getParameter("storeName"));
        businessInfo.setNotes(request.getParameter("notes"));
        businessInfo.setTel(request.getParameter("tel"));
        businessInfo.setAvatar(request.getParameter("avatar"));
        businessInfo.setAddress(request.getParameter("address"));
        int rows = businessInfoDao.insertBusinessInfo(businessInfo);
        if (rows > 0){
            return BaseResponse.success();
        }else{
            return BaseResponse.error(10001,"保存失败");
        }
    }

    @Override
    public String deleteBusiness(HttpServletRequest request) {
        String[] strings = request.getParameterMap().get("ids[]");
        Integer[] id = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            id[i] = Integer.parseInt(strings[i]);
        }
        int rows = businessInfoDao.deleteBusiness(id);
        if (rows > 0){
            return BaseResponse.success();
        }else{
            return BaseResponse.error(10001,"修改失败");
        }
    }

    private Map<String, String> mapZH(Map<String, String[]> parameterMap) {
        Map<String, String> newMap = new HashMap<>();
        for (String s : parameterMap.keySet()) {
            if (!parameterMap.get(s)[0].isEmpty() && parameterMap.get(s)[0] != "") {
                newMap.put(s, parameterMap.get(s)[0]);
            }
        }
        return newMap;
    }
}
