package com.rocket.framework.test;

import com.rocket.framework.reflect.Invoker;
import com.rocket.framework.reflect.InvokerFactory;
import org.junit.Test;

/**
 * Created by zksun on 2019/7/11.
 */
public class InvokerTest {

    @Test
    public void invokerTest0() {
        Invoker invoker = InvokerFactory.getInvoker(new InvokerTestBean());
        Object returnValue = invoker.invoke("complexMethod", new String[]{"one", "two", "three"}, new Class<?>[]{String.class, String.class, String.class});
        System.out.println(returnValue);
    }

    @Test
    public void invokerTest1() {
        Invoker invoker = InvokerFactory.getInvoker(new InvokerTestBean());
        invoker.invoke("setSomething", new String[]{"hello world"}, new Class[]{String.class});
        String returnValue = (String) invoker.invoke("getSomething", null, null);
        System.out.println(returnValue);
    }

    @Test
    public void invokerTest2() {
        Invoker invoker = InvokerFactory.getInvoker(new InvokerOverloadTestBean());
        Object doSomething = invoker.invoke("doSomething", null, null);
        System.out.println(doSomething);
    }

}
