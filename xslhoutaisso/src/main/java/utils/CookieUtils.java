package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/2 14:14
 * @Description:
 */
public class CookieUtils {

    public static void setCookie(HttpServletResponse response , String managerId , String managerKey){
        /**
         *
         * 功能描述: 设置cookie到当前域名的/路径下
         *
         * @param: [response, managerKey]
         * @return: void
         * @auther: 11432_000
         * @date: 2018/10/2 14:00
         */
        Cookie cookie = new Cookie(managerId ,managerKey );
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void removeCookie(HttpServletResponse response ,String cookieName){
        /**
         *
         * 功能描述: 删除当域名下的路径为/的cookie
         *
         * @param: [response, cookieName]
         * @return: void
         * @auther: 11432_000
         * @date: 2018/10/2 14:01
         */
        Cookie removeCookie = new Cookie(cookieName,"");
        removeCookie.setPath("/");
        removeCookie.setMaxAge(0);
        response.addCookie(removeCookie);
    }

}
