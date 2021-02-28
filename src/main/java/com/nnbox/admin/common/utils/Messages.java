package com.nnbox.admin.common.utils;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class Messages {

    @Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource);
    }

    public String get(String code) {
        return accessor.getMessage(code, Locale.KOREAN);
    }
    public String get(String code, Locale lo) {
        return accessor.getMessage(code, lo);
    }
    public String get(String code, String lo) {
    	Locale locale = Locale.KOREAN;
    	if ("en".equals(lo)) locale = Locale.ENGLISH;
    	else if ("zh".equals(lo)) locale = Locale.CHINESE;
    	else if ("ja".equals(lo)) locale = Locale.JAPANESE;
    	else if ("vi".equals(lo)) locale = Locale.ITALIAN;
        return accessor.getMessage(code, locale);
    }

}