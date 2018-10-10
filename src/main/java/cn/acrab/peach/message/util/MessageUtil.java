package cn.acrab.peach.message.util;

import cn.acrab.peach.message.enums.EncryptMethod;

public class MessageUtil {

    public static byte[] decryptBytes(byte[] encryptedBytes, EncryptMethod encryptMethod, String encryptKey) {
        //TODO decrypt
        return encryptedBytes;
    }

    public static byte[] encryptBytes(byte[] decryptedBytes, EncryptMethod encryptMethod, String decryptKey) {
        //TODO encrypt
        return decryptedBytes;
    }
}
