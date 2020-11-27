package com.athome.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.athome.dao.BlogDao;
import com.athome.entity.Blog;
import com.athome.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author zhangxw03
 * @Dat 2020-11-24 10:13
 * @Describe
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog getBlog(Integer id) {
        return blogDao.getBlog(id);
    }

    @Override
    public List<Blog> list() {

        return blogDao.list();
    }

    @Override
    public int save(Blog blog) {
        int id = blog.getBook().getId();
        blog.setBookId(id);
        return blogDao.save(blog);
    }

    @Override
    public int udpate(Blog blog) {

        return blogDao.update(blog);
    }

    @Override
    public void remove(String id) {
        blogDao.remove(id);
    }

}
