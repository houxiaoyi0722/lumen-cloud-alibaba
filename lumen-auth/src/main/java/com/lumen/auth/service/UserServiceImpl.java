package com.lumen.auth.service;

import cn.hutool.core.collection.CollUtil;
import com.lumen.auth.entity.SecurityUser;
import com.lumen.common.domain.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hxy
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    private List<User> userList;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
//        String password = passwordEncoder.encode("123456");
//        userList = new ArrayList<>();
//        userList.add(new lumenUser("macro", password, "admin"));
//        userList.add(new lumenUser("andy", password, "TEST"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> findUserList = userList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        if (CollUtil.isEmpty(findUserList)) {
            throw new UsernameNotFoundException("USERNAME_PASSWORD_ERROR");
        }
        User user = findUserList.get(0);
        SecurityUser securityUser = SecurityUser.builder()
                .id(user.getId())
                .roles(user.getRoles())
                .username(user.getUsername())
                .password(user.getPassword())
                .enabled(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build();

        return securityUser;
    }
}
