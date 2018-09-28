package cn.xsl.sso.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Result;
import utils.TokenUtils;
import xsl.sso.service.CheckService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/9/22 10:37
 * @Description:
 */
@Controller
public class CheckController {

    @Resource
    private CheckService checkService;
    @Value("${LOGIN_URL}")
    private String LOGIN_URL;
    /**存储token的key*/
    @Value("${COOKIE_ID}")
    private String COOKIE_ID;
    /**成功状态码*/
    private static final int SUCCESS = 100;


    @RequestMapping("/manager/check")
    public String login(HttpServletRequest request ,HttpServletResponse response){
        /**
         *
         * 功能描述: 拦截器重定向页面，检查用户是否登录，已登录，返回要访问的页面，未登录，清空cookie，跳转至登录界面
         *
         * @param: [request]
         * @return: java.lang.String
         * @auther: 11432_000
         * @date: 2018/9/22 9:57
         */
        String returnUrl = request.getParameter("returnUrl");
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if (COOKIE_ID.equals(cookie.getName())){
                    Result checkResult = checkService.getCheckResult(cookie.getValue());
                    //未登录
                    if (checkResult.getStatus() != SUCCESS){
                        Cookie removeCookie = new Cookie(COOKIE_ID,"");
                        response.addCookie(removeCookie);
                        return "redirect:"+ LOGIN_URL + "?returnUrl=" + returnUrl;
                    }
                    //已登录
                    if (checkResult.getStatus() == SUCCESS){
                        String tokenKey = TokenUtils.checkSuccess(cookie.getValue());
                        return "redirect:" + returnUrl + "?tokenKey=" + tokenKey;
                    }
                    break;
                }
            }
        }
        return "redirect:"+ LOGIN_URL + "?returnUrl=" + returnUrl;
    }


}
