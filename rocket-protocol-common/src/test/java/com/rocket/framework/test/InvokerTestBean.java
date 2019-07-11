package com.rocket.framework.test;

/**
 * Created by zksun on 2019/7/11.
 */
public class InvokerTestBean {

    private String something;

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public void complexMethod(String arg1, String arg2, String arg3) {
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
    }

}
