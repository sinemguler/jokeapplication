package com.joke.webservices.user.exception;

import java.util.Collections;
import java.util.Map;

import org.springframework.context.i18n.LocaleContextHolder;
import com.joke.webservices.shared.Messages;


public class NotUniqueEmailException extends RuntimeException{

    public NotUniqueEmailException(){
        super(Messages.getMessageForLocale("joke.error.validation", LocaleContextHolder.getLocale()));
    }

    public Map<String, String> getValidationErrors(){
        return Collections.singletonMap("email", Messages.getMessageForLocale("joke.constraint.email.notunique", LocaleContextHolder.getLocale()));
    }

}