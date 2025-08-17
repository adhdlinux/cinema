package com.adcolony.sdk;

import java.io.IOException;
import java.io.InputStream;

class w0 extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    InputStream f13489b;

    /* renamed from: c  reason: collision with root package name */
    int f13490c;

    w0(InputStream inputStream, int i2, int i3) throws IOException {
        this.f13489b = inputStream;
        while (i2 > 0) {
            i2 -= (int) inputStream.skip((long) i2);
        }
        this.f13490c = i3;
    }

    public int available() throws IOException {
        int available = this.f13489b.available();
        int i2 = this.f13490c;
        if (available <= i2) {
            return available;
        }
        return i2;
    }

    public void close() throws IOException {
        this.f13489b.close();
    }

    public int read() throws IOException {
        int i2 = this.f13490c;
        if (i2 == 0) {
            return -1;
        }
        this.f13490c = i2 - 1;
        return this.f13489b.read();
    }

    public long skip(long j2) throws IOException {
        int i2 = (int) j2;
        if (i2 <= 0) {
            return 0;
        }
        int i3 = this.f13490c;
        if (i2 > i3) {
            i2 = i3;
        }
        this.f13490c = i3 - i2;
        while (i2 > 0) {
            i2 -= (int) this.f13489b.skip(j2);
        }
        return j2;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f13490c;
        if (i4 == 0) {
            return -1;
        }
        if (i3 > i4) {
            i3 = i4;
        }
        int read = this.f13489b.read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        this.f13490c -= read;
        return read;
    }
}
