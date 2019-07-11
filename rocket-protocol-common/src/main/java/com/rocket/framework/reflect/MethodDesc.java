package com.rocket.framework.reflect;

import java.lang.reflect.Method;

/**
 * Created by zksun on 2019/7/9.
 */
public class MethodDesc {

    private Method source;
    private Class<?> returnType;
    private Class<?>[] parameterTypes;

    private String methodName;

    public MethodDesc(Method source) {
        this.source = source;
        this.returnType = source.getReturnType();
        this.parameterTypes = source.getParameterTypes();
        this.methodName = source.getName();
    }

    public boolean isVoid() {
        Class<?> returnType = this.source.getReturnType();
        if (Void.TYPE.equals(returnType)) {
            return true;
        }
        return false;
    }

    public boolean hasParameter() {
        return this.source.getParameterCount() > 0 ? true : false;
    }


    public Class<?> returnType() {
        return this.returnType;
    }

    public Class<?>[] parameterTypes() {
        if (!hasParameter()) {
            return new Class[0];
        } else {
            return this.parameterTypes;
        }
    }

    public String getMethodName() {
        return methodName;
    }

    public Method getSource() {
        return source;
    }
}
