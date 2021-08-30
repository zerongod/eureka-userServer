package com.example.springdemo.mapper;

import com.example.springdemo.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper {

    User getUserInfo(int id);
    int save(User user);
    int update(User user);
    int deleteById(int id);
    List<User> selectAll();

}
