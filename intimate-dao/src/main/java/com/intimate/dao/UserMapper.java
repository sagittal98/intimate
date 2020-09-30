package com.intimate.dao;

import com.intimate.pojo.User;
import com.intimate.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    // 批量插入用户信息
    void insertUserInfos(List<User> userList);

    List<User> selectByExample(UserExample example);
    // 通过手机号码查询用户信息
    List<User> selectByPhones(List<User> userList);

    User selectByPrimaryKey(Long userId);

    User selectByPhoneNumber(@Param("phone") String phone);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkPhone(String phoneNumber);
}