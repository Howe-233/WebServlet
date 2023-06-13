package com.hzlx.service.impl;

import com.hzlx.component.BGMSConfig;
import com.hzlx.dao.MenuInfoDao;
import com.hzlx.dao.impl.MenuInfoDaoImpl;
import com.hzlx.entity.MenuInfoPojo;
import com.hzlx.entity.UserInfoPojo;
import com.hzlx.entity.vo.MenuInfoVo;
import com.hzlx.service.MenuInfoService;
import com.hzlx.utils.BaseResponse;
import com.hzlx.utils.MD5EncryptionUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/6/2 9:08
 */
public class MenuInfoServiceImpl implements MenuInfoService {
    private MenuInfoDao menuInfoDao = new MenuInfoDaoImpl();

    @Override
    public String homePage(HttpServletRequest request) {
        //获取session中的用户对象
        UserInfoPojo userInfoPojo = (UserInfoPojo) request.getSession().getAttribute(BGMSConfig.SESSION_USER_KEY);
        List<MenuInfoVo> menuInfoVos = assemblyByMenuTree(userInfoPojo.getId());

        request.getSession().setAttribute("menuList", menuInfoVos);

        return "pages/home";
    }

    @Override
    public String showMenuManage(HttpServletRequest request) {
        List<MenuInfoPojo> menuInfoAll = menuInfoDao.getMenuInfoAll();
        request.getSession().setAttribute(BGMSConfig.MENU_INFO_ALL, menuInfoAll);
        return "pages/menuManage";

    }

    @Override
    public String modifyMenuInfo(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        MenuInfoPojo menuInfoPojo = menuInfoDao.modifyMenuInfo(id);
        if ( menuInfoPojo == null) {
            return BaseResponse.error(10001,"数据回显失败");
        }else {
            return BaseResponse.success(menuInfoPojo);
        }


    }

    @Override
    public String createMenuInfo(HttpServletRequest request) {
        MenuInfoPojo menuInfoPojo = new MenuInfoPojo();
        menuInfoPojo.setTitle(request.getParameter("title"));
        menuInfoPojo.setIcon(request.getParameter("icon"));
        menuInfoPojo.setHref(request.getParameter("href"));
        menuInfoPojo.setPId(Integer.valueOf(request.getParameter("pid")));

        int rows = menuInfoDao.createMenuInfo(menuInfoPojo);
        if (rows > 0){
            return BaseResponse.success();
        }else {
            return BaseResponse.error(10001,"保存失败");
        }
    }

    @Override
    public String updateMenInfo(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, String> menuInfoMap = mapZH(parameterMap);
        Integer id = Integer.valueOf(menuInfoMap.remove("id"));
        String[] keys = new String[menuInfoMap.size()];
        String[] values = new String[menuInfoMap.size()];
        int i = 0;
        for (Map.Entry<String, String> stringStringEntry : menuInfoMap.entrySet()) {
            keys[i] = stringStringEntry.getKey();
            values[i] = stringStringEntry.getValue();
            i++;
        }
        int rows = menuInfoDao.updateMenuInfo(id, keys, values);
        if (rows > 0) {
            return BaseResponse.success();
        }else {
            return BaseResponse.error(10001,"保存失败");
        }

    }

    @Override
    public String deleteMenuOne(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Integer rows = menuInfoDao.deleteMenuOne(id);
        if (rows > 0) {
            return BaseResponse.success();
        }else {
            return BaseResponse.error(10001,"删除失败");
        }
    }

    @Override
    public String deleteMenu(HttpServletRequest request) {
        String[] strings = request.getParameterMap().get("ids[]");
        Integer[] id = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            id[i] = Integer.parseInt(strings[i]);
        }
        int rows = menuInfoDao.deleteMenu(id);
        if (rows > 0) {
            return BaseResponse.success();
        }else {
            return BaseResponse.error(10001,"修改失败");
        }

    }


    private List<MenuInfoVo> assemblyByMenuTree(Integer userId) {
        List<MenuInfoPojo> oneMenuInfo = menuInfoDao.getMenuInfoForListByPid(userId, -1);
        List<MenuInfoVo> menuInfoVos = new ArrayList<>();
        oneMenuInfo.forEach(menuInfoPojo -> {
            MenuInfoVo menuInfoVo = MenuInfoConvertMenuInfoVo(menuInfoPojo);
            menuInfoVo.setList(menuInfoDao.getMenuInfoForListByPid(userId, menuInfoVo.getId()));
            menuInfoVos.add(menuInfoVo);
        });
        return menuInfoVos;
    }

    private MenuInfoVo MenuInfoConvertMenuInfoVo(MenuInfoPojo pojo) {
        MenuInfoVo vo = new MenuInfoVo();

        vo.setId(pojo.getId());
        vo.setTitle(pojo.getTitle());
        vo.setIcon(pojo.getIcon());
        vo.setHref(pojo.getHref());
        vo.setPId(pojo.getPId());
        vo.setCreateTime(pojo.getCreateTime());
        vo.setStatus(pojo.getStatus());
        return vo;
    }

    private Map<String, String> mapZH(Map<String, String[]> parameterMap){
        Map<String, String> newMap = new HashMap<>();
        for (String s : parameterMap.keySet()) {
            if (!parameterMap.get(s)[0].isEmpty() && parameterMap.get(s)[0] != ""){
                    newMap.put(s,parameterMap.get(s)[0]);
            }
        }
        return newMap;
    }
}
