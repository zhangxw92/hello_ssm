package com.athome.controller;

import com.athome.entity.Blog;
import com.athome.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
}
