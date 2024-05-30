package com.joke.webservices.user.exception;

import org.springframework.context.i18n.LocaleContextHolder;

import com.joke.webservices.shared.Messages;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(){
        super(Messages.getMessageForLocale("joke.activate.user.invalid.token", LocaleContextHolder.getLocale()));
    }
}
