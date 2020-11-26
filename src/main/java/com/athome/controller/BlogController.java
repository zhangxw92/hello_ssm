package com.athome.controller;

import com.athome.entity.Blog;
import com.athome.entity.User;
import com.athome.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/testget/{id}", method = RequestMethod.GET)
    public String login(@PathVariable("id") String id) {
        System.out.println("----" + id);
        return "success";
    }

    @RequestMapping(value = "/getBlog")
    public String getBlog(Map<String, Object> map) {
        Blog blog = blogService.getBlog(1);
        map.put("blog", blog);
        return "list";
    }

    @RequestMapping("login")
    public String login(String username, String password) {
        System.out.println(username + "----" + password);
        return "success";
    }

    @RequestMapping(value = "/testpost", method = RequestMethod.POST)
    public String submit() {
        System.out.println("Post");
        return "success";
    }

    @RequestMapping(value = "/testpost", method = RequestMethod.PUT)
    public String update() {
        System.out.println("put");
        return "success";
    }

    @RequestMapping(value = "/testpost", method = RequestMethod.DELETE)
    public String delete() {
        System.out.println("DELETE");
        return "success";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(@RequestParam(value = "name", required = false) String username, String password) {
        System.out.println(username + "===" + password);
        return "success";
    }

    @RequestMapping(value = "/submit2", method = RequestMethod.POST)
    public String submit2(User user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping(value = "/submit3", method = RequestMethod.POST)
    public ModelAndView submit3(HttpServletRequest request) {
        System.out.println(request.getCookies());
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("password"));
        System.out.println(request.getMethod());
        System.out.println(request.getRequestURL().toString());
        System.out.println(request.getServerPort());
        System.out.println(request.getServerName());
        System.out.println(request.getParameterMap());
        System.out.println(request.getRequestURI());
        System.out.println(request.getContextPath());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "tom");
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
