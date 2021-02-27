package com.athome.xiangyuanmoshi;

import java.util.HashMap;
import java.util.Map;

public class WebSiteFactory {

    private Map<String, WebSite> map = new HashMap<>();

    public WebSite getWebSite(String type) {
        if (!map.containsKey(type)) {
            if ("1".equals(type)) {
                map.put(type, new BlogWebSite(type));
            } else if ("2".equals(type)) {
                map.put(type, new XinlangWebSite(type));
            }
        }

        return map.get(type);
    }
}
