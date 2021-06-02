package com.xmd.common.controller;

import com.xmd.common.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "测试swagger")
@RestController
@Validated
@Slf4j
@RequestMapping("/api/leads-medis/")
public class CommonController {

    @PostMapping("/test")
    @ApiOperation("测试")
    public String findItem(@RequestBody User user) {

        return "123";
    }
}
