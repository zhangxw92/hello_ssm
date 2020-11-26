package com.athome.controller;

import com.athome.entity.Blog;
import com.athome.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/blog")
public class Blog2Controller {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String list(Map<String, Object> map) {
        List<Blog> list = blogService.list();
        map.put("blogs", list);
        return "list";
    }
}
