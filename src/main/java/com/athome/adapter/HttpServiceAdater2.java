package com.athome.adapter;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 17:00
 * @Describe 对象适配器
 */
public class HttpServiceAdater2 implements HttpService {

    private FormatterServiceImpl formatterService;

    public HttpServiceAdater2(FormatterServiceImpl formatterService) {
        this.formatterService = formatterService;
    }

    @Override
    public boolean send() {
        String formatter = formatterService.formatter();
        System.out.println("数据发送成功！" + formatter);
        return false;
    }
}
