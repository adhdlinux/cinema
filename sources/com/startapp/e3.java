package com.startapp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class e3 {
    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8096];
        while (true) {
            int read = inputStream.read(bArr, 0, 8096);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
