package com.chinesecooly.common;

public enum Code {

    SUCCESS(200),FAILED(404);

    private int code;

    Code(int code){
        this.code=code;
    }
}
