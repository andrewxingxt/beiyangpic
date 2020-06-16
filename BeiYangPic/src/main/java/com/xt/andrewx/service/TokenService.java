package com.xt.andrewx.service;

import com.xt.andrewx.entity.User;

import java.util.Map;

public interface TokenService {
    String getToken(User user);
    Map checkExpireToken(String token, User user);

}
