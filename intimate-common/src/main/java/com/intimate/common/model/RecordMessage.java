package com.intimate.common.model;

import java.io.Serializable;



public class RecordMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 请求的方法
     */
    private String method;

    /**
     * 请求方法所在的对象
     */
    private String targetObject;

    /**
     * 请求参数
     */
    private String requestParames;

    /**
     * 请求时间
     */
    private String requestTime;

    /**
     * 响应时间
     */
    private String responseTime;

    /**
     * 响应参数
     */
    private String responseParames;

    /**
     * 请求的来源IP
     */
    private String requestIp;

    /**
     * 方法执行的耗时,毫秒
     */
    private long costTime;

    /**
     * 请求的方法
     */
    public String getMethod()
    {
        return method;
    }

    /**
     * 请求的方法
     */
    public void setMethod(String method)
    {
        this.method = method;
    }

    /**
     * 请求方法所在的对象
     */
    public String getTargetObject()
    {
        return targetObject;
    }

    /**
     * 请求方法所在的对象
     */
    public void setTargetObject(String targetObject)
    {
        this.targetObject = targetObject;
    }

    /**
     * 请求参数
     */
    public String getRequestParames()
    {
        return requestParames;
    }

    /**
     * 请求参数
     */
    public void setRequestParames(String requestParames)
    {
        this.requestParames = requestParames;
    }

    /**
     * 请求时间
     */
    public String getRequestTime()
    {
        return requestTime;
    }

    /**
     * 请求时间
     */
    public void setRequestTime(String requestTime)
    {
        this.requestTime = requestTime;
    }

    /**
     * 响应时间
     */
    public String getResponseTime()
    {
        return responseTime;
    }

    /**
     * 响应时间
     */
    public void setResponseTime(String responseTime)
    {
        this.responseTime = responseTime;
    }

    /**
     * 响应参数
     */
    public String getResponseParames()
    {
        return responseParames;
    }

    /**
     * 响应参数
     */
    public void setResponseParames(String responseParames)
    {
        this.responseParames = responseParames;
    }

    /**
     * 请求的来源IP
     */
    public String getRequestIp()
    {
        return requestIp;
    }

    /**
     * 请求的来源IP
     */
    public void setRequestIp(String requestIp)
    {
        this.requestIp = requestIp;
    }

    /**
     * 方法执行的耗时,毫秒
     */
    public long getCostTime()
    {
        return costTime;
    }

    /**
     * 方法执行的耗时,毫秒
     */
    public void setCostTime(long costTime)
    {
        this.costTime = costTime;
    }

    /**
     * toString
     * @return String String

     */
    @Override
    public String toString()
    {

        return "method=" + method +
                ", targetObject=" + targetObject +
                ", requestParames=" + requestParames +
                ", requestTime=" + requestTime +
                ", responseTime=" + responseTime +
                ", responseParames=" + responseParames +
                ", requestIp=" + requestIp +
                ", costTime=" + costTime;
    }

}
