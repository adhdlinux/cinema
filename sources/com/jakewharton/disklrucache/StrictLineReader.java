package com.jakewharton.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private final InputStream f31834b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Charset f31835c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f31836d;

    /* renamed from: e  reason: collision with root package name */
    private int f31837e;

    /* renamed from: f  reason: collision with root package name */
    private int f31838f;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void f() throws IOException {
        InputStream inputStream = this.f31834b;
        byte[] bArr = this.f31836d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f31837e = 0;
            this.f31838f = read;
            return;
        }
        throw new EOFException();
    }

    public void close() throws IOException {
        synchronized (this.f31834b) {
            if (this.f31836d != null) {
                this.f31836d = null;
                this.f31834b.close();
            }
        }
    }

    public String i() throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.f31834b) {
            if (this.f31836d != null) {
                if (this.f31837e >= this.f31838f) {
                    f();
                }
                for (int i4 = this.f31837e; i4 != this.f31838f; i4++) {
                    byte[] bArr2 = this.f31836d;
                    if (bArr2[i4] == 10) {
                        int i5 = this.f31837e;
                        if (i4 != i5) {
                            i3 = i4 - 1;
                            if (bArr2[i3] == 13) {
                                String str = new String(bArr2, i5, i3 - i5, this.f31835c.name());
                                this.f31837e = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(bArr2, i5, i3 - i5, this.f31835c.name());
                        this.f31837e = i4 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 r12 = new ByteArrayOutputStream((this.f31838f - this.f31837e) + 80) {
                    public String toString() {
                        int i2 = this.count;
                        if (i2 > 0 && this.buf[i2 - 1] == 13) {
                            i2--;
                        }
                        try {
                            return new String(this.buf, 0, i2, StrictLineReader.this.f31835c.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1:
                while (true) {
                    byte[] bArr3 = this.f31836d;
                    int i6 = this.f31837e;
                    r12.write(bArr3, i6, this.f31838f - i6);
                    this.f31838f = -1;
                    f();
                    i2 = this.f31837e;
                    while (true) {
                        if (i2 != this.f31838f) {
                            bArr = this.f31836d;
                            if (bArr[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                }
                int i7 = this.f31837e;
                if (i2 != i7) {
                    r12.write(bArr, i7, i2 - i7);
                }
                this.f31837e = i2 + 1;
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
        } else if (charset.equals(Util.f31840a)) {
            this.f31834b = inputStream;
            this.f31835c = charset;
            this.f31836d = new byte[i2];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
