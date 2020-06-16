package com.xt.andrewx.controller;


import com.alibaba.fastjson.JSONObject;
import com.xt.andrewx.Annotation.UserLoginToken;
import com.xt.andrewx.Util.CheckNullUtil;
import com.xt.andrewx.Util.GetCurrentTime;
import com.xt.andrewx.Util.JsonUtil;
import com.xt.andrewx.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.UUID;

import static com.xt.andrewx.Util.ArticleErrorCode.*;
import static com.xt.andrewx.Util.ErrorCodeUtil.CONTENT_NULL;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("addNewPicArticle")
    @ResponseBody
    @UserLoginToken
    public Map addNewPicArticle(@RequestBody String data){

        String title,user_id,content;
        int type = 0,pic_count = -1;

        Map<String, Object> dataMap = JsonUtil.J2Map(data);

        title = dataMap.get("title").toString();
        user_id = dataMap.get("user_id").toString();
        content = dataMap.get("content").toString();
        pic_count = Integer.parseInt(dataMap.get("pic_count").toString());

        if(CheckNullUtil.checkNull(new String[]{title,user_id,content}) || pic_count == -1){
            return  CONTENT_NULL();
        }

        String id = UUID.randomUUID().toString();
        String currentTime = GetCurrentTime.currentTimeOnDay();


        Map<String,JSONObject> dataObject = JsonUtil.J2MapObject(data);
        JSONObject pics1 = dataObject.get("pics");
        String ps = pics1.toString();

        if(CheckNullUtil.checkNull(new String[]{ps})){
            return CONTENT_NULL();
        }

        Map<Integer,String> pics = JsonUtil.J2Map(ps);

        try{
            articleService.addNewPicArticle(id,user_id,title,currentTime,content,pic_count,type,pic_count,pics);
        }catch(Exception e){
            e.printStackTrace();
            return DATABASE_ERROR();
        }
        return ARTICLE_ADD_SUCCESS();
    }

    @PostMapping("getAllArticleList")
    @UserLoginToken
    @ResponseBody
    public Map getAllArticleList(@RequestBody String data){

        return null;
    }
}
