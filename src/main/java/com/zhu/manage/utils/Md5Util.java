package com.zhu.manage.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * 明文----加密-----》密文
 *
 * @author niurui
 */
public class Md5Util {
    //设置盐值
    private static String secret = "zhu";

    //加密方法
    public static String md5(String password) {
        byte[] bytes = null;
        try {
            //1.指定算法，创建消息摘要对象
            MessageDigest digest = MessageDigest.getInstance("md5");
            //2.进行加密
            //设置盐值
            digest.update(secret.getBytes());
            bytes = digest.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //3.转换成字符串后返回结果
        return new BigInteger(1, bytes).toString(16).toUpperCase();
    }
}
