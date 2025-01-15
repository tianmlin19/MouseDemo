package com.tml.mouseDemo.constants;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResponse<T> implements Serializable {
    private static final long serialVersionUID = 3803049072309399446L;

    private int code;

    private String msg;

    private T data;

    private void setResultCode(ResponseCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public static<T> CommonResponse<T> success(T data) {
        CommonResponse result = new CommonResponse();
        result.setResultCode(ResponseCode.SUCCESS);
        result.setData(data);
        return result;
    }


    public static CommonResponse customerRes(ResponseCode resultCode) {
        CommonResponse result = new CommonResponse();
        result.setResultCode(resultCode);
        return result;
    }

    public static CommonResponse fail() {
        CommonResponse result = new CommonResponse();
        result.setResultCode(ResponseCode.FAIL);
        return result;
    }


    public static CommonResponse fail(String msg) {
        CommonResponse result = new CommonResponse();
        result.setCode(ResponseCode.FAIL.getCode());
        result.setMsg(msg);
        return result;
    }
}
