package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    private int f17150b = Integer.MIN_VALUE;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private long a(long j2) {
        int i2 = this.f17150b;
        if (i2 == 0) {
            return -1;
        }
        return (i2 == Integer.MIN_VALUE || j2 <= ((long) i2)) ? j2 : (long) i2;
    }

    private void f(long j2) {
        int i2 = this.f17150b;
        if (i2 != Integer.MIN_VALUE && j2 != -1) {
            this.f17150b = (int) (((long) i2) - j2);
        }
    }

    public int available() throws IOException {
        int i2 = this.f17150b;
        if (i2 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i2, super.available());
    }

    public synchronized void mark(int i2) {
        super.mark(i2);
        this.f17150b = i2;
    }

    public int read() throws IOException {
        if (a(1) == -1) {
            return -1;
        }
        int read = super.read();
        f(1);
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.f17150b = Integer.MIN_VALUE;
    }

    public long skip(long j2) throws IOException {
        long a2 = a(j2);
        if (a2 == -1) {
            return 0;
        }
        long skip = super.skip(a2);
        f(skip);
        return skip;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int a2 = (int) a((long) i3);
        if (a2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i2, a2);
        f((long) read);
        return read;
    }
}
