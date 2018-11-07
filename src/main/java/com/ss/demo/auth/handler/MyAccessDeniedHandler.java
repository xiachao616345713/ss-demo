package com.ss.demo.auth.handler;

import com.ss.demo.common.result.Code;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author chao
 * @since 2018-11-07
 */
public class MyAccessDeniedHandler extends BaseHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        renderJson(response, Code.FORBIDDEN, accessDeniedException.getMessage());
    }
}
