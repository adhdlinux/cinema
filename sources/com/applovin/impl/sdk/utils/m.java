package com.applovin.impl.sdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class m {
    public static String a(String str, String str2) {
        return a(str, str2, new byte[]{-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77});
    }

    public static String a(String str, String str2, long j2) {
        return a(str, str2, j2, new byte[]{-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77});
    }

    private static String a(String str, String str2, long j2, byte[] bArr) {
        String str3 = str;
        String str4 = str2;
        byte[] bArr2 = bArr;
        if (str4 == null) {
            throw new IllegalArgumentException("No SDK key specified");
        } else if (str2.length() < 80) {
            throw new IllegalArgumentException("SDK key is too short");
        } else if (bArr2 != null) {
            char c2 = ' ';
            if (bArr2.length < 32) {
                throw new IllegalArgumentException("Salt is too short");
            } else if (str3 == null || str.isEmpty()) {
                return str3;
            } else {
                try {
                    String substring = str4.substring(32);
                    String substring2 = str4.substring(0, 32);
                    byte[] bytes = str3.getBytes("UTF-8");
                    byte[] a2 = a(substring2, bArr2);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(((byte) ((int) ((j2 >> 0) & 255))) ^ a2[0]);
                    byteArrayOutputStream.write(((byte) ((int) ((j2 >> 8) & 255))) ^ a2[1]);
                    byteArrayOutputStream.write(((byte) ((int) ((j2 >> 16) & 255))) ^ a2[2]);
                    byteArrayOutputStream.write(((byte) ((int) ((j2 >> 24) & 255))) ^ a2[3]);
                    byteArrayOutputStream.write(((byte) ((int) ((j2 >> 32) & 255))) ^ a2[4]);
                    byteArrayOutputStream.write(((byte) ((int) ((j2 >> 40) & 255))) ^ a2[5]);
                    byteArrayOutputStream.write(((byte) ((int) ((j2 >> 48) & 255))) ^ a2[6]);
                    byteArrayOutputStream.write(((byte) ((int) ((j2 >> 56) & 255))) ^ a2[7]);
                    int i2 = 0;
                    while (i2 < bytes.length) {
                        long j3 = j2 + ((long) i2);
                        long j4 = (j3 ^ (j3 >> 33)) * -4417276706812531889L;
                        long j5 = (j4 ^ (j4 >> 29)) * -8796714831421723037L;
                        long j6 = j5 ^ (j5 >> c2);
                        int i3 = i2 + 0;
                        byteArrayOutputStream.write((byte) ((int) (((long) ((i3 >= bytes.length ? 0 : bytes[i3]) ^ a2[i3 % a2.length])) ^ ((j6 >> 0) & 255))));
                        int i4 = i2 + 1;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a2[i4 % a2.length] ^ (i4 >= bytes.length ? 0 : bytes[i4]))) ^ ((j6 >> 8) & 255))));
                        int i5 = i2 + 2;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a2[i5 % a2.length] ^ (i5 >= bytes.length ? 0 : bytes[i5]))) ^ ((j6 >> 16) & 255))));
                        int i6 = i2 + 3;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a2[i6 % a2.length] ^ (i6 >= bytes.length ? 0 : bytes[i6]))) ^ ((j6 >> 24) & 255))));
                        int i7 = i2 + 4;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a2[i7 % a2.length] ^ (i7 >= bytes.length ? 0 : bytes[i7]))) ^ ((j6 >> 32) & 255))));
                        int i8 = i2 + 5;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a2[i8 % a2.length] ^ (i8 >= bytes.length ? 0 : bytes[i8]))) ^ ((j6 >> 40) & 255))));
                        int i9 = i2 + 6;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a2[i9 % a2.length] ^ (i9 >= bytes.length ? 0 : bytes[i9]))) ^ ((j6 >> 48) & 255))));
                        int i10 = i2 + 7;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a2[i10 % a2.length] ^ (i10 >= bytes.length ? 0 : bytes[i10]))) ^ ((j6 >> 56) & 255))));
                        i2 += 8;
                        c2 = ' ';
                    }
                    String b2 = b(byteArrayOutputStream.toByteArray());
                    String a3 = a(bArr);
                    return "1:" + a3 + ":" + substring + ":" + b2;
                } catch (IOException unused) {
                    return null;
                }
            }
        } else {
            throw new IllegalArgumentException("No salt specified");
        }
    }

    private static String a(String str, String str2, byte[] bArr) {
        String str3 = str;
        String str4 = str2;
        byte[] bArr2 = bArr;
        if (str4 == null) {
            throw new IllegalArgumentException("No SDK key specified");
        } else if (str2.length() < 80) {
            throw new IllegalArgumentException("SDK key is too short");
        } else if (bArr2 != null) {
            char c2 = ' ';
            if (bArr2.length < 32) {
                throw new IllegalArgumentException("Salt is too short");
            } else if (TextUtils.isEmpty(str) || str.trim().startsWith("{")) {
                return str3;
            } else {
                String[] split = str3.split(":");
                char c3 = 0;
                try {
                    if (!"1".equals(split[0])) {
                        return null;
                    }
                    if (split.length != 4) {
                        return null;
                    }
                    char c4 = 1;
                    String str5 = split[1];
                    String str6 = split[2];
                    byte[] a2 = a(split[3]);
                    if (!str4.endsWith(str6)) {
                        return null;
                    }
                    if (!a(bArr).equals(str5)) {
                        return null;
                    }
                    byte[] a3 = a(str4.substring(0, 32), bArr2);
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a2);
                    char c5 = 8;
                    try {
                        long read = (((long) ((byteArrayInputStream.read() ^ a3[5]) & 255)) << 40) | (((long) ((byteArrayInputStream.read() ^ a3[0]) & 255)) << 0) | (((long) ((byteArrayInputStream.read() ^ a3[1]) & 255)) << 8) | (((long) ((byteArrayInputStream.read() ^ a3[2]) & 255)) << 16) | (((long) ((byteArrayInputStream.read() ^ a3[3]) & 255)) << 24) | (((long) ((byteArrayInputStream.read() ^ a3[4]) & 255)) << 32) | (((long) ((byteArrayInputStream.read() ^ a3[6]) & 255)) << 48) | (((long) ((byteArrayInputStream.read() ^ a3[7]) & 255)) << 56);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr3 = new byte[8];
                        int read2 = byteArrayInputStream.read(bArr3);
                        int i2 = 0;
                        while (read2 >= 0) {
                            long j2 = ((long) i2) + read;
                            long j3 = (j2 ^ (j2 >> 33)) * -4417276706812531889L;
                            long j4 = (j3 ^ (j3 >> 29)) * -8796714831421723037L;
                            long j5 = j4 ^ (j4 >> c2);
                            byteArrayOutputStream.write((byte) ((int) (((long) (bArr3[c3] ^ a3[(i2 + 0) % a3.length])) ^ ((j5 >> c3) & 255))));
                            byteArrayOutputStream.write((byte) ((int) (((long) (bArr3[c4] ^ a3[(i2 + 1) % a3.length])) ^ ((j5 >> c5) & 255))));
                            long j6 = read;
                            byteArrayOutputStream.write((byte) ((int) (((long) (a3[(i2 + 2) % a3.length] ^ bArr3[2])) ^ ((j5 >> 16) & 255))));
                            byteArrayOutputStream.write((byte) ((int) (((long) (bArr3[3] ^ a3[(i2 + 3) % a3.length])) ^ ((j5 >> 24) & 255))));
                            byteArrayOutputStream.write((byte) ((int) (((long) (a3[(i2 + 4) % a3.length] ^ bArr3[4])) ^ ((j5 >> c2) & 255))));
                            byteArrayOutputStream.write((byte) ((int) (((long) (bArr3[5] ^ a3[(i2 + 5) % a3.length])) ^ ((j5 >> 40) & 255))));
                            byteArrayOutputStream.write((byte) ((int) (((long) (a3[(i2 + 6) % a3.length] ^ bArr3[6])) ^ ((j5 >> 48) & 255))));
                            byteArrayOutputStream.write((byte) ((int) (((long) (a3[(i2 + 7) % a3.length] ^ bArr3[7])) ^ ((j5 >> 56) & 255))));
                            i2 += 8;
                            read2 = byteArrayInputStream.read(bArr3);
                            read = j6;
                            c5 = 8;
                            c3 = 0;
                            c2 = ' ';
                            c4 = 1;
                        }
                        return new String(byteArrayOutputStream.toByteArray(), "UTF-8").trim();
                    } catch (IOException unused) {
                        return null;
                    }
                } catch (IOException unused2) {
                    return null;
                }
            }
        } else {
            throw new IllegalArgumentException("No salt specified");
        }
    }

    private static String a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr);
            return StringUtils.toHexString(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("SHA-1 algorithm not found", e2);
        }
    }

    private static byte[] a(String str) {
        return Base64.decode(b(str), 0);
    }

    private static byte[] a(String str, byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            instance.update(str.getBytes("UTF-8"));
            return instance.digest();
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("SHA-1 algorithm not found", e2);
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException("UTF-8 encoding not found", e3);
        }
    }

    private static String b(String str) {
        return str.replace('-', '+').replace('_', '/').replace('*', '=');
    }

    private static String b(byte[] bArr) throws UnsupportedEncodingException {
        return c(Base64.encode(bArr, 2));
    }

    private static String c(byte[] bArr) throws UnsupportedEncodingException {
        return new String(bArr, "UTF-8").replace('+', '-').replace('/', '_').replace('=', '*');
    }
}
