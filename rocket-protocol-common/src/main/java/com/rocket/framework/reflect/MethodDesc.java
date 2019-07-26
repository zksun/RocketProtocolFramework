package com.rocket.framework.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zksun on 2019/7/9.
 */
public class MethodDesc {

    private Method source;
    private Class<?> returnType;
    private Class<?>[] parameterTypes;

    private String methodName;

    private boolean overLoad;
    private List<MethodDesc> overLoads;

    private int parameterCount;

    public MethodDesc(Method source) {
        this(source, false);
    }

    public MethodDesc(Method source, boolean overLoad) {
        this.source = source;
        this.returnType = source.getReturnType();
        this.parameterTypes = source.getParameterTypes();
        this.methodName = source.getName();
        this.overLoad = overLoad;
        this.parameterCount = source.getParameterCount();
    }

    void addOverLoad(Method source) {
        synchronized (source) {
            if (null == overLoads) {
                overLoads = new ArrayList<>();
            }
            overLoads.add(new MethodDesc(source, true));
        }
        overLoad = true;
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

    public boolean isOverLoad() {
        return overLoad;
    }

    public MethodDesc[] getOverLoads() {
        if (overLoad) {
            return overLoads.toArray(new MethodDesc[this.overLoads.size()]);
        }
        throw new UnsupportedOperationException("not a overLoad method");
    }

    public MethodDesc[] getAll() {
        if (!overLoad) {
            return new MethodDesc[]{this};
        } else {
            MethodDesc[] overLoads = getOverLoads();
            List<MethodDesc> all = new ArrayList<>();
            all.add(this);
            for (MethodDesc overLoad : overLoads) {
                all.add(overLoad);
            }
            return all.toArray(new MethodDesc[all.size()]);
        }
    }

    public int getParameterCount() {
        return parameterCount;
    }

}
