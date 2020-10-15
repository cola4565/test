package com.wsq.test02.dao;

import com.wsq.test02.model.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    User selectByPrimaryKey(String id);
    int insert(User user);
    int update(User user);
    int delete(String id);
}
