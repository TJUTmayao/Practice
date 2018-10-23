package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.entity.ResultPojo;
import project.entity.UserLogin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/12 09:38
 * @Description:
 */
@Controller
public class PageContrller {

    @RequestMapping("/page/{page}")
    public String page(@PathVariable String page){
        return page;
    }


    @RequestMapping("/test")
    public String test(Model model){
        return "testJq";
    }
}
