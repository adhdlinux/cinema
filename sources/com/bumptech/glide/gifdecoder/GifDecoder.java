package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

public interface GifDecoder {

    public interface BitmapProvider {
        void a(Bitmap bitmap);

        byte[] b(int i2);

        Bitmap c(int i2, int i3, Bitmap.Config config);

        int[] d(int i2);

        void e(byte[] bArr);

        void f(int[] iArr);
    }

    Bitmap a();

    void b();

    int c();

    void clear();

    void d(Bitmap.Config config);

    int e();

    void f();

    int g();

    ByteBuffer getData();

    int h();
}
