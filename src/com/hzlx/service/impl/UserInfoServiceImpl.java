package com.hzlx.service.impl;

import com.hzlx.component.BGMSConfig;
import com.hzlx.dao.UserInfoDao;
import com.hzlx.dao.impl.UserInfoDaoImpl;
import com.hzlx.entity.UserInfoPojo;
import com.hzlx.service.UserInfoService;
import com.hzlx.utils.BaseResponse;
import com.hzlx.utils.MD5EncryptionUtil;
import com.mysql.cj.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author Howe
 * @version 2021.2
 * @date 2023/5/30 21:38
 */
public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();

    @Override
    /**
     * @description: 用户登录方法通过用户名和密码
     * @param: Web请求对象
     * @return: 异步信息
     * @author Howe
     */
    public String UserLogin(HttpServletRequest request) {

        //获取用户请求
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //用户名密码非空校验
        if (StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(password)) {

            return BaseResponse.error(10001, "用户名或密码为空");
        }

        String NPassword = MD5EncryptionUtil.encryptMD5(password, userName);
        UserInfoPojo userInfo = userInfoDao.getUserInfoByUserNameAndPassword(userName, NPassword);
        if (userInfo == null) {
            return BaseResponse.error(10002, "账号或密码错误");
        } else {
            request.getSession().setAttribute("userInfo", userInfo);
            return BaseResponse.success();
        }
    }

    /**
     * @description: 用户管理页面展示
     * @param:
     * @return:
     * @author Howe
     */
    @Override
    public String showUserMessage(HttpServletRequest request) {
        String keyword = request.getParameter(BGMSConfig.KEYWORD);
//        List<UserInfoPojo> MoHuList = userInfoDao.getAllUserInfo(keyword);
        request.setAttribute(BGMSConfig.KEYWORD, keyword);
        request.setAttribute(BGMSConfig.USER_INFO_ALL, userInfoDao.getAllUserInfo(keyword));

        /*String keyword = request.getParameter(BgmsConfig.KEYWORD);
        request.setAttribute(BgmsConfig.KEYWORD, keyword);
        request.setAttribute(BgmsConfig.ROLE_LIST, roleInfoDao.getRoleInfoAllByName(keyword));*/



        return "pages/userManage";
    }

    /**
     * @description: 展示添加用户页面
     * @param:
     * @return:
     * @author Howe
     */
    @Override
    public String showAddUser(HttpServletRequest request) {
        return "pages/addUser";
    }

    /**
     * @description: 添加用户
     * @param:
     * @return:
     * @author Howe
     */
    @Override
    public String register(HttpServletRequest request) {
        UserInfoPojo userInfo = new UserInfoPojo();

        String name = request.getParameter("name");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        Integer sex = Integer.valueOf(request.getParameter("sex"));

        userInfo.setName(name);
        userInfo.setUserName(userName);

        String s = MD5EncryptionUtil.encryptMD5(password, userName);

        userInfo.setPassword(s);
        userInfo.setTel(tel);
        userInfo.setAddress(address);
        userInfo.setSex(sex);

        Integer register = userInfoDao.register(userInfo);
        if (register != 0) {
            return BaseResponse.success();
        } else {
            return BaseResponse.error(10001, "添加失败");
        }

    }

    @Override
    public String deleteUserInfo(HttpServletRequest request) {
        String[] selectIds = request.getParameterMap().get("selectId[]");
        Integer[] id = new Integer[selectIds.length];
        for (int i = 0; i < selectIds.length; i++) {
            id[i] = Integer.parseInt(selectIds[i]);
        }
        Integer integer = userInfoDao.setStatus(id);
        if (integer > 0) {
            return BaseResponse.success();
        } else {
            return BaseResponse.error(100001, "删除失败");
        }

    }

    @Override
    public String modifyUserInfo(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        UserInfoPojo userInfo = userInfoDao.getUserInfoById(id);
        if (userInfo == null) {
            return BaseResponse.error(100001, "参数错误");
        } else {
            return BaseResponse.success(userInfo);
        }

    }

    @Override
    public String userUpdate(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, String> newMap = mapZH(parameterMap);


        Integer id = Integer.valueOf(newMap.remove("id"));
        Integer sex = Integer.valueOf(newMap.remove("sex"));
        String[] keys = new String[newMap.size()];
        String[] values = new String[newMap.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : newMap.entrySet()) {
                keys[i] = entry.getKey();
                values[i] = entry.getValue();
            i++;
        }
//        for (int i1 = 0; i1 < keys.length; i1++) {
//
//        }
        Integer rows = userInfoDao.userUpdate(keys, values, sex, id);
//        return rows > 0 ? BaseResponse.success() : BaseResponse.error(100001,"保存失败");
        if (rows > 0){
            System.out.println(200);
            return BaseResponse.success();
        }else{
            System.out.println(1000);
            return BaseResponse.error(100003,"保存失败");
        }
    }

    @Override
    public String deleteOne(HttpServletRequest request) {
        String id = request.getParameter("id");
        if ( userInfoDao.deleteOne(Integer.parseInt(id)) > 0 ){
            return BaseResponse.success();
        }else{
            return BaseResponse.error(10001,"删除失败");
        }
    }

    private Map<String, String> mapZH(Map<String, String[]> parameterMap){
        Map<String, String> newMap = new HashMap<>();
        String userName = parameterMap.get("user_name")[0];
        String password = parameterMap.get("password")[0];
        for (String s : parameterMap.keySet()) {
            if (!parameterMap.get(s)[0].isEmpty() && parameterMap.get(s)[0] != ""){
                if (s.equals("password")){
                    newMap.put(s,MD5EncryptionUtil.encryptMD5(password,userName));
                }else {
                    newMap.put(s,parameterMap.get(s)[0]);
                }

            }
        }
        return newMap;
    }
}
