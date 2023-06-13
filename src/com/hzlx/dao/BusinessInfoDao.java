package com.hzlx.dao;

import com.hzlx.entity.BusinessInfoPojo;

import java.util.List;

public interface BusinessInfoDao {
    List<BusinessInfoPojo> getBusinessInfoAll();

    BusinessInfoPojo modifyBusinessInfo(Integer id);

    int updateBusinessInfo(Integer id, String[] keys, String[] values);

    int deleteBusinessInfo(Integer id);

    int insertBusinessInfo(BusinessInfoPojo businessInfo);

    int deleteBusiness(Integer[] id);
}
