package com.xt.andrewx.service.Impl;

import com.alibaba.fastjson.JSON;
import com.xt.andrewx.verifyCodeUtil.CheckSumBuilder;
import com.xt.andrewx.service.VerifyCodeService;
import com.xt.andrewx.verifyCodeUtil.CodeJson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;

@Service("VerifyCodeService")
public class VerifyCodeServiceImpl implements VerifyCodeService {

    private static final String
            SERVER_URL="https://api.netease.im/sms/sendcode.action";

    private static final String
            APP_KEY="620ff93a4b8975e8ccdd2c06fbdc362f";

    private static final String APP_SECRET="7393ab8b9dba";

    private static final String NONCE="123456";

    //短信模板ID
    private static final String TEMPLATEID="14872180";

    //验证码长度，范围4～10，默认为4
    private static final String CODELEN="6";


    @Override
    public CodeJson SendVerifyCode(String MOBILE) {
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();


        String curTime = String.valueOf((new Date()).getTime() / 1000L);

        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

        headers.add("AppKey", APP_KEY);
        headers.add("Nonce", NONCE);
        headers.add("CurTime", curTime);
        headers.add("CheckSum", checkSum);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");


        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();

        map.add("templateid", TEMPLATEID);
        map.add("mobile", MOBILE);
        map.add("codeLen", CODELEN);

        HttpEntity<Map> request = new HttpEntity<>(map,headers);

        ResponseEntity<String> response = client.postForEntity(SERVER_URL, request , String.class);

        System.out.println(response.getBody());
        CodeJson codeJson = JSON.parseObject(response.getBody(),CodeJson.class);
        codeJson.setMobile(MOBILE);
        return codeJson;
    }
}
