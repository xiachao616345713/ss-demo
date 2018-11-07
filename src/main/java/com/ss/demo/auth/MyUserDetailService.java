package com.ss.demo.auth;

import com.ss.demo.service.UserService;
import com.ss.demo.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author chao
 * @since 2018-11-06
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TUser user = userService.selectByUsername(username);

        if (user != null) {
            return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRoles())
                    .build();
        }

        throw new UsernameNotFoundException("用户不存在");
    }
}
