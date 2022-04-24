package com.chinesecooly.common;

import lombok.Data;

@Data
public class Result{

    private Object data;
    private String msg;
    private Code code;

    private Result(){

    }

    public static Result newInstance(){
        return new Result();
    }

    public Result message(String msg){
        this.msg=msg;
        return this;
    }

    public Result data(Object data){
        this.data=data;
        return this;
    }

    public Result code(Code code){
        this.code=code;
        return this;
    }
}
