package com.bumptech.glide.disklrucache;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

final class Util {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f16221a = Charset.forName("US-ASCII");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f16222b = Charset.forName("UTF-8");

    private Util() {
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i2 = 0;
            while (i2 < length) {
                File file2 = listFiles[i2];
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (file2.delete()) {
                    i2++;
                } else {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }
}
