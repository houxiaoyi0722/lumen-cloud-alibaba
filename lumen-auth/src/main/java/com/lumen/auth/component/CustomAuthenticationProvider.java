package com.lumen.auth.component;

import cn.hutool.core.util.StrUtil;
import com.lumen.auth.entity.SecurityUser;
import com.lumen.auth.exception.IncorrectAccountPasswordException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义登录校验逻辑
 * @author hxy
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static Map<String, String> user = new HashMap<>();
    private static Map<String, String> role = new HashMap< >();
    static {
        user.put("storeStaff","123456");
        user.put("storeManager","123456");
        user.put("hqOperator","123456");
        user.put("hqAdmin","123456");
        user.put("admin","123456");

        role.put("storeStaff","STORE_STAFF");
        role.put("storeManager","STORE_MANAGER");
        role.put("hqOperator","HQ_OPERATOR");
        role.put("hqAdmin","HQ_ADMIN");
        role.put("admin","admin");
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();


        //todo temp 权限测试使用
        SecurityUser build = null;
        String s = user.get(name);
        //在这里对用户做身份认证,定义一个service发送请求获取用户数据返回SecurityUser
        if (StrUtil.isNotEmpty(s)) {
            if (password.equals(s)) {
                build = SecurityUser.builder().username(name).password(password).roles(role.get(name)).build();
            }
        }

        //如果认证失败抛出异常
        if (build == null) {
            throw new IncorrectAccountPasswordException();
        }

        //认证成功
        List<GrantedAuthority> grantedAuths = AuthorityUtils.createAuthorityList(build.getRoles());
        return new UsernamePasswordAuthenticationToken(build, password, grantedAuths);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
