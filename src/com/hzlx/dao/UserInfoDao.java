package com.hzlx.dao;

import com.hzlx.entity.UserInfoPojo;

import java.util.List;

public interface UserInfoDao {
    /**
     * @description: 根据用户名和密码查询用户信息(登录方法)
     * @param: userName账号和password密码
     * @return: 查询到的userInfo对象
     * @author Howe
     */
    UserInfoPojo getUserInfoByUserNameAndPassword(String userName,String password);
    /**
     * @description: 获取所有用户（用户管理菜单展示）
     * @param:
     * @return:
     * @author Howe
     */
    List<UserInfoPojo> getAllUserInfo(String name);
    /**
     * @description: 用户添加方法
     * @param:
     * @return:
     * @author Howe
     */
    Integer register(UserInfoPojo userInfo);
    /**
     * @description: 用户删除（真）
     * @param:
     * @return:
     * @author Howe
     */
    Integer deleteUserInfo(Integer[] userId);
    /**
     * @description: 删除用户（更改用户状态为注销）
     * @param: 多选框选中的数据的id
     * @return:
     * @author Howe
     */
    Integer setStatus(Integer[] userId);
    /**
     * @description: 通过id获取用户用于一条数据的用户
     * @param:
     * @return:
     * @author Howe
     */

    UserInfoPojo getUserInfoById(Integer id);
    /**
     * @description: 修改用户信息
     * @param: 修改的数据keys：有值的字段名，values：有值的字段对应的值，sex，id单个表单个请求使用的int类型的数据
     * @return:
     * @author Howe
     */
    Integer userUpdate(String[] keys, String[] values,Integer sex,Integer id);
    /**
     * @description: 删除单个用户信息（修改状态） 通过id修改状态
     * @param: 用户id
     * @return: 执行成功的行数
     * @author Howe
     */
    Integer deleteOne(Integer id);

}
