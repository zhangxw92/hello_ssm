package com.athome.xiangyuanmoshi;

import com.athome.entity.User;

public class XinlangWebSite extends WebSite {

    public XinlangWebSite(String type) {
        super(type);
    }

    public void use(User user) {
        System.out.println("这是新浪网站：用户名" + user.getName());
    }
}
