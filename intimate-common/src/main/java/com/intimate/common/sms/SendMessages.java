package com.intimate.common.sms;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.sms.SmsClient;
import com.baidubce.services.sms.SmsClientConfiguration;
import com.baidubce.services.sms.model.SendMessageV3Request;
import com.baidubce.services.sms.model.SendMessageV3Response;
import com.intimate.common.model.SMSInfoModel;

import java.util.HashMap;
import java.util.Map;

public class SendMessages {

//    key
    private final String ACCESS_KEY_ID = "3f7678de978e4cee857e695fca42054b";
//    密匙
    private final String SECRET_ACCESS_KEY = "0c659c8e697e463db66d91226be89e49";
//    域名
    private final String ENDPOINT = "http://smsv3.bj.baidubce.com";
    //    注册模板ID
    private final String REGISTER_TEMPLATE_ID = "sms-tmpl-tBQalx18874";
    //    登录模板ID
    private final String LOGIN_TEMPLATE_ID = "sms-tmpl-AcQYaJ98769";
    //    通知模板ID
    private final String NOTICE_TEMPLATE_ID = "null";
    //    签名ID
    private final String SIGNATURE_ID = "sms-sign-zecwFc68161";

    // 注册/登录/通知  20876/24405/30693

    public boolean sendVerifyCode(SMSInfoModel smsInfoModel){
        // 创建SmsClientConfiguration实例
        SmsClientConfiguration config = new SmsClientConfiguration();
        // 配置代理为本地8090端口
//        config.setProxyHost("180.76.106.21");
//        config.setProxyPort(8090);
        // 设置HTTP最大连接数为10
        config.setMaxConnections(10);
        // 设置TCP连接超时为5000毫秒
        config.setConnectionTimeoutInMillis(5000);
        // 设置最大的重试次数为3
        config.setMaxConnections(3);
        // 设置Socket传输数据超时的时间为2000毫秒
        config.setSocketTimeoutInMillis(2000);


        // 创建SMS客户端
        config.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID,SECRET_ACCESS_KEY));
        // 域名
        config.setEndpoint(ENDPOINT);
        SmsClient client = new SmsClient(config);

        // 创建模板变量信息
        Map<String, String> contentVar = new HashMap<>();
//        验证码
        contentVar.put("code", smsInfoModel.getCode());
//        有效期
        contentVar.put("minute",smsInfoModel.getType() == 30693 ? null : smsInfoModel.getMinute());

//        请求设置
        SendMessageV3Request request = new SendMessageV3Request();
//        发送对象
        request.setMobile(smsInfoModel.getPhone());
//        签名模板
        request.setSignatureId(SIGNATURE_ID);
//        注册模板
        request.setTemplate(smsInfoModel.getType() == 20876 ? REGISTER_TEMPLATE_ID : (smsInfoModel.getType() == 24405 ? LOGIN_TEMPLATE_ID : NOTICE_TEMPLATE_ID));
//        放进请求容器
        request.setContentVar(contentVar);
//        发送短信
        SendMessageV3Response response = client.sendMessage(request);
//        结果响应
        return response != null && response.isSuccess();
    }



}
