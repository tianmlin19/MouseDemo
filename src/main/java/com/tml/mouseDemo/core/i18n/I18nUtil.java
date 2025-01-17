package com.tml.mouseDemo.core.i18n;

import com.tml.mouseDemo.config.LanguageContext;
import com.tml.mouseDemo.constants.I18nKey;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.tml.mouseDemo.constants.CommonConstants.DEFAULT_LANGUAGE_CODE;

@Slf4j
public class I18nUtil {

    /**
     * 获取当前线程的language
     *
     * @return
     */
    public static String getLanguageCode() {
        String lanCode = LanguageContext.get();
        return Optional.ofNullable(lanCode).orElse(DEFAULT_LANGUAGE_CODE);
    }

    public static String getI18nMessage(I18nKey i18nKey) {

        String languageCode = getLanguageCode();

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("i18n.").append("messages_").append(i18nKey.getType());


            String i18keyPrefix = sb.toString();
            String actualKey = i18nKey.getType() + "." + i18nKey.name().toLowerCase();
            Locale locale = new Locale(languageCode);
            ResourceBundle bundle = ResourceBundle.getBundle(i18keyPrefix, locale);
            String message = new String(bundle.getString(actualKey).getBytes("iso-8859-1"), "utf-8");
            log.info("getI18nMessage i18keyPrefix:{}--languageCode:{}--actualKey:{}--message:{}", i18keyPrefix, languageCode, actualKey, message);
            return message;

        } catch (Exception e) {
            log.error("getI18nMessage occur error", e);
        }

        return i18nKey.name().toLowerCase();
    }
}
