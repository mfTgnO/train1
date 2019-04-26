package com.example.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Package: com.example.demo.annotation
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-26 18:09
 * @Description:
 */
public class AnnotationParsing {
    public static void main(String[] args) {
        try {
            for (Method method : AnnotationParsing.class.getClassLoader().loadClass(("com.example.demo.annotation.AnnotationExample")).getMethods()) {
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        for (Annotation annotation : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '" + method + "' : " + annotation);
                        }
                        MethodInfo methodAnnotation = method.getAnnotation(MethodInfo.class);
                        if (methodAnnotation.revision() == 1) {
                            System.out.println("Method with revision no 1 = " + method);
                        }
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
