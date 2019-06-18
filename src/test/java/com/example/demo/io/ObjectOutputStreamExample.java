package com.example.demo.io;

import com.example.demo.io.bean.Employee;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @package: com.example.demo.io
 * @author:
 * @email:
 * @createDate: 2019-06-13 20:34
 * @description: ObjectOutputStream in Java can be used to convert an object to OutputStream.
 * The process of converting object to stream is called serialization in java.
 * <p>
 * Once an object is converted to Output Stream, it can be saved to file or database,
 * send over the network or used in socket connections. So we can use FileOutputStream to write Object to file.
 */
public class ObjectOutputStreamExample {
    /**
     * ObjectOutputStream is part of Java IO classes and it’s whole purpose is to provide us a way
     * to convert java object to stream. When we create instance of ObjectOutputStream, we have to
     * provide the OutputStream to be used. This OutputStream is further used by ObjectOutputStream to
     * channel the object stream to underlying output stream, for example FileOutputStream.
     * <p>
     * The object that we want to serialize should implement java.io.Serializable interface.
     * Serializable is just a marker interface and doesn’t have any abstract method that we have to
     * implement. We will get java.io.NotSerializableException if the class doesn’t implement
     * Serializable interface. Something like below exception stack trace.
     * <p>
     * If we don’t want some object property to be converted to stream, we have to use transient
     * keyword for that. For example, just change the role property like below and it will not be saved.
     * private transient String role;
     * <p>
     * Did you noticed the serialVersionUID defined in the Employee object? It’s used by ObjectOutputStream
     * and ObjectInputStream classes for write and read object operations. Although it’s not mandatory to have
     * this field, but you should keep it. Otherwise anytime you change your class that don’t have effect on
     * earlier serialized objects, it will start failing. For a detailed analysis, go over to Serialization in Java.
     * <p>
     * If you are wondering whether our program worked fine or not, use below code to read object from the saved file.
     */
    @Test
    public void test1() {
        Employee employee = new Employee("a", "b", 1);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("EmployeeObject.ser");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(employee);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * How to read Object from File in Java
     */
    @Test
    public void test2() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("EmployeeObject.ser");
            ois = new ObjectInputStream(fis);

            Employee employee = (Employee) ois.readObject();
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
