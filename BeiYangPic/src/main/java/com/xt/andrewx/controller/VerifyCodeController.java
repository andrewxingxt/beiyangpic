package com.xt.andrewx.controller;

import com.alibaba.fastjson.JSONObject;
import com.xt.andrewx.service.VerifyCodeService;
import com.xt.andrewx.verifyCodeUtil.CodeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.xt.andrewx.verifyCodeUtil.VerifyCodeMap.verifyCodeMap;

@RestController
@RequestMapping("/VerifyCode")
public class VerifyCodeController {

    @Autowired
    private VerifyCodeService verifyCodeService;

    @PostMapping("/send")
    @ResponseBody
    public void verifCode(@RequestBody String data
            ){
        String mobile;

        JSONObject jsonObject = JSONObject.parseObject(data);
        Map<String, String> dataMap =  jsonObject.toJavaObject(Map.class);
        mobile = dataMap.get("mobile");

        if(mobile == null || mobile == ""){

            return;
        }
        CodeJson codeJson = verifyCodeService.SendVerifyCode(mobile);
        verifyCodeMap.put(mobile,codeJson);
        System.out.println(verifyCodeMap.size());
    }
}
