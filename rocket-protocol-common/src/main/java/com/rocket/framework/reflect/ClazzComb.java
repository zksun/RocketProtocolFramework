package com.rocket.framework.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zksun on 2019/7/9.
 */
public class ClazzComb {

    private final Class<?> source;

    private String className;

    private MethodDesc[] methodDescs;

    public ClazzComb(Class<?> clazz) {
        this.source = clazz;
        this.className = clazz.getSimpleName();
        Method[] methods = this.source.getDeclaredMethods();
        if (methods.length > 0) {
            List list = new ArrayList();
            //new MethodDesc[methods.length];
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                if (method.getModifiers() == Modifier.PUBLIC) {
                    list.add(new MethodDesc(method));
                }
            }
            this.methodDescs = (MethodDesc[]) list.toArray(new MethodDesc[list.size()]);
        }
    }

    public MethodDesc[] getMethodDescs() {
        return methodDescs;
    }

    public String getClassName() {
        return className;
    }
}
