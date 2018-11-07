package com.ss.demo.controller;

import com.ss.demo.common.result.Code;
import com.ss.demo.common.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * test
 *
 * @author chao
 * @since 2018-11-06
 */
@RestController
@RequestMapping("/users")
public class Test {

    @RequestMapping(value = "/admin/test", method = RequestMethod.GET)
    public Result adminTest() {
        return Result.newResult(Code.SUCCESS, "test admin method");
    }

    @RequestMapping(value = "/user/test", method = RequestMethod.GET)
    public Result userTest() {
        return Result.newResult(Code.SUCCESS, "test user method");
    }
}
