package com.lumen.auth.controller;

import com.lumen.auth.entity.Oauth2TokenDto;
import com.lumen.common.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

/**
 * 自定义Oauth2获取令牌接口
 */
@RestController
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    /**
     * Oauth2登录认证
     */
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public Result postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead("Bearer ").build();
        //todo 签发后使用redis 管理token
        return Result.ok(oauth2TokenDto);
    }

    /**
     * Oauth2登出认证
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result logout() {
        //todo logout后删除token
        return Result.ok();
    }

}
