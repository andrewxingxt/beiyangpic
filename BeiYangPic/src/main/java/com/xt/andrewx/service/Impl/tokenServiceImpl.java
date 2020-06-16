package com.xt.andrewx.service.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.xt.andrewx.entity.User;
import com.xt.andrewx.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import static com.xt.andrewx.Util.ErrorCodeUtil.*;


@Service("TokenService")
public class tokenServiceImpl implements TokenService {

    @Override
    public String getToken(User user) {
        Date today = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)+3);
        String token;
        token = JWT
                .create()
                .withExpiresAt(calendar.getTime())
                .withAudience(user.getPhone_number())
                .sign(Algorithm.HMAC256(user.getId()));
        return  token;
    }

    @Override
    public Map checkExpireToken(String token, User user) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getId())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            if(e.getClass() == TokenExpiredException.class){
                return Token_EXPIRED();
            }else{
                return Token_NOT_LEGAL();
            }

        }
        return Token_LEGAL();
    }

}
