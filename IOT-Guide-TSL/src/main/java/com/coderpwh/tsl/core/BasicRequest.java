package com.coderpwh.tsl.core;

/**
 * @author coderpwh
 */
public class BasicRequest {


    public static final Integer DEFAULT_REQUEST_ID = 0;

    private final Integer requestId;

    public BasicRequest(Integer requestId){
        this.requestId = requestId;
    }

    public Integer getRequestId() {
        return requestId;
    }
}
