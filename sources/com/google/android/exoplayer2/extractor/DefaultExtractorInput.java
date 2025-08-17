package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Util;
import com.google.ar.core.ImageMetadata;
import com.google.protobuf.CodedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

public final class DefaultExtractorInput implements ExtractorInput {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f24175a = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];

    /* renamed from: b  reason: collision with root package name */
    private final DataReader f24176b;

    /* renamed from: c  reason: collision with root package name */
    private final long f24177c;

    /* renamed from: d  reason: collision with root package name */
    private long f24178d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f24179e = new byte[65536];

    /* renamed from: f  reason: collision with root package name */
    private int f24180f;

    /* renamed from: g  reason: collision with root package name */
    private int f24181g;

    static {
        ExoPlayerLibraryInfo.a("goog.exo.extractor");
    }

    public DefaultExtractorInput(DataReader dataReader, long j2, long j3) {
        this.f24176b = dataReader;
        this.f24178d = j2;
        this.f24177c = j3;
    }

    private void q(int i2) {
        if (i2 != -1) {
            this.f24178d += (long) i2;
        }
    }

    private void s(int i2) {
        int i3 = this.f24180f + i2;
        byte[] bArr = this.f24179e;
        if (i3 > bArr.length) {
            this.f24179e = Arrays.copyOf(this.f24179e, Util.q(bArr.length * 2, 65536 + i3, i3 + ImageMetadata.LENS_APERTURE));
        }
    }

    private int t(byte[] bArr, int i2, int i3) {
        int i4 = this.f24181g;
        if (i4 == 0) {
            return 0;
        }
        int min = Math.min(i4, i3);
        System.arraycopy(this.f24179e, 0, bArr, i2, min);
        x(min);
        return min;
    }

    private int u(byte[] bArr, int i2, int i3, int i4, boolean z2) throws IOException {
        if (!Thread.interrupted()) {
            int read = this.f24176b.read(bArr, i2 + i4, i3 - i4);
            if (read != -1) {
                return i4 + read;
            }
            if (i4 == 0 && z2) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    private int v(int i2) {
        int min = Math.min(this.f24181g, i2);
        x(min);
        return min;
    }

    private void x(int i2) {
        byte[] bArr;
        int i3 = this.f24181g - i2;
        this.f24181g = i3;
        this.f24180f = 0;
        byte[] bArr2 = this.f24179e;
        if (i3 < bArr2.length - ImageMetadata.LENS_APERTURE) {
            bArr = new byte[(65536 + i3)];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i2, bArr, 0, i3);
        this.f24179e = bArr;
    }

    public int a(int i2) throws IOException {
        int v2 = v(i2);
        if (v2 == 0) {
            byte[] bArr = this.f24175a;
            v2 = u(bArr, 0, Math.min(i2, bArr.length), 0, true);
        }
        q(v2);
        return v2;
    }

    public boolean c(byte[] bArr, int i2, int i3, boolean z2) throws IOException {
        if (!l(i3, z2)) {
            return false;
        }
        System.arraycopy(this.f24179e, this.f24180f - i3, bArr, i2, i3);
        return true;
    }

    public void e() {
        this.f24180f = 0;
    }

    public boolean f(byte[] bArr, int i2, int i3, boolean z2) throws IOException {
        int t2 = t(bArr, i2, i3);
        while (t2 < i3 && t2 != -1) {
            t2 = u(bArr, i2, i3, t2, z2);
        }
        q(t2);
        if (t2 != -1) {
            return true;
        }
        return false;
    }

    public long g() {
        return this.f24178d + ((long) this.f24180f);
    }

    public long getLength() {
        return this.f24177c;
    }

    public long getPosition() {
        return this.f24178d;
    }

    public void h(int i2) throws IOException {
        l(i2, false);
    }

    public int j(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        s(i3);
        int i5 = this.f24181g;
        int i6 = this.f24180f;
        int i7 = i5 - i6;
        if (i7 == 0) {
            i4 = u(this.f24179e, i6, i3, 0, true);
            if (i4 == -1) {
                return -1;
            }
            this.f24181g += i4;
        } else {
            i4 = Math.min(i3, i7);
        }
        System.arraycopy(this.f24179e, this.f24180f, bArr, i2, i4);
        this.f24180f += i4;
        return i4;
    }

    public void k(int i2) throws IOException {
        w(i2, false);
    }

    public boolean l(int i2, boolean z2) throws IOException {
        s(i2);
        int i3 = this.f24181g - this.f24180f;
        while (i3 < i2) {
            i3 = u(this.f24179e, this.f24180f, i2, i3, z2);
            if (i3 == -1) {
                return false;
            }
            this.f24181g = this.f24180f + i3;
        }
        this.f24180f += i2;
        return true;
    }

    public void m(byte[] bArr, int i2, int i3) throws IOException {
        c(bArr, i2, i3, false);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int t2 = t(bArr, i2, i3);
        if (t2 == 0) {
            t2 = u(bArr, i2, i3, 0, true);
        }
        q(t2);
        return t2;
    }

    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        f(bArr, i2, i3, false);
    }

    public boolean w(int i2, boolean z2) throws IOException {
        int v2 = v(i2);
        while (v2 < i2 && v2 != -1) {
            v2 = u(this.f24175a, -v2, Math.min(i2, this.f24175a.length + v2), v2, z2);
        }
        q(v2);
        if (v2 != -1) {
            return true;
        }
        return false;
    }
}
