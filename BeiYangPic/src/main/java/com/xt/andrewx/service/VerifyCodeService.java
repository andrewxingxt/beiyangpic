package com.xt.andrewx.service;

import com.xt.andrewx.verifyCodeUtil.CodeJson;

public interface VerifyCodeService {


    CodeJson SendVerifyCode(String MOBILE);

}
