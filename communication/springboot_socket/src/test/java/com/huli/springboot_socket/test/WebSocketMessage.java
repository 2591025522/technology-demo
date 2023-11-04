package com.huli.springboot_socket.test;

import com.alibaba.fastjson2.JSONObject;


public class WebSocketMessage {
    public String api;
    public int status;
    public String data;
    public Long logId=0l;
    public WebSocketMessage(){
        
    }
    public static WebSocketMessage create(String api,int status,Long logId,String data){
        WebSocketMessage webSocketMessage =new WebSocketMessage();
        webSocketMessage.api=api;
        webSocketMessage.status=status;
        webSocketMessage.logId=logId;
        webSocketMessage.data=data;
        return webSocketMessage;
    }
    public static WebSocketMessage create(String message){
        //return JSONObject.parseObject(message, WebSocketMessage.class);
        JSONObject jsonObject = JSONObject.parseObject(message);
        WebSocketMessage webSocketMessage =new WebSocketMessage();
        webSocketMessage.api = jsonObject.getString("api");
        webSocketMessage.status = jsonObject.getIntValue("status");
        webSocketMessage.data = jsonObject.getString("data");
        if(jsonObject.containsKey("logId"))
            webSocketMessage.logId = jsonObject.getLong("logId");
        return webSocketMessage;
    }

    public static WebSocketMessage create(String api,int statue,String data,Long logId){
        WebSocketMessage webSocketMessage =new WebSocketMessage();
        webSocketMessage.api=api;
        webSocketMessage.status=statue;
        webSocketMessage.data=data;
        webSocketMessage.logId=logId;
        return webSocketMessage;
    }
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
