package com.intimate.common.authorization.impl;

import com.intimate.common.authorization.IAuthority;


/**
 * 权限由三个数字组成三位数 第一位数是用户类型 第二位数是用户权限 第三位数是用户等级
 *
 * 用户类型：0（管理员）、1（企业者）、2（临时企业者）、3（组织者）、4（临时组织者）、5（普通用户）
 *
 * 用户权限：0（管理权限）、1（企业者权限）、2（临时企业者权限）、3（组织者权限）、4（临时组织者权限）、5（普通用户权限）
 *
 * 用户等级：0（普通）、1（VIP）、2（SVIP）、3（最高管理权限）
 *
 * 普通用户：550
 * vip用户：551
 * SVIP用户：552
 *
 * 临时组织者：440
 *
 * 组织者：330
 * vip组织者：331
 * SVIP组织者：332
 *
 * 临时企业者：220
 *
 * 企业者：110
 * vip企业者：111
 * SVIP企业者：112
 *
 * 普通管理员：000
 * 中级管理员：001
 * 高级管理员：002
 * 最高管理员：003
 */

public class AuthorityImpl implements IAuthority {
    /**
     * 权限开放接口
     * @param operatorAuthority  操作者的权限
     * @param userAuthority  被操作者的权限
     * @return  返回结果  可以与否
     */
    @Override
    public Boolean isOpenAuthority(String operatorAuthority, String userAuthority) {
        // 读取operatorAuthority第一位数与userAuthority第一位数比较，如果相等或者大于则true，否则false
        return Integer.parseInt(operatorAuthority.substring(0,1)) <= Integer.parseInt(userAuthority.substring(0,1));
    }



    /**
     * 权限鉴别——————批量录入用户信息 企业者、组织者、管理员
     */
    @Override
    public Boolean authorityAuthentication(String operatorAuthority) {
        // 批量录入用户信息都可以操作
        return Integer.parseInt(operatorAuthority.substring(0,1)) < 5;
    }

}
