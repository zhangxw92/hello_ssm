package com.athome.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author zhangxw03
 * @Dat 2020-11-30 10:11
 * @Describe
 */
public class HelloInterceptor implements HandlerInterceptor {
    //thredlocal结合拦截器使用，目的计算出方法执行完需要多长时间
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("业务逻辑执行之前执行");
        threadLocal.set(System.currentTimeMillis());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("return之后执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("最终都要执行");
        long end = System.currentTimeMillis();
        long total = end - threadLocal.get();
        System.out.println("菜单加载完成总共需要：" + total);
        threadLocal.remove();
    }
}
