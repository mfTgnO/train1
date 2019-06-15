package com.example.demo.dynamicproxies;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @package: com.example.demo.dynamicproxies
 * @author:
 * @email:
 * @createDate: 2019-06-15 14:08
 * @description: Creating Proxy Instance
 * A proxy instance serviced by the invocation handler we have just defined is created via a factory method call on the java.lang.reflect.Proxy class:
 */
public class DynamicProxyTest {
    @Test
    public void test1() {
        Map proxyInstance = (Map) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(), new Class[]{Map.class}, new DynamicInvocationHandler());
        // Once we have a proxy instance we can invoke its interface methods as normal:
        // As expected a message about put() method being invoked is printed out in the log file.
        proxyInstance.put("hello", "hello");
    }

    /**
     * Invocation Handler via Lambda Expressions
     * <p>
     * Since InvocationHandler is a functional interface, it is possible to define the handler inline using lambda expression:
     */
    @Test
    public void test2() {
        Map proxyInstance = (Map) Proxy.newProxyInstance(
                DynamicProxyTest.class.getClassLoader(),
                new Class[]{Map.class},
                (proxy, method, methodArgs) -> {
                    if (method.getName().equals("get")) {
                        return 42;
                    } else {
                        throw new UnsupportedOperationException(
                                "Unsupported method: " + method.getName());
                    }
                });
        int result = (int) proxyInstance.get("hello");// 42
        System.out.println(result);
        proxyInstance.put("hello", "world"); // exception
    }

    @Test
    public void test3() {
        Map mapProxyInstance = (Map) Proxy.newProxyInstance(
                DynamicProxyTest.class.getClassLoader(), new Class[] { Map.class },
                new TimingDynamicInvocationHandler(new HashMap<>()));

        mapProxyInstance.put("hello", "world");

        CharSequence csProxyInstance = (CharSequence) Proxy.newProxyInstance(
                DynamicProxyTest.class.getClassLoader(),
                new Class[] { CharSequence.class },
                new TimingDynamicInvocationHandler("Hello World"));

        csProxyInstance.length();
    }
}
