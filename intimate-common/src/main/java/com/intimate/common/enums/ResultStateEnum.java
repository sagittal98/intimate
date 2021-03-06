package com.intimate.common.enums;


/**
 * 返回状态说明
 */
public enum ResultStateEnum {
    // 请求成功
    SUCCESS(200,"The request is successful!"),
    // 请求失败
    FAIL(201,"The request failed!"),
    // 数据库连接失败
    DATABASE_CONNECTION_FAILED(202,"Database connection failed!"),
    // 内存溢出
    MEMORY_OVERFLOW(203,"memory overflow"),
    // 无效请求参数
    REQUEST_PARAMETER_ILLEGAL(204,"The request parameter is not valid!"),
    // 请求参数为空
    REQUEST_PARAMETER_ISNULL(205,"The request parameter is null!"),
    // 服务器拒绝请求
    SERVER_REJECTS_REQUEST(206,"Server rejects request!"),
    // 请求超时
    REQUEST_TIMEOUT(207,"The request timeout!"),
    // 服务器错误
    SERVER_INTERNAL_ERROR(208,"Server internal error!"),
    // token 过期
    JWT_ERROR_CODE_EXPIRE(209,"jwt expire!"),
    // token生成失败
    JWT_ERROR_CODE_FAIL(210,"jwt fail!"),
    // 手机号存在，不可以注册
    REGISTER_ERROR_PHONE_IS_EXIST(211,"Phone is exist!"),
    // 手机号不存在，可以注册
    REGISTER_PHONE_IS_EMPTY(212,"Phone is empty! You can register!"),
    // 验证码发送成功
    SMS_SENT_SUCCESSFULLY(213,"SMS sent successfully!"),
    // 验证码发送失败
    SMS_SENT_FAILED(214,"SMS sent failed!"),
    // 验证码未检查
    SMS_CODE_ERROR(215,"SMS verify code is not successfully!"),
    // 注册成功
    REGISTER_SUCCESSFULLY(216,"Register is successfully!"),
    // 数据库插入失败
    SQL_INSERT_FAILED(217,"SQL insert is failed!"),
    // 可以登录
    CAN_LOGIN(218,"You can log in this system!"),
    // 需要注册
    NEED_REGISTER(219,"You need log on this system!"),
    // 登录成功
    LOGIN_SUCCESSFULLY(220,"Welcome to the System of Hydrogen Honey!"),
    // 数据库查询失败
    SQL_SELECT_FAILED(221,"SQL select failed!"),
    // token 更新成功
    TOKEN_SUCCESSFULLY(222,"Update token successfully!"),
    // 数据库修改成功
    SQL_UPDATE_SUCCESSFULLY(223,"Update SQL successfully!"),
    // 数据库修改失败
    SQL_UPDATE_FAILED(224,"Update SQL failed!"),
    // 手机号码不正确
    PHONE_IS_NOT_COMPLETE(225,"Phone is not complete!"),
    // 邮箱不正确
    EMAIL_IS_NOT_COMPLETE(226,"Email is not complete!"),
    // redis缓存失败
    REDIS_SAVE_FAILED(227,"Redis save failed!"),
    // redis缓存key值为空
    REDIS_SAVE_KEY_IS_NULL(228,"Redis save key is null!"),
    // 微信授权获取openid失败
    WE_CHAT_AUTHORITY_OPENID_FAILED(229,"We chat authority is no successfully!"),
    // 微信授权获取用户信息失败
    WE_CHAT_AUTHORITY_USER_FAILED(230,"We chat authority get user info is failed!"),
    // 微信授权信息成功
    WE_CHAT_AUTHORITY_USER_SUCCESSFULLY(231,"We chat authority get user info is successfully!"),
    // 操作者权限不够
    OPERATOR_AUTHORITY_IS_NOT_ENOUGH(232," Operator's authority is not enough!"),
    // 权限提升成功
    PRIVILEGE_PROMOTION_SUCCEEDED(233,"Privilege promotion succeeded!")





    ;

    public static final char[] JWT_SECRET = "hydrogen_honey".toCharArray();
    private int state;
    private String stateInfo;

    ResultStateEnum(int state,String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ResultStateEnum stateOf(int index) {
        for (ResultStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

    // 根据代号返回信息
    public static String stateInfo(int code){
        for (ResultStateEnum state : values()){
            if (state.getState() == code){
                return state.stateInfo;
            }
        }
        return null;
    }
}
