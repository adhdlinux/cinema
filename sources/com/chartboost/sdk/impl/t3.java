package com.chartboost.sdk.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class t3 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f18628a = new byte[0];

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(inputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static long b(InputStream inputStream, OutputStream outputStream) {
        return a(inputStream, outputStream, 8192);
    }

    public static int a(InputStream inputStream, OutputStream outputStream) {
        long b2 = b(inputStream, outputStream);
        if (b2 > 2147483647L) {
            return -1;
        }
        return (int) b2;
    }

    public static long a(InputStream inputStream, OutputStream outputStream, int i2) {
        return a(inputStream, outputStream, new byte[i2]);
    }

    public static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j2 += (long) read;
        }
    }
}
