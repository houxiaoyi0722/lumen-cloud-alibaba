package com.lumen.auth.handler;

import com.lumen.auth.exception.IncorrectAccountPasswordException;
import com.lumen.common.response.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局处理Oauth2抛出的异常
 * @author hxy
 */
@ControllerAdvice
public class Oauth2ExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = IncorrectAccountPasswordException.class)
    public ResponseEntity<Result> handleOauth2(IncorrectAccountPasswordException e) {
        return new ResponseEntity<>(Result.accountPasswordFailed(), HttpStatus.UNAUTHORIZED);
    }
}
