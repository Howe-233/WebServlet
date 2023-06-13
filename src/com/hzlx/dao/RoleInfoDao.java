package com.hzlx.dao;

import com.hzlx.entity.RoleInfoPojo;

import java.util.List;

public interface RoleInfoDao {
    /**
     * @description: 获取角色表中所有数据
     * @param:
     * @return: 实体类的集合
     * @author Howe
     */
    List<RoleInfoPojo> getRoleInfoAll();
    /**
     * @description: 通过Id查询对应的角色信息返回给对应的实体类
     * @param:
     * @return:
     * @author Howe
     */
    RoleInfoPojo getRoleInfoById(Integer id);
    /** 
     * @description: 修改单条数据
     * @param: 需要修改数据的ID
     * @return: 修改数据的数量
     * @author Howe
     */ 
    Integer updateRoleInfo(String name,Integer id);
    /** 
     * @description: 删除多条数据(修改状态)
     * @param: 需要修改的id
     * @return: 修改数据的数量
     * @author Howe
     */ 
    Integer deleteRoleInfoById(Integer id);

    Integer deleteInfo(Integer[] ids);

    Integer createRoleInfo(String name);
}
