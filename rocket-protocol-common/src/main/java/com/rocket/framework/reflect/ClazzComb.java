package com.rocket.framework.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zksun on 2019/7/9.
 */
public class ClazzComb {

    private final static Map<Class<?>, ClazzComb> METASPACE = new HashMap();

    private final Class<?> source;

    private String className;

    private MethodDesc[] methodDescs;

    public ClazzComb(Class<?> clazz) {
        this.source = clazz;
        this.className = clazz.getSimpleName();
        Method[] methods = this.source.getDeclaredMethods();
        if (methods.length > 0) {
            List<MethodDesc> list = new ArrayList();
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                if (method.getModifiers() == Modifier.PUBLIC) {
                    if (null == lookup(method.getName(), list)) {
                        list.add(new MethodDesc(method));
                    } else {
                        MethodDesc lookup = lookup(method.getName(), list);
                        lookup.addOverLoad(method);
                    }
                }
            }
            this.methodDescs = (MethodDesc[]) list.toArray(new MethodDesc[list.size()]);
        }
        METASPACE.put(clazz, this);
    }

    private MethodDesc lookup(String methodName, List<MethodDesc> list) {
        if (null == list || list.size() < 1) {
            return null;
        }
        for (MethodDesc methodDesc : list) {
            if (methodDesc.getMethodName().equals(methodName)) {
                return methodDesc;
            }
        }
        return null;
    }

    public MethodDesc[] getMethodDescs() {
        return methodDescs;
    }

    public String getClassName() {
        return className;
    }
}
