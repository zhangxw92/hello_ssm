package com.athome.adapter;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 17:00
 * @Describe 该类将获取到的文本格式化
 */
public class FormatterServiceImpl {

    public String formatter() {
        JSONObject j = new JSONObject();
        j.put("name", "张三");
        j.put("age", "15");
        return j.toJSONString();
    }
}
