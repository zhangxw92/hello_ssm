package com.athome.controller;

import com.athome.dao.BookDao;
import com.athome.entity.Blog;
import com.athome.entity.Book;
import com.athome.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/list")
    public String list(Map<String, Object> map) {
        List<Blog> list = blogService.list();
        map.put("blogs", list);
        return "list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        List<Book> list = bookDao.list();
        model.addAttribute("books", list);
        System.out.println("测试保存,跳转到编辑页");
        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Blog blog) {
        System.out.println("测试保存" + blog);
        int save = blogService.save(blog);
        System.out.println("测试保存，结果：" + save);
        //增删改之后重定向到列表页面
        return "redirect:list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") String id) {
        System.out.println(id);
        return "success";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String id) {
        System.out.println(id);
        return "success";
    }
}
