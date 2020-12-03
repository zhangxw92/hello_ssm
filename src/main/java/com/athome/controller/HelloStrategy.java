package com.athome.controller;

import com.athome.entity.User;
import com.athome.strategy.HelloPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * @Author zhangxw03
 * @Dat 2020-12-03 10:52
 * @Describe
 */
@Controller
@RequestMapping("/helloStrategy")
public class HelloStrategy {

    @Autowired
    private Set<HelloPerson> helloPersonSet;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(User user) {
        String execute = helloPersonSet.stream().filter(h -> h.canExecute(user)).findFirst().get().execute(user);
        System.out.println(execute);
        return "success";
    }
}
