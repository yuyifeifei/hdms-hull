package com.sws.hdmshull.exception;

import com.sws.hdmshull.pojo.APIResponse;

public class MessageCenterException extends RuntimeException {

    public MessageCenterException(APIResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    private APIResponse apiResponse;


    public APIResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(APIResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
}
