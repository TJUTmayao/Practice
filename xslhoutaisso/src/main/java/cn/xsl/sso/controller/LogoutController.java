package cn.xsl.sso.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Result;
import utils.JsonUtils;
import xsl.sso.service.LogoutService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/9/22 14:21
 * @Description:
 */
@Controller
public class LogoutController {
    /**存储token的key*/
    @Value("${COOKIE_ID}")
    private String COOKIE_ID;
    @Resource
    private LogoutService logoutService;

    @RequestMapping("/manager/logout")
    @ResponseBody
    public String logout(HttpServletRequest request , HttpServletResponse response){
        Result result = new Result();
        result.setStatus(100);
        result.setInfo("登出成功");
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if (COOKIE_ID.equals(cookie.getName())){
                    result = logoutService.logoutByToken(cookie.getValue());
                    Cookie removeCookie = new Cookie(COOKIE_ID,"");
                    response.addCookie(removeCookie);
                }
            }
        }
        return JsonUtils.objectToJson(result);
    }

}
