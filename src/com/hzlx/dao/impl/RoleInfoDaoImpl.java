package com.hzlx.dao.impl;

import com.hzlx.dao.RoleInfoDao;
import com.hzlx.entity.RoleInfoPojo;
import com.hzlx.utils.BaceDao;

import java.util.List;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/7 16:01
 */
public class RoleInfoDaoImpl extends BaceDao<RoleInfoPojo> implements RoleInfoDao {

    @Override
    public List<RoleInfoPojo> getRoleInfoAll() {
        return selectListForObject("select * from t_role_info",RoleInfoPojo.class);
    }

    @Override
    public RoleInfoPojo getRoleInfoById(Integer id) {
        return selectOne("select * from t_role_info where id = ?" ,RoleInfoPojo.class,id);
    }

    @Override
    public Integer updateRoleInfo(String name,Integer id) {
        return executeUpdate("update t_role_info set name = ? where id = ?",name,id);
    }

    @Override
    public Integer deleteRoleInfoById(Integer id) {

        return executeUpdate("update t_role_info set `status` = 0 where id = ?",id);
    }

    @Override
    public Integer deleteInfo(Integer[] ids) {
        String sql = "update t_role_info set `status` = if(`status`=0,1,0) where ";
        for (int i = 0; i < ids.length; i++) {
            if (i == ids.length -1){
                sql += " id = ?";
            }else{
                sql += " id = ?  or ";
            }

        }


        return executeUpdate(sql,ids);
    }

    @Override
    public Integer createRoleInfo(String name) {
        return executeUpdate("insert into t_role_info value (default,?,now(),default)",name);
    }
}
