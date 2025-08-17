package okio;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* renamed from: okio.-Base64  reason: invalid class name */
public final class Base64 {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f41312a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f41313b;

    static {
        ByteString.Companion companion = ByteString.f41331e;
        f41312a = companion.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").g();
        f41313b = companion.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").g();
    }

    public static final byte[] a(String str) {
        boolean z2;
        int i2;
        boolean z3;
        String str2 = str;
        Intrinsics.f(str2, "<this>");
        int length = str.length();
        while (length > 0 && ((r6 = str2.charAt(length - 1)) == '=' || r6 == 10 || r6 == 13 || r6 == ' ' || r6 == 9)) {
            length--;
        }
        int i3 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            boolean z4 = true;
            if (i4 < length) {
                char charAt = str2.charAt(i4);
                if ('A' > charAt || charAt >= '[') {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    i2 = charAt - 'A';
                } else {
                    if ('a' > charAt || charAt >= '{') {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        i2 = charAt - 'G';
                    } else {
                        if ('0' > charAt || charAt >= ':') {
                            z4 = false;
                        }
                        if (z4) {
                            i2 = charAt + 4;
                        } else if (charAt == '+' || charAt == '-') {
                            i2 = 62;
                        } else if (charAt == '/' || charAt == '_') {
                            i2 = 63;
                        } else {
                            if (!(charAt == 10 || charAt == 13 || charAt == ' ' || charAt == 9)) {
                                return null;
                            }
                            i4++;
                        }
                    }
                }
                i6 = (i6 << 6) | i2;
                i5++;
                if (i5 % 4 == 0) {
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) (i6 >> 16);
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) (i6 >> 8);
                    bArr[i9] = (byte) i6;
                    i7 = i9 + 1;
                }
                i4++;
            } else {
                int i10 = i5 % 4;
                if (i10 == 1) {
                    return null;
                }
                if (i10 == 2) {
                    bArr[i7] = (byte) ((i6 << 12) >> 16);
                    i7++;
                } else if (i10 == 3) {
                    int i11 = i6 << 6;
                    int i12 = i7 + 1;
                    bArr[i7] = (byte) (i11 >> 16);
                    i7 = i12 + 1;
                    bArr[i12] = (byte) (i11 >> 8);
                }
                if (i7 == i3) {
                    return bArr;
                }
                byte[] copyOf = Arrays.copyOf(bArr, i7);
                Intrinsics.e(copyOf, "copyOf(this, newSize)");
                return copyOf;
            }
        }
    }

    public static final String b(byte[] bArr, byte[] bArr2) {
        Intrinsics.f(bArr, "<this>");
        Intrinsics.f(bArr2, "map");
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            int i5 = i4 + 1;
            byte b3 = bArr[i4];
            int i6 = i5 + 1;
            byte b4 = bArr[i5];
            int i7 = i3 + 1;
            bArr3[i3] = bArr2[(b2 & 255) >> 2];
            int i8 = i7 + 1;
            bArr3[i7] = bArr2[((b2 & 3) << 4) | ((b3 & 255) >> 4)];
            int i9 = i8 + 1;
            bArr3[i8] = bArr2[((b3 & 15) << 2) | ((b4 & 255) >> 6)];
            i3 = i9 + 1;
            bArr3[i9] = bArr2[b4 & 63];
            i2 = i6;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b5 = bArr[i2];
            int i10 = i3 + 1;
            bArr3[i3] = bArr2[(b5 & 255) >> 2];
            int i11 = i10 + 1;
            bArr3[i10] = bArr2[(b5 & 3) << 4];
            bArr3[i11] = 61;
            bArr3[i11 + 1] = 61;
        } else if (length2 == 2) {
            int i12 = i2 + 1;
            byte b6 = bArr[i2];
            byte b7 = bArr[i12];
            int i13 = i3 + 1;
            bArr3[i3] = bArr2[(b6 & 255) >> 2];
            int i14 = i13 + 1;
            bArr3[i13] = bArr2[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr3[i14] = bArr2[(b7 & 15) << 2];
            bArr3[i14 + 1] = 61;
        }
        return _JvmPlatformKt.b(bArr3);
    }

    public static /* synthetic */ String c(byte[] bArr, byte[] bArr2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bArr2 = f41312a;
        }
        return b(bArr, bArr2);
    }
}
