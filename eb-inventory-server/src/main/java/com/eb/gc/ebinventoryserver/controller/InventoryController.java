package com.eb.gc.ebinventoryserver.controller;

import com.eb.gc.common.ResultInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Author: gc
 * Date: 2020/3/11 14:12
 * Description: TODO
 */
@RestController
@RefreshScope
@RequestMapping("/inventory")
public class InventoryController {
    @Value("${server.port}")
    private String port;

    @Value("${eb.config.test1}")
    private String test1;

    @Value("${eb.config.test2}")
    private String test2;


    @GetMapping("/cut/{id}")
    public ResultInfo cutById(@PathVariable("id") Long id) {
        String configMsg = "test1:" + test1 + " && test2:" + test2;
        return ResultInfo.success(String.format("{'msg':'请求库存中心[port:%s],削减商品[id:%d]'}", port, id)+ " | " + configMsg);
    }
}
