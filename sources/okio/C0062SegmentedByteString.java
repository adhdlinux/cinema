package okio;

import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.SegmentedByteString;

/* renamed from: okio.SegmentedByteString  reason: case insensitive filesystem */
public final class C0062SegmentedByteString extends ByteString {

    /* renamed from: g  reason: collision with root package name */
    private final transient byte[][] f41389g;

    /* renamed from: h  reason: collision with root package name */
    private final transient int[] f41390h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0062SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.f41332f.g());
        Intrinsics.f(bArr, "segments");
        Intrinsics.f(iArr, "directory");
        this.f41389g = bArr;
        this.f41390h = iArr;
    }

    private final ByteString C() {
        return new ByteString(x());
    }

    public final int[] A() {
        return this.f41390h;
    }

    public final byte[][] B() {
        return this.f41389g;
    }

    public String a() {
        return C().a();
    }

    public ByteString d(String str) {
        Intrinsics.f(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        int length = B().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = A()[length + i2];
            int i5 = A()[i2];
            instance.update(B()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
        byte[] digest = instance.digest();
        Intrinsics.c(digest);
        return new ByteString(digest);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.size() == size() && p(0, byteString, 0, size());
        }
    }

    public int hashCode() {
        int h2 = h();
        if (h2 != 0) {
            return h2;
        }
        int length = B().length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int i5 = A()[length + i2];
            int i6 = A()[i2];
            byte[] bArr = B()[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        r(i3);
        return i3;
    }

    public int i() {
        return A()[B().length - 1];
    }

    public String k() {
        return C().k();
    }

    public byte[] l() {
        return x();
    }

    public byte m(int i2) {
        int i3;
        SegmentedByteString.b((long) A()[B().length - 1], (long) i2, 1);
        int b2 = SegmentedByteString.b(this, i2);
        if (b2 == 0) {
            i3 = 0;
        } else {
            i3 = A()[b2 - 1];
        }
        return B()[b2][(i2 - i3) + A()[B().length + b2]];
    }

    public boolean p(int i2, ByteString byteString, int i3, int i4) {
        int i5;
        Intrinsics.f(byteString, "other");
        if (i2 < 0 || i2 > size() - i4) {
            return false;
        }
        int i6 = i4 + i2;
        int b2 = SegmentedByteString.b(this, i2);
        while (i2 < i6) {
            if (b2 == 0) {
                i5 = 0;
            } else {
                i5 = A()[b2 - 1];
            }
            int i7 = A()[B().length + b2];
            int min = Math.min(i6, (A()[b2] - i5) + i5) - i2;
            if (!byteString.q(i3, B()[b2], i7 + (i2 - i5), min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            b2++;
        }
        return true;
    }

    public boolean q(int i2, byte[] bArr, int i3, int i4) {
        int i5;
        Intrinsics.f(bArr, "other");
        if (i2 < 0 || i2 > size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int i6 = i4 + i2;
        int b2 = SegmentedByteString.b(this, i2);
        while (i2 < i6) {
            if (b2 == 0) {
                i5 = 0;
            } else {
                i5 = A()[b2 - 1];
            }
            int i7 = A()[B().length + b2];
            int min = Math.min(i6, (A()[b2] - i5) + i5) - i2;
            if (!SegmentedByteString.a(B()[b2], i7 + (i2 - i5), bArr, i3, min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            b2++;
        }
        return true;
    }

    public String toString() {
        return C().toString();
    }

    public ByteString w() {
        return C().w();
    }

    public byte[] x() {
        byte[] bArr = new byte[size()];
        int length = B().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = A()[length + i2];
            int i6 = A()[i2];
            int i7 = i6 - i3;
            byte[] unused = ArraysKt___ArraysJvmKt.e(B()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    public void z(Buffer buffer, int i2, int i3) {
        int i4;
        Intrinsics.f(buffer, "buffer");
        int i5 = i2 + i3;
        int b2 = SegmentedByteString.b(this, i2);
        while (i2 < i5) {
            if (b2 == 0) {
                i4 = 0;
            } else {
                i4 = A()[b2 - 1];
            }
            int i6 = A()[B().length + b2];
            int min = Math.min(i5, (A()[b2] - i4) + i4) - i2;
            int i7 = i6 + (i2 - i4);
            Segment segment = new Segment(B()[b2], i7, i7 + min, true, false);
            Segment segment2 = buffer.f41320b;
            if (segment2 == null) {
                segment.f41383g = segment;
                segment.f41382f = segment;
                buffer.f41320b = segment;
            } else {
                Intrinsics.c(segment2);
                Segment segment3 = segment2.f41383g;
                Intrinsics.c(segment3);
                segment3.c(segment);
            }
            i2 += min;
            b2++;
        }
        buffer.t0(buffer.size() + ((long) i3));
    }
}
