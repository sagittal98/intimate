package com.intimate.common.authorization;


/**
 * 权限判定
 */
public interface IAuthority {

    /**
     * 是否能进行权限操作
     */
    Boolean isOpenAuthority(String operatorAuthority,String userAuthority);



}
