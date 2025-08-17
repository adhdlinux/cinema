package kotlin.io.encoding;

import java.nio.charset.Charset;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public class Base64 {

    /* renamed from: c  reason: collision with root package name */
    public static final Default f40394c = new Default((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f40395d = {13, 10};
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final Base64 f40396e = new Base64(true, false);

    /* renamed from: f  reason: collision with root package name */
    private static final Base64 f40397f = new Base64(false, true);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f40398a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f40399b;

    public static final class Default extends Base64 {
        private Default() {
            super(false, false, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Base64 r() {
            return Base64.f40396e;
        }
    }

    private Base64(boolean z2, boolean z3) {
        boolean z4;
        this.f40398a = z2;
        this.f40399b = z3;
        if (!z2 || !z3) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public /* synthetic */ Base64(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, z3);
    }

    private final void c(int i2, int i3, int i4) {
        if (i3 < 0 || i3 > i2) {
            throw new IndexOutOfBoundsException("destination offset: " + i3 + ", destination size: " + i2);
        }
        int i5 = i3 + i4;
        if (i5 < 0 || i5 > i2) {
            throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + i3 + ", destination size: " + i2 + ", capacity needed: " + i4);
        }
    }

    public static /* synthetic */ byte[] g(Base64 base64, CharSequence charSequence, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = charSequence.length();
            }
            return base64.e(charSequence, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public static /* synthetic */ byte[] h(Base64 base64, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = bArr.length;
            }
            return base64.f(bArr, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    private final int i(byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        int[] iArr;
        byte[] bArr3 = bArr;
        int i5 = i4;
        if (this.f40398a) {
            iArr = Base64Kt.f40403d;
        } else {
            iArr = Base64Kt.f40401b;
        }
        int i6 = -8;
        int i7 = i2;
        int i8 = i3;
        int i9 = 0;
        int i10 = -8;
        while (true) {
            if (i8 >= i5) {
                break;
            }
            if (i10 == i6 && i8 + 3 < i5) {
                int i11 = i8 + 1;
                int i12 = iArr[bArr3[i8] & 255];
                int i13 = i11 + 1;
                int i14 = iArr[bArr3[i11] & 255];
                int i15 = i13 + 1;
                int i16 = iArr[bArr3[i13] & 255];
                int i17 = i15 + 1;
                int i18 = (i16 << 6) | (i12 << 18) | (i14 << 12) | iArr[bArr3[i15] & 255];
                if (i18 >= 0) {
                    int i19 = i7 + 1;
                    bArr2[i7] = (byte) (i18 >> 16);
                    int i20 = i19 + 1;
                    bArr2[i19] = (byte) (i18 >> 8);
                    bArr2[i20] = (byte) i18;
                    i7 = i20 + 1;
                    i8 = i17;
                    i6 = -8;
                } else {
                    i8 = i17 - 4;
                }
            }
            byte b2 = bArr3[i8] & 255;
            int i21 = iArr[b2];
            if (i21 >= 0) {
                i8++;
                i9 = (i9 << 6) | i21;
                i10 += 6;
                if (i10 >= 0) {
                    bArr2[i7] = (byte) (i9 >>> i10);
                    i9 &= (1 << i10) - 1;
                    i10 -= 8;
                    i7++;
                }
            } else if (i21 == -2) {
                i8 = p(bArr3, i8, i5, i10);
                break;
            } else if (this.f40399b) {
                i8++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid symbol '");
                sb.append((char) b2);
                sb.append("'(");
                String num = Integer.toString(b2, CharsKt__CharJVMKt.a(8));
                Intrinsics.e(num, "toString(this, checkRadix(radix))");
                sb.append(num);
                sb.append(") at index ");
                sb.append(i8);
                throw new IllegalArgumentException(sb.toString());
            }
            i6 = -8;
        }
        if (i10 != -2) {
            int q2 = q(bArr3, i8, i5);
            if (q2 >= i5) {
                return i7 - i2;
            }
            byte b3 = bArr3[q2] & 255;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Symbol '");
            sb2.append((char) b3);
            sb2.append("'(");
            String num2 = Integer.toString(b3, CharsKt__CharJVMKt.a(8));
            Intrinsics.e(num2, "toString(this, checkRadix(radix))");
            sb2.append(num2);
            sb2.append(") at index ");
            sb2.append(q2 - 1);
            sb2.append(" is prohibited after the pad character");
            throw new IllegalArgumentException(sb2.toString());
        }
        throw new IllegalArgumentException("The last unit of input does not have enough bits");
    }

    private final int j(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        if (i4 == 0) {
            return 0;
        }
        if (i4 != 1) {
            if (this.f40399b) {
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int i5 = Base64Kt.f40401b[bArr[i2] & 255];
                    if (i5 < 0) {
                        if (i5 == -2) {
                            i4 -= i3 - i2;
                            break;
                        }
                        i4--;
                    }
                    i2++;
                }
            } else if (bArr[i3 - 1] == 61) {
                i4--;
                if (bArr[i3 - 2] == 61) {
                    i4--;
                }
            }
            return (int) ((((long) i4) * ((long) 6)) / ((long) 8));
        }
        throw new IllegalArgumentException("Input should have at list 2 symbols for Base64 decoding, startIndex: " + i2 + ", endIndex: " + i3);
    }

    public static /* synthetic */ String l(Base64 base64, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = bArr.length;
            }
            return base64.k(bArr, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
    }

    private final int n(int i2) {
        int i3;
        int i4 = ((i2 + 3) - 1) / 3;
        if (this.f40399b) {
            i3 = (i4 - 1) / 19;
        } else {
            i3 = 0;
        }
        int i5 = (i4 * 4) + (i3 * 2);
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalArgumentException("Input is too big");
    }

    private final int p(byte[] bArr, int i2, int i3, int i4) {
        if (i4 != -8) {
            if (i4 != -6) {
                if (i4 == -4) {
                    i2 = q(bArr, i2 + 1, i3);
                    if (i2 == i3 || bArr[i2] != 61) {
                        throw new IllegalArgumentException("Missing one pad character at index " + i2);
                    }
                } else if (i4 != -2) {
                    throw new IllegalStateException("Unreachable".toString());
                }
            }
            return i2 + 1;
        }
        throw new IllegalArgumentException("Redundant pad character at index " + i2);
    }

    private final int q(byte[] bArr, int i2, int i3) {
        if (!this.f40399b) {
            return i2;
        }
        while (i2 < i3) {
            if (Base64Kt.f40401b[bArr[i2] & 255] != -1) {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    public final byte[] b(CharSequence charSequence, int i2, int i3) {
        Intrinsics.f(charSequence, "source");
        d(charSequence.length(), i2, i3);
        byte[] bArr = new byte[(i3 - i2)];
        int i4 = 0;
        while (i2 < i3) {
            char charAt = charSequence.charAt(i2);
            if (charAt <= 255) {
                bArr[i4] = (byte) charAt;
                i4++;
            } else {
                bArr[i4] = 63;
                i4++;
            }
            i2++;
        }
        return bArr;
    }

    public final void d(int i2, int i3, int i4) {
        AbstractList.f40302b.a(i3, i4, i2);
    }

    public final byte[] e(CharSequence charSequence, int i2, int i3) {
        byte[] bArr;
        Intrinsics.f(charSequence, "source");
        if (charSequence instanceof String) {
            d(charSequence.length(), i2, i3);
            String substring = ((String) charSequence).substring(i2, i3);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Charset charset = Charsets.f40518g;
            Intrinsics.d(substring, "null cannot be cast to non-null type java.lang.String");
            bArr = substring.getBytes(charset);
            Intrinsics.e(bArr, "this as java.lang.String).getBytes(charset)");
        } else {
            bArr = b(charSequence, i2, i3);
        }
        return h(this, bArr, 0, 0, 6, (Object) null);
    }

    public final byte[] f(byte[] bArr, int i2, int i3) {
        boolean z2;
        Intrinsics.f(bArr, "source");
        d(bArr.length, i2, i3);
        int j2 = j(bArr, i2, i3);
        byte[] bArr2 = new byte[j2];
        if (i(bArr, bArr2, 0, i2, i3) == j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return bArr2;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final String k(byte[] bArr, int i2, int i3) {
        Intrinsics.f(bArr, "source");
        return new String(o(bArr, i2, i3), Charsets.f40518g);
    }

    public final int m(byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        byte[] bArr3;
        int i5;
        boolean z2;
        Intrinsics.f(bArr, "source");
        Intrinsics.f(bArr2, "destination");
        d(bArr.length, i3, i4);
        c(bArr2.length, i2, n(i4 - i3));
        if (this.f40398a) {
            bArr3 = Base64Kt.f40402c;
        } else {
            bArr3 = Base64Kt.f40400a;
        }
        if (this.f40399b) {
            i5 = 19;
        } else {
            i5 = Integer.MAX_VALUE;
        }
        int i6 = i2;
        while (true) {
            z2 = false;
            if (i3 + 2 >= i4) {
                break;
            }
            int min = Math.min((i4 - i3) / 3, i5);
            int i7 = 0;
            while (i7 < min) {
                int i8 = i3 + 1;
                int i9 = i8 + 1;
                byte b2 = ((bArr[i3] & 255) << 16) | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
                int i10 = i6 + 1;
                bArr2[i6] = bArr3[b2 >>> 18];
                int i11 = i10 + 1;
                bArr2[i10] = bArr3[(b2 >>> 12) & 63];
                int i12 = i11 + 1;
                bArr2[i11] = bArr3[(b2 >>> 6) & 63];
                i6 = i12 + 1;
                bArr2[i12] = bArr3[b2 & 63];
                i7++;
                i3 = i9 + 1;
            }
            if (min == i5 && i3 != i4) {
                int i13 = i6 + 1;
                byte[] bArr4 = f40395d;
                bArr2[i6] = bArr4[0];
                i6 = i13 + 1;
                bArr2[i13] = bArr4[1];
            }
        }
        int i14 = i4 - i3;
        if (i14 == 1) {
            int i15 = i3 + 1;
            int i16 = (bArr[i3] & 255) << 4;
            int i17 = i6 + 1;
            bArr2[i6] = bArr3[i16 >>> 6];
            int i18 = i17 + 1;
            bArr2[i17] = bArr3[i16 & 63];
            int i19 = i18 + 1;
            bArr2[i18] = 61;
            i6 = i19 + 1;
            bArr2[i19] = 61;
            i3 = i15;
        } else if (i14 == 2) {
            int i20 = i3 + 1;
            int i21 = i20 + 1;
            int i22 = ((bArr[i20] & 255) << 2) | ((bArr[i3] & 255) << 10);
            int i23 = i6 + 1;
            bArr2[i6] = bArr3[i22 >>> 12];
            int i24 = i23 + 1;
            bArr2[i23] = bArr3[(i22 >>> 6) & 63];
            int i25 = i24 + 1;
            bArr2[i24] = bArr3[i22 & 63];
            i6 = i25 + 1;
            bArr2[i25] = 61;
            i3 = i21;
        }
        if (i3 == i4) {
            z2 = true;
        }
        if (z2) {
            return i6 - i2;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final byte[] o(byte[] bArr, int i2, int i3) {
        Intrinsics.f(bArr, "source");
        d(bArr.length, i2, i3);
        byte[] bArr2 = new byte[n(i3 - i2)];
        m(bArr, bArr2, 0, i2, i3);
        return bArr2;
    }
}
