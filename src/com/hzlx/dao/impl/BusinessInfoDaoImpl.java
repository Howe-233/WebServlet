package com.hzlx.dao.impl;

import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.entity.BusinessInfoPojo;
import com.hzlx.utils.BaceDao;

import java.util.List;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/9 9:15
 */
public class BusinessInfoDaoImpl extends BaceDao<BusinessInfoPojo> implements BusinessInfoDao {

    @Override
    public List<BusinessInfoPojo> getBusinessInfoAll() {
        return selectListForObject("select * from t_business_info", BusinessInfoPojo.class);
    }

    @Override
    public BusinessInfoPojo modifyBusinessInfo(Integer id) {
        return selectOne("select * from t_business_info where id = ?", BusinessInfoPojo.class, id);
    }

    @Override
    public int updateBusinessInfo(Integer id, String[] keys, String[] values) {
        String sql = "UPDATE t_business_info set ";
        for (int i = 0; i < keys.length; i++) {
            if (i == keys.length - 1) {
                sql += keys[i] + " = ? WHERE id = ? ";
            }else{
                sql += keys[i] + " = ? , ";
            }
        }
        return executeUpdate(sql, values,id);
    }

    @Override
    public int deleteBusinessInfo(Integer id) {
        return executeUpdate("update t_business_info set `status` = 0 WHERE id = ?",id);
    }

    @Override
    public int insertBusinessInfo(BusinessInfoPojo businessInfo) {
        return executeUpdate("insert into t_business_info value(default,?,?,?,?,?,now(),default)",
                businessInfo.getStoreName(),
                businessInfo.getNotes(),
                businessInfo.getTel(),
                businessInfo.getAddress(),
                businessInfo.getAvatar()
        );
    }

    @Override
    public int deleteBusiness(Integer[] id) {
        String sql = "update t_business_info set `status` = if(`status`=1,0,1) where id = ? ";
        for (int i = 1; i < id.length; i++) {
            sql += " or id = ? ";
        }
        return executeUpdate(sql,id);
    }
}
