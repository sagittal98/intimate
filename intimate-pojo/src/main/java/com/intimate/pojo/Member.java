package com.intimate.pojo;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    // 成员id
    private Long memberId;
    // 组织id
    private Long groupId;
    // 用户id
    private Long userId;
    // 用户添加时间
    private Date userCreateData;

    public Member() {
    }

    public Member(User user, Long groupId, Date userCreateData) {
        this.groupId = groupId;
        this.userId = user.getUserId();
        this.userCreateData = userCreateData;
    }

    private static final long serialVersionUID = 1L;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getUserCreateData() {
        return userCreateData;
    }

    public void setUserCreateData(Date userCreateData) {
        this.userCreateData = userCreateData;
    }
}