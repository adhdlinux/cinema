package androidx.media3.common;

import androidx.media3.common.util.Util;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

public final class ColorInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final ColorInfo f3935h = new Builder().d(1).c(2).e(3).a();

    /* renamed from: i  reason: collision with root package name */
    public static final ColorInfo f3936i = new Builder().d(1).c(1).e(2).a();

    /* renamed from: j  reason: collision with root package name */
    private static final String f3937j = Util.B0(0);

    /* renamed from: k  reason: collision with root package name */
    private static final String f3938k = Util.B0(1);

    /* renamed from: l  reason: collision with root package name */
    private static final String f3939l = Util.B0(2);

    /* renamed from: m  reason: collision with root package name */
    private static final String f3940m = Util.B0(3);

    /* renamed from: n  reason: collision with root package name */
    private static final String f3941n = Util.B0(4);

    /* renamed from: o  reason: collision with root package name */
    private static final String f3942o = Util.B0(5);

    /* renamed from: a  reason: collision with root package name */
    public final int f3943a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3944b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3945c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f3946d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3947e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3948f;

    /* renamed from: g  reason: collision with root package name */
    private int f3949g;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f3950a;

        /* renamed from: b  reason: collision with root package name */
        private int f3951b;

        /* renamed from: c  reason: collision with root package name */
        private int f3952c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f3953d;

        /* renamed from: e  reason: collision with root package name */
        private int f3954e;

        /* renamed from: f  reason: collision with root package name */
        private int f3955f;

        public ColorInfo a() {
            return new ColorInfo(this.f3950a, this.f3951b, this.f3952c, this.f3953d, this.f3954e, this.f3955f);
        }

        public Builder b(int i2) {
            this.f3955f = i2;
            return this;
        }

        public Builder c(int i2) {
            this.f3951b = i2;
            return this;
        }

        public Builder d(int i2) {
            this.f3950a = i2;
            return this;
        }

        public Builder e(int i2) {
            this.f3952c = i2;
            return this;
        }

        public Builder f(byte[] bArr) {
            this.f3953d = bArr;
            return this;
        }

        public Builder g(int i2) {
            this.f3954e = i2;
            return this;
        }

        public Builder() {
            this.f3950a = -1;
            this.f3951b = -1;
            this.f3952c = -1;
            this.f3954e = -1;
            this.f3955f = -1;
        }

        private Builder(ColorInfo colorInfo) {
            this.f3950a = colorInfo.f3943a;
            this.f3951b = colorInfo.f3944b;
            this.f3952c = colorInfo.f3945c;
            this.f3953d = colorInfo.f3946d;
            this.f3954e = colorInfo.f3947e;
            this.f3955f = colorInfo.f3948f;
        }
    }

    private static String b(int i2) {
        if (i2 == -1) {
            return "NA";
        }
        return i2 + "bit Chroma";
    }

    private static String c(int i2) {
        if (i2 == -1) {
            return "Unset color range";
        }
        if (i2 == 1) {
            return "Full range";
        }
        if (i2 == 2) {
            return "Limited range";
        }
        return "Undefined color range " + i2;
    }

    private static String d(int i2) {
        if (i2 == -1) {
            return "Unset color space";
        }
        if (i2 == 6) {
            return "BT2020";
        }
        if (i2 == 1) {
            return "BT709";
        }
        if (i2 == 2) {
            return "BT601";
        }
        return "Undefined color space " + i2;
    }

    private static String e(int i2) {
        if (i2 == -1) {
            return "Unset color transfer";
        }
        if (i2 == 10) {
            return "Gamma 2.2";
        }
        if (i2 == 1) {
            return "Linear";
        }
        if (i2 == 2) {
            return "sRGB";
        }
        if (i2 == 3) {
            return "SDR SMPTE 170M";
        }
        if (i2 == 6) {
            return "ST2084 PQ";
        }
        if (i2 == 7) {
            return "HLG";
        }
        return "Undefined color transfer " + i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r1 = r4.f3945c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001f, code lost:
        r1 = r4.f3948f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
        r4 = r4.f3947e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r1 = r4.f3944b;
     */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"#1"}, result = false)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean h(androidx.media3.common.ColorInfo r4) {
        /*
            r0 = 1
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r4.f3943a
            r2 = 2
            r3 = -1
            if (r1 == r3) goto L_0x000e
            if (r1 == r0) goto L_0x000e
            if (r1 != r2) goto L_0x002e
        L_0x000e:
            int r1 = r4.f3944b
            if (r1 == r3) goto L_0x0014
            if (r1 != r2) goto L_0x002e
        L_0x0014:
            int r1 = r4.f3945c
            if (r1 == r3) goto L_0x001b
            r2 = 3
            if (r1 != r2) goto L_0x002e
        L_0x001b:
            byte[] r1 = r4.f3946d
            if (r1 != 0) goto L_0x002e
            int r1 = r4.f3948f
            r2 = 8
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x002e
        L_0x0027:
            int r4 = r4.f3947e
            if (r4 == r3) goto L_0x002f
            if (r4 != r2) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.ColorInfo.h(androidx.media3.common.ColorInfo):boolean");
    }

    @Pure
    public static int j(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 9) {
            return (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int k(int i2) {
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 4) {
            return 10;
        }
        if (i2 == 13) {
            return 2;
        }
        if (i2 == 16) {
            return 6;
        }
        if (i2 != 18) {
            return (i2 == 6 || i2 == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String l(int i2) {
        if (i2 == -1) {
            return "NA";
        }
        return i2 + "bit Luma";
    }

    public Builder a() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ColorInfo.class != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        if (this.f3943a == colorInfo.f3943a && this.f3944b == colorInfo.f3944b && this.f3945c == colorInfo.f3945c && Arrays.equals(this.f3946d, colorInfo.f3946d) && this.f3947e == colorInfo.f3947e && this.f3948f == colorInfo.f3948f) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return (this.f3947e == -1 || this.f3948f == -1) ? false : true;
    }

    public boolean g() {
        return (this.f3943a == -1 || this.f3944b == -1 || this.f3945c == -1) ? false : true;
    }

    public int hashCode() {
        if (this.f3949g == 0) {
            this.f3949g = ((((((((((527 + this.f3943a) * 31) + this.f3944b) * 31) + this.f3945c) * 31) + Arrays.hashCode(this.f3946d)) * 31) + this.f3947e) * 31) + this.f3948f;
        }
        return this.f3949g;
    }

    public boolean i() {
        return f() || g();
    }

    public String m() {
        String str;
        String str2;
        if (g()) {
            str = Util.G("%s/%s/%s", d(this.f3943a), c(this.f3944b), e(this.f3945c));
        } else {
            str = "NA/NA/NA";
        }
        if (f()) {
            str2 = this.f3947e + "/" + this.f3948f;
        } else {
            str2 = "NA/NA";
        }
        return str + "/" + str2;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(d(this.f3943a));
        sb.append(", ");
        sb.append(c(this.f3944b));
        sb.append(", ");
        sb.append(e(this.f3945c));
        sb.append(", ");
        if (this.f3946d != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        sb.append(z2);
        sb.append(", ");
        sb.append(l(this.f3947e));
        sb.append(", ");
        sb.append(b(this.f3948f));
        sb.append(")");
        return sb.toString();
    }

    private ColorInfo(int i2, int i3, int i4, byte[] bArr, int i5, int i6) {
        this.f3943a = i2;
        this.f3944b = i3;
        this.f3945c = i4;
        this.f3946d = bArr;
        this.f3947e = i5;
        this.f3948f = i6;
    }
}
