package com.intimate.user.service;

import com.intimate.common.model.Result;
import com.intimate.pojo.User;

import java.util.List;

public interface IUserService {
    /**
     * 用户账户操作：
     * 1. 修改账户信息
     * 2. 修改账户权限
     * 3. 批量添加账户信息
     * 4. 查找所有群成员
     * 5. 查找群成员  通过手机号码查询
     * 6. 查找用户
     */


    /**
     *  修改账户信息
     *    修改返回成功或失败，成功则前端自行修改，失败则失败
     * @param user  传入用户需要修改的数据
     * @return 返回结果成功或失败
     */
    Result<Boolean> updateUserInfo(String operatorAuthority,User user);


    /**
     * 修改账户权限
     *       修改有条件，必须是组织者或企业者才能修改
     *          必须是有群组织，必须是对成员进行提升权限
     *
     * @return  返回结果成功与否
     */
    Result<Boolean> updateUserAuthorization(String operatorAuthority,User user);

    /**
     * 添加大量用户信息
     * @param userList  用户信息清单
     * @param groupId 组织id
     * @param operatorAuthority 组织者权限
     * @return 返回成功与否
     * 1. 批量添加组员，首先必须是组织者或者企业者或者是管理员  且有组织群
     *  2. 先添加到用户数据库
     *    3. 再添加到缓存
     *      4. 然后添加到成员数据库
     */
    Result<Boolean> addALotOfUserInfo(List<User> userList,Long groupId,String operatorAuthority);

    /**
     * 查询所有群成员
     * @return  返回成员列表
     */
    Result<List<User>> queryAllGroupMember(String operatorAuthority,Long groupId);

    /**
     * 通过手机号码查询群成员  实际是手机号+群id
     * 通过手机号码查询到用户id   在判断用户id是否在群成员里面
     * 如果在里面 则返回用户信息，如果不在则返回空
     * @param phoneNumber  手机号码
     * @return  返回用户信息
     */
    Result<User> queryGroupUserInfoByPhone(Long userId,String phoneNumber,Long groupId);

    /**
     * 查找用户
     * @return  返回用户信息
     */
    Result<User> queryUserInfoByPhone(String phoneNumber);

}
