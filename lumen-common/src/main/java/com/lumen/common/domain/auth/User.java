package com.lumen.common.domain.auth;

import com.lumen.common.domain.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

/**
 * @author hxy
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseModel {
    @Column(length = 200)
    private String username;
    @Column(length = 200)
    private String password;
    @Column(length = 255)
    private String roles;
}
