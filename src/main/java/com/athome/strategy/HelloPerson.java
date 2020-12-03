package com.athome.strategy;

import com.athome.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 10:38
 * @Describe
 */
public interface HelloPerson {

    boolean canExecute(User user);

    String execute(User user);
}
