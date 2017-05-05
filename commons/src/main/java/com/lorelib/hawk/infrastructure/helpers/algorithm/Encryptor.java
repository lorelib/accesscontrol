package com.lorelib.hawk.infrastructure.helpers.algorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 加密算法
 */
public class Encryptor {

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String md5(String val) {
        return generateValue("MD5", val);
    }

    public static String sha1(String val) {
        return generateValue("SHA-1", val);
    }

    public static String md5() {
        return md5(UUID.randomUUID().toString());
    }

    public static String generateValue(String type, String val) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance(type);
            algorithm.reset();
            algorithm.update(val.getBytes("UTF-8"));
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHexString(byte[] data) {
        if (data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

}
