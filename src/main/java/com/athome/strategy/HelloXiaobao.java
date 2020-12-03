package com.athome.strategy;

import com.athome.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 10:47
 * @Describe
 */
@Component
public class HelloXiaobao implements HelloPerson {
    @Override
    public boolean canExecute(User user) {
        return user != null && user.getSex() == 3;
    }

    @Override
    public String execute(User user) {
        System.out.println(user);
        return "识别不出来(＾Ｕ＾)ノ~ＹＯ";
    }
}
