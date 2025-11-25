package com.yanwan.authcenter.controller;

import com.yanwan.authcenter.commmon.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public Result<?> helloWorld() {
        return Result.success("Hello, World!");
    }
}
