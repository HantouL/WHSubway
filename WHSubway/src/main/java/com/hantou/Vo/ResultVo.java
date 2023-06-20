package com.hantou.Vo;

import com.hantou.constant.ResultEnum;
import lombok.Getter;

@Getter
//打包一下result
public class ResultVo<T> {
    private T data;
    private Integer code;
    private String message;
    public ResultVo(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        data = null;
    }
    public ResultVo(ResultEnum resultEnum,T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }
    public ResultVo(Integer code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

