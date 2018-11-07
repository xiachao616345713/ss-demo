package com.ss.demo.auth;

import com.ss.demo.auth.handler.MyAccessDeniedHandler;
import com.ss.demo.auth.handler.UnauthorizedPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author chao
 * @since 2018-11-05
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(AuthServerOAuth2Config.RESOURCE_ID).stateless(false).tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.anonymous().disable()
                .requestMatchers().antMatchers("/users/**")
                .and()
                .authorizeRequests()
                .antMatchers("/users/**").hasRole("ADMIN")//.authenticated()
                .antMatchers("/users/user/**").hasRole("USER")
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new UnauthorizedPoint())
                .accessDeniedHandler(new MyAccessDeniedHandler());
    }
}
