package com.wsq.test02.interceptor;

import com.wsq.test02.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user=(User) request.getSession().getAttribute("user");
        if (null==user){
            response.sendRedirect(request.getContextPath() + "/error");
            return false;
        }
        return true;
    }
}
