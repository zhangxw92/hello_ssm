package com.athome.xiangyuanmoshi;

import com.athome.entity.User;

public abstract class WebSite {

    protected String type;

    public abstract void use(User user);

    public WebSite(String type) {
        this.type = type;
    }
}
