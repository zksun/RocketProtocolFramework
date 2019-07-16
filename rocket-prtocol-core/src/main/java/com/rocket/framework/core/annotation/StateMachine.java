package com.rocket.framework.core.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by zksun on 2019/7/12.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface StateMachine {
}
