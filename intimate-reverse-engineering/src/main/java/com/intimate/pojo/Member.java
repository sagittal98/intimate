package com.intimate.pojo;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    private Long memberId;

    private Long groupId;

    private Long userId;

    private Date userCreateData;

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