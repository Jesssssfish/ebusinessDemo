package com.eb.gc.eborderserver.service;

import com.eb.gc.common.ResultInfo;
import com.eb.gc.eborderserver.service.impl.StorageServiceFailure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author: gc
 * Date: 2020/3/11 14:46
 * Description: TODO
 */
@FeignClient(name = "eb-storage-server",fallback = StorageServiceFailure.class)
public interface StorageService {

    @GetMapping("/storage/send/{id}")
    ResultInfo send(@PathVariable("id") Long id);
}
