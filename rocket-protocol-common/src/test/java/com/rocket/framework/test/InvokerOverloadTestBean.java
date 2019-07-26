package com.rocket.framework.test;

/**
 * Created by zksun on 2019/7/26.
 */
public class InvokerOverloadTestBean {

    public void getSomething(String something) {

    }

    public void doSomething() {
        System.out.println("do something without parameters");
    }

    public void doSomething(int seq, String something) {
        System.out.printf("do something with parameter: int %d, String %s%n", seq, something);
    }

    public void doSomething(String something, int seq) {
        System.out.printf("do something with parameter: String %s, int %d%n", something, seq);
    }

    public void doSomething(Integer seq, String something) {
        System.out.printf("do something with parameter: Integer %d, String %s%n", seq, something);
    }
}
