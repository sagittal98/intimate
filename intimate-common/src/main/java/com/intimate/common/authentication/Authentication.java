package com.intimate.common.authentication;

import com.intimate.common.authentication.impl.AuthenticationImpl;
import com.intimate.common.model.IDCardInfoModel;

import java.util.List;

public interface Authentication {

    // 读取身份证信息
    public IDCardInfoModel readIDCardInfo(String IDNumber);

    // 验证身份证真假
    public boolean verifyIDCard(String IDNumber);

    /**
     * 使用方法
     * @param args  使用方法
     */
    public static void main(String[] args) {
        Authentication authentication = new AuthenticationImpl();
        boolean result = authentication.verifyIDCard("511902199609132913");
        IDCardInfoModel idCardInfoModel = authentication.readIDCardInfo("511902199609132913");
        System.out.println(result);
        System.out.println(idCardInfoModel.toString());
    }
}



