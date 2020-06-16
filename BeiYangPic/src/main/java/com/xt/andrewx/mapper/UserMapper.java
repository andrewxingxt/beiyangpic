package com.xt.andrewx.mapper;

import com.xt.andrewx.entity.User;
import com.xt.andrewx.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User findByPhoneNum(String PhoneNum);
    void InsertUser(String Id,String username,String password,String phone_num);
    void InsertUserinfo(String user_id);
    UserInfo login(String PhoneNum);
    void Updatebirthday(String user_id,String birthday);
    void UpdateUsername(String user_id,String username);
    void UpdateHeadAvt(String user_id,String HeadAvt);
    void UpdateIntro(String user_id, String intro);
    void addFollow(String user_ed_id,String user_id);
    UserInfo findUserById(String id);
    UserInfo loginInPassword(String phone_num, String password);
}
