package com.intimate.common.enums;


/**
 * 返回状态说明
 */
public enum ResultStateEnum {

    SUCCESS(200,"The request is successful!"),
    FAIL(201,"The request failed!"),
    DATABASE_CONNECTION_FAILED(202,"Database connection failed!"),
    MEMORY_OVERFLOW(203,"memory overflow"),
    REQUEST_PARAMETER_ILLEGAL(204,"The request parameter is not valid!"),
    REQUEST_PARAMETER_ISNULL(205,"The request parameter is null!"),
    SERVER_REJECTS_REQUEST(206,"Server rejects request!"),
    REQUEST_TIMEOUT(207,"The request timeout!"),
    SERVER_INTERNAL_ERROR(208,"Server internal error!");

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

}
