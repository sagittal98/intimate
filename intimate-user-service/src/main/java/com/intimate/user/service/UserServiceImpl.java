package com.intimate.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
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
import com.intimate.pojo.Group;
import com.intimate.pojo.Member;
import com.intimate.pojo.MemberExample;
import com.intimate.pojo.User;
import org.apache.avro.generic.GenericData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.annotation.ExceptionProxy;

import java.sql.SQLException;
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
    /**
     *  1. 判定权限，权限满足才能操作
     *  2. 修改数据库信息
     *  3. 删除缓存
     *  4. 更新缓存
     *  5. 返回结果
     * */
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
    /**
     * 1. 权限判定，满足权限方可操作
     *  1.1 权限提升，提升的权限不能超过本身
     * 2. 更新数据库
     * 3. 获取用户缓存信息
     * 4. 修改获取到的缓存信息的权限
     * 5. 删除缓存
     * 5. 将更新的信息存入缓存
     * 6. 返回结果
     * */
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
    /**
     *  1. 权限判定，必须是组织者或企业者
     *  2. 查看插入用户中的用户是否在缓存中存在
     *   2.1 如果有存在，则直接从需要插入的用户中删除掉
     *   2.2 如果不存在，则存入需要插入的数组中
     *  3. 将用户数据插入数据库中
     *  4. 根据手机号码查询所有用户信息
     *  5. 将用户信息写入缓存
     *  6. 返回结果
     *
     * @param userALLList  传入需要放入成员列表的用户信息
     * */
    @Override
    public Result<Boolean> addALotOfUserInfo(List<User> userALLList,Long groupId,String operatorAuthority) {



        logger.info("【日志提醒】进入批量用户信息添加逻辑！");
        logger.info("【日志提醒】权限鉴别，必须是组织者或企业者或管理员！");
        Boolean authorityAuthentication = authority.authorityAuthentication(operatorAuthority);
        logger.info("【日志提醒】权限鉴别成功！");
        if (!authorityAuthentication){
            logger.info("【日志提醒】权限不够,返回结果：aBoolean =  false");
            return Result.error(232);
        }
        logger.info("【日志提醒】拥有足够权限操作！ aBoolean = true");




        // 首先将用户信息存入数据库，并且获取用户信息  如果有电话号码了，怎么处理
        // 查看缓存中是否存在用户信息，如果存在则不插入数据库 insertUserInfosToUser  insertDataBaseUserInfos
        List<User> insertUserInfosToUser = new ArrayList<>();
        logger.info("【日志提醒】创建需要插入数据库的用户数据列表！");
        // 此处是剔除不需要插入的用户信息
        for (User info:userALLList){
            logger.info("【日志提醒】用户phone = " + info.getPhone());
            Boolean hasKey = redisTemplate.hasKey(RedisKeySignEnum.signInfo(1002) + info.getUserId());
            logger.info("【日志提醒】phone = " + info.getPhone() + (hasKey ? "存在":"不存在") + "缓存中！");
            if (!hasKey){
                logger.info("【日志提醒】用户不存在缓存中，将用户信息加入需要待插入数据库的数组中！");
                insertUserInfosToUser.add(info);
                logger.info("【日志提醒】成功将用户信息放入数组中！insertUserListInfos = " + insertUserInfosToUser.toString());
            }
        }




        logger.info("【日志提醒】将用户信息存入数据库，并且获取用户信息");
        try {
            logger.info("【日志提醒】开始存入数据库中");
            userMapper.insertUserInfos(insertUserInfosToUser);
        }catch (Exception e){
            logger.info("【日志提醒】用户插入数据库，出现错误");
            // TODO  回滚到没插入前
        }



        // 存入后，根据电话号码查询所有的信息，返回结果集
        logger.info("【日志提醒】成功存入后，根据电话号码查询所有的信息，并返回结果集");
        // insertMemberInfosToMember  insertUserInfosToRedis
        List<User> insertUserInfosToRedis = null;
        try {
            insertUserInfosToRedis = userMapper.selectByPhones(userALLList);
        }catch (Exception e){

            logger.info("【日志提醒】查询数据库失败！返回结果！");

        }



        // 成员列表
        logger.info("【日志提醒】查询数据库成功，新建成员列表!");
        List<Member> insertMemberInfosToMember = new ArrayList<>();
        // 拿到所有信息后，存入缓存
        logger.info("【日志提醒】拿到信息后，存入缓存");
        assert insertUserInfosToRedis != null;
        logger.info("【日志提醒】将成员信息存入缓存中！users = " + insertUserInfosToRedis.toString());
        for (User user :insertUserInfosToRedis){
            redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1002) + user.getUserId()).set(user);
            // 当前写入时间
            long getCurrentTime = System.currentTimeMillis();
            Date date = new Date(getCurrentTime);
            // 循环加入memberList
            insertMemberInfosToMember.add(new Member(user,groupId,date));
        }

        logger.info("【日志提醒】成功存入缓存中！");
        // 存入缓存后，将信息存入成员列表中
        try {
            memberMapper.insertMemberInfos(insertMemberInfosToMember);
        }catch (Exception e){
            // TODO  回滚没插入前
        }


        // 成功后，存入缓存
        redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1003)+groupId).set(insertMemberInfosToMember);


        // 成功存入后，返回结果
        return Result.success(true,200);
    }
    /**
     * 查询群组织所有成员
     * 1. 权限判定
     *  1. 必须是非普通成员方可查询
     * 2. 参数需要查询者权限、群组织id
     * 3. 先查询缓存
     * 4. 缓存不存在，再查询数据库，并将查询结果写入缓存
     * 5. 返回结果
     * */
    @Override
    public Result<List<User>> queryAllGroupMember(String operatorAuthority,Long groupId) {
        // userId 集合
        List<Long> userIds = new ArrayList<>();
        // userList 集合
        List<User> userList = new ArrayList<>();
        logger.info("【日志提醒】进入查询成员查询逻辑！");
        logger.info("【日志提醒】权限判断！！");
        Boolean authorityAuthentication = authority.authorityAuthentication(operatorAuthority);
        if (!authorityAuthentication){
            logger.info("【日志提醒】权限鉴定失败，不能操作！");
            return Result.error(232);
        }

        logger.info("【日志提醒】先判断是否有缓存！");
        Boolean hasKey = false;
        try {
            hasKey = redisTemplate.hasKey(RedisKeySignEnum.signInfo(1003) + groupId);
        }catch (Exception e){
            logger.info("【日志提醒】缓存出现异常！返回错误信息！");
            return Result.error(227);
        }

        if (hasKey)
        {
            logger.info("【日志提醒】缓存存在！");
            logger.info("【日志提醒】开始获取缓存！");
            // 获取成员信息列表中的ids
            JSONArray getMemberInfoJSONObject = JSONArray.parseArray(String.valueOf(redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1003) + groupId).get()));
            logger.info("【日志提醒】成功获取：getMemberInfoJSONObject = " + getMemberInfoJSONObject);
            logger.info("【日志提醒】循环获取uerId");
            for (Object object:getMemberInfoJSONObject){
                Long userId = JSONObject.parseObject(object.toString()).getLong("userId");
                userIds.add(userId);
            }
            logger.info("【日志提醒】userIds = " + userIds);
        }else {
            logger.info("【日志提醒】缓存不存在！");
            // 如果不存在缓存中，则查询数据库，并将查询结果放入缓存中
            MemberExample memberExample = new MemberExample();
            MemberExample.Criteria criteria = memberExample.createCriteria();
            criteria.andGroupIdEqualTo(groupId);
            logger.info("【日志提醒】开始查询数据库！");
            List<Member> memberList = new ArrayList<>();
            try {
                memberList = memberMapper.selectByExample(memberExample);
            }catch (Exception e ){
                logger.info("【日志提醒】数据库查询失败！返回错误信息！");
                return Result.error(221);
            }
            logger.info("【日志提醒】查询结果：memberList = " + memberList);
            logger.info("【日志提醒】将查询结果放入缓存中！");
            // 将结果放入缓存
            try {
                redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1003)+groupId).set(memberList);
            }catch (Exception e){
                logger.info("【日志提醒】放入缓存失败！");
                return Result.error(227);
            }
            logger.info("【日志提醒】成功放入缓存！");
            logger.info("【日志提醒】开始获取userId！");
            // 获取userId
            for (Member member: memberList){
                userIds.add(member.getUserId());
            }
            logger.info("【日志提醒】userIds = " + userIds);
        }
        // 根据ids进行缓存查询
        logger.info("【日志提醒】根据ids进行缓存查询！");
        for (Long userId:userIds){
            logger.info("【日志提醒】缓存查询是否存在！");
            Boolean hasUser = redisTemplate.hasKey(RedisKeySignEnum.signInfo(1002) + userId);
            if (hasUser){
                logger.info("【日志提醒】缓存查询存在！");
                logger.info("【日志提醒】获取用户信息！");
                JSONObject userObject = JSONObject.parseObject(String.valueOf(redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1002) + userId).get()));
                logger.info("【日志提醒】获取用户信息：userObject = " + userObject);
                User user = new User(userObject);
                logger.info("【日志提醒】写入userList中！");
                userList.add(user);
            }else {
                logger.info("【日志提醒】缓存查询不存在！");
                try {
                    logger.info("【日志提醒】开始数据库查询！");
                    User user = userMapper.selectByPrimaryKey(userId);
                    logger.info("【日志提醒】成功查询：user = " + user.toString());
                    logger.info("【日志提醒】写入userList中去！");
                    userList.add(user);
                    try {
                        logger.info("【日志提醒】将数据库查询的数据存入缓存中！");
                        redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1002) + user.getUserId()).set(user);
                        logger.info("【日志提醒】缓存成功！");
                    }catch (Exception e){
                        logger.info("【日志提醒】缓存失败！");
                    }
                }catch (Exception e){
                    logger.info("【日志提醒】数据库查询失败，但是继续，不影响！");
                }
            }
        }
        logger.info("【日志提醒】成功查询！");
        return Result.success(userList,200);
    }


    /**
     * 通过手机号查询群组织成员
     *
     *
     *
     * 1. 权限判定，必须是组织者身份
     * 2. 查询缓存中是否有此成员存在
     * 3. 缓存中如果没有，则查询数据库中是否存在
     * 4. 返回查询结果
     *
     * 成员必须是存在群组织中的方可进行查询，否则不行
     * 通过手机号查询，必须满足是组织者或者企业者，必须满足当前群组织内成员。
     * 
     *
     * */
    @Override
    public Result<User> queryGroupUserInfoByPhone(Long userId,String phoneNumber, Long groupId) {
        logger.info("【日志提醒】通过手机号查询群组织成员！");
        logger.info("【日志提醒】查询缓存中当前群组织信息！");
        logger.info("【日志题型】查看是否存在此群缓存信息！");
        Boolean hasGroupMember = redisTemplate.hasKey(RedisKeySignEnum.signInfo(1004)+groupId);
        if(!hasGroupMember){
            // 如果缓存中不存在，则进行数据库查询
            logger.info("【日志提醒】缓存不存在，开始进行数据库查询！");
            Group groupInfo = groupMapper.select(groupId);
            // 将获取到的数据库信息存入缓存
            redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1004)+groupId).set(groupInfo);
        }
        // 缓存中存在，则不需要进行数据库查询，直接下一步
        // 从缓存中获取group数据
        JSONObject groupObject = JSONObject.parseObject(String.valueOf(redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1004) + groupId).get()));
        // 将数据转为模型
        Group group = new Group(groupObject);
        // 判断数据模型中的userId与传入userId是否一致
        if (userId.equals(group.getUserId())){
            // 权限判定成功，是群组织者进行操作
            // 判断是否存在此号码在缓存中
            Boolean hasGroupKey = redisTemplate.hasKey(RedisKeySignEnum.signInfo(1005) + phoneNumber);
            if(hasGroupKey){
                // 电话号码存在缓存中
                // 获取缓存中的信息
                Long selectUserId = Long.parseLong(String.valueOf(redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1005) + phoneNumber).get()));
                // 获取缓存中查询的用户信息是否存在
                Boolean hasSelectUserId = redisTemplate.hasKey(RedisKeySignEnum.signInfo(1002) + selectUserId);
               
                if(hasSelectUserId){
                    // 用户信息存在
                    try {
                        // 获取用户
                        JSONObject userObject = JSONObject.parseObject(String.valueOf(redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1002) + selectUserId).get()));
                        // TODO 用户信息转为模型   此处不对头，需要判断用户是否存在群组织中
                        User user = new User(userObject);
                        return Result.success(user,200);
                    }catch (Exception e){
                        System.out.println("缓存获取失败！");
                        return Result.error(227);
                    }
                }else {
                    try {
                        User user = userMapper.selectByPrimaryKey(selectUserId);
                        try {
                            redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1002)+selectUserId).set(user);
                        }catch (Exception e){
                            System.out.println("缓存失败！");
                        }
                        return Result.success(user,200);
                    }catch (Exception e){
                        return Result.error(221);
                    }
                }
            }else {
                // 用户未缓存


            }
        }

        return null;
    }
    /**
    * 根据手机号码获取用户信息
    * 此逻辑主要用于
    * 1. 
    */
    @Override
    public Result<User> queryUserInfoByPhone(String phoneNumber) {
        return null;
    }
}
