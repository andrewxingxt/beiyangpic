package com.xt.andrewx.Util;

public class CheckNullUtil {
    public static boolean checkNull(String[] datas){
        for(String data : datas){
            if(data == null || data == ""){
                return true;
            }
        }
        return false;
    }
}
