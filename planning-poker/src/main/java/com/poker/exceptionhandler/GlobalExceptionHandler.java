package com.poker.exceptionhandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.poker.exception.ErrorResponseModel;
import com.poker.exception.PokerExceptionTypeEnum;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseModel genericError(final HttpServletRequest request, final HttpServletResponse response,
            final Exception exception) {
        return new ErrorResponseModel(PokerExceptionTypeEnum.SERVICE_ERROR,exception.getLocalizedMessage());
    }
}
