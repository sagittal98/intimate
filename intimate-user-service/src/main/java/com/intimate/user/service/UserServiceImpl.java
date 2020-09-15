package com.intimate.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.intimate.common.model.Result;
import com.intimate.dao.GroupMapper;
import com.intimate.dao.MemberMapper;
import com.intimate.dao.UserMapper;
import com.intimate.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Result<Boolean> updateUserInfo(User user) {
        logger.info("【日志提醒】进入修改用户信息逻辑！");
        logger.info("【日志提醒】需要修改的用户：user = " + user);
        // 权限判定  authorityLevel
        int result = userMapper.updateByPrimaryKey(user);
        return Result.success(Boolean.parseBoolean(String.valueOf(result)), result == 1 ? 223 : 224);
    }

    @Override
    public Result<Boolean> updateUserAuthorization(User user) {
        return null;
    }

    @Override
    public Result<Boolean> addALotOfUserInfo(List<User> userList) {
        return null;
    }

    @Override
    public Result<List<User>> queryAllGroupMember(Long groupId) {
        return null;
    }

    @Override
    public Result<User> queryGroupUserInfoByPhone(String phoneNumber, Long groupId) {
        return null;
    }

    @Override
    public Result<User> queryUserInfoByPhone(String phoneNumber) {
        return null;
    }
}
