package com.eb.gc.ebstorageserver.controller;

import com.eb.gc.common.ResultInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Author: gc
 * Date: 2020/3/11 14:39
 * Description: TODO
 */
@RestController
@RequestMapping("/storage")
public class StorageController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/send/{id}")
    public ResultInfo sendById(@PathVariable("id") Long id) {
        return ResultInfo.success(String.format("{'msg':'请求仓储中心[port:%s],发货[id:%d]'}", port, id));
    }
}
