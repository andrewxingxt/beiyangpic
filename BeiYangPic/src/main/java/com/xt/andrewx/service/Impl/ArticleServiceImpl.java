package com.xt.andrewx.service.Impl;

import com.xt.andrewx.Exceptions.AddErrorException;
import com.xt.andrewx.mapper.ArticleMapper;
import com.xt.andrewx.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addNewPicArticle(String id, String user_id,
                                 String title, String release_date, String content,
                                 int pic_count, int typeof, int pic_num, Map<Integer, String> pic_addr) {
        try{
            articleMapper.addNewPicArticle(id,user_id, title, release_date, content, pic_count, typeof);
            for(int i = 1;i<=pic_num;i++){
                articleMapper.addArticlePic(id, i, pic_addr.get(i));
            }
        }catch (Exception e){
            throw e;
        }

    }

}
