package com.lumen.consumer.controller;

import com.lumen.api.dict.DataHandleApi;
import com.lumen.common.component.LoginUserHolder;
import com.lumen.common.domain.auth.JwtInfo;
import com.lumen.common.domain.provider.dict.entity.Dictionary;
import com.lumen.common.response.Result;
import org.springframework.stereotype.Controller;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping(value = "/lumen")
public class DataHandleController {

    @Reference(version = "1.0.0",group = "lumen")
    private DataHandleApi dataHandleApi;

    @Resource
    private LoginUserHolder loginUserHolder;

    @GetMapping("/test")
    public Result<Dictionary> test() {

        JwtInfo currentUser = loginUserHolder.getCurrentUser();


        return Result.ok(dataHandleApi.findOne(1L));
    }


}
