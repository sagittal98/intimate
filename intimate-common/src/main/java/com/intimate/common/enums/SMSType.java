package com.intimate.common.enums;

public enum SMSType {

    REGISTER(20876,"register"),LOGIN(24405,"login"),NOTICE(30693,"notice");
    private int state;
    private String stateInfo;
    SMSType(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SMSType stateOf(int number){
        for (SMSType smsType : values()){
            if (smsType.getState() == number){
                return smsType;
            }
        }
        return null;
    }
}
