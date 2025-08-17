package okio.internal;

import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Options;
import okio.Segment;
import okio.SegmentedByteString;
import okio._JvmPlatformKt;

/* renamed from: okio.internal.-Buffer  reason: invalid class name */
public final class Buffer {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f41392a = _JvmPlatformKt.a("0123456789abcdef");

    public static final Buffer.UnsafeCursor a(okio.Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        boolean z2;
        Intrinsics.f(buffer, "<this>");
        Intrinsics.f(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor g2 = SegmentedByteString.g(unsafeCursor);
        if (g2.f41322b == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            g2.f41322b = buffer;
            g2.f41323c = true;
            return g2;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final byte[] b() {
        return f41392a;
    }

    public static final boolean c(Segment segment, int i2, byte[] bArr, int i3, int i4) {
        Intrinsics.f(segment, "segment");
        Intrinsics.f(bArr, "bytes");
        int i5 = segment.f41379c;
        byte[] bArr2 = segment.f41377a;
        while (i3 < i4) {
            if (i2 == i5) {
                segment = segment.f41382f;
                Intrinsics.c(segment);
                byte[] bArr3 = segment.f41377a;
                int i6 = segment.f41378b;
                bArr2 = bArr3;
                i2 = i6;
                i5 = segment.f41379c;
            }
            if (bArr2[i2] != bArr[i3]) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    public static final String d(okio.Buffer buffer, long j2) {
        Intrinsics.f(buffer, "<this>");
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (buffer.z(j3) == 13) {
                String r02 = buffer.r0(j3);
                buffer.skip(2);
                return r02;
            }
        }
        String r03 = buffer.r0(j2);
        buffer.skip(1);
        return r03;
    }

    public static final int e(okio.Buffer buffer, Options options, boolean z2) {
        int i2;
        int i3;
        boolean z3;
        int i4;
        Segment segment;
        int i5;
        okio.Buffer buffer2 = buffer;
        Intrinsics.f(buffer2, "<this>");
        Intrinsics.f(options, "options");
        Segment segment2 = buffer2.f41320b;
        if (segment2 != null) {
            byte[] bArr = segment2.f41377a;
            int i6 = segment2.f41378b;
            int i7 = segment2.f41379c;
            int[] g2 = options.g();
            Segment segment3 = segment2;
            int i8 = 0;
            int i9 = -1;
            loop0:
            while (true) {
                int i10 = i8 + 1;
                int i11 = g2[i8];
                int i12 = i10 + 1;
                int i13 = g2[i10];
                if (i13 != -1) {
                    i9 = i13;
                }
                if (segment3 == null) {
                    break;
                }
                if (i11 < 0) {
                    int i14 = i12 + (i11 * -1);
                    while (true) {
                        int i15 = i6 + 1;
                        int i16 = i12 + 1;
                        if ((bArr[i6] & 255) != g2[i12]) {
                            return i9;
                        }
                        if (i16 == i14) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (i15 == i7) {
                            Intrinsics.c(segment3);
                            Segment segment4 = segment3.f41382f;
                            Intrinsics.c(segment4);
                            i5 = segment4.f41378b;
                            byte[] bArr2 = segment4.f41377a;
                            i4 = segment4.f41379c;
                            if (segment4 == segment2) {
                                if (!z3) {
                                    break loop0;
                                }
                                bArr = bArr2;
                                segment = null;
                            } else {
                                byte[] bArr3 = bArr2;
                                segment = segment4;
                                bArr = bArr3;
                            }
                        } else {
                            Segment segment5 = segment3;
                            i4 = i7;
                            i5 = i15;
                            segment = segment5;
                        }
                        if (z3) {
                            i3 = g2[i16];
                            i2 = i5;
                            i7 = i4;
                            segment3 = segment;
                            break;
                        }
                        i6 = i5;
                        i7 = i4;
                        i12 = i16;
                        segment3 = segment;
                    }
                } else {
                    i2 = i6 + 1;
                    byte b2 = bArr[i6] & 255;
                    int i17 = i12 + i11;
                    while (i12 != i17) {
                        if (b2 == g2[i12]) {
                            i3 = g2[i12 + i11];
                            if (i2 == i7) {
                                segment3 = segment3.f41382f;
                                Intrinsics.c(segment3);
                                i2 = segment3.f41378b;
                                bArr = segment3.f41377a;
                                i7 = segment3.f41379c;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                            }
                        } else {
                            i12++;
                        }
                    }
                    return i9;
                }
                if (i3 >= 0) {
                    return i3;
                }
                i8 = -i3;
                i6 = i2;
            }
            if (z2) {
                return -2;
            }
            return i9;
        } else if (z2) {
            return -2;
        } else {
            return -1;
        }
    }

    public static /* synthetic */ int f(okio.Buffer buffer, Options options, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return e(buffer, options, z2);
    }
}
