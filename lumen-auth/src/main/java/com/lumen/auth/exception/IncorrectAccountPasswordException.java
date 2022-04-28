package com.lumen.auth.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 账号密码错误认证失败自定义异常
 * @author hxy
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncorrectAccountPasswordException extends RuntimeException {
    private Long code;
    private String msg;
}
