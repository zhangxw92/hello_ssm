package com.athome.strategy;

import com.athome.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 10:42
 * @Describe
 */
@Component
public class HelloTom implements HelloPerson {
    @Override
    public boolean canExecute(User user) {
        return user != null && user.getSex() == 1;
    }

    @Override
    public String execute(User user) {
        System.out.println(user);
        return "识别出来为男性";
    }
}
