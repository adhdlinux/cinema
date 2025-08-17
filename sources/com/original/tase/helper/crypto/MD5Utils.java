package com.original.tase.helper.crypto;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f33886a = StandardCharsets.UTF_8;

    public static String a(String str) {
        return b(c(str.getBytes(f33886a)));
    }

    public static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i2])}));
        }
        return sb.toString();
    }

    public static byte[] c(byte[] bArr) {
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
