package com.xt.andrewx.service;

import java.util.Map;

public interface ArticleService {
    void addNewPicArticle(String id,String user_id,String title,String release_date,String  content,int pic_count,int typeof,int pic_num, Map<Integer,String> pic_addr);
    //void addNewPicArticle(String id,String user_id,String title,String release_date,String  content,int pic_count,int typeof);
    //void addArticleExtraInfo(String article_id, int pic_num, Map<Integer,String> pic_addr);
}
