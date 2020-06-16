package com.xt.andrewx.service.Impl;

import com.xt.andrewx.entity.User;
import com.xt.andrewx.entity.UserInfo;
import com.xt.andrewx.mapper.UserMapper;
import com.xt.andrewx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findByPhoneNum(String PhoneNum) {
        return userMapper.findByPhoneNum(PhoneNum);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void InsertUser(String Id, String username,String password, String phone_num) {
        try {
            userMapper.InsertUser(Id,username,password,phone_num);
            userMapper.InsertUserinfo(Id);
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public UserInfo login(String PhoneNum) {
        return userMapper.login(PhoneNum);
    }

    @Override
    public void Updatebirthday(String user_id, String birthday) {
        userMapper.Updatebirthday(user_id, birthday);
    }

    @Override
    public void UpdateUsername(String user_id, String username) {
        userMapper.UpdateUsername(user_id,username);
    }

    @Override
    public void UpdateHeadAvt(String user_id, String HeadAvt) {
        userMapper.UpdateHeadAvt(user_id, HeadAvt);
    }

    @Override
    public void UpdateIntro(String user_id, String intro) {
        userMapper.UpdateIntro(user_id, intro);
    }

    @Override
    public void addFollow(String user_ed_id, String user_id) {
        userMapper.addFollow(user_ed_id, user_id);
    }

    @Override
    public UserInfo findUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Override
    public UserInfo loginInPassword(String phone_num, String password) {
        return userMapper.loginInPassword(phone_num, password);
    }

}
