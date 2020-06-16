package com.xt.andrewx.controller;


import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.xt.andrewx.entity.User;
import com.xt.andrewx.service.TokenService;
import com.xt.andrewx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.xt.andrewx.Util.ErrorCodeUtil.*;


@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    public UserService userService;
    @Autowired
    public TokenService tokenService;

    @PostMapping("/check")
    @ResponseBody
    public Map checkExpireToken(@RequestBody String data){

        String token;
        JSONObject jsonObject = JSONObject.parseObject(data);
        Map<String, String> dataMap =  jsonObject.toJavaObject(Map.class);
        token = dataMap.get("token");

        if(token == null || token == ""){

            return CONTENT_NULL();
        }

        String user_phone_num;
        try {
            user_phone_num = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            return Token_NOT_LEGAL();
        }
        User user = userService.findByPhoneNum(user_phone_num);
        // 验证 token
        return tokenService.checkExpireToken(token,user);
    }
}
