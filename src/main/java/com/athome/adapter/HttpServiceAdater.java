package com.athome.adapter;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 17:00
 * @Describe
 */
public class HttpServiceAdater extends FormatterServiceImpl implements HttpService {

    @Override
    public boolean send() {
        String formatter = formatter();
        System.out.println("数据发送成功！" + formatter);
        return false;
    }
}
