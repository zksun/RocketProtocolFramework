package com.rocket.framework.reflect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zksun on 2019/7/9.
 */
public class ClassScanner {

    private final static ClassScanner instance = new ClassScanner();

    private final static Map<Class<?>, ClazzComb> CLAZZ_COMB_MAP = new ConcurrentHashMap<>();

    private ClassScanner() {

    }

    public static ClassScanner getInstance() {
        return instance;
    }

    public ClazzComb getClazzDesc(Class<?> clazz) {
        if (null == clazz) {
            throw new NullPointerException("clazz cannot be null");
        }

        ClazzComb clazzComb = CLAZZ_COMB_MAP.get(clazz);
        if (null == clazzComb) {
            CLAZZ_COMB_MAP.put(clazz, new ClazzComb(clazz));
            return CLAZZ_COMB_MAP.get(clazz);
        }

        return clazzComb;
    }


}
