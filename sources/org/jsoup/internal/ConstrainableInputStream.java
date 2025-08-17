package org.jsoup.internal;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import org.jsoup.helper.Validate;

public final class ConstrainableInputStream extends BufferedInputStream {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f41536b;

    /* renamed from: c  reason: collision with root package name */
    private final int f41537c;

    /* renamed from: d  reason: collision with root package name */
    private long f41538d;

    /* renamed from: e  reason: collision with root package name */
    private long f41539e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f41540f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f41541g;

    private ConstrainableInputStream(InputStream inputStream, int i2, int i3) {
        super(inputStream, i2);
        boolean z2;
        boolean z3 = true;
        if (i3 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.d(z2);
        this.f41537c = i3;
        this.f41540f = i3;
        this.f41536b = i3 == 0 ? false : z3;
        this.f41538d = System.nanoTime();
    }

    private boolean a() {
        if (this.f41539e != -1 && System.nanoTime() - this.f41538d > this.f41539e) {
            return true;
        }
        return false;
    }

    public static ConstrainableInputStream k(InputStream inputStream, int i2, int i3) {
        if (inputStream instanceof ConstrainableInputStream) {
            return (ConstrainableInputStream) inputStream;
        }
        return new ConstrainableInputStream(inputStream, i2, i3);
    }

    public ByteBuffer f(int i2) throws IOException {
        boolean z2;
        boolean z3 = true;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.e(z2, "maxSize must be 0 (unlimited) or larger");
        if (i2 <= 0) {
            z3 = false;
        }
        int i3 = 32768;
        if (z3 && i2 < 32768) {
            i3 = i2;
        }
        byte[] bArr = new byte[i3];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        while (true) {
            int read = read(bArr);
            if (read == -1) {
                break;
            }
            if (z3) {
                if (read >= i2) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                    break;
                }
                i2 -= read;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    public ConstrainableInputStream i(long j2, long j3) {
        this.f41538d = j2;
        this.f41539e = j3 * 1000000;
        return this;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        if (this.f41541g || (this.f41536b && this.f41540f <= 0)) {
            return -1;
        }
        if (Thread.interrupted()) {
            this.f41541g = true;
            return -1;
        } else if (!a()) {
            if (this.f41536b && i3 > (i4 = this.f41540f)) {
                i3 = i4;
            }
            try {
                int read = super.read(bArr, i2, i3);
                this.f41540f -= read;
                return read;
            } catch (SocketTimeoutException unused) {
                return 0;
            }
        } else {
            throw new SocketTimeoutException("Read timeout");
        }
    }

    public void reset() throws IOException {
        super.reset();
        this.f41540f = this.f41537c - this.markpos;
    }
}
