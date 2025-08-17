package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentLengthInputStream extends FilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    private final long f17137b;

    /* renamed from: c  reason: collision with root package name */
    private int f17138c;

    private ContentLengthInputStream(InputStream inputStream, long j2) {
        super(inputStream);
        this.f17137b = j2;
    }

    private int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.f17138c += i2;
        } else if (this.f17137b - ((long) this.f17138c) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f17137b + ", but read: " + this.f17138c);
        }
        return i2;
    }

    public static InputStream f(InputStream inputStream, long j2) {
        return new ContentLengthInputStream(inputStream, j2);
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.f17137b - ((long) this.f17138c), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        return a(super.read(bArr, i2, i3));
    }
}
