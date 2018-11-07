package com.ss.demo.auth.handler;

import com.alibaba.fastjson.JSONObject;
import com.ss.demo.common.result.Code;
import com.ss.demo.common.result.Result;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.util.StringUtils;

/**
 * @author chao
 * @since 2018-11-07
 */
@Slf4j
public class UnauthorizedPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try (PrintWriter writer = response.getWriter()) {
            String message = authException.getMessage();
            if (StringUtils.isEmpty(message)) {
                message = Code.UNAUTHORIZED.msg();
            }
            writer.print(JSONObject.toJSONString(Result.newResult(Code.UNAUTHORIZED, message)));
            response.flushBuffer();
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
