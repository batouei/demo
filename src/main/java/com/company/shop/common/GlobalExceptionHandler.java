package com.company.shop.common;

import com.company.shop.user.service.exception.UserNotFoundException;
import com.company.shop.user.web.UnAuthorizedUserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSourceAccessor messageSourceAccessor;

    @ExceptionHandler({
            UserNotFoundException.class
    })
    public ResponseEntity<String> handleInternalServerExceptionBySimpleName(Exception e) {
        var msg = getMessage(e.getClass().getSimpleName());
        return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler({
            UnAuthorizedUserException.class
    })
    public ResponseEntity<String> handleAuthExceptionBySimpleName(Exception e) {
        var msg = getMessage(e.getClass().getSimpleName());
        return new ResponseEntity<>(msg, HttpStatus.UNAUTHORIZED);
    }

    private String getMessage(String key) {
        try {
            return messageSourceAccessor.getMessage(key);
        } catch (NoSuchMessageException e) {
            return messageSourceAccessor.getMessage("msg_error_default");
        }
    }


}
