package com.tml.mouseDemo.core.log;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.tml.mouseDemo.config.TraceContext;

import java.util.Optional;

/**
 * logback日志框架原理研究
 */
public class TraceIdConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        return Optional.ofNullable(TraceContext.get()).orElse("");
    }
}
