package com.eb.gc.eborderserver.service.impl;

import com.eb.gc.common.ResultInfo;
import com.eb.gc.eborderserver.service.AccumulateService;
import org.springframework.stereotype.Component;

/**
 * Author: gc
 * Date: 2020/3/11 15:03
 * Description: TODO
 */
@Component
public class AccumulateServiceFailure implements AccumulateService {
    @Override
    public ResultInfo increase(Long id) {
        return ResultInfo.fail("积分中心系统故障,商品ID：" + id);
    }
}
