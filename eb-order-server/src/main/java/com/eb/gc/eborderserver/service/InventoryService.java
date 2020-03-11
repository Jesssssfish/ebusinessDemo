package com.eb.gc.eborderserver.service;

import com.eb.gc.common.ResultInfo;
import com.eb.gc.eborderserver.service.impl.InventoryServiceFailure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author: gc
 * Date: 2020/3/11 14:46
 * Description: TODO
 */
@FeignClient(name = "EB-INVENTORY-SERVER",fallback = InventoryServiceFailure.class)
public interface InventoryService {
    @GetMapping("/inventory/cut/{id}")
    ResultInfo cut(@PathVariable("id") Long id);
}
