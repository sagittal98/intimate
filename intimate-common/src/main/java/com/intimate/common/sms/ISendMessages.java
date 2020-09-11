package com.intimate.common.sms;

import com.intimate.common.model.SMSInfoModel;
import com.intimate.common.sms.impl.SendMessages;

public interface ISendMessages {
    // 发送短信是否成功
    boolean  sendVerifyCode(SMSInfoModel smsInfoModel);

    public static void main(String[] args) {
       ISendMessages iSendMessages  = new SendMessages();
        SMSInfoModel smsInfoModel = new SMSInfoModel();
        smsInfoModel.setMinute("1");
        smsInfoModel.setCode("9956");
        smsInfoModel.setPhone("17364831501");
        smsInfoModel.setType(24405);
        boolean result = iSendMessages.sendVerifyCode(smsInfoModel);
        System.out.println(result);
    }


}


