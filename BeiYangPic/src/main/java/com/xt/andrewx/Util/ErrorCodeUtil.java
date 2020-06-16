package com.xt.andrewx.Util;

import com.xt.andrewx.entity.User;
import com.xt.andrewx.entity.UserInfo;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodeUtil {

    /**
     * 注册失败
     * */
    public static Map ERROR_USER_EXISTS(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",101);
        Code_Mess.put("message","注册失败，用户存在");
        return Code_Mess;
    }
    /**
     * 插入数据库时出错
     * */
    public static Map REGISTER_ERROR_DATABASE(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",102);
        Code_Mess.put("message","插入数据库时出错");
        return Code_Mess;
    }
    /**
     * 注册成功
     * */
    public static Map REGISTER_SUCCESS(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",103);
        Code_Mess.put("message","注册成功");
        return Code_Mess;
    }

    /**
     * 验证码错误
     * */
    public static Map VERIFY_CODE_FAIL(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",105);
        Code_Mess.put("message","验证码错误");
        return Code_Mess;
    }
    /**
     * 验证码保存错误
     * */
    public static Map VERIFY_CODE_NOT_FIND(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",106);
        Code_Mess.put("message","验证码保存错误");
        return Code_Mess;
    }




    /**
     * 登录成功
     * */
    public static Map LOGIN_SUCCESS(UserInfo user,String token){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",201);
        Code_Mess.put("message","登录成功");
        Code_Mess.put("User_message",user);
        Code_Mess.put("token",token);
        return Code_Mess;
    }
    /**
     * 登录失败
     * */
    public static Map LOGIN_FAIL(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",202);
        Code_Mess.put("message","密码错误或用户名不存在");
        return Code_Mess;
    }
    /**
     *修改用户名失败
     * */
    public static Map UpdateUsername_FAIL(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",301);
        Code_Mess.put("message","用户名修改失败");
        return Code_Mess;
    }

    /**
     *修改用户名成功
     * */
    public static Map UpdateUsername_SUCCESS(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",302);
        Code_Mess.put("message","用户名修改成功");
        return Code_Mess;
    }

    /**
     *修改生日成功
     * */
    public static Map UpdateBirthday_SUCCESS(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",303);
        Code_Mess.put("message","生日修改成功");
        return Code_Mess;
    }

    /**
     *修改生日失败
     * */
    public static Map UpdateBirthday_FAIL(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",304);
        Code_Mess.put("message","生日修改失败");
        return Code_Mess;
    }

    /**
     *修改头像成功
     * */
    public static Map UpdateHeadAvt_SUCCESS(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",305);
        Code_Mess.put("message","头像修改成功");
        return Code_Mess;
    }

    /**
     *修改头像失败
     * */
    public static Map UpdateHeadAvt_FAIL(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",306);
        Code_Mess.put("message","头像修改失败");
        return Code_Mess;
    }

    /**
     *修改个人介绍成功
     * */
    public static Map UpdateIntro_SUCCESS(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",307);
        Code_Mess.put("message","个人介绍修改成功");
        return Code_Mess;
    }
    /**
     *修改个人介绍失败
     * */
    public static Map UpdateIntro_FAIL(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",308);
        Code_Mess.put("message","个人介绍修改失败");
        return Code_Mess;
    }

    /**
     *添加关注成功
     * */
    public static Map AddFollow_SUCCESS(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",309);
        Code_Mess.put("message","添加关注成功");
        return Code_Mess;
    }
    /**
     *添加关注失败
     * */
    public static Map AddFollow_FAIL(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",310);
        Code_Mess.put("message","添加关注失败");
        return Code_Mess;
    }

    /**
     *查找用户成功
     * */
    public static Map FindById_SUCCESS(UserInfo userInfo){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",311);
        Code_Mess.put("message","查找用户成功");
        Code_Mess.put("userInfo",userInfo);
        return Code_Mess;
    }
    /**
     *查找用户失败
     * */
    public static Map FindById_FAIL(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",312);
        Code_Mess.put("message","查找用户失败");
        return Code_Mess;
    }
    /**
     *用户不存在
     * */
    public static Map Not_FindById(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",313);
        Code_Mess.put("message","用户不存在");
        return Code_Mess;
    }

    /**
     *token过期
     * */
    public static Map Token_EXPIRED(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",802);
        Code_Mess.put("message","token过期");
        return Code_Mess;
    }

    /**
     *token合法
     * */
    public static Map Token_LEGAL(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",801);
        Code_Mess.put("message","token合法");
        return Code_Mess;
    }

    /**
     *token不合法
     * */
    public static Map Token_NOT_LEGAL(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",803);
        Code_Mess.put("message","token不合法");
        return Code_Mess;
    }

    /**
     *内容为空
     * */
    public static Map CONTENT_NULL(){
        Map Code_Mess = new HashMap();
        Code_Mess.put("code",111);
        Code_Mess.put("message","内容为空");
        return Code_Mess;
    }


}
