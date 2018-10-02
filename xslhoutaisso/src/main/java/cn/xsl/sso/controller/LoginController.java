package cn.xsl.sso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Result;
import utils.CookieUtils;
import utils.JsonUtils;
import utils.TokenUtils;
import xsl.sso.service.LoginService;
import xsl.sso.service.LogoutService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/9/22 09:12
 * @Description:
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private LoginService loginService;
    @Resource
    private LogoutService logoutService;
    @Resource
    private TokenUtils tokenUtils;
    /**存储token的key*/
    @Value("${COOKIE_ID}")
    private String COOKIE_ID;
    @Value("${PASSWORD_PREFIX}")
    private String PASSWORD_PREFIX;
    @Value("${PASSWORD_SUFFIX}")
    private String PASSWORD_SUFFIX;
    /**成功状态码*/
    private static final int SUCCESS = 100;


    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        /**
         *
         * 功能描述: 跳转登录界面
         *
         * @param: [request]
         * @return: java.lang.String
         * @auther: 11432_000
         * @date: 2018/9/22 10:21
         */
        request.setAttribute("returnUrl",request.getParameter("returnUrl"));
        return "index";
    }

    @RequestMapping("/manager/login")
    @ResponseBody
    public String managerLogin(HttpServletRequest request, HttpServletResponse response){
        /**
         *
         * 功能描述: 登录验证，若登录成功，跳转至登录前想要访问的页面，返回tokenKey。
         *
         * @param: [request, response]
         * @return: java.lang.String
         * @auther: 11432_000
         * @date: 2018/9/22 13:26
         */
        Map map = new HashMap<String, Integer>();
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        String returnUrl = request.getParameter("returnUrl");
        passwd = passwd.replace(PASSWORD_PREFIX,"");
        passwd = passwd.replaceAll(PASSWORD_SUFFIX,"");
        Result loginResult = loginService.getLoginResult(username, passwd);
        if (loginResult.getStatus() == SUCCESS){
            logout(request,response);
            CookieUtils.setCookie(response , loginResult.getData().toString());
            String tokenKey = tokenUtils.checkOrLoginSuccess(loginResult.getData().toString());
            map.put("statu",100);
            map.put("returnUrl",returnUrl + "sso/return?tokenKey=" + tokenKey);
            return JsonUtils.objectToJson(map);
        }
        map.put("statu",loginResult.getStatus());
        return JsonUtils.objectToJson(map);
    }

    public String logout(HttpServletRequest request , HttpServletResponse response){
        /**
         *
         * 功能描述: 登出功能
         *
         * @param: [request, response]
         * @return: java.lang.String
         * @auther: 11432_000
         * @date: 2018/10/2 10:45
         */
        Result result = new Result();
        result.setStatus(100);
        result.setInfo("登出成功");
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if (COOKIE_ID.equals(cookie.getName())){
                    result = logoutService.logoutByToken(cookie.getValue());
                    CookieUtils.removeCookie(response , cookie.getName());
                }
            }
        }
        return JsonUtils.objectToJson(result);
    }

}
