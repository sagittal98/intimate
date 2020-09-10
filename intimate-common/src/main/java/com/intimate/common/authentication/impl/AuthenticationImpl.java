package com.intimate.common.authentication.impl;

import com.intimate.common.authentication.Authentication;
import com.intimate.common.model.IDCardInfoModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AuthenticationImpl implements Authentication {
    /**
     * 读取身份证信息
     * @return 返回身份证信息
     */
    @Override
    public IDCardInfoModel readIDCardInfo(String IDNumber) {
        IDCardInfoModel idCardInfoModel = new IDCardInfoModel();
        // 身份证号码
        idCardInfoModel.setIDNumber(IDNumber);
        // 身份证地址代号
        idCardInfoModel.setIDAddressCode(Integer.valueOf(IDNumber.substring(0,6)));
        // 现将一连串数字转换成日期
        String birthNumber = IDNumber.substring(6,14);
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
        // 再将日期转换成需要的格式
        SimpleDateFormat birthDate = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = new Date() ;
        try {
            parse = yyyyMMdd.parse(birthNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 出生
        idCardInfoModel.setIDBirth(birthDate.format(parse));
        // 性别
        idCardInfoModel.setIDSex(Integer.parseInt(IDNumber.substring(16,17))%2);
        // 年龄
        idCardInfoModel.setIDAge(Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()))-  Integer.parseInt(IDNumber.substring(6,10)));

        return idCardInfoModel;
    }


    // coefficient constant  系数常量集合
    final private static int[] COEFFICIENT_SET = new int[]{7 ,9 ,10 ,5 ,8 ,4 ,2 ,1 ,6 ,3 ,7 ,9 ,10, 5 ,8, 4 ,2};
    // remainder constant 余数常量集合
    final private static char[] REMAINDER_SET = new char[]{'1','0','X','9','8','7','6','5','4','3','2'};
    /**
     * 验证身份证真假
     * @return 返回真假
     */
    @Override
    public boolean verifyIDCard(String IDNumber) {
        // ID card verification code.
        char idCardCheckCode = IDNumber.charAt(17);
        if (IDNumber.length() == 18){
            // product sum
            int idCardSum = 0;
            // remainder
            int remainder;
            for (int i = 0 ; i < IDNumber.length() -1 ; i ++ ){
                idCardSum += Integer.parseInt(String.valueOf(IDNumber.charAt(i))) * COEFFICIENT_SET[i];
            }
            remainder = idCardSum % 11 ;
            // get result TRUE or FALSE.
            return idCardCheckCode == REMAINDER_SET[remainder];
        }else {
            // if there are no 18 digits in the ID card number, it is a fake ID card number.
            return false;
        }
    }
}
