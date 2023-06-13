package com.hzlx.controller;

import com.hzlx.annotation.*;
import com.hzlx.component.BGMSConfig;
import com.hzlx.service.CaptchaCodeService;
import com.hzlx.service.impl.CaptchaCodeServiceImpl;
import com.hzlx.utils.BaseResponse;
import com.wf.captcha.ArithmeticCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description 功能描述
 * @Author: Mr、哈喽沃德
 * @Date: 2023/5/30 17:34
 * This file was created in IntelliJ IDEA
 */
@Controller
@RequestMapping("/api/captcha")
public class EasyCaptchaController{
    private CaptchaCodeService captchaCodeService = new CaptchaCodeServiceImpl();
    /**
     * @description: 获取验证码图片
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/code")
    @HttpServlet
    public void captcha(HttpServletRequest request, HttpServletResponse response){
        captchaCodeService.captcha(request,response);
    }
    /**
     * @description: 检查验证码
     * @param:
     * @return:
     * @author Howe
     */
    @RequestMapping("/checkCaptcha")
    @ResponseBody
    @RequestParameter
    public String checkCaptcha(HttpServletRequest request){
        return captchaCodeService.check(request);
    }
}
