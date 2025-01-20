package com.tml.mouseDemo.constants;

import com.tml.mouseDemo.config.TraceContext;
import com.tml.mouseDemo.core.i18n.I18nUtil;
import lombok.Data;
import org.slf4j.MDC;

import java.io.Serializable;

import static com.tml.mouseDemo.constants.CommonConstants.TRACE_ID;

@Data
public class CommonResponse<T> implements Serializable {
    private static final long serialVersionUID = 3803049072309399446L;

    private int code;

    private String msg;

    private T data;

    private String traceId;

    private void setResultCode(ResponseCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public static<T> CommonResponse<T> success(T data) {
        CommonResponse result = new CommonResponse();
        result.setResultCode(ResponseCode.SUCCESS);
        result.setData(data);
        //result.setTraceId(MDC.get(TRACE_ID));
        result.setTraceId(TraceContext.get());
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
        //result.setTraceId(MDC.get(TRACE_ID));
        result.setTraceId(TraceContext.get());
        return result;
    }


    public static CommonResponse fail(String msg) {
        CommonResponse result = new CommonResponse();
        result.setCode(ResponseCode.FAIL.getCode());
        //result.setTraceId(MDC.get(TRACE_ID));
        result.setTraceId(TraceContext.get());
        result.setMsg(msg);
        return result;
    }

    public static CommonResponse failWithI18n(I18nKey i18nKey) {
        CommonResponse result = new CommonResponse();
        result.setCode(i18nKey.getCode());
        //result.setTraceId(MDC.get(TRACE_ID));
        result.setTraceId(TraceContext.get());
        String i18nMessage = I18nUtil.getI18nMessage(i18nKey);
        result.setMsg(i18nMessage);
        return result;
    }


}
