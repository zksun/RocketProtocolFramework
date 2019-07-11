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
        Object returnValue = invoker.invoke("complexMethod", new String[]{"one", "two", "three"});
        System.out.println(returnValue);
    }

    @Test
    public void invokerTest1() {
        Invoker invoker = InvokerFactory.getInvoker(new InvokerTestBean());
        invoker.invoke("setSomething", new String[]{"hello world"});
        String returnValue = (String) invoker.invoke("getSomething", null);
        System.out.println(returnValue);
    }

}
