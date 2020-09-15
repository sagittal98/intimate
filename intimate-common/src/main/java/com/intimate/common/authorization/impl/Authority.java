package com.intimate.common.authorization.impl;

import com.intimate.common.authorization.IAuthority;

public class Authority implements IAuthority {
    /**
     * 权限开放接口
     * @param operatorAuthority  管理者
     * @param userAuthority  被管理者
     * @return  返回结果  可以与否
     */
    @Override
    public Boolean isOpenAuthority(String operatorAuthority, String userAuthority) {

        return null;
    }
}
