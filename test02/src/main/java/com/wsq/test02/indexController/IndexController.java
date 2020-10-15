package com.wsq.test02.indexController;

import com.wsq.test02.model.User;

import com.wsq.test02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private UserService service;

    @RequestMapping( value = "/index")
    public  String index(){
        return "index";
    }
    @RequestMapping(value = "/login" )
    public @ResponseBody String login (HttpServletRequest request, User user){
        if (user.getId()==null||user.getPassword()==null){return "用户名或密码不能为空";}
        if (service.login(user)){
            request.getSession().setAttribute("user",user);
            return "登录成功！";
        }
        return "登录失败！";
    }
    @RequestMapping(value = "/center")
    public String check(HttpServletRequest request, Map<String,Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("id",user.getId());
        map.put("password",user.getPassword());
        return "center";
    }
    @RequestMapping(value = "/changepassword")
    public String changePassword(){
        return "changepassword";
    }
    @RequestMapping(value = "/newpassword")
    public @ResponseBody String newPassword(HttpServletRequest request,String password){
        User user= (User) request.getSession().getAttribute("user");
        request.getSession().removeAttribute("user");
        user.setPassword(password);
        return service.update(user)?"更改密码成功!":"更改密码失败!";

    }
    @RequestMapping(value = "/errors")
    public @ResponseBody String error(){
        return "error";
    }
    @RequestMapping(value = "/deletes")
    public  String deletes(HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        service.delete(user.getId());
         return "redirect:http://localhost:8080/index";
    }
    @RequestMapping(value = "/logup")
    public String logUp(User user){
        return "zhuce";
    }
    @RequestMapping(value = "/newuser")
    public @ResponseBody String newUser(User user){
        if (service.select(user.getId())){
            return "用户名已存在！";
        }
        if(service.insert(user)){
            return "注册成功！";
        }
        return "注册失败!";
    }
}
