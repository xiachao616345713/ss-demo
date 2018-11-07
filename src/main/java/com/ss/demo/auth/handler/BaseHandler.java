package com.ss.demo.auth.handler;

import com.alibaba.fastjson.JSONObject;
import com.ss.demo.common.result.Code;
import com.ss.demo.common.result.Result;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

/**
 * @author chao
 * @since 2018-11-07
 */
@Slf4j
class BaseHandler {

    /**
     * return JsonResult
     */
    void renderJson(HttpServletResponse response, Code code, String message) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try (PrintWriter writer = response.getWriter()) {
            writer.print(JSONObject.toJSONString(Result.newResult(code, message)));
            response.flushBuffer();
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
