package com.vi.encrypt;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class Md5Demo {
    @Test
    public void testMd5() {
        String password = "123";
        String encryptPwd = new Md5Hash(password).toString();
        System.out.println(encryptPwd);//结果:202cb962ac59075b964b07152d234b70
    }
}
