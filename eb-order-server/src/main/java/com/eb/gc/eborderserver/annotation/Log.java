package com.eb.gc.eborderserver.annotation;

import com.eb.gc.eborderserver.common.enums.BusinessType;

import java.lang.annotation.*;

/**
 * Author: gc
 * Date: 2020/3/17 11:00
 * Description: 自定义日志操作注解
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    /**
     * 操作模块
     *
     * @return
     */
    public String title() default "";

    /**
     * 操作类型
     *
     * @return
     */
    public BusinessType businessType() default BusinessType.OTHER;
}
