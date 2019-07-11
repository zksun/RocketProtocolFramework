package com.rocket.framework.reflect;

/**
 * Created by zksun on 2019/7/11.
 */
public interface Invoker {
    Object invoke(String methodName, Object[] params);
}
