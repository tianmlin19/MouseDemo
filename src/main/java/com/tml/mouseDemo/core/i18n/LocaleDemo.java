package com.tml.mouseDemo.core.i18n;

import java.util.Locale;

public class LocaleDemo {

    public static void main(String[] args) {
        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault.getCountry());


        Locale locale = new Locale("en", "UK");
        System.out.println(locale.getDisplayName());

    }
}
