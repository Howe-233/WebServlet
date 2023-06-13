package com.hzlx.dao.impl;

import com.hzlx.dao.UserInfoDao;
import com.hzlx.entity.UserInfoPojo;
import com.hzlx.utils.BaceDao;
import com.mysql.cj.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/5/30 21:44
 */
public class UserInfoDaoImpl extends BaceDao<UserInfoPojo> implements UserInfoDao {
    /**
     * @description: 用户登录方法
     * @param: 获取到的userName和Password
     * @return: UserInfoPojo对象
     * @author Howe
     */
    @Override
    public UserInfoPojo getUserInfoByUserNameAndPassword(String userName, String password) {

        return selectOne("select * from t_user_info where user_name = ? and `password` = ?", UserInfoPojo.class, userName, password);
    }

    @Override
    public List<UserInfoPojo> getAllUserInfo(String name) {

        String sql = "select * from t_user_info ";
        if (!StringUtils.isNullOrEmpty(name)) {
            sql += " where user_name like concat('%',?,'%')";
            return selectListForObject(sql, UserInfoPojo.class, name);
        }
        return selectListForObject(sql, UserInfoPojo.class);

    }

    @Override
    public Integer register(UserInfoPojo userInfo) {

        return executeUpdate("insert into t_user_info value(DEFAULT,?,?,?,?,?,?,DEFAULT,now(),DEFAULT)",
                userInfo.getName(),
                userInfo.getUserName(),
                userInfo.getPassword(),
                userInfo.getTel(),
                userInfo.getAddress(),
                userInfo.getSex()
        );
    }

    @Override
    public Integer deleteUserInfo(Integer[] userId) {
        String sqlL = "delete from t_user_info where ";
        for (Integer integer : userId) {
            sqlL += "id=? or ";
        }
        sqlL = sqlL.substring(0, sqlL.length() - 3);
        return executeUpdate(sqlL, userId);
    }

    public Integer setStatus(Integer[] userId) {
        String sqlL = "update  t_user_info set `status`= if(`status`=0,1,0) where ";
        for (Integer integer : userId) {
            sqlL += "id=? or ";
        }
        sqlL = sqlL.substring(0, sqlL.length() - 3);
        return executeUpdate(sqlL, userId);
    }

    @Override
    public UserInfoPojo getUserInfoById(Integer id) {
        return selectOne("select * from t_user_info where id=?", UserInfoPojo.class, id);
    }

    @Override
    public Integer userUpdate(String[] keys, String[] values, Integer sex, Integer id) {
        String sql = "update t_user_info set ";
        for (int i = 0; i < keys.length; i++) {
            sql += " " + keys[i] + " = ?,";
            if (i == values.length - 1) {
                sql += " sex = ? where id = ? ";
            }
        }

        return executeUpdate(sql, values, sex, id);
    }

    @Override
    public Integer deleteOne(Integer id) {
        return executeUpdate("update t_user_info set `status` = 0 where id = ?", id);
    }


}
