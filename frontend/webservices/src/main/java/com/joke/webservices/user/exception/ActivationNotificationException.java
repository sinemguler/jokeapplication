package com.joke.webservices.user.exception;

import org.springframework.context.i18n.LocaleContextHolder;

import com.joke.webservices.shared.Messages;

public class ActivationNotificationException extends RuntimeException{
    public ActivationNotificationException(){
        super(Messages.getMessageForLocale("joke.create.user.email.failure", LocaleContextHolder.getLocale()));
    }
}
