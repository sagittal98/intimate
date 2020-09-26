package com.intimate.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.intimate.common.authorization.IAuthority;
import com.intimate.common.authorization.impl.AuthorityImpl;
import com.intimate.common.enums.RedisKeySignEnum;
import com.intimate.common.model.Result;
import com.intimate.common.redis.IRedisTemplate;
import com.intimate.common.redis.impl.RedisTemplateImpl;
import com.intimate.common.time.TimeUtils;
import com.intimate.dao.GroupMapper;
import com.intimate.dao.MemberMapper;
import com.intimate.dao.UserMapper;
import com.intimate.pojo.Member;
import com.intimate.pojo.User;
import org.apache.avro.generic.GenericData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.annotation.ExceptionProxy;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
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

    private IAuthority authority = new AuthorityImpl();

    //    redis缓存
    private IRedisTemplate<String,Object> redisTemplate = new RedisTemplateImpl<>();


    // 修改用户信息
    @Override
    public Result<Boolean> updateUserInfo(String operatorAuthority,User user) {
        logger.info("【日志提醒】进入修改用户信息逻辑！");
        logger.info("【日志提醒】需要修改的用户：user = " + user.toString());
        // 权限判定  authorityLevel
        logger.info("【日志提醒】进入权限判定！");
        Boolean openAuthority = authority.isOpenAuthority(operatorAuthority, user.getAuthorityLevel());
        logger.info("【日志提醒】判定结果：openAuthority = " + openAuthority);
        if (openAuthority){
            logger.info("【日志提醒】进入更新数据库！");
            userMapper.updateByPrimaryKeySelective(user);
            logger.info("【日志提醒】更新成功！");
        }else {
            logger.info("【日志提醒】操作者权限不够！");
            return Result.error(232);
        }
        logger.info("【日志提醒】删除并修改缓存！");
        // 删除并修改缓存
        Boolean delete = redisTemplate.delete(RedisKeySignEnum.signInfo(1002) + user.getUserId());
        logger.info("【日志提醒】删除缓存状态：delete = " + delete);
        if (delete){
            logger.info("【日志提醒】重新存入缓存！");
            redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1002) + user.getUserId()).set(user);
            logger.info("【日志提醒】存入缓存成功！");
        }
        logger.info("【日志提醒】更新用户成功，并返回结果！");
        return Result.success(true,223);
    }

    // 提升权限
    @Override
    public Result<Boolean> updateUserAuthorization(String operatorAuthority,User user) {
        logger.info("【日志提醒】进入权限提升逻辑！");
        logger.info("【日志提醒】对比权限，是否能提升！");
        Boolean openAuthority = authority.isOpenAuthority(operatorAuthority, user.getAuthorityLevel());
        logger.info("【日志提醒】能否提升： openAuthority = " + openAuthority);
        if (!openAuthority){
            logger.info("【日志提醒】操作者权限不够！");
            return Result.error(232);
        }else {
            logger.info("【日志提醒】操作者能操作！");
            logger.info("【日志提醒】开始更新数据！");
            userMapper.updateByPrimaryKeySelective(user);
            logger.info("【日志提醒】更新成功！");
            logger.info("【日志提醒】开始更新缓存！");
            JSONObject objectUserInfo = JSONObject.parseObject(String.valueOf(redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1002) + user.getUserId()).get()));
            logger.info("【日志提醒】获取缓存内容： objectUserInfo = " + objectUserInfo.toJSONString());
            User userInfo = new User(objectUserInfo);
            userInfo.setAuthorityLevel(user.getAuthorityLevel());
            logger.info("【日志提醒】更新缓存内容： userInfo = " + userInfo.toString());
            Boolean delete = redisTemplate.delete(RedisKeySignEnum.signInfo(1002) + user.getUserId());
            logger.info("【日志提醒】删除原先的缓存！");
            if (delete){
                logger.info("【日志提醒】成功删除，开始更新缓存！");
                redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1002) + user.getUserId()).set(userInfo);
                logger.info("【日志提醒】缓存更新成功！");
            }
        }
        return Result.success(true,233);
    }

    // 组织者或企业者或管理员添加大量用户信息
    @Override
    public Result<Boolean> addALotOfUserInfo(List<User> userList,Long groupId,String operatorAuthority) {
        logger.info("【日志提醒】进入批量用户信息添加逻辑！");
        logger.info("【日志提醒】权限鉴别，必须是组织者或企业者或管理员！");
        Boolean aBoolean = authority.authorityAuthentication(operatorAuthority);
        if (!aBoolean){
            logger.info("【日志提醒】权限不够,返回结果：aBoolean =  false");
            return Result.error(232);
        }
        logger.info("【日志提醒】拥有足够权限操作！ aBoolean = true");
        // 首先将用户信息存入数据库，并且获取用户信息  如果有电话号码了，怎么处理
        // 查看缓存中是否存在用户信息，如果存在则不插入数据库
        List<User> insertUserListInfos = new ArrayList<>();
        for (User info:userList){
            Boolean aBoolean1 = redisTemplate.hasKey(RedisKeySignEnum.signInfo(1002) + info.getUserId());
            if (!aBoolean1){
                insertUserListInfos.add(info);
            }
        }
        logger.info("【日志提醒】将用户信息存入数据库，并且获取用户信息");
        try {
            userMapper.insertUserInfos(insertUserListInfos);
        }catch (Exception e){
            logger.info("【日志提醒】用户插入数据库，出现错误");
            // TODO  回滚到没插入前
        }
        // 存入后，根据电话号码查询所有的信息，返回结果集
        logger.info("【日志提醒】成功存入后，根据电话号码查询所有的信息，并返回结果集");
        List<User> users = userMapper.selectByPhones(userList);
        // 成员列表
        List<Member> memberList = new ArrayList<>();
        // 拿到所有信息后，存入缓存
        logger.info("【日志提醒】拿到信息后，存入缓存");
        for (User info :users){
            redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1002) + info.getUserId()).set(info);
            // 当前写入时间
            long getCurrentTime = System.currentTimeMillis();
            Date date = new Date(getCurrentTime);
            // 循环加入memberList
            memberList.add(new Member(info,groupId,date));
        }
        // 存入缓存后，将信息存入成员列表中
        try {
            memberMapper.insertMemberInfos(memberList);
        }catch (Exception e){
            // TODO  回滚没插入前
        }
        // 成功后，存入缓存
        for (Member memberInfo: memberList){
            redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1003)+memberInfo.getMemberId()).set(memberInfo);
        }
        // 成功存入后，返回结果
        return Result.success(true,200);
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
