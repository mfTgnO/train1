package com.example.demo.foundation;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-14 15:55
 * @description:
 */
public class StringDemo {
    /**
     * String类型比较
     */
    @Test
    public void test1() {
        String str0 = "hello";
        String str1 = "he" + new String("llo");

        // 内存地址
        // false
        System.err.println(str0 == str1);

        // same sequence of characters
        // true
        System.err.println(str0.equals(str1));
    }

    @Test
    public void test2() {
        String str0 = "aaa";
        String str1 = "aaa";

        String str2 = new String("bbb");
        String str3 = new String("bbb");

        // true
        System.err.println(str0 == str1);
        // true
        System.err.println(str0.equals(str1));

        // false
        System.err.println(str2 == str3);
        // true
        System.err.println(str2.equals(str3));
    }

    @Test
    public void test3() {
        String str = "hello";
        int h = str.indexOf("h");
        System.out.println(h);

        h = str.indexOf("e");
        System.out.println(h);

        h = str.indexOf("l");
        System.out.println(h);

        h = str.indexOf("o");
        System.out.println(h);

        h = str.indexOf("he");
        System.out.println(h);
    }

    @Test
    public void test4() {
        String str = "hello";

        String s = DigestUtils.md5Hex(str.toString());
        System.out.println(s);

        s = s.toUpperCase();
        System.out.println(s);
    }

    @Test
    public void test5() {
        List<String> list = Arrays.asList("/**,a,b");
        System.out.println(list);
    }

    /**
     * String转换为大写
     */
    @Test
    public void test6() {
        String str = "Store_rating_standards";
        System.out.println(str.toUpperCase());
    }

    /**
     *
     */
    @Test
    public void test7() {
//        String values[] = {"hello", "world"};
        String values[] = {"hello"};

        String valueStr = "";
        for (int i = 0; i < values.length; i++) {
            valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
        }
        System.out.println(valueStr);
    }

    /**
     * Md5Crypt
     */
    @Test
    public void test8() {
        String str = "hello";
        String md5Crypt = Md5Crypt.md5Crypt(str.getBytes());
        System.out.println(md5Crypt);
    }

    /**
     * 转换为字符数组打印
     */
    @Test
    public void test11() {
        String str = "Store_rating_standards";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    /**
     * 转换为小写
     */
    @Test
    public void test12() {
        String str = "Store_rating_standards";
        System.out.println(str.toLowerCase());
    }

    /**
     * 截取首字母、截取除了首字母以外的字符串
     */
    @Test
    public void test13() {
        String str = "Store_rating_standards";
        System.out.println(str.substring(0, 1));
        System.out.println(str.substring(1));
    }

    /**
     * 字符串反转
     */
    @Test
    public void test14() {
        String str = "Store_rating_standards";
        char[] chars = str.toCharArray();
        for (int start = 0, end = chars.length - 1; start < end; start++, end--) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
        }
        System.out.println(new String(chars));
    }

    /**
     * 生成随机验证码
     *
     * @param strLength 验证码长度
     * @return String 验证码
     */
    public static String genRamNumber(int strLength) {
        int maxNum = 10;
        int i;
        int count = 0;
        char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuilder code = new StringBuilder();
        Random r = new Random();
        while (count < strLength) {
            i = Math.abs(r.nextInt(maxNum));
            if (i >= 0 && i < str.length) {
                code.append(str[i]);
                count++;
            }
        }
        return code.toString();
    }

    @Test
    public void verificationCode() {
        System.out.println(genRamNumber(4));
        System.out.println(genRamNumber(6));
    }

    /**
     * 计算MD5摘要并将值作为32个字符的十六进制字符串返回。
     */
    @Test
    public void test() {
        String text = "/v1/adorder/userOrderList?1190Wenle-Key-hehe";
        String sign = DigestUtils.md5Hex(text);
        System.out.println(sign);
        System.out.println(sign.equals("1cf5426fe1050bd6504c24c8b187762c"));
    }

    @Test
    public void stringJoin() {
        String str = "[{\"id\":148,\"name\":\"黑色\",\"styleType\":\"4\",\"createTime\":\"2019-08-13 08:40:44\",\"updateTime\":\"2019-08-13 08:40:44\",\"place\":1,\"deleted\":0},{\"id\":149,\"name\":\"彩色\",\"styleType\":\"4\",\"createTime\":\"2019-08-13 08:40:44\",\"updateTime\":\"2019-08-13 08:40:44\",\"place\":2,\"deleted\":0}]";
        String join = String.join(",", str);
        String valueOf = String.valueOf(str);
        System.out.println(join);
        System.out.println(valueOf);
    }

    /**
     *
     */
    @Test
    public void test15() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        System.out.println(list);

        String s = StringUtils.collectionToCommaDelimitedString(list);
        System.out.println(s);
    }

    /**
     * 获取class名称
     */
    @Test
    public void test16() {
        String simpleName = this.getClass().getSimpleName();
        System.out.println(simpleName);
    }
}