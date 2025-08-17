package com.original.tase.helper.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Sha1Cryptor {
    public static String a(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            formatter.format("%02x", new Object[]{Byte.valueOf(bArr[i2])});
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    public static String b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return a(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return "";
        }
    }
}
