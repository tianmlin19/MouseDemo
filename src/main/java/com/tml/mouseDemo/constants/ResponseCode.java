package com.tml.mouseDemo.constants;

public enum ResponseCode {

    SUCCESS(0, "success!"),
    FAIL(500, "system error!");

    private int code;

    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
