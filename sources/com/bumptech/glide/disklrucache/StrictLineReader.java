package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private final InputStream f16215b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Charset f16216c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f16217d;

    /* renamed from: e  reason: collision with root package name */
    private int f16218e;

    /* renamed from: f  reason: collision with root package name */
    private int f16219f;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void f() throws IOException {
        InputStream inputStream = this.f16215b;
        byte[] bArr = this.f16217d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f16218e = 0;
            this.f16219f = read;
            return;
        }
        throw new EOFException();
    }

    public void close() throws IOException {
        synchronized (this.f16215b) {
            if (this.f16217d != null) {
                this.f16217d = null;
                this.f16215b.close();
            }
        }
    }

    public boolean i() {
        return this.f16219f == -1;
    }

    public String k() throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.f16215b) {
            if (this.f16217d != null) {
                if (this.f16218e >= this.f16219f) {
                    f();
                }
                for (int i4 = this.f16218e; i4 != this.f16219f; i4++) {
                    byte[] bArr2 = this.f16217d;
                    if (bArr2[i4] == 10) {
                        int i5 = this.f16218e;
                        if (i4 != i5) {
                            i3 = i4 - 1;
                            if (bArr2[i3] == 13) {
                                String str = new String(bArr2, i5, i3 - i5, this.f16216c.name());
                                this.f16218e = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(bArr2, i5, i3 - i5, this.f16216c.name());
                        this.f16218e = i4 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 r12 = new ByteArrayOutputStream((this.f16219f - this.f16218e) + 80) {
                    public String toString() {
                        int i2 = this.count;
                        if (i2 > 0 && this.buf[i2 - 1] == 13) {
                            i2--;
                        }
                        try {
                            return new String(this.buf, 0, i2, StrictLineReader.this.f16216c.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1:
                while (true) {
                    byte[] bArr3 = this.f16217d;
                    int i6 = this.f16218e;
                    r12.write(bArr3, i6, this.f16219f - i6);
                    this.f16219f = -1;
                    f();
                    i2 = this.f16218e;
                    while (true) {
                        if (i2 != this.f16219f) {
                            bArr = this.f16217d;
                            if (bArr[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                }
                int i7 = this.f16218e;
                if (i2 != i7) {
                    r12.write(bArr, i7, i2 - i7);
                }
                this.f16218e = i2 + 1;
                String byteArrayOutputStream = r12.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public StrictLineReader(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(Util.f16221a)) {
            this.f16215b = inputStream;
            this.f16216c = charset;
            this.f16217d = new byte[i2];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
