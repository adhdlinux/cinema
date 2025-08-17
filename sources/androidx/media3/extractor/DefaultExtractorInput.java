package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Util;
import com.google.ar.core.ImageMetadata;
import com.google.protobuf.CodedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

public final class DefaultExtractorInput implements ExtractorInput {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f7965a = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];

    /* renamed from: b  reason: collision with root package name */
    private final DataReader f7966b;

    /* renamed from: c  reason: collision with root package name */
    private final long f7967c;

    /* renamed from: d  reason: collision with root package name */
    private long f7968d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f7969e = new byte[65536];

    /* renamed from: f  reason: collision with root package name */
    private int f7970f;

    /* renamed from: g  reason: collision with root package name */
    private int f7971g;

    static {
        MediaLibraryInfo.a("media3.extractor");
    }

    public DefaultExtractorInput(DataReader dataReader, long j2, long j3) {
        this.f7966b = dataReader;
        this.f7968d = j2;
        this.f7967c = j3;
    }

    private void o(int i2) {
        if (i2 != -1) {
            this.f7968d += (long) i2;
        }
    }

    private void p(int i2) {
        int i3 = this.f7970f + i2;
        byte[] bArr = this.f7969e;
        if (i3 > bArr.length) {
            this.f7969e = Arrays.copyOf(this.f7969e, Util.p(bArr.length * 2, 65536 + i3, i3 + ImageMetadata.LENS_APERTURE));
        }
    }

    private int q(byte[] bArr, int i2, int i3) {
        int i4 = this.f7971g;
        if (i4 == 0) {
            return 0;
        }
        int min = Math.min(i4, i3);
        System.arraycopy(this.f7969e, 0, bArr, i2, min);
        u(min);
        return min;
    }

    private int r(byte[] bArr, int i2, int i3, int i4, boolean z2) throws IOException {
        if (!Thread.interrupted()) {
            int read = this.f7966b.read(bArr, i2 + i4, i3 - i4);
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

    private int s(int i2) {
        int min = Math.min(this.f7971g, i2);
        u(min);
        return min;
    }

    private void u(int i2) {
        byte[] bArr;
        int i3 = this.f7971g - i2;
        this.f7971g = i3;
        this.f7970f = 0;
        byte[] bArr2 = this.f7969e;
        if (i3 < bArr2.length - ImageMetadata.LENS_APERTURE) {
            bArr = new byte[(65536 + i3)];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i2, bArr, 0, i3);
        this.f7969e = bArr;
    }

    public int a(int i2) throws IOException {
        int s2 = s(i2);
        if (s2 == 0) {
            byte[] bArr = this.f7965a;
            s2 = r(bArr, 0, Math.min(i2, bArr.length), 0, true);
        }
        o(s2);
        return s2;
    }

    public boolean c(byte[] bArr, int i2, int i3, boolean z2) throws IOException {
        if (!l(i3, z2)) {
            return false;
        }
        System.arraycopy(this.f7969e, this.f7970f - i3, bArr, i2, i3);
        return true;
    }

    public void e() {
        this.f7970f = 0;
    }

    public boolean f(byte[] bArr, int i2, int i3, boolean z2) throws IOException {
        int q2 = q(bArr, i2, i3);
        while (q2 < i3 && q2 != -1) {
            q2 = r(bArr, i2, i3, q2, z2);
        }
        o(q2);
        if (q2 != -1) {
            return true;
        }
        return false;
    }

    public long g() {
        return this.f7968d + ((long) this.f7970f);
    }

    public long getLength() {
        return this.f7967c;
    }

    public long getPosition() {
        return this.f7968d;
    }

    public void h(int i2) throws IOException {
        l(i2, false);
    }

    public int j(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        p(i3);
        int i5 = this.f7971g;
        int i6 = this.f7970f;
        int i7 = i5 - i6;
        if (i7 == 0) {
            i4 = r(this.f7969e, i6, i3, 0, true);
            if (i4 == -1) {
                return -1;
            }
            this.f7971g += i4;
        } else {
            i4 = Math.min(i3, i7);
        }
        System.arraycopy(this.f7969e, this.f7970f, bArr, i2, i4);
        this.f7970f += i4;
        return i4;
    }

    public void k(int i2) throws IOException {
        t(i2, false);
    }

    public boolean l(int i2, boolean z2) throws IOException {
        p(i2);
        int i3 = this.f7971g - this.f7970f;
        while (i3 < i2) {
            i3 = r(this.f7969e, this.f7970f, i2, i3, z2);
            if (i3 == -1) {
                return false;
            }
            this.f7971g = this.f7970f + i3;
        }
        this.f7970f += i2;
        return true;
    }

    public void m(byte[] bArr, int i2, int i3) throws IOException {
        c(bArr, i2, i3, false);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int q2 = q(bArr, i2, i3);
        if (q2 == 0) {
            q2 = r(bArr, i2, i3, 0, true);
        }
        o(q2);
        return q2;
    }

    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        f(bArr, i2, i3, false);
    }

    public boolean t(int i2, boolean z2) throws IOException {
        int s2 = s(i2);
        while (s2 < i2 && s2 != -1) {
            s2 = r(this.f7965a, -s2, Math.min(i2, this.f7965a.length + s2), s2, z2);
        }
        o(s2);
        if (s2 != -1) {
            return true;
        }
        return false;
    }
}
