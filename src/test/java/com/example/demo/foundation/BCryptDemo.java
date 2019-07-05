package com.example.demo.foundation;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-07-04 10:26
 * @description:
 */
public class BCryptDemo {
    @Test
    public void test1() {
        String gensalt = BCrypt.gensalt();
        System.out.println(gensalt);

        String password = "mypassword";
        String hashpw = BCrypt.hashpw(password, gensalt);
        System.out.println(hashpw);

        boolean checkpw = BCrypt.checkpw(password, hashpw);
        System.out.println(checkpw);
    }
}
