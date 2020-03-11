package com.eb.gc.ebaccumulateserver.controller;

import com.eb.gc.common.ResultInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Author: gc
 * Date: 2020/3/11 14:33
 * Description: TODO
 */
@RestController
@RequestMapping("/accumulate")
public class AccumulateController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/increase/{id}")
    public ResultInfo increaseById(@PathVariable("id") Long id) {
        return ResultInfo.success(String.format("{'msg':'请求积分系统[port:%s],增加用户积分[id:%d]'}", port, id));
    }
}
