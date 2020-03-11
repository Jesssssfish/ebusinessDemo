package com.eb.gc.eborderserver.service.impl;

import com.eb.gc.common.ResultInfo;
import com.eb.gc.eborderserver.service.InventoryService;
import org.springframework.stereotype.Component;

/**
 * Author: gc
 * Date: 2020/3/11 15:00
 * Description: TODO
 */
@Component
public class InventoryServiceFailure implements InventoryService {
    @Override
    public ResultInfo cut(Long id) {
        return ResultInfo.fail("库存中心系统故障,商品ID：" + id);
    }
}
