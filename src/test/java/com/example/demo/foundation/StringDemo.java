package com.example.demo.foundation;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-14 15:55
 * @description:
 */
@Slf4j
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

    @Test
    public void test17() {
        // The below line will create two object one is in heap and another is in String constant pool.
        String s1 = new String("abc");

        // SCP object reference
        String s2 = s1.intern();
        // false
        System.out.println(s1 == s2);
        String s3 = "abc";
        // true
        System.out.println(s3 == s2);
    }

    /**
     *
     */
    @Test
    public void test18() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        System.out.println(hostName);
    }

    @Test
    public void test19() throws UnknownHostException {
        String simpleName = this.getClass().getSimpleName();
        System.out.println(simpleName);
    }

    @Test
    public void test20() {
        List<String> ips = new ArrayList<String>();
        Enumeration<NetworkInterface> allNetInterfaces = null;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = allNetInterfaces.nextElement();
            Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress inetAddress = addresses.nextElement();
                if (inetAddress != null && inetAddress instanceof Inet4Address) {
                    String ip = inetAddress.getHostAddress();
                    if (ip != null && !ip.equals("127.0.0.1")) {
                        ips.add(ip);
                    }
                }
            }
        }
        if (ips.isEmpty()) {
            System.out.println("is empty");
//            return null;
        }
        StringBuffer strBuffer = new StringBuffer();
        for (String str : ips) {
            strBuffer.append("," + str);
        }
        String ip = strBuffer.toString().substring(1);
        System.out.println(ip);
    }

    /**
     * log
     */
    @Test
    public void test21() {
        log.error("id：{}，txid：{}", 1, 2);
    }

    @Test
    public void test22() {
        String str = "hello";

        String s = new String(str.getBytes(), StandardCharsets.UTF_8);
        System.out.println(s);
    }

    @Test
    public void test23() {
        String str = "hello";

        System.out.println(str.contains("he"));
    }

    /**
     * string split
     */
    @Test
    public void test24() {
        String str = "E.1231";
        String[] split = str.split("、");
        System.out.println(Arrays.toString(split));
        System.out.println(split.length);
    }

    /**
     * replace underline
     */
    @Test
    public void test25() {
//        String str = "5、补全以下诗句：____________，疑是地上霜。____________，低头思故乡。";
        String str = "4、《史记》的作者123是？__________，_________";

        StringBuffer sb = new StringBuffer();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            if (letter == '_') {
                int j = i + 1;
                for (; j < chars.length; j++) {
                    char letterJ = chars[j];
                    if (letterJ != '_') {
                        i = j - 1;
                        break;
                    }

                    if (j == chars.length - 1) {
                        i = chars.length - 1;
                        break;
                    }
                }
                sb.append("________");
            } else {
                sb.append(letter);
            }
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test26() {
        String str = "abc";
        char data[] = {'a', 'b', 'c'};
        String newstr = new String(data);
        System.out.println(str);
        System.out.println(newstr);
        System.out.println(str.equals(newstr));
    }

    @Test
    public void test27() {
        char data[] = {'a', 'b', 'c', 'd'};
        String str = new String(data, 1, 2);
        System.out.println(str);
    }

    @Test
    public void test28() {
        String fileName = "http://39.104.19.41:8080//resources/picture/be96283c-c6fb-4662-9644-16c8a450afcb.jpg";
        String bucketName = "jhhn-test-files";
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";

        int index = endpoint.indexOf("//");
        String first = endpoint.substring(0, index + 2);
        String second = endpoint.substring(index + 2);
        System.out.println(first + bucketName + "." + second);
    }

    @Test
    public void test29() {
        String fileName = "http://jhhn-test-files.oss-cn-hangzhou.aliyuncs.com/20200612/1591945245404662.jpg";
        int index = fileName.lastIndexOf("/");
        String substring = fileName.substring(index + 1);
        System.out.println(substring);

        System.out.println(fileName.substring(fileName.lastIndexOf("/") + 1));
    }

    @Test
    public void test30() {
        String str = "1/29/129/132/";
        String[] split = str.split("/");
        for (int i = 0; i < split.length; i++) {
            String element = "";
            int j = i;
            while (j >= 0) {
                element = split[j] + "/" + element;
                j--;
            }
            System.out.println(element);
        }
    }
}