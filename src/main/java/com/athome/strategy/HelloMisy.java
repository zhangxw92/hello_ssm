package com.athome.strategy;

import com.athome.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 10:45
 * @Describe
 */
@Component
public class HelloMisy implements HelloPerson {
    @Override
    public boolean canExecute(User user) {
        return user != null && user.getSex() == 0;
    }

    @Override
    public String execute(User user) {
        System.out.println(user);
        return "识别出来为女性";
    }
}
