package com.athome.controller;

import com.athome.entity.Blog;
import com.athome.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

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
}
