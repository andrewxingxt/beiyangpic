package com.xt.andrewx.controller;

import com.alibaba.fastjson.JSONObject;
import com.xt.andrewx.Annotation.UserLoginToken;
import com.xt.andrewx.Util.CheckNullUtil;
import com.xt.andrewx.Util.JsonUtil;
import com.xt.andrewx.service.TokenService;
import com.xt.andrewx.verifyCodeUtil.CodeJson;
import com.xt.andrewx.entity.User;
import com.xt.andrewx.entity.UserInfo;
import com.xt.andrewx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.xt.andrewx.Util.ErrorCodeUtil.*;
import static com.xt.andrewx.verifyCodeUtil.VerifyCodeMap.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(@RequestBody String s){
        System.out.println(s);
        return userService.findAll();
    }

    @PostMapping("/register")
    @ResponseBody
    public Map register(
            @RequestBody String data
            ){
        String phone_num,password,username,verifyCode;

        Map<String, String> dataMap = JsonUtil.J2Map(data);

        phone_num = dataMap.get("phone_num");
        password = dataMap.get("password");
        username = dataMap.get("username");
        verifyCode = dataMap.get("verifyCode");

        if(CheckNullUtil.checkNull(new String[]{phone_num,password,username,verifyCode})){
            return  CONTENT_NULL();
        }
        CodeJson codeJson = verifyCodeMap.get(phone_num);

        if(codeJson == null|| !verifyCode.equals(codeJson.getObj())){
            return VERIFY_CODE_FAIL();
        }

        User user = userService.findByPhoneNum(phone_num);
        if (user!=null){
            return ERROR_USER_EXISTS();
        }
        /**
         * 注册用户登录数据
         */
        String Id = DigestUtils.md5DigestAsHex(new Date().toString().getBytes());
        try{
            userService.InsertUser(Id,username,password,phone_num);
        }catch (Exception e){
            return REGISTER_ERROR_DATABASE();
        }

        verifyCodeMap.remove(phone_num);
        return REGISTER_SUCCESS();
    }

    @PostMapping("/loginInPassword")
    @ResponseBody
    public Map loginInPassword(@RequestBody String data
    ){
        String phone_num,password;
        Map<String, String> dataMap = JsonUtil.J2Map(data);
        phone_num = dataMap.get("phone_num");
        password = dataMap.get("password");

        if(CheckNullUtil.checkNull(new String[]{phone_num,password})){
            return  CONTENT_NULL();
        }
        UserInfo userInfo;

        try{
            userInfo = userService.loginInPassword(phone_num,password);
            if(userInfo==null){
                System.out.println("userInfo == null");
                return LOGIN_FAIL();
            }
            String token = tokenService.getToken(userInfo.toUser());
            return LOGIN_SUCCESS(userInfo,token);
        }catch (Exception e){
            e.printStackTrace();
            return LOGIN_FAIL();
        }
    }
    @PostMapping("/login")
    @ResponseBody
    public Map login(@RequestBody String data
                     ){
        String phone_num,verifyCode;
        Map<String, String> dataMap = JsonUtil.J2Map(data);
        phone_num = dataMap.get("phone_num");
        verifyCode = dataMap.get("verifyCode");

        if(CheckNullUtil.checkNull(new String[]{phone_num,verifyCode})){
            return  CONTENT_NULL();
        }
        System.out.println(phone_num);
        UserInfo userInfo;
        CodeJson codeJson = verifyCodeMap.get(phone_num);
        if(codeJson != null){
            if(!verifyCode.equals(codeJson.getObj())){
                return VERIFY_CODE_FAIL();
            }
        }else{
            return VERIFY_CODE_NOT_FIND();
        }

        try{
            userInfo = userService.login(phone_num);
            if(userInfo==null){
                return LOGIN_FAIL();
            }
            verifyCodeMap.remove(phone_num);
            String token = tokenService.getToken(userInfo.toUser());
            return LOGIN_SUCCESS(userInfo,token);
        }catch (Exception e){
            return LOGIN_FAIL();
        }
    }

    @UserLoginToken
    @PostMapping("/updateUsername")
    @ResponseBody
    public Map UpdateUsername(@RequestBody String data
            ){
        String user_id;String username;
        Map<String, String> dataMap = JsonUtil.J2Map(data);
        user_id = dataMap.get("user_id");
        username = dataMap.get("username");
        if(CheckNullUtil.checkNull(new String[]{user_id,username})){
            return  CONTENT_NULL();
        }
        try{
            userService.UpdateUsername(user_id,username);
        }catch (Exception e){
            return UpdateUsername_FAIL();
        }
        return UpdateUsername_SUCCESS();
    }

    @UserLoginToken
    @PostMapping("/updateBirthday")
    @ResponseBody
    public Map UpdateBirthday(@RequestBody String data
                              ){
        String user_id;String birthday;
        Map<String, String> dataMap = JsonUtil.J2Map(data);
        user_id = dataMap.get("user_id");
        birthday = dataMap.get("birthday");

        if(CheckNullUtil.checkNull(new String[]{user_id,birthday})){
            return  CONTENT_NULL();
        }
        try{
            userService.Updatebirthday(user_id, birthday);
        }catch (Exception e){
            return UpdateBirthday_FAIL();
        }
        return UpdateBirthday_SUCCESS();
    }

    @UserLoginToken
    @PostMapping("/updateHeadAvt")
    @ResponseBody
    public Map UpdateHeadAvt(@RequestBody String data
                             ){
        String user_id;
        String HeadAvt;
        Map<String, String> dataMap = JsonUtil.J2Map(data);
        user_id = dataMap.get("user_id");
        HeadAvt = dataMap.get("HeadAvt");

        if(CheckNullUtil.checkNull(new String[]{user_id,HeadAvt})){
            return  CONTENT_NULL();
        }
        try{
            userService.UpdateHeadAvt(user_id, HeadAvt);
        }catch (Exception e){
            return UpdateHeadAvt_FAIL();
        }
        return UpdateHeadAvt_SUCCESS();
    }

    @UserLoginToken
    @PostMapping("/updateIntro")
    @ResponseBody
    public Map UpdateIntro(@RequestBody String data
                          ){
        String user_id,intro;
        Map<String, String> dataMap = JsonUtil.J2Map(data);

        user_id = dataMap.get("user_id");
        intro = dataMap.get("intro");

        if(CheckNullUtil.checkNull(new String[]{user_id,intro})){
            return  CONTENT_NULL();
        }
        try{
            userService.UpdateIntro(user_id, intro);
        }catch (Exception e){
            return UpdateIntro_FAIL();
        }
        return UpdateIntro_SUCCESS();
    }

    @UserLoginToken
    @PostMapping("/addFollow")
    @ResponseBody
    public Map addFollow(@RequestBody String data
                         ){
        String user_ed_id;String user_id;
        Map<String, String> dataMap = JsonUtil.J2Map(data);
        user_ed_id = dataMap.get("user_ed_id");
        user_id = dataMap.get("user_id");

        if(CheckNullUtil.checkNull(new String[]{user_id,user_ed_id})){
            return  CONTENT_NULL();
        }
        try{
            userService.addFollow(user_ed_id, user_id);
        }catch (Exception e){
            return AddFollow_FAIL();
        }
        return AddFollow_SUCCESS();
    }

    @UserLoginToken
    @RequestMapping("/findUserById")
    @ResponseBody
    public Map findUserById(@RequestBody String data){

        String Id;
        Map<String, String> dataMap = JsonUtil.J2Map(data);
        Id = dataMap.get("Id");

        if(CheckNullUtil.checkNull(new String[]{Id})){
            return  CONTENT_NULL();
        }
        UserInfo userinfo;
        try {
            userinfo = userService.findUserById(Id);
            if(userinfo == null){
                return Not_FindById();
            }
        }catch (Exception e){
            return FindById_FAIL();
        }
        return FindById_SUCCESS(userinfo);
    }
}
