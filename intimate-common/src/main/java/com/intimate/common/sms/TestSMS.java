package com.intimate.common.sms;

import com.intimate.common.enums.SMSType;

import java.util.Objects;


public class TestSMS {
    public static void main(String[] args) {
        String smsType = Objects.requireNonNull(SMSType.stateOf(20876)).getStateInfo();
        System.out.println(smsType);
    }
}
