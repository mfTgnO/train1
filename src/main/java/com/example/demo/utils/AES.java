package com.example.demo.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @package: com.example.demo.utils
 * @author:
 * @email:
 * @createDate: 2019-06-25 16:06
 * @description:
 */
public class AES {
    private static String union = "ozi_G1L6s8mdMIUO7PJLxW6OvP-w";
    private static final String secret = "miaopost2018";

    /**
     * 编码格式
     */
    private static final String ENCODING = "UTF-8";
    /**
     * 加密算法
     */
    public static final String KEY_ALGORITHM = "AES";
    /**
     * 签名算法
     */
    public static final String SIGN_ALGORITHMS = "SHA1PRNG";
    public static String encrypt(String content) {
        return encrypt(content,secret);
    }
    /**
     * 加密
     *
     * @param content 待加密内容
     * @param key     加密的密钥
     * @return
     */
    private static String encrypt(String content,String key) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom random = SecureRandom.getInstance(SIGN_ALGORITHMS);
            random.setSeed(key.getBytes(ENCODING));
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            byte[] byteContent = content.getBytes(ENCODING);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] byteRresult = cipher.doFinal(byteContent);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteRresult.length; i++) {
                String hex = Integer.toHexString(byteRresult[i] & 0xFF);
                if (hex.length() == 1) hex = '0' + hex;
                sb.append(hex.toUpperCase());
            }
            return sb.toString();
        } catch (Exception e) {
            e.toString();
        }
        return null;
    }
    public static String decrypt(String content) {
        return decrypt(content,secret);
    }
    /**
     * 解密
     *
     * @param content 待解密内容
     * @param key     解密的密钥
     * @return
     */
    public static String decrypt(String content, String key) {
        if (content.length() < 1) return null;
        byte[] byteRresult = new byte[content.length() / 2];
        for (int i = 0; i < content.length() / 2; i++) {
            int high = Integer.parseInt(content.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(content.substring(i * 2 + 1, i * 2 + 2), 16);
            byteRresult[i] = (byte) (high * 16 + low);
        }
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom random = SecureRandom.getInstance(SIGN_ALGORITHMS);
            random.setSeed(key.getBytes(ENCODING));
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] result = cipher.doFinal(byteRresult);
            return new String(result, ENCODING);
        } catch (Exception e) {
            e.toString();
        }
        return null;
    }


    public static void main(String[] args) {
        String encrypt = encrypt(union);
        String decod = decrypt(encrypt);

        System.out.println(encrypt);
        System.out.println(decod);

    }
}
