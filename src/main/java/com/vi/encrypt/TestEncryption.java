package com.vi.encrypt;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class TestEncryption {
    @Test
    public void testSalt() {
        String password = "12345";
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
        String encryptPwd = new SimpleHash(algorithmName, password, salt, times).toString();
        System.out.printf("算法为:%s ,明文:%s ,盐:%s ,加密次数:%d ,结果:\n%s",algorithmName,password,salt,times,encryptPwd);
    }
}
