package com.xt.andrewx.Util;

import java.util.HashMap;
import java.util.Map;

public class ArticleErrorCode {
    /**
     *数据库错误
     * */
    public static Map DATABASE_ERROR(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",411);
        Code_Mess.put("message","数据库错误");
        return Code_Mess;
    }
    /**
     *文章写入成功
     * */
    public static Map ARTICLE_ADD_SUCCESS(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",412);
        Code_Mess.put("message","文章写入成功");
        return Code_Mess;
    }
}
