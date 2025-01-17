package com.tml.mouseDemo.constants;

import lombok.Getter;

import static com.tml.mouseDemo.constants.CommonConstants.APP;
import static com.tml.mouseDemo.constants.CommonConstants.SYS;

@Getter
public enum I18nKey {

    INVALID_PWD(10001,APP),
    SAY_HELLO(10002,APP),
    NETWORK_ERROR(90001,SYS);

    private int code;

    private String type;

    I18nKey(int code, String type) {
        this.code = code;
        this.type = type;
    }
}
