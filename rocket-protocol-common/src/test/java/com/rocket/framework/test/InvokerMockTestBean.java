package com.rocket.framework.test;

/**
 * Created by hanshou on 2019/7/26.
 */
public class InvokerMockTestBean {
    private final InvokerOverloadTestBean invoker;

    public InvokerMockTestBean(InvokerOverloadTestBean invoker) {
        this.invoker = invoker;
    }

    public Object invoke(String methodName, Object[] params, Class<?>[] parameterTypes) {
        if (methodName.equals("doSomething")) {
            if (this.check_doSomething_params_0(params, parameterTypes)) {
                this.invoker.doSomething(((Integer) params[0]).intValue(), (String) params[1]);
                return null;
            } else if (this.check_doSomething_params_1(params, parameterTypes)) {
                this.invoker.doSomething((String) params[0], ((Integer) params[1]).intValue());
                return null;
            } else if (this.check_doSomething_params_2(params, parameterTypes)) {
                this.invoker.doSomething((Integer) params[0], (String) params[1]);
                return null;
            } else if (this.check_doSomething_params_3(params)) {
                this.invoker.doSomething();
                return null;
            } else {
                throw new IllegalArgumentException("this method does not match these parameters");
            }
        } else if (methodName.equals("getSomething")) {
            this.invoker.getSomething((String) params[0]);
            return null;
        } else {
            throw new IllegalArgumentException("no method with this method name");
        }
    }

    private boolean check_doSomething_params_0(Object[] params, Class<?>[] parameterTypes) {
        if (null != params && params.length == 2) {
            if (!params[0].getClass().getTypeName().equals(String.class.getTypeName())) {
                return false;
            } else {
                try {
                    ((Integer) params[1]).intValue();
                } catch (ClassCastException ex) {
                    return false;
                }
                return parameterTypes[1].getTypeName().equals(Integer.TYPE.getTypeName());
            }
        } else {
            return false;
        }
    }

    private boolean check_doSomething_params_1(Object[] params, Class<?>[] parameterTypes) {
        return null != params && params.length == 2 ? (!params[0].getClass().getTypeName().equals(String.class.getTypeName()) ? false : Integer.TYPE.getTypeName().equals(Integer.TYPE.getTypeName())) : false;
    }

    private boolean check_doSomething_params_2(Object[] params, Class<?>[] parameterTypes) {
        return null != params && params.length == 2 ? (!params[0].getClass().getTypeName().equals(Integer.class.getTypeName()) ? false : params[1].getClass().getTypeName().equals(String.class.getTypeName())) : false;
    }

    private boolean check_doSomething_params_3(Object[] params) {
        return null == params;
    }
}
