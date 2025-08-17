package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

public final class BufferedOutputStream extends OutputStream {

    /* renamed from: b  reason: collision with root package name */
    private final OutputStream f16318b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f16319c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayPool f16320d;

    /* renamed from: e  reason: collision with root package name */
    private int f16321e;

    public BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    private void a() throws IOException {
        int i2 = this.f16321e;
        if (i2 > 0) {
            this.f16318b.write(this.f16319c, 0, i2);
            this.f16321e = 0;
        }
    }

    private void f() throws IOException {
        if (this.f16321e == this.f16319c.length) {
            a();
        }
    }

    private void release() {
        byte[] bArr = this.f16319c;
        if (bArr != null) {
            this.f16320d.put(bArr);
            this.f16319c = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.f16318b.close();
            release();
        } catch (Throwable th) {
            this.f16318b.close();
            throw th;
        }
    }

    public void flush() throws IOException {
        a();
        this.f16318b.flush();
    }

    public void write(int i2) throws IOException {
        byte[] bArr = this.f16319c;
        int i3 = this.f16321e;
        this.f16321e = i3 + 1;
        bArr[i3] = (byte) i2;
        f();
    }

    BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool, int i2) {
        this.f16318b = outputStream;
        this.f16320d = arrayPool;
        this.f16319c = (byte[]) arrayPool.c(i2, byte[].class);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            int i7 = this.f16321e;
            if (i7 != 0 || i5 < this.f16319c.length) {
                int min = Math.min(i5, this.f16319c.length - i7);
                System.arraycopy(bArr, i6, this.f16319c, this.f16321e, min);
                this.f16321e += min;
                i4 += min;
                f();
            } else {
                this.f16318b.write(bArr, i6, i5);
                return;
            }
        } while (i4 < i3);
    }
}
