package okio;

import com.facebook.ads.internal.c.a;
import com.facebook.imageutils.JfifUtil;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.internal.ByteString;

/* renamed from: okio.-SegmentedByteString  reason: invalid class name */
public final class SegmentedByteString {

    /* renamed from: a  reason: collision with root package name */
    private static final Buffer.UnsafeCursor f41314a = new Buffer.UnsafeCursor();

    /* renamed from: b  reason: collision with root package name */
    private static final int f41315b = -1234567890;

    public static final boolean a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        Intrinsics.f(bArr, a.f20042a);
        Intrinsics.f(bArr2, "b");
        for (int i5 = 0; i5 < i4; i5++) {
            if (bArr[i5 + i2] != bArr2[i5 + i3]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException("size=" + j2 + " offset=" + j3 + " byteCount=" + j4);
        }
    }

    public static final int c() {
        return f41315b;
    }

    public static final Buffer.UnsafeCursor d() {
        return f41314a;
    }

    public static final int e(ByteString byteString, int i2) {
        Intrinsics.f(byteString, "<this>");
        if (i2 == f41315b) {
            return byteString.size();
        }
        return i2;
    }

    public static final int f(byte[] bArr, int i2) {
        Intrinsics.f(bArr, "<this>");
        if (i2 == f41315b) {
            return bArr.length;
        }
        return i2;
    }

    public static final Buffer.UnsafeCursor g(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.f(unsafeCursor, "unsafeCursor");
        if (unsafeCursor == f41314a) {
            return new Buffer.UnsafeCursor();
        }
        return unsafeCursor;
    }

    public static final int h(int i2) {
        return ((i2 & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((-16777216 & i2) >>> 24) | ((16711680 & i2) >>> 8) | ((65280 & i2) << 8);
    }

    public static final short i(short s2) {
        short s3 = s2 & 65535;
        return (short) (((s3 & 255) << 8) | ((65280 & s3) >>> 8));
    }

    public static final String j(byte b2) {
        return StringsKt__StringsJVMKt.o(new char[]{ByteString.f()[(b2 >> 4) & 15], ByteString.f()[b2 & 15]});
    }

    public static final String k(int i2) {
        if (i2 == 0) {
            return "0";
        }
        int i3 = 0;
        char[] cArr = {ByteString.f()[(i2 >> 28) & 15], ByteString.f()[(i2 >> 24) & 15], ByteString.f()[(i2 >> 20) & 15], ByteString.f()[(i2 >> 16) & 15], ByteString.f()[(i2 >> 12) & 15], ByteString.f()[(i2 >> 8) & 15], ByteString.f()[(i2 >> 4) & 15], ByteString.f()[i2 & 15]};
        while (i3 < 8 && cArr[i3] == '0') {
            i3++;
        }
        return StringsKt__StringsJVMKt.p(cArr, i3, 8);
    }
}
