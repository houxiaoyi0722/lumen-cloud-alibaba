package com.lumen.common.component;

import cn.hutool.json.JSONUtil;
import com.lumen.common.constants.StringConst;
import com.lumen.common.domain.auth.JwtInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取登录用户信息
 * @author hxy
 */
@Component
public class LoginUserHolder {

    public JwtInfo getCurrentUser(){
        //从Header中获取用户信息
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String userStr = request.getHeader(StringConst.HEADER_NAME);
        JwtInfo jwtInfo = JSONUtil.toBean(userStr, JwtInfo.class);
        //清除某些关键信息
        jwtInfo.setJti("");
        return jwtInfo;
    }
}
