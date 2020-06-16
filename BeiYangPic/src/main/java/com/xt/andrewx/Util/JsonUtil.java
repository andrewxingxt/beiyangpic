package com.xt.andrewx.Util;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class JsonUtil {

    public static Map J2Map(String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        Map<String, String> dataMap =  jsonObject.toJavaObject(Map.class);

        return dataMap;
    }

    public static Map J2MapObject(String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        Map<String, JSONObject> dataMap =  jsonObject.toJavaObject(Map.class);

        return dataMap;
    }
}
