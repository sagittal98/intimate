package com.intimate.register.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.intimate.common.model.Result;
import com.intimate.common.model.SMSInfoModel;
import com.intimate.common.model.UserInfo;
import com.intimate.common.sms.ISendMessages;
import com.intimate.common.sms.impl.SendMessages;
import com.intimate.common.token.JwtUtils;
import com.intimate.dao.UserMapper;
import com.intimate.pojo.User;
import com.intimate.register.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 手机号码注册
     * @param smsInfoModel  用户注册信息
     * @return 返回参数
     */
    public Result<String> phoneRegister(SMSInfoModel smsInfoModel) {
        // 2. 短信验证码是否验证成功
        if (smsInfoModel.isVerifyCode()){  // 已经成功验证
            // 3. 写入数据库
            User user = new User();
            // 手机号
            user.setPhone(smsInfoModel.getPhone());
            // 密码
            user.setPassword(smsInfoModel.getPassword());
            // 是否检查手机号
            user.setIsPhoneCheck(smsInfoModel.isCheckPhoneNumber());
            long getCurrentTime = System.currentTimeMillis();
            Date date = new Date(getCurrentTime);
            // 注册日期
            user.setRegisterDate(date);
            // 用户权限级别  默认550
            user.setAuthorityLevel("550");
            // 最后登录时间
            user.setLastLoginTime(date);
            // 插入数据库
            try {
                userMapper.insert(user);
            }catch (Exception e){
                System.out.println(e.getMessage());
                // 插入失败
                return Result.error(217);
            }
            // 生成token
            UserInfo userInfo = new UserInfo();
            userInfo.setAuthorityLevel(user.getAuthorityLevel());
            userInfo.setOpenID(user.getOpenid());
            userInfo.setPhone(user.getPhone());
            // 有效期限6个月
            long ttlMillis = 6 * 30 * 24 * 60 * 60 * 1000L;
            // 唯一标识
            String jti = "hydrogen_honey" ;
            // 生成token
            String token = JwtUtils.createJWT(jti, userInfo.toString(), ttlMillis);
            // 4. 返回结果
            return Result.success(token,216);
        }else {
            return Result.error(215);
        }
    }

    /**
     * 发送短信验证码
     */
    public Result<SMSInfoModel> sendPhoneVerify(SMSInfoModel smsInfoModel) {
        // 短信接口使用
        ISendMessages sendMessages = new SendMessages();
        boolean isSuccess = sendMessages.sendVerifyCode(smsInfoModel);
        if (isSuccess){
            return Result.success(smsInfoModel,213);
        }else {
            return Result.error(214);
        }
    }

    /**
     * 验证手机号码是否存在
     */
    public Result<SMSInfoModel> phoneIsExist(String phoneNumber){
        SMSInfoModel smsInfoModel = new SMSInfoModel();
        smsInfoModel.setPhone(phoneNumber);
        // 1. 通过手机号码查询  返回结果
        int count = userMapper.checkPhone(phoneNumber);
        if (count != 0 ){
            return Result.error(211);
        }else {
            smsInfoModel.setCheckPhoneNumber(true);
            return Result.success(smsInfoModel,212);
        }
    }

}
