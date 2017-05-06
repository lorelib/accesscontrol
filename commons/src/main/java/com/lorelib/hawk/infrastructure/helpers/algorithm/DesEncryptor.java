package com.lorelib.hawk.infrastructure.helpers.algorithm;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * Des 加密方式.
 */
public class DesEncryptor {
    /**
     * DES 加密 返回字符串.
     *
     * @param message
     */
    public static String encryptToStr(String message, String key) throws Exception {
        return bytes2HexStr(encrypt(message, key));
    }

    /**
     * DES 加密.
     *
     * @param message
     */
    public static byte[] encrypt(String message, String key) throws Exception {
        if (key.length() > 9) {
            key = key.substring(0, 8);
        }
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        return cipher.doFinal(message.getBytes("UTF-8"));
    }

    /**
     * des 解密.
     */
    public static String decrypt(byte[] bytes, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

        byte[] retByte = cipher.doFinal(bytes);
        return new String(retByte, "UTF-8");
    }

    private static String bytes2HexStr(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    private static byte[] hexStr2Bytes(String str) {
        byte digest[] = new byte[str.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = str.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte) byteValue;
        }
        return digest;
    }

    /**
     * 解密16进制字符串.
     *
     * @param message
     */
    public static String decryptHex(String message, String key) throws Exception {
        return decrypt(hexStr2Bytes(message), key);
    }

    /**
     * DES加密转64进制字符串.
     *
     * @param message
     */
    public static String encryptTo64(String message, String key) throws Exception {
        return bytes2Base64(encrypt(message, key));
    }

    /**
     * 解密64进制字符串.
     *
     * @param message
     */
    public static String decrypt64(String message, String key) throws Exception {
        if (key.length() > 9) key = key.substring(0, 8);
        return decrypt(base642Bytes(message), key);
    }

    /**
     * 字节转64进制.
     *
     * @param bytes
     * @return
     */
    public static String bytes2Base64(byte[] bytes) {
        //return new BASE64Encoder().encode(bytes);
        return Base64.encodeBase64String(bytes);
    }

    /**
     * 64进制转字节.
     *
     * @param base64
     * @return
     */
    public static byte[] base642Bytes(final String base64) {
        //return new BASE64Decoder().decodeBuffer(base64);
        return Base64.decodeBase64(base64);
    }
}
