package com.eb.gc.eborderserver.controller;

import com.eb.gc.common.ResultInfo;
import com.eb.gc.eborderserver.service.AccumulateService;
import com.eb.gc.eborderserver.service.InventoryService;
import com.eb.gc.eborderserver.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: gc
 * Date: 2020/3/11 15:04
 * Description: TODO
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 库存中心
     */
    @Autowired
    InventoryService inventoryService;

    /**
     * 仓储中心
     */
    @Autowired
    StorageService storageService;

    /**
     * 积分中心
     */
    @Autowired
    AccumulateService accumulateService;

    /**
     * 下单
     * @param id 商品ID
     * @return
     */
    @GetMapping("/doOrder/{id}")
    @ResponseBody
    public ResultInfo doOrder(@PathVariable("id") Long id) {
        ResultInfo inventoryRes = inventoryService.cut(id);
        ResultInfo storageRes = storageService.send(id);
        ResultInfo accumulateRes = accumulateService.increase(id);
        return ResultInfo.success(inventoryRes.getMsg() + " | " + storageRes.getMsg() + " | " + accumulateRes.getMsg());
    }
}
