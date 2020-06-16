package com.xt.andrewx.verifyCodeUtil;

public class CodeJson {
    private String code;
    private String msg;
    private String obj;
    private String mobile;

    public CodeJson(String code, String msg, String obj, String mobile) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
}
