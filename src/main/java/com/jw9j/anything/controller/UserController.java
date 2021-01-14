package com.jw9j.anything.controller;

import com.jw9j.anything.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口", description = "提供用户相关的Rest API")
public class UserController {
    @ApiOperation("新增用户接口")
    @PostMapping("/add")
    public boolean addUse(@RequestBody User user){
        return false;
    }
}
