package com.eb.gc.eborderserver.controller;

import com.eb.gc.common.ResultInfo;
import com.eb.gc.eborderserver.annotation.Log;
import com.eb.gc.eborderserver.common.enums.BusinessType;
import com.eb.gc.eborderserver.service.AccumulateService;
import com.eb.gc.eborderserver.service.InventoryService;
import com.eb.gc.eborderserver.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Author: gc
 * Date: 2020/3/11 15:04
 * Description: TODO
 */
@RestController
@RequestMapping("/order")
@RefreshScope
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

    @Value("${eb.config.test1}")
    private String test1;

    @Value("${eb.config.test2}")
    private String test2;

    /**
     * 下单
     *
     * @param id 商品ID
     * @return
     */
    @Log(title = "下单", businessType = BusinessType.UPDATE)
    @GetMapping("/doOrder/{id}")
    @ResponseBody
    public ResultInfo doOrder(@PathVariable("id") Long id) {
        ResultInfo inventoryRes = inventoryService.cut(id);
        ResultInfo storageRes = storageService.send(id);
        ResultInfo accumulateRes = accumulateService.increase(id);
        String configMsg = "test1:" + test1 + " && test2:" + test2;
        return ResultInfo.success(inventoryRes.getMsg() + " | " + storageRes.getMsg() + " | " + accumulateRes.getMsg
                () + " | " + configMsg);
    }

    @Log(title = "新增订单", businessType = BusinessType.ADD)
    @RequestMapping("/add/{id}")
    public ResultInfo add(@PathVariable("id") Long id) {
        return ResultInfo.success("新增成功 ID：" + id);
    }

    @Log(title = "删除订单", businessType = BusinessType.DELETE)
    @RequestMapping("/del/{id}")
    public ResultInfo del(@PathVariable("id") Long id) {
        throw new NullPointerException("空");
        //return ResultInfo.success("删除成功 ID：" + id);
    }
}
