package com.wsq.test02.indexController;

import com.wsq.test02.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping( value = "/index")
    public  String index(){
        return "index";
    }
    @RequestMapping(value = "/login" )
    public @ResponseBody String login (HttpServletRequest request, User user){
        if ("xiaowang".equals(user.getId())&&"123456".equals(user.getPassword())){
            request.getSession().setAttribute("user",user);
            return "登录成功！";
        }
        return "登录失败！";
    }
    @RequestMapping(value = "/center")
    public @ResponseBody String check(HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        return "用户名:"+user.getId()+"密码:"+user.getPassword();
    }
    @RequestMapping(value = "/errors")
    public @ResponseBody String error(){
        return "error";
    }
}
