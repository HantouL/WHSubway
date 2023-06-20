package com.hantou.constant;

import lombok.Getter;

//打包一下result

@Getter
public enum ResultEnum {
    OK(2000,"成功"),
    Error(5000,"失败");
    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
    Integer code;
    String message;
}
