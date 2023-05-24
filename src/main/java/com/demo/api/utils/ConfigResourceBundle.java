package com.demo.api.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigResourceBundle {

    public static final ConfigResourceBundle CONFIG_RESOURCE = getInstance(System.getProperty("language"));
    private final ResourceBundle resourceConfig;

    private ConfigResourceBundle(String language) {
        Locale locale;
        if ("vi".equals(language)) {
            locale = new Locale("vi", "VI");
        } else {
            locale = Locale.ENGLISH;
        }
        resourceConfig = ResourceBundle.getBundle("language", locale);
    }

    public static ConfigResourceBundle getInstance(String language) {
        return new ConfigResourceBundle(language);
    }

    public String getValue(String key) {
        return resourceConfig.getString(key);
    }

}
