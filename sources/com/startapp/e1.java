package com.startapp;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class e1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34393a = "e1";

    /* renamed from: b  reason: collision with root package name */
    private static final String f34394b = "SHA-256";

    /* renamed from: c  reason: collision with root package name */
    private static final int f34395c = 8192;

    public static byte[] a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(f34394b);
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable th) {
            l2.a(th);
            return null;
        }
    }

    public static byte[] a(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance(f34394b);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[f34395c];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return instance.digest();
                }
            }
        } catch (Throwable th) {
            l2.a(th);
            return null;
        }
    }
}
