package com.example.demo.reflection.demo1;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
     *
     * Below call will return the field from BaseInterface that is implemented by
     * ConcreteClass. If there is no field found then it throws NoSuchFieldException.
     * */
    @Test
    public void test14() throws ClassNotFoundException, NoSuchFieldException {
        Field field = Class.forName("com.example.demo.reflection.demo1.ConcreteClass").getField("interfaceInt");
        System.out.println(field);
    }

    /*
     * Field Declaring Class
     *
     * We can use getDeclaringClass() of field object to get the class declaring the field.
     * */
    @Test
    public void test15() {
        try {
            Field field = Class.forName("com.example.demo.reflection.demo1.ConcreteClass").getField("interfaceInt");
            Class<?> fieldClass = field.getDeclaringClass();
            System.out.println(fieldClass.getCanonicalName()); //prints com.journaldev.reflection.BaseInterface
        } catch (NoSuchFieldException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * Get Field Type
     *
     * getType() method returns the Class object for the declared field type, if field is primitive type, it returns the wrapper class object.
     * */
    @Test
    public void test16() throws ClassNotFoundException, NoSuchFieldException {
        Field field = Class.forName("com.example.demo.reflection.demo1.ConcreteClass").getField("publicInt");
        Class<?> fieldType = field.getType();
        System.out.println(fieldType.getCanonicalName()); //prints int
    }

    /*
     * Get/Set Public Field Value
     *
     * We can get and set the value of a field in an Object using reflection.
     *
     * get() method return Object, so if field is primitive type, it returns the corresponsing
     * Wrapper Class. If the field is static, we can pass Object as null in get() method.
     *
     * There are several set*() methods to set Object to the field or set different types of
     * primitive types to the field. We can get the type of field and then invoke correct function
     * to set the field value correctly. If the field is final, the set()
     * methods throw java.lang.IllegalAccessException.
     * */
    @Test
    public void test17() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        Field field = Class.forName("com.example.demo.reflection.demo1.ConcreteClass").getField("publicInt");
        ConcreteClass obj = new ConcreteClass(5);
        System.out.println(field.get(obj)); //prints 5
        field.setInt(obj, 10); //setting field value to 10 in object
        System.out.println(field.get(obj)); //prints 10
    }

    /*
     * Get/Set Private Field Value
     *
     * We know that private fields and methods can’t be accessible outside of the class but using
     * reflection we can get/set the private field value by turning off the java access check for field modifiers.
     * */
    @Test
    public void test18() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        Field privateField = Class.forName("com.example.demo.reflection.demo1.ConcreteClass").getDeclaredField("privateString");
        //turning off access check with below method call
        privateField.setAccessible(true);
        ConcreteClass objTest = new ConcreteClass(1);
        System.out.println(privateField.get(objTest)); // prints "private string"
        privateField.set(objTest, "private string updated");
        System.out.println(privateField.get(objTest)); //prints "private string updated"
    }

    /*
     * Java Reflection for Methods
     * Using reflection we can get information about a method and we can invoke it also.
     * In this section, we will learn different ways to get a method, invoke a method and accessing private methods.
     *
     * Get Public Method
     * We can use getMethod() to get a public method of class, we need to pass the method name
     * and parameter types of the method. If the method is not found in the class, reflection
     * API looks for the method in superclass.
     * In below example, I am getting put() method of HashMap using reflection. The example
     * also shows how to get the parameter types, method modifiers and return type of a method.
     * */
    @Test
    public void test19() throws ClassNotFoundException, NoSuchMethodException {
        Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
        //get method parameter types, prints "[class java.lang.Object, class java.lang.Object]"
        System.out.println(Arrays.toString(method.getParameterTypes()));
        //get method return type, return "class java.lang.Object", class reference for void
        System.out.println(method.getReturnType());
        //get method modifiers
        System.out.println(Modifier.toString(method.getModifiers())); //prints "public"
    }

    /*
     * Invoking Public Method
     *
     * We can use invoke() method of Method object to invoke a method, in below example code I am invoking put method on HashMap using reflection.
     *
     * If the method is static, we can pass NULL as object argument.
     * */
    @Test
    public void test20() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
        Map<String, String> hm = new HashMap<>();
        method.invoke(hm, "key", "value");
        System.out.println(hm); // prints {key=value}
    }

    /*
     * Invoking Private Methods
     *
     * We can use getDeclaredMethod() to get the private method and then turn off the access check to invoke it, below example shows how we can invoke method3() of BaseClass that is static and have no parameters.
     * */
    @Test
    public void test21() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //invoking private method
        Method method = Class.forName("com.journaldev.reflection.BaseClass").getDeclaredMethod("method3", null);
        method.setAccessible(true);
        method.invoke(null, null); //prints "Method3"
    }

    /*
     * Java Reflection for Constructors
     * Reflection API provides methods to get the constructors of a class to analyze and we can create new
     * instances of class by invoking the constructor. We have already learned how to get all the public constructors.
     *
     * Get Public Constructor
     * We can use getConstructor() method on the class representation of object to get specific public constructor.
     * Below example shows how to get the constructor of ConcreteClass defined above and the no-argument constructor
     * of HashMap. It also shows how to get the array of parameter types for the constructor.
     * */
    @Test
    public void test22() throws ClassNotFoundException, NoSuchMethodException {
        Constructor<?> constructor = Class.forName("com.journaldev.reflection.ConcreteClass").getConstructor(int.class);
        //getting constructor parameters
        System.out.println(Arrays.toString(constructor.getParameterTypes())); // prints "[int]"

        Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap").getConstructor(null);
        System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes())); // prints "[]"
    }

    /*
     * Instantiate Object using Constructor
     *
     * We can use newInstance() method on the constructor object to instantiate a new instance of the class.
     * Since we use reflection when we don’t have the classes information at compile time, we can assign it
     * to Object and then further use reflection to access it’s fields and invoke it’s methods.
     * */
    @Test
    public void test23() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = Class.forName("com.journaldev.reflection.ConcreteClass").getConstructor(int.class);
        //getting constructor parameters
        System.out.println(Arrays.toString(constructor.getParameterTypes())); // prints "[int]"

        Object myObj = constructor.newInstance(10);
        Method myObjMethod = myObj.getClass().getMethod("method1", null);
        myObjMethod.invoke(myObj, null); //prints "Method1 impl."

        Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap").getConstructor(null);
        System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes())); // prints "[]"
        HashMap<String, String> myMap = (HashMap<String, String>) hashMapConstructor.newInstance(null);
    }

    /*
     * Reflection for Annotations
     *
     * Annotations was introduced in Java 1.5 to provide metadata information of the class,
     * methods or fields and now it’s heavily used in frameworks like Spring and Hibernate.
     * Reflection API was also extended to provide support to analyze the annotations at runtime.
     *
     * Using reflection API we can analyze annotations whose retention policy is Runtime.
     * I have already written a detailed tutorial on annotations and how we can use reflection
     * API to parse annotations, so I would suggest you to check out Java Annotations Tutorial.
     *
     * Thats all for java reflection example tutorial, I hope you liked the tutorial
     * and understood the importance of Java Reflection API.
     * */
}
