package com.example.demo.foundation;

import org.junit.Test;

import java.util.Scanner;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-25 16:34
 * @description:
 */
public class OperatorDemo {
    /**
     * 取模运算
     */
    @Test
    public void test1() {
        //取模运算就是取余数
        System.out.println(12 % 5);

        //如果左边绝对值小于右边就是本身
        System.out.println(-3 % 5);

        //如果左边绝对值是右边的倍数时,结果为0
        System.out.println(-10 % 5);

        //如果左边的绝对值大于右边,结果是余数,符号取决于左边,右边忽略不计
        System.out.println(13 % -5);

        //一个数模与2结果要么是0,要么是1,可以用来切换条件
        System.out.println(3 % 2);
        int a = 100;
        int b = 30;
        System.out.println(a / b);                //整数与整数运算结果肯定是整数,不能是小数 out : 3
    }

    @Test
    public void test2() {
        int a = 4;
        a++;// a=5
//        a++ 相当于a = a + 1

        //如果++符号放在变量的后面,是先赋值,再自加
        int b = a++;// b=5,a=6

        //无论赋值,还是运算,还是打印都是先将变量里的值拿出来,然后在自身+1
        System.out.println("b = " + b);
        System.out.println(a++);//a=6
        System.out.println(a); //a=7

        a = 4;// a=4
        ++a;//a++和++a单独写没有区别 a=5
        b = ++a;        //如果++符号放在变量的前面,是先自加,然后再赋值 b=6,a=6
        System.out.println("a= " + a);
        System.out.println("b = " + b);
    }

    @Test
    public void test3() {
        int a = 10;
        int b = 10;
        int c = 10;

        a = b++;        //a= 10, b= 11, c= 10
        System.out.println("a= " + a + ", b= " + b + ", c= " + c);
        c = --a;        //a= 9, b= 11, c= 9
        System.out.println("a= " + a + ", b= " + b + ", c= " + c);
        b = ++a;        //a= 10, b= 10, c= 9
        System.out.println("a= " + a + ", b= " + b + ", c= " + c);
        a = c--;        //a= 9, b= 10, c= 8
        System.out.println("a= " + a + ", b= " + b + ", c= " + c);
    }

    @Test
    public void test4() {
        int a = 4;
        // 4+5
        int b = (a++) + (++a) + (a * 10);

        // a= 6, b= 70
        System.out.println("a= " + a + ", b= " + b);
    }

    @Test
    public void test5() {
        int a = 4;
        System.out.println(a++);
        System.out.println(++a);
        System.out.println(a * 10);
    }

    /**
     * 面试题:看下面的程序是否有问题，如果有问题，请指出并说明理由。
     * short s=1;s = s+1;
     * short s=1;s+=1;
     */
    @Test
    public void test6() {
        int a = 10;
        //a += 20;			//a = a + 20;相当于将左右两边相加的结果再赋值给左边,
        //20 += a;			//左边一定是变量
        a *= 20;
        System.out.println(a);

        short s = 1;
        //short类型与int类型进行运算会提升为int类型,结果是int类型,不能赋值给short类型
        //s = s+1;
        // s = (short)(s + 1);+=号是一个赋值运算符,所以为了能够保证赋值成功,会把int类型强转为short类型
        s += 1;
        System.out.println(s);
    }

    /**
     * 1.逻辑运算符和位运算符的具体使用。
     * 2.附带了常问的关于Java的异或面试题。
     * 3.三元运算符的使用，以及和if语句的互转，及其使用的场合
     * 4.顺序结构语句和选择结构语句的使用环境和适用场合。
     * 5.if语句的三种形式介绍以及相关使用细节和注意事项。
     * 6.if语句的嵌套使用。
     * 7.if语句和switch语句的区别
     * 逻辑运算符的基本用法
     * <p>
     * A:逻辑运算符有哪些
     * B:案例演示
     * 逻辑运算符的基本用法
     * 注意事项：
     * a:逻辑运算符一般用于连接boolean类型的表达式或者值。
     * b:表达式：就是用运算符把常量或者变量连接起来的符合java语法的式子。
     * 算术表达式：a + b
     * 比较表达式：a == b(条件表达式)
     * C:结论：
     * &逻辑与:有false则false。
     * |逻辑或:有true则true。
     * ^逻辑异或:相同为false，不同为true。
     * <p>
     * !逻辑非:非false则true，非true则false。
     * 特点：偶数个不改变本身。
     */
    @Test
    public void test7() {
        //逻辑与,左右两边都为真的时候,结果才为真
        int x = 10;
        System.out.println(x == 5 & x == 15);// false
        System.out.println(true & true);// true
        System.out.println(false & true);// false
        System.out.println(true & false);// false
        System.out.println(false & false);// false
        System.out.println("============================");
        //逻辑或,左右两边只要有一个为真,结果为真
        int y = 10;
        System.out.println(y > 10 | y == 10);// true
        System.out.println(true | true);// true
        System.out.println(true | false);// true
        System.out.println(false | true);// true
        System.out.println(false | false);// false
        System.out.println("============================");

        //逻辑异或,左右两边相同,结果为假,左右两边不同结果为真
        System.out.println(true ^ true);// false
        System.out.println(true ^ false);// true
        System.out.println(false ^ true);// true
        System.out.println(false ^ false);// false
        System.out.println("============================");
        //逻辑非!
        System.out.println(!!true);// true
        System.out.println(!!false);// false
    }

    /**
     * 逻辑运算符&&和&的区别
     * A:案例演示
     * &&和&的区别?(面试题)
     * a:最终结果一样。
     * b:&&具有短路效果。左边是false，右边不执行。
     * 		&和&&的区别(面试题)
     * 		&无论左边是true还是false,右边都参与运算
     * 		&&左边如果为false,右边不参与运算,左边如果为true,右边参与运算
     *
     *
     * B:同理||和|的区别?(学生自学)
     *		|和||的区别
     * 		|无论左边是true还是false,右边都参与运算
     * 		||左边如果为true,右边不参与运算,左边如果为false,右边参与运算
     *
     *
     * C:开发中常用谁?
     * &&,||,!
     */

    /**
     * 位运算符的基本用法1
     *
     * A:位运算符有哪些
     * B:案例演示
     *
     *     位运算符的基本用法1
     *     &,|,^,~ 的用法
     *     &:有0则0
     *     |:有1则1
     *     ^:相同则0，不同则1（异或）
     *     ~:按位取反
     */


    /**
     *
     */
    @Test
    public void test8() {
        System.out.println(-6 >> 1);            //向右移动几次就是除以2的几次幂
        //System.out.println(6 << 1);			//向左移动几次就是乘以2的几次幂
	/*
	>>>无符号右移和>>有符号右移的区别
	>>>无符号右移无论高位是0还是1,移动后都用0补位
	>>有符号右移高位是0就补0,高位是1就补1
	*/
        //面试题
        //请用最有效率的方式写出计算2乘以8的结果
        System.out.println(2 * 8);
        System.out.println(2 << 3);                //最有效率,直接操作的是二进制
    }

    /**
     * 三元运算符的基本用法
     *
     *     A:三元运算符的格式
     *         (关系表达式) ? 表达式1 : 表达式2;
     *     B:三元运算符的执行流程
     *     C:案例演示
     *         获取两个数中的最大值
     */
    /**
     *
     */
    @Test
    public void test9() {
        //格式(关系表达式)?表达式1：表达式2；
        int x = 10;
        int y = 5;
        int z = (x > y) ? x : y;    //如果条件为真,就把表达式1的值赋值过去,如果条件为假就把表达式2的值赋值过去
        System.out.println(z);
    }

    /**
     * 键盘录入的基本格式讲解
     *
     *     A:为什么要使用键盘录入数据
     *         a:为了让程序的数据更符合开发的数据
     *         b:让程序更灵活一下
     *     B:如何实现键盘录入呢
     *         先照格式来。
     *         a:导包
     *             格式：
     *                 import java.util.Scanner;
     *             位置：
     *                 在class上面。
     *         b:创建键盘录入对象
     *             格式：
     *                 Scanner sc = new Scanner(System.in);
     *             c:通过对象获取数据
     *             格式：
     *                 int x = sc.nextInt();
     *     C:案例演示
     *         键盘录入1个整数，并输出到控制台。
     *         键盘录入2个整数，并输出到控制台。
     */
    /**
     *
     */
    @Test
    public void test10() {
        Scanner sc = new Scanner(System.in);		//创建对象,键盘录入
        System.out.println("请输入第一个整数");
        int x = sc.nextInt();						//录入一个int类型的整数
        System.out.println(x);
        System.out.println("请输入第二个整数");
        int y = sc.nextInt();
        System.out.println(y);
    }
}
