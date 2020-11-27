package com.athome.service;

import com.athome.entity.Blog;

import java.util.List;

/**
 * @Author zhangxw03
 * @Dat 2020-11-24 10:13
 * @Describe
 */
public interface BlogService {

    Blog getBlog(Integer id);

    List<Blog> list();

    int save(Blog blog);

    int udpate(Blog blog);

    void remove(String id);
}
