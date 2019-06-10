package com.example.demo.reflection.demo1;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @package: com.example.demo.reflection.demo1
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:35
 * @description:
 */
public class ReflectionDemo {
    /*
     * Get Class Object
     *
     * We can get Class of an object using three methods – through static variable class,
     * using getClass() method of object and java.lang.Class.forName(String fullyClassifiedClassName).
     * For primitive types and arrays, we can use static variable class. Wrapper classes provide
     * another static variable TYPE to get the class.
     *
     * getCanonicalName() returns the canonical name of the underlying class. Notice that
     * java.lang.Class uses Generics, it helps frameworks in making sure that the Class retrieved
     * is subclass of framework Base Class. Check out Java Generics Tutorial to learn about generics and its wildcards.
     * */
    @Test
    public void getClassObjectTest() throws ClassNotFoundException {
        // Get Class using reflection
        Class<?> concreteClass = ConcreteClass.class;
        concreteClass = new ConcreteClass(5).getClass();
        try {
            // below method is used most of the times in frameworks like JUnit
            //Spring dependency injection, Tomcat web container
            //Eclipse auto completion of method names, hibernate, Struts2 etc.
            //because ConcreteClass is not available at compile time
            concreteClass = Class.forName("com.example.demo.reflection.demo1.ConcreteClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(concreteClass.getCanonicalName()); // prints com.journaldev.reflection.ConcreteClass

        //for primitive types, wrapper classes and arrays
        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName()); // prints boolean

        Class<?> cDouble = Double.TYPE;
        System.out.println(cDouble.getCanonicalName()); // prints double

        Class<?> cDoubleArray = Class.forName("[D");
        System.out.println(cDoubleArray.getCanonicalName()); //prints double[]

        Class<?> twoDStringArray = String[][].class;
        System.out.println(twoDStringArray.getCanonicalName()); // prints java.lang.String[][]
    }

    /*
     * Get Super Class
     *
     * getSuperclass() method on a Class object returns the super class of the class.
     * If this Class represents either the Object class, an interface, a primitive type,
     * or void, then null is returned. If this object represents an array class then the Class
     * object representing the Object class is returned.
     * */
    @Test
    public void test2() throws ClassNotFoundException {
        Class<?> superClass = Class.forName("com.example.demo.reflection.demo1.ConcreteClass").getSuperclass();
        System.out.println(superClass); // prints "class com.journaldev.reflection.BaseClass"
        System.out.println(Object.class.getSuperclass()); // prints "null"
        System.out.println(String[][].class.getSuperclass());// prints "class java.lang.Object"

    }

    /*
     * Get Public Member Classes
     *
     * getClasses() method of a Class representation of object returns an array containing Class
     * objects representing all the public classes, interfaces and enums that are members of the
     * class represented by this Class object. This includes public class and interface members
     * inherited from superclasses and public class and interface members declared by the class.
     * This method returns an array of length 0 if this Class object has no public member classes or
     * interfaces or if this Class object represents a primitive type, an array class, or void.
     * */
    @Test
    public void test3() throws ClassNotFoundException {
        Class<?> concreteClass = Class.forName("com.example.demo.reflection.demo1.ConcreteClass");
        Class<?>[] classes = concreteClass.getClasses();
//[class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicClass,
//class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicEnum,
//interface com.journaldev.reflection.ConcreteClass$ConcreteClassPublicInterface,
//class com.journaldev.reflection.BaseClass$BaseClassInnerClass,
//class com.journaldev.reflection.BaseClass$BaseClassMemberEnum]
        for (int i = 0; i < classes.length; i++) {
            System.out.println(classes[i]);
        }
    }

    /*
     * Get Declared Classes
     *
     * getDeclaredClasses() method returns an array of Class objects reflecting all the classes
     * and interfaces declared as members of the class represented by this Class object. The returned
     * array doesn’t include classes declared in inherited classes and interfaces.
     * */
    @Test
    public void test4() throws ClassNotFoundException {
        //getting all of the classes, interfaces, and enums that are explicitly declared in ConcreteClass
        Class<?>[] explicitClasses = Class.forName("com.example.demo.reflection.demo1.ConcreteClass").getDeclaredClasses();
        //prints [class com.journaldev.reflection.ConcreteClass$ConcreteClassDefaultClass,
        //class com.journaldev.reflection.ConcreteClass$ConcreteClassDefaultEnum,
        //class com.journaldev.reflection.ConcreteClass$ConcreteClassPrivateClass,
        //class com.journaldev.reflection.ConcreteClass$ConcreteClassProtectedClass,
        //class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicClass,
        //class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicEnum,
        //interface com.journaldev.reflection.ConcreteClass$ConcreteClassPublicInterface]
        for (int i = 0; i < explicitClasses.length; i++) {
            System.out.println(explicitClasses[i]);
        }
    }

    /*
     * Get Declaring Class
     *
     * getDeclaringClass() method returns the Class object representing the class in which it was declared.
     * */
    @Test
    public void test5() throws ClassNotFoundException {
        Class<?> innerClass = Class.forName("com.example.demo.reflection.demo1.ConcreteClass$ConcreteClassDefaultClass");
        //prints com.journaldev.reflection.ConcreteClass
        System.out.println(innerClass.getDeclaringClass().getCanonicalName());
        System.out.println(innerClass.getEnclosingClass().getCanonicalName());
    }

    /*
     * Getting Package Name
     *
     * getPackage() method returns the package for this class. The class loader of this class is
     * used to find the package. We can invoke getName() method of Package to get the name of the package.
     * */
    @Test
    public void test6() throws ClassNotFoundException {
        //prints "com.journaldev.reflection"
        System.out.println(Class.forName("com.example.demo.reflection.demo1.BaseInterface").getPackage().getName());
    }

    /*
     * Getting Class Modifiers
     *
     * getModifiers() method returns the int representation of the class modifiers, we can
     * use java.lang.reflect.Modifier.toString() method to get it in the string format as used in source code.
     * */
    @Test
    public void test7() throws ClassNotFoundException {
        Class<?> concreteClass = Class.forName("com.example.demo.reflection.demo1.ConcreteClass");
        System.out.println(Modifier.toString(concreteClass.getModifiers())); //prints "public"
        //prints "public abstract interface"
        System.out.println(Modifier.toString(Class.forName("com.example.demo.reflection.demo1.BaseInterface").getModifiers()));
    }

    /*
     * Get Type Parameters
     *
     * getTypeParameters() returns the array of TypeVariable if there are any Type parameters associated
     * with the class. The type parameters are returned in the same order as declared.
     * */
    @Test
    public void test8() throws ClassNotFoundException {
        //Get Type parameters (generics)
        TypeVariable<?>[] typeParameters = Class.forName("java.util.HashMap").getTypeParameters();
        for (TypeVariable<?> t : typeParameters)
            System.out.print(t.getName() + ",");
    }

    /*
     * Get Implemented Interfaces
     *
     * getGenericInterfaces() method returns the array of interfaces implemented by the class with
     * generic type information. We can also use getInterfaces() to get the class representation of all the implemented interfaces.
     * */
    @Test
    public void test9() throws ClassNotFoundException {
        Type[] interfaces = Class.forName("java.util.HashMap").getGenericInterfaces();
        //prints "[java.util.Map<K, V>, interface java.lang.Cloneable, interface java.io.Serializable]"
        System.out.println(Arrays.toString(interfaces));
        //prints "[interface java.util.Map, interface java.lang.Cloneable, interface java.io.Serializable]"
        System.out.println(Arrays.toString(Class.forName("java.util.HashMap").getInterfaces()));
    }

    /*
     * Get All Public Methods
     *
     * getMethods() method returns the array of public methods of the Class including public
     * methods of it’s superclasses and super interfaces.
     * */
    @Test
    public void test10() throws ClassNotFoundException {
        Method[] publicMethods = Class.forName("com.example.demo.reflection.demo1.ConcreteClass").getMethods();
        //prints public methods of ConcreteClass, BaseClass, Object
        for (int i = 0; i < publicMethods.length; i++) {
            System.out.println(publicMethods[i]);
        }
    }

    /*
     * Get All Public Constructors
     *
     * getConstructors() method returns the list of public constructors of the class reference of object.
     * */
    @Test
    public void test11() throws ClassNotFoundException {
        //Get All public constructors
        Constructor<?>[] publicConstructors = Class.forName("com.example.demo.reflection.demo1.ConcreteClass").getConstructors();
        //prints public constructors of ConcreteClass
        System.out.println(Arrays.toString(publicConstructors));
    }

    /*
     * Get All Public Fields
     *
     * getFields() method returns the array of public fields of the class including public fields of it’s super classes and super interfaces.
     * */
    @Test
    public void test12() throws ClassNotFoundException {
        //Get All public fields
        Field[] publicFields = Class.forName("com.example.demo.reflection.demo1.ConcreteClass").getFields();
        //prints public fields of ConcreteClass, it's superclass and super interfaces
        for (int i = 0; i < publicFields.length; i++) {
            System.out.println(publicFields[i]);
        }
    }

    /*
     * Get All Annotations
     *
     * getAnnotations() method returns all the annotations for the element, we can use it with class,
     * fields and methods also. Note that only annotations available with reflection are with retention
     * policy of RUNTIME, check out Java Annotations Tutorial.
     * We will look into this in more details in later sections.
     * */
    @Test
    public void test13() throws ClassNotFoundException {
        java.lang.annotation.Annotation[] annotations = Class.forName("com.example.demo.reflection.demo1.ConcreteClass").getAnnotations();
        //prints [@java.lang.Deprecated()]
        System.out.println(Arrays.toString(annotations));
    }

    /*
     * Get Public Field
     *
     * In last section, we saw how to get the list of all the public fields of a class.
     * Reflection API also provides method to get specific public field of a class through getField() method.
     * This method look for the field in the specified class reference and then in the super interfaces and then in the super classes.
     * */
    @Test
    public void test14() throws ClassNotFoundException, NoSuchFieldException {
        Field field = Class.forName("com.example.demo.reflection.demo1.ConcreteClass").getField("interfaceInt");
        System.out.println(field);
    }
}
