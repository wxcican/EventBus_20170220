package com.fuicuiedu.xc.eventbus_20170220;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class MessageEvent {

    private String message;

    public MessageEvent(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
