package com.athome.xiangyuanmoshi;

import com.athome.entity.User;

public class Client {

    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();

        WebSite webSite = webSiteFactory.getWebSite("2");
        WebSite webSite2 = webSiteFactory.getWebSite("2");
        System.out.println(webSite == webSite2);

        WebSite webSite3 = webSiteFactory.getWebSite("1");
        WebSite webSite4 = webSiteFactory.getWebSite("1");
        System.out.println(webSite3 == webSite4);

        webSite.use(new User("张三"));
    }
}
