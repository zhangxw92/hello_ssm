package com.athome.dao;

import com.athome.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zhangxw03
 * @Dat 2020-11-24 10:14
 * @Describe
 */
@Mapper
public interface BlogDao {

    Blog getBlog(Integer id);
}
