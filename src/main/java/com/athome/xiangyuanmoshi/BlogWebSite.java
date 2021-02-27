package com.athome.xiangyuanmoshi;

import com.athome.entity.User;

public class BlogWebSite extends WebSite {

    public BlogWebSite(String type) {
        super(type);
    }

    public void use(User user) {
        System.out.println("这是博客网站：用户名" + user.getName());
    }
}
