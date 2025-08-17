package androidx.media3.common;

import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.facebook.common.time.Clock;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class Format {
    private static final Format M = new Builder().K();
    private static final String N = Util.B0(0);
    private static final String O = Util.B0(1);
    private static final String P = Util.B0(2);
    private static final String Q = Util.B0(3);
    private static final String R = Util.B0(4);
    private static final String S = Util.B0(5);
    private static final String T = Util.B0(6);
    private static final String U = Util.B0(7);
    private static final String V = Util.B0(8);
    private static final String W = Util.B0(9);
    private static final String X = Util.B0(10);
    private static final String Y = Util.B0(11);
    private static final String Z = Util.B0(12);

    /* renamed from: a0  reason: collision with root package name */
    private static final String f3982a0 = Util.B0(13);

    /* renamed from: b0  reason: collision with root package name */
    private static final String f3983b0 = Util.B0(14);

    /* renamed from: c0  reason: collision with root package name */
    private static final String f3984c0 = Util.B0(15);

    /* renamed from: d0  reason: collision with root package name */
    private static final String f3985d0 = Util.B0(16);

    /* renamed from: e0  reason: collision with root package name */
    private static final String f3986e0 = Util.B0(17);

    /* renamed from: f0  reason: collision with root package name */
    private static final String f3987f0 = Util.B0(18);

    /* renamed from: g0  reason: collision with root package name */
    private static final String f3988g0 = Util.B0(19);

    /* renamed from: h0  reason: collision with root package name */
    private static final String f3989h0 = Util.B0(20);

    /* renamed from: i0  reason: collision with root package name */
    private static final String f3990i0 = Util.B0(21);

    /* renamed from: j0  reason: collision with root package name */
    private static final String f3991j0 = Util.B0(22);

    /* renamed from: k0  reason: collision with root package name */
    private static final String f3992k0 = Util.B0(23);

    /* renamed from: l0  reason: collision with root package name */
    private static final String f3993l0 = Util.B0(24);

    /* renamed from: m0  reason: collision with root package name */
    private static final String f3994m0 = Util.B0(25);

    /* renamed from: n0  reason: collision with root package name */
    private static final String f3995n0 = Util.B0(26);

    /* renamed from: o0  reason: collision with root package name */
    private static final String f3996o0 = Util.B0(27);

    /* renamed from: p0  reason: collision with root package name */
    private static final String f3997p0 = Util.B0(28);

    /* renamed from: q0  reason: collision with root package name */
    private static final String f3998q0 = Util.B0(29);

    /* renamed from: r0  reason: collision with root package name */
    private static final String f3999r0 = Util.B0(30);

    /* renamed from: s0  reason: collision with root package name */
    private static final String f4000s0 = Util.B0(31);

    /* renamed from: t0  reason: collision with root package name */
    private static final String f4001t0 = Util.B0(32);
    public final ColorInfo A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    private int L;

    /* renamed from: a  reason: collision with root package name */
    public final String f4002a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4003b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Label> f4004c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4005d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4006e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4007f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4008g;

    /* renamed from: h  reason: collision with root package name */
    public final int f4009h;

    /* renamed from: i  reason: collision with root package name */
    public final int f4010i;

    /* renamed from: j  reason: collision with root package name */
    public final String f4011j;

    /* renamed from: k  reason: collision with root package name */
    public final Metadata f4012k;

    /* renamed from: l  reason: collision with root package name */
    public final Object f4013l;

    /* renamed from: m  reason: collision with root package name */
    public final String f4014m;

    /* renamed from: n  reason: collision with root package name */
    public final String f4015n;

    /* renamed from: o  reason: collision with root package name */
    public final int f4016o;

    /* renamed from: p  reason: collision with root package name */
    public final int f4017p;

    /* renamed from: q  reason: collision with root package name */
    public final List<byte[]> f4018q;

    /* renamed from: r  reason: collision with root package name */
    public final DrmInitData f4019r;

    /* renamed from: s  reason: collision with root package name */
    public final long f4020s;

    /* renamed from: t  reason: collision with root package name */
    public final int f4021t;

    /* renamed from: u  reason: collision with root package name */
    public final int f4022u;

    /* renamed from: v  reason: collision with root package name */
    public final float f4023v;

    /* renamed from: w  reason: collision with root package name */
    public final int f4024w;

    /* renamed from: x  reason: collision with root package name */
    public final float f4025x;

    /* renamed from: y  reason: collision with root package name */
    public final byte[] f4026y;

    /* renamed from: z  reason: collision with root package name */
    public final int f4027z;

    public static final class Builder {
        /* access modifiers changed from: private */
        public int A;
        /* access modifiers changed from: private */
        public int B;
        /* access modifiers changed from: private */
        public int C;
        /* access modifiers changed from: private */
        public int D;
        /* access modifiers changed from: private */
        public int E;
        /* access modifiers changed from: private */
        public int F;
        /* access modifiers changed from: private */
        public int G;
        /* access modifiers changed from: private */
        public int H;
        /* access modifiers changed from: private */
        public int I;
        /* access modifiers changed from: private */
        public int J;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f4028a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f4029b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public List<Label> f4030c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f4031d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f4032e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f4033f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f4034g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f4035h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public String f4036i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public Metadata f4037j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public Object f4038k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public String f4039l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public String f4040m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public int f4041n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public int f4042o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public List<byte[]> f4043p;
        /* access modifiers changed from: private */

        /* renamed from: q  reason: collision with root package name */
        public DrmInitData f4044q;
        /* access modifiers changed from: private */

        /* renamed from: r  reason: collision with root package name */
        public long f4045r;
        /* access modifiers changed from: private */

        /* renamed from: s  reason: collision with root package name */
        public int f4046s;
        /* access modifiers changed from: private */

        /* renamed from: t  reason: collision with root package name */
        public int f4047t;
        /* access modifiers changed from: private */

        /* renamed from: u  reason: collision with root package name */
        public float f4048u;
        /* access modifiers changed from: private */

        /* renamed from: v  reason: collision with root package name */
        public int f4049v;
        /* access modifiers changed from: private */

        /* renamed from: w  reason: collision with root package name */
        public float f4050w;
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public byte[] f4051x;
        /* access modifiers changed from: private */

        /* renamed from: y  reason: collision with root package name */
        public int f4052y;
        /* access modifiers changed from: private */

        /* renamed from: z  reason: collision with root package name */
        public ColorInfo f4053z;

        public Format K() {
            return new Format(this);
        }

        public Builder L(int i2) {
            this.F = i2;
            return this;
        }

        public Builder M(int i2) {
            this.f4034g = i2;
            return this;
        }

        public Builder N(int i2) {
            this.A = i2;
            return this;
        }

        public Builder O(String str) {
            this.f4036i = str;
            return this;
        }

        public Builder P(ColorInfo colorInfo) {
            this.f4053z = colorInfo;
            return this;
        }

        public Builder Q(String str) {
            this.f4039l = MimeTypes.t(str);
            return this;
        }

        public Builder R(int i2) {
            this.J = i2;
            return this;
        }

        public Builder S(int i2) {
            this.G = i2;
            return this;
        }

        public Builder T(Object obj) {
            this.f4038k = obj;
            return this;
        }

        public Builder U(DrmInitData drmInitData) {
            this.f4044q = drmInitData;
            return this;
        }

        public Builder V(int i2) {
            this.D = i2;
            return this;
        }

        public Builder W(int i2) {
            this.E = i2;
            return this;
        }

        public Builder X(float f2) {
            this.f4048u = f2;
            return this;
        }

        public Builder Y(int i2) {
            this.f4047t = i2;
            return this;
        }

        public Builder Z(int i2) {
            this.f4028a = Integer.toString(i2);
            return this;
        }

        public Builder a0(String str) {
            this.f4028a = str;
            return this;
        }

        public Builder b0(List<byte[]> list) {
            this.f4043p = list;
            return this;
        }

        public Builder c0(String str) {
            this.f4029b = str;
            return this;
        }

        public Builder d0(List<Label> list) {
            this.f4030c = ImmutableList.n(list);
            return this;
        }

        public Builder e0(String str) {
            this.f4031d = str;
            return this;
        }

        public Builder f0(int i2) {
            this.f4041n = i2;
            return this;
        }

        public Builder g0(int i2) {
            this.f4042o = i2;
            return this;
        }

        public Builder h0(Metadata metadata) {
            this.f4037j = metadata;
            return this;
        }

        public Builder i0(int i2) {
            this.C = i2;
            return this;
        }

        public Builder j0(int i2) {
            this.f4035h = i2;
            return this;
        }

        public Builder k0(float f2) {
            this.f4050w = f2;
            return this;
        }

        public Builder l0(byte[] bArr) {
            this.f4051x = bArr;
            return this;
        }

        public Builder m0(int i2) {
            this.f4033f = i2;
            return this;
        }

        public Builder n0(int i2) {
            this.f4049v = i2;
            return this;
        }

        public Builder o0(String str) {
            this.f4040m = MimeTypes.t(str);
            return this;
        }

        public Builder p0(int i2) {
            this.B = i2;
            return this;
        }

        public Builder q0(int i2) {
            this.f4032e = i2;
            return this;
        }

        public Builder r0(int i2) {
            this.f4052y = i2;
            return this;
        }

        public Builder s0(long j2) {
            this.f4045r = j2;
            return this;
        }

        public Builder t0(int i2) {
            this.H = i2;
            return this;
        }

        public Builder u0(int i2) {
            this.I = i2;
            return this;
        }

        public Builder v0(int i2) {
            this.f4046s = i2;
            return this;
        }

        public Builder() {
            this.f4030c = ImmutableList.r();
            this.f4034g = -1;
            this.f4035h = -1;
            this.f4041n = -1;
            this.f4042o = -1;
            this.f4045r = Clock.MAX_TIME;
            this.f4046s = -1;
            this.f4047t = -1;
            this.f4048u = -1.0f;
            this.f4050w = 1.0f;
            this.f4052y = -1;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.F = -1;
            this.G = 1;
            this.H = -1;
            this.I = -1;
            this.J = 0;
        }

        private Builder(Format format) {
            this.f4028a = format.f4002a;
            this.f4029b = format.f4003b;
            this.f4030c = format.f4004c;
            this.f4031d = format.f4005d;
            this.f4032e = format.f4006e;
            this.f4033f = format.f4007f;
            this.f4034g = format.f4008g;
            this.f4035h = format.f4009h;
            this.f4036i = format.f4011j;
            this.f4037j = format.f4012k;
            this.f4038k = format.f4013l;
            this.f4039l = format.f4014m;
            this.f4040m = format.f4015n;
            this.f4041n = format.f4016o;
            this.f4042o = format.f4017p;
            this.f4043p = format.f4018q;
            this.f4044q = format.f4019r;
            this.f4045r = format.f4020s;
            this.f4046s = format.f4021t;
            this.f4047t = format.f4022u;
            this.f4048u = format.f4023v;
            this.f4049v = format.f4024w;
            this.f4050w = format.f4025x;
            this.f4051x = format.f4026y;
            this.f4052y = format.f4027z;
            this.f4053z = format.A;
            this.A = format.B;
            this.B = format.C;
            this.C = format.D;
            this.D = format.E;
            this.E = format.F;
            this.F = format.G;
            this.G = format.H;
            this.H = format.I;
            this.I = format.J;
            this.J = format.K;
        }
    }

    private static String c(List<Label> list, String str) {
        for (Label next : list) {
            if (TextUtils.equals(next.f4069a, str)) {
                return next.f4070b;
            }
        }
        return list.get(0).f4070b;
    }

    private static boolean f(Builder builder) {
        if (builder.f4030c.isEmpty() && builder.f4029b == null) {
            return true;
        }
        for (int i2 = 0; i2 < builder.f4030c.size(); i2++) {
            if (((Label) builder.f4030c.get(i2)).f4070b.equals(builder.f4029b)) {
                return true;
            }
        }
        return false;
    }

    public static String g(Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(format.f4002a);
        sb.append(", mimeType=");
        sb.append(format.f4015n);
        if (format.f4014m != null) {
            sb.append(", container=");
            sb.append(format.f4014m);
        }
        if (format.f4010i != -1) {
            sb.append(", bitrate=");
            sb.append(format.f4010i);
        }
        if (format.f4011j != null) {
            sb.append(", codecs=");
            sb.append(format.f4011j);
        }
        if (format.f4019r != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i2 = 0;
            while (true) {
                DrmInitData drmInitData = format.f4019r;
                if (i2 >= drmInitData.f3973e) {
                    break;
                }
                UUID uuid = drmInitData.f(i2).f3975c;
                if (uuid.equals(C.f3931b)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(C.f3932c)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(C.f3934e)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(C.f3933d)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(C.f3930a)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
                i2++;
            }
            sb.append(", drm=[");
            Joiner.e(',').b(sb, linkedHashSet);
            sb.append(']');
        }
        if (!(format.f4021t == -1 || format.f4022u == -1)) {
            sb.append(", res=");
            sb.append(format.f4021t);
            sb.append("x");
            sb.append(format.f4022u);
        }
        ColorInfo colorInfo = format.A;
        if (colorInfo != null && colorInfo.i()) {
            sb.append(", color=");
            sb.append(format.A.m());
        }
        if (format.f4023v != -1.0f) {
            sb.append(", fps=");
            sb.append(format.f4023v);
        }
        if (format.B != -1) {
            sb.append(", channels=");
            sb.append(format.B);
        }
        if (format.C != -1) {
            sb.append(", sample_rate=");
            sb.append(format.C);
        }
        if (format.f4005d != null) {
            sb.append(", language=");
            sb.append(format.f4005d);
        }
        if (!format.f4004c.isEmpty()) {
            sb.append(", labels=[");
            Joiner.e(',').b(sb, format.f4004c);
            sb.append("]");
        }
        if (format.f4006e != 0) {
            sb.append(", selectionFlags=[");
            Joiner.e(',').b(sb, Util.l0(format.f4006e));
            sb.append("]");
        }
        if (format.f4007f != 0) {
            sb.append(", roleFlags=[");
            Joiner.e(',').b(sb, Util.k0(format.f4007f));
            sb.append("]");
        }
        if (format.f4013l != null) {
            sb.append(", customData=");
            sb.append(format.f4013l);
        }
        return sb.toString();
    }

    public Builder a() {
        return new Builder();
    }

    public Format b(int i2) {
        return a().R(i2).K();
    }

    public int d() {
        int i2;
        int i3 = this.f4021t;
        if (i3 == -1 || (i2 = this.f4022u) == -1) {
            return -1;
        }
        return i3 * i2;
    }

    public boolean e(Format format) {
        if (this.f4018q.size() != format.f4018q.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f4018q.size(); i2++) {
            if (!Arrays.equals(this.f4018q.get(i2), format.f4018q.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        int i2;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i3 = this.L;
        if ((i3 == 0 || (i2 = format.L) == 0 || i3 == i2) && this.f4006e == format.f4006e && this.f4007f == format.f4007f && this.f4008g == format.f4008g && this.f4009h == format.f4009h && this.f4016o == format.f4016o && this.f4020s == format.f4020s && this.f4021t == format.f4021t && this.f4022u == format.f4022u && this.f4024w == format.f4024w && this.f4027z == format.f4027z && this.B == format.B && this.C == format.C && this.D == format.D && this.E == format.E && this.F == format.F && this.G == format.G && this.I == format.I && this.J == format.J && this.K == format.K && Float.compare(this.f4023v, format.f4023v) == 0 && Float.compare(this.f4025x, format.f4025x) == 0 && Objects.equals(this.f4002a, format.f4002a) && Objects.equals(this.f4003b, format.f4003b) && this.f4004c.equals(format.f4004c) && Objects.equals(this.f4011j, format.f4011j) && Objects.equals(this.f4014m, format.f4014m) && Objects.equals(this.f4015n, format.f4015n) && Objects.equals(this.f4005d, format.f4005d) && Arrays.equals(this.f4026y, format.f4026y) && Objects.equals(this.f4012k, format.f4012k) && Objects.equals(this.A, format.A) && Objects.equals(this.f4019r, format.f4019r) && e(format) && Objects.equals(this.f4013l, format.f4013l)) {
            return true;
        }
        return false;
    }

    public Format h(Format format) {
        List<Label> list;
        Metadata metadata;
        String str;
        if (this == format) {
            return this;
        }
        int k2 = MimeTypes.k(this.f4015n);
        String str2 = format.f4002a;
        int i2 = format.I;
        int i3 = format.J;
        String str3 = format.f4003b;
        if (str3 == null) {
            str3 = this.f4003b;
        }
        if (!format.f4004c.isEmpty()) {
            list = format.f4004c;
        } else {
            list = this.f4004c;
        }
        String str4 = this.f4005d;
        if ((k2 == 3 || k2 == 1) && (str = format.f4005d) != null) {
            str4 = str;
        }
        int i4 = this.f4008g;
        if (i4 == -1) {
            i4 = format.f4008g;
        }
        int i5 = this.f4009h;
        if (i5 == -1) {
            i5 = format.f4009h;
        }
        String str5 = this.f4011j;
        if (str5 == null) {
            String Q2 = Util.Q(format.f4011j, k2);
            if (Util.m1(Q2).length == 1) {
                str5 = Q2;
            }
        }
        Metadata metadata2 = this.f4012k;
        if (metadata2 == null) {
            metadata = format.f4012k;
        } else {
            metadata = metadata2.c(format.f4012k);
        }
        float f2 = this.f4023v;
        if (f2 == -1.0f && k2 == 2) {
            f2 = format.f4023v;
        }
        int i6 = this.f4006e | format.f4006e;
        int i7 = this.f4007f | format.f4007f;
        return a().a0(str2).c0(str3).d0(list).e0(str4).q0(i6).m0(i7).M(i4).j0(i5).O(str5).h0(metadata).U(DrmInitData.e(format.f4019r, this.f4019r)).X(f2).t0(i2).u0(i3).K();
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (this.L == 0) {
            String str = this.f4002a;
            int i9 = 0;
            if (str == null) {
                i2 = 0;
            } else {
                i2 = str.hashCode();
            }
            int i10 = (527 + i2) * 31;
            String str2 = this.f4003b;
            if (str2 == null) {
                i3 = 0;
            } else {
                i3 = str2.hashCode();
            }
            int hashCode = (((i10 + i3) * 31) + this.f4004c.hashCode()) * 31;
            String str3 = this.f4005d;
            if (str3 == null) {
                i4 = 0;
            } else {
                i4 = str3.hashCode();
            }
            int i11 = (((((((((hashCode + i4) * 31) + this.f4006e) * 31) + this.f4007f) * 31) + this.f4008g) * 31) + this.f4009h) * 31;
            String str4 = this.f4011j;
            if (str4 == null) {
                i5 = 0;
            } else {
                i5 = str4.hashCode();
            }
            int i12 = (i11 + i5) * 31;
            Metadata metadata = this.f4012k;
            if (metadata == null) {
                i6 = 0;
            } else {
                i6 = metadata.hashCode();
            }
            int i13 = (i12 + i6) * 31;
            Object obj = this.f4013l;
            if (obj == null) {
                i7 = 0;
            } else {
                i7 = obj.hashCode();
            }
            int i14 = (i13 + i7) * 31;
            String str5 = this.f4014m;
            if (str5 == null) {
                i8 = 0;
            } else {
                i8 = str5.hashCode();
            }
            int i15 = (i14 + i8) * 31;
            String str6 = this.f4015n;
            if (str6 != null) {
                i9 = str6.hashCode();
            }
            this.L = ((((((((((((((((((((((((((((((((((i15 + i9) * 31) + this.f4016o) * 31) + ((int) this.f4020s)) * 31) + this.f4021t) * 31) + this.f4022u) * 31) + Float.floatToIntBits(this.f4023v)) * 31) + this.f4024w) * 31) + Float.floatToIntBits(this.f4025x)) * 31) + this.f4027z) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.F) * 31) + this.G) * 31) + this.I) * 31) + this.J) * 31) + this.K;
        }
        return this.L;
    }

    public String toString() {
        return "Format(" + this.f4002a + ", " + this.f4003b + ", " + this.f4014m + ", " + this.f4015n + ", " + this.f4011j + ", " + this.f4010i + ", " + this.f4005d + ", [" + this.f4021t + ", " + this.f4022u + ", " + this.f4023v + ", " + this.A + "], [" + this.B + ", " + this.C + "])";
    }

    private Format(Builder builder) {
        this.f4002a = builder.f4028a;
        String R0 = Util.R0(builder.f4031d);
        this.f4005d = R0;
        if (builder.f4030c.isEmpty() && builder.f4029b != null) {
            this.f4004c = ImmutableList.s(new Label(R0, builder.f4029b));
            this.f4003b = builder.f4029b;
        } else if (builder.f4030c.isEmpty() || builder.f4029b != null) {
            Assertions.h(f(builder));
            this.f4004c = builder.f4030c;
            this.f4003b = builder.f4029b;
        } else {
            this.f4004c = builder.f4030c;
            this.f4003b = c(builder.f4030c, R0);
        }
        this.f4006e = builder.f4032e;
        this.f4007f = builder.f4033f;
        int H2 = builder.f4034g;
        this.f4008g = H2;
        int I2 = builder.f4035h;
        this.f4009h = I2;
        this.f4010i = I2 != -1 ? I2 : H2;
        this.f4011j = builder.f4036i;
        this.f4012k = builder.f4037j;
        this.f4013l = builder.f4038k;
        this.f4014m = builder.f4039l;
        this.f4015n = builder.f4040m;
        this.f4016o = builder.f4041n;
        this.f4017p = builder.f4042o;
        this.f4018q = builder.f4043p == null ? Collections.emptyList() : builder.f4043p;
        DrmInitData i2 = builder.f4044q;
        this.f4019r = i2;
        this.f4020s = builder.f4045r;
        this.f4021t = builder.f4046s;
        this.f4022u = builder.f4047t;
        this.f4023v = builder.f4048u;
        int i3 = 0;
        this.f4024w = builder.f4049v == -1 ? 0 : builder.f4049v;
        this.f4025x = builder.f4050w == -1.0f ? 1.0f : builder.f4050w;
        this.f4026y = builder.f4051x;
        this.f4027z = builder.f4052y;
        this.A = builder.f4053z;
        this.B = builder.A;
        this.C = builder.B;
        this.D = builder.C;
        this.E = builder.D == -1 ? 0 : builder.D;
        this.F = builder.E != -1 ? builder.E : i3;
        this.G = builder.F;
        this.H = builder.G;
        this.I = builder.H;
        this.J = builder.I;
        if (builder.J != 0 || i2 == null) {
            this.K = builder.J;
        } else {
            this.K = 1;
        }
    }
}
