package com.lumen.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResultCodeEnum {

    SUCCESS(200,"请求成功"),
    ERROR(500,"未处理异常"),
    NO_PERMISSION(218,"权限不足"),
    PASSWORD_ERROR(217,"账号或密码错误"),
    UNAUTHORIZED(508, "暂未登录或token已经过期");

    private Integer code;
    private String message;
}
