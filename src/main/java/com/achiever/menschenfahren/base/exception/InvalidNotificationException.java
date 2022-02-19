package com.achiever.menschenfahren.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Notification data invalid")
public class InvalidNotificationException extends Exception {

    private static final long serialVersionUID = -503341549235515462L;

    public InvalidNotificationException(final String reason) {
        super(reason);
    }

}
