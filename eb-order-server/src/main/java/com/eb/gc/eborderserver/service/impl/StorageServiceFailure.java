package com.eb.gc.eborderserver.service.impl;

import com.eb.gc.common.ResultInfo;
import com.eb.gc.eborderserver.service.StorageService;
import org.springframework.stereotype.Component;

/**
 * Author: gc
 * Date: 2020/3/11 14:49
 * Description: TODO
 */
@Component
public class StorageServiceFailure implements StorageService {
    @Override
    public ResultInfo send(Long id) {
        return ResultInfo.fail("仓储中心系统故障,商品ID：" + id);
    }
}
