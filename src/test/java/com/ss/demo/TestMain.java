package com.ss.demo;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author chao
 * @since 2018-11-07
 */
public class TestMain {

    public static void main(String[] args) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String ps = encoder.encode("123456");
        System.out.println(ps);
        System.out.println(encoder.matches("123456", ps));
    }
}
