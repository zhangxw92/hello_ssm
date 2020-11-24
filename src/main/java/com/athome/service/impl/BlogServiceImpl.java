package com.athome.service.impl;

import com.athome.dao.BlogDao;
import com.athome.entity.Blog;
import com.athome.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
