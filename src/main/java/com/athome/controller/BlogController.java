package com.athome.controller;

import com.athome.entity.Blog;
import com.athome.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/getBlog")
    public void getBlog() {
        Blog blog = blogService.getBlog(1);
        System.out.println(blog);
    }
}
