package com.chinesecooly.user.exception;


import com.chinesecooly.common.Code;
import lombok.Data;
import org.springframework.security.authentication.AccountExpiredException;


public class UserExpiredException extends AccountExpiredException {

    private Code code;

    public UserExpiredException(String msg, Code code) {
        super(msg);
        this.code=code;
    }

    public Code getCode() {
        return code;
    }
}
