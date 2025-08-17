package okio;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f41331e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    public static final ByteString f41332f = new ByteString(new byte[0]);

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f41333b;

    /* renamed from: c  reason: collision with root package name */
    private transient int f41334c;

    /* renamed from: d  reason: collision with root package name */
    private transient String f41335d;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ByteString g(Companion companion, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = SegmentedByteString.c();
            }
            return companion.f(bArr, i2, i3);
        }

        public final ByteString a(String str) {
            Intrinsics.f(str, "<this>");
            byte[] a2 = Base64.a(str);
            if (a2 != null) {
                return new ByteString(a2);
            }
            return null;
        }

        public final ByteString b(String str) {
            boolean z2;
            Intrinsics.f(str, "<this>");
            if (str.length() % 2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    bArr[i2] = (byte) ((okio.internal.ByteString.e(str.charAt(i3)) << 4) + okio.internal.ByteString.e(str.charAt(i3 + 1)));
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }

        public final ByteString c(String str, Charset charset) {
            Intrinsics.f(str, "<this>");
            Intrinsics.f(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        public final ByteString d(String str) {
            Intrinsics.f(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.a(str));
            byteString.s(str);
            return byteString;
        }

        public final ByteString e(byte... bArr) {
            Intrinsics.f(bArr, "data");
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.e(copyOf, "copyOf(this, size)");
            return new ByteString(copyOf);
        }

        public final ByteString f(byte[] bArr, int i2, int i3) {
            Intrinsics.f(bArr, "<this>");
            int f2 = SegmentedByteString.f(bArr, i3);
            SegmentedByteString.b((long) bArr.length, (long) i2, (long) f2);
            return new ByteString(ArraysKt___ArraysJvmKt.i(bArr, i2, f2 + i2));
        }
    }

    public ByteString(byte[] bArr) {
        Intrinsics.f(bArr, "data");
        this.f41333b = bArr;
    }

    public static final ByteString c(String str) {
        return f41331e.a(str);
    }

    public static final ByteString e(String str) {
        return f41331e.d(str);
    }

    public static final ByteString o(byte... bArr) {
        return f41331e.e(bArr);
    }

    public String a() {
        return Base64.c(g(), (byte[]) null, 1, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0030 A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L_0x0013:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L_0x002b
            byte r7 = r9.f(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.f(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L_0x0028
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0028:
            if (r7 >= r8) goto L_0x0032
            goto L_0x0030
        L_0x002b:
            if (r0 != r1) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            if (r0 >= r1) goto L_0x0032
        L_0x0030:
            r3 = -1
            goto L_0x0033
        L_0x0032:
            r3 = 1
        L_0x0033:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public ByteString d(String str) {
        Intrinsics.f(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(this.f41333b, 0, size());
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
            return byteString.size() == g().length && byteString.q(0, g(), 0, g().length);
        }
    }

    public final byte f(int i2) {
        return m(i2);
    }

    public final byte[] g() {
        return this.f41333b;
    }

    public final int h() {
        return this.f41334c;
    }

    public int hashCode() {
        int h2 = h();
        if (h2 != 0) {
            return h2;
        }
        int hashCode = Arrays.hashCode(g());
        r(hashCode);
        return hashCode;
    }

    public int i() {
        return g().length;
    }

    public final String j() {
        return this.f41335d;
    }

    public String k() {
        char[] cArr = new char[(g().length * 2)];
        int i2 = 0;
        for (byte b2 : g()) {
            int i3 = i2 + 1;
            cArr[i2] = okio.internal.ByteString.f()[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = okio.internal.ByteString.f()[b2 & 15];
        }
        return StringsKt__StringsJVMKt.o(cArr);
    }

    public byte[] l() {
        return g();
    }

    public byte m(int i2) {
        return g()[i2];
    }

    public final ByteString n() {
        return d("MD5");
    }

    public boolean p(int i2, ByteString byteString, int i3, int i4) {
        Intrinsics.f(byteString, "other");
        return byteString.q(i3, g(), i2, i4);
    }

    public boolean q(int i2, byte[] bArr, int i3, int i4) {
        Intrinsics.f(bArr, "other");
        if (i2 < 0 || i2 > g().length - i4 || i3 < 0 || i3 > bArr.length - i4 || !SegmentedByteString.a(g(), i2, bArr, i3, i4)) {
            return false;
        }
        return true;
    }

    public final void r(int i2) {
        this.f41334c = i2;
    }

    public final void s(String str) {
        this.f41335d = str;
    }

    public final int size() {
        return i();
    }

    public final ByteString t() {
        return d("SHA-1");
    }

    public String toString() {
        boolean z2;
        boolean z3;
        ByteString byteString;
        String str;
        boolean z4 = true;
        if (g().length == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            str = "[size=0]";
        } else {
            int a2 = okio.internal.ByteString.c(g(), 64);
            if (a2 != -1) {
                String y2 = y();
                String substring = y2.substring(0, a2);
                Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String C = StringsKt__StringsJVMKt.C(StringsKt__StringsJVMKt.C(StringsKt__StringsJVMKt.C(substring, "\\", "\\\\", false, 4, (Object) null), ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
                if (a2 < y2.length()) {
                    return "[size=" + g().length + " text=" + C + "…]";
                }
                return "[text=" + C + ']';
            } else if (g().length <= 64) {
                str = "[hex=" + k() + ']';
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[size=");
                sb.append(g().length);
                sb.append(" hex=");
                int e2 = SegmentedByteString.e(this, 64);
                if (e2 <= g().length) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (e2 + 0 < 0) {
                        z4 = false;
                    }
                    if (z4) {
                        if (e2 == g().length) {
                            byteString = this;
                        } else {
                            byteString = new ByteString(ArraysKt___ArraysJvmKt.i(g(), 0, e2));
                        }
                        sb.append(byteString.k());
                        sb.append("…]");
                        return sb.toString();
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                throw new IllegalArgumentException(("endIndex > length(" + g().length + ')').toString());
            }
        }
        return str;
    }

    public final ByteString u() {
        return d("SHA-256");
    }

    public final boolean v(ByteString byteString) {
        Intrinsics.f(byteString, "prefix");
        return p(0, byteString, 0, byteString.size());
    }

    public ByteString w() {
        int i2 = 0;
        while (i2 < g().length) {
            byte b2 = g()[i2];
            if (b2 < 65 || b2 > 90) {
                i2++;
            } else {
                byte[] g2 = g();
                byte[] copyOf = Arrays.copyOf(g2, g2.length);
                Intrinsics.e(copyOf, "copyOf(this, size)");
                copyOf[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b3 = copyOf[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        copyOf[i3] = (byte) (b3 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public byte[] x() {
        byte[] g2 = g();
        byte[] copyOf = Arrays.copyOf(g2, g2.length);
        Intrinsics.e(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public String y() {
        String j2 = j();
        if (j2 != null) {
            return j2;
        }
        String b2 = _JvmPlatformKt.b(l());
        s(b2);
        return b2;
    }

    public void z(Buffer buffer, int i2, int i3) {
        Intrinsics.f(buffer, "buffer");
        okio.internal.ByteString.d(this, buffer, i2, i3);
    }
}
