package com.ss.demo.service;

import com.ss.demo.entity.TUser;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 * @author chao
 * @since 2018-11-06
 */
@Service
public class UserService {

    private static final String DEFAULT_PASSWORD = "{bcrypt}$2a$10$NAboATMsbr19A0CTeq1l7eGIJJbP2.rGFR/AZNGGT65K54s4QAmAK";

    /**
     * select by username from db
     */
    public TUser selectByUsername(String username) {
        if ("xiaochao".equalsIgnoreCase(username)) {
            TUser tUser = new TUser();
            tUser.setId(1);
            tUser.setUsername(username);
            tUser.setPassword(DEFAULT_PASSWORD);
            tUser.setStatus(1);
            tUser.setRoles("ADMIN");
            tUser.setCreateTime(new Date());
            return tUser;
        }
        if ("chao".equalsIgnoreCase(username)) {
            TUser tUser = new TUser();
            tUser.setId(1);
            tUser.setUsername(username);
            tUser.setPassword(DEFAULT_PASSWORD);
            tUser.setStatus(1);
            tUser.setRoles("USER");
            tUser.setCreateTime(new Date());
            return tUser;
        }
        return null;
    }
}
