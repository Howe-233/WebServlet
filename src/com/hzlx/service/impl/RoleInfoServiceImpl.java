package com.hzlx.service.impl;

import com.hzlx.component.BGMSConfig;
import com.hzlx.dao.RoleInfoDao;
import com.hzlx.dao.impl.RoleInfoDaoImpl;
import com.hzlx.entity.RoleInfoPojo;
import com.hzlx.service.RoleInfoService;
import com.hzlx.utils.BaseResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/7 16:06
 */
public class RoleInfoServiceImpl implements RoleInfoService {
    private RoleInfoDao roleInfoDao = new RoleInfoDaoImpl();

    /**
     * @description: 展示角色管理菜单
     * @param:
     * @return:
     * @author Howe
     */
    @Override
    public String showRolesInfo(HttpServletRequest request) {
        List<RoleInfoPojo> roleInfoAll = roleInfoDao.getRoleInfoAll();
        request.getSession().setAttribute(BGMSConfig.ROLE_INFO_ALL, roleInfoAll);
        return "pages/roles";
    }

    @Override
    public String modifyRoleInfo(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        RoleInfoPojo roleInfoPojo = roleInfoDao.getRoleInfoById(id);
        if (roleInfoPojo == null) {
            return BaseResponse.error(100001, "数据回显失败");
        } else {
            return BaseResponse.success(roleInfoPojo);
        }

    }

    @Override
    public String updateRoleInfo(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        if (roleInfoDao.updateRoleInfo(name, id) > 0) {
            return BaseResponse.success();
        } else {
            return BaseResponse.error(100001, "保存失败");
        }
    }

    @Override
    public String deleteOne(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        if (roleInfoDao.deleteRoleInfoById(id) > 0) {
            return BaseResponse.success();
        } else {
            return BaseResponse.error(100001, "修改失败");
        }
    }

    @Override
    public String deleteInfo(HttpServletRequest request) {
        String[] selectIds = request.getParameterMap().get("ids[]");
        Integer[] ids = new Integer[selectIds.length];
        for (int i = 0; i < selectIds.length; i++) {
            ids[i] = Integer.parseInt(selectIds[i]);
        }
        if (roleInfoDao.deleteInfo(ids) > 0) {
            return BaseResponse.success();
        } else {
            return BaseResponse.error(100001, "修改失败");
        }

    }

    @Override
    public String createRoleInfo(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (roleInfoDao.createRoleInfo(name) > 0) {
            return BaseResponse.success();
        } else {
           return BaseResponse.error(100001, "保存失败");
        }

    }
}
