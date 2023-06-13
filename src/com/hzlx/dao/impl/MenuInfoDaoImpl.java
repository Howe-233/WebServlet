package com.hzlx.dao.impl;

import com.hzlx.dao.MenuInfoDao;
import com.hzlx.entity.MenuInfoPojo;
import com.hzlx.entity.UserInfoPojo;
import com.hzlx.utils.BaceDao;

import java.util.List;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/2 8:57
 */
public class MenuInfoDaoImpl extends BaceDao<MenuInfoPojo> implements MenuInfoDao {
    @Override
    public List<MenuInfoPojo> getMenuInfoForListByPid(Integer userId, Integer pId) {
        String sql = "select tmi.*\n" +
                "from t_menu_info tmi\n" +
                "left join t_menu_role_info tmri on tmri.menu_id=tmi.id\n" +
                "left join t_user_role_info turi  on turi.role_id=tmri.role_id\n" +
                "where turi.user_id=? and tmi.`status`=1 and tmi.p_id=?";
        return selectListForObject(sql, MenuInfoPojo.class, userId, pId);
    }

    @Override
    public List<MenuInfoPojo> getMenuInfoAll() {
        return selectListForObject("SELECT * FROM t_menu_info", MenuInfoPojo.class);
    }

    @Override
    public MenuInfoPojo modifyMenuInfo(Integer id) {
        return selectOne("SELECT * FROM t_menu_info where id = ?", MenuInfoPojo.class, id);
    }

    @Override
    public int createMenuInfo(MenuInfoPojo menuInfoPojo) {

        return executeUpdate("insert into t_menu_info value(default,?,?,?,?,now(),default)",
                menuInfoPojo.getTitle(),
                menuInfoPojo.getIcon(),
                menuInfoPojo.getHref(),
                menuInfoPojo.getPId()
        );
    }

    @Override
    public int updateMenuInfo(Integer id, String[] keys, String[] values) {
        String sql = "UPDATE t_menu_info SET ";
        for (int i = 0; i < keys.length; i++) {
            sql += keys[i] + " = ? ,";
            if (i == keys.length - 1){
                sql = sql.substring(0,sql.length() -1);
            }
        }
        sql += " where id = ? ";
        return executeUpdate(sql, values, id);
    }

    @Override
    public Integer deleteMenuOne(Integer id) {
        return executeUpdate("update t_menu_info set `status` = 0 where id = ?", id);
    }

    @Override
    public int deleteMenu(Integer[] id) {
        String sql = "update t_menu_info set `status` = if(`status` = 1,0,1) where id = ? ";
        for (int i = 1; i < id.length; i++) {
            sql+=" or id = ? ";

        }

        return executeUpdate(sql,id);
    }


}
