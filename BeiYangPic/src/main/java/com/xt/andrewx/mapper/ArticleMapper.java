package com.xt.andrewx.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    void addNewPicArticle(String id,String user_id,String title,String release_date,String content,int pic_count,int typeof);
    void addArticlePic(String article_id,int pic_num,String pic_addr);
}
