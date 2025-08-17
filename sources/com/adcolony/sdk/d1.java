package com.adcolony.sdk;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class d1 {
    static String a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(str.getBytes("iso-8859-1"), 0, str.length());
        return b(instance.digest());
    }

    private static String b(byte[] bArr) {
        int i2;
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            byte b3 = (b2 >>> 4) & 15;
            int i3 = 0;
            while (true) {
                if (b3 < 0 || b3 > 9) {
                    i2 = (b3 - 10) + 97;
                } else {
                    i2 = b3 + 48;
                }
                sb.append((char) i2);
                b3 = b2 & 15;
                int i4 = i3 + 1;
                if (i3 >= 1) {
                    break;
                }
                i3 = i4;
            }
        }
        return sb.toString();
    }
}
