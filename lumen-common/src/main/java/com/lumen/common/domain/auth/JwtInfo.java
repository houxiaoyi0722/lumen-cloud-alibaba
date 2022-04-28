package com.lumen.common.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtInfo {
    private String userName;
    private String scope;
    private String exp;
    private String authorities;
    private String jti;
    private String clientId;
}
