package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;

public final class MediaMetadata {
    public static final MediaMetadata J = new Builder().I();
    private static final String K = Util.B0(0);
    private static final String L = Util.B0(1);
    private static final String M = Util.B0(2);
    private static final String N = Util.B0(3);
    private static final String O = Util.B0(4);
    private static final String P = Util.B0(5);
    private static final String Q = Util.B0(6);
    private static final String R = Util.B0(8);
    private static final String S = Util.B0(9);
    private static final String T = Util.B0(10);
    private static final String U = Util.B0(11);
    private static final String V = Util.B0(12);
    private static final String W = Util.B0(13);
    private static final String X = Util.B0(14);
    private static final String Y = Util.B0(15);
    private static final String Z = Util.B0(16);

    /* renamed from: a0  reason: collision with root package name */
    private static final String f4213a0 = Util.B0(17);

    /* renamed from: b0  reason: collision with root package name */
    private static final String f4214b0 = Util.B0(18);

    /* renamed from: c0  reason: collision with root package name */
    private static final String f4215c0 = Util.B0(19);

    /* renamed from: d0  reason: collision with root package name */
    private static final String f4216d0 = Util.B0(20);

    /* renamed from: e0  reason: collision with root package name */
    private static final String f4217e0 = Util.B0(21);

    /* renamed from: f0  reason: collision with root package name */
    private static final String f4218f0 = Util.B0(22);

    /* renamed from: g0  reason: collision with root package name */
    private static final String f4219g0 = Util.B0(23);

    /* renamed from: h0  reason: collision with root package name */
    private static final String f4220h0 = Util.B0(24);

    /* renamed from: i0  reason: collision with root package name */
    private static final String f4221i0 = Util.B0(25);

    /* renamed from: j0  reason: collision with root package name */
    private static final String f4222j0 = Util.B0(26);

    /* renamed from: k0  reason: collision with root package name */
    private static final String f4223k0 = Util.B0(27);

    /* renamed from: l0  reason: collision with root package name */
    private static final String f4224l0 = Util.B0(28);

    /* renamed from: m0  reason: collision with root package name */
    private static final String f4225m0 = Util.B0(29);

    /* renamed from: n0  reason: collision with root package name */
    private static final String f4226n0 = Util.B0(30);

    /* renamed from: o0  reason: collision with root package name */
    private static final String f4227o0 = Util.B0(31);

    /* renamed from: p0  reason: collision with root package name */
    private static final String f4228p0 = Util.B0(32);

    /* renamed from: q0  reason: collision with root package name */
    private static final String f4229q0 = Util.B0(33);

    /* renamed from: r0  reason: collision with root package name */
    private static final String f4230r0 = Util.B0(1000);
    public final CharSequence A;
    public final CharSequence B;
    public final Integer C;
    public final Integer D;
    public final CharSequence E;
    public final CharSequence F;
    public final CharSequence G;
    public final Integer H;
    public final Bundle I;

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f4231a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f4232b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f4233c;

    /* renamed from: d  reason: collision with root package name */
    public final CharSequence f4234d;

    /* renamed from: e  reason: collision with root package name */
    public final CharSequence f4235e;

    /* renamed from: f  reason: collision with root package name */
    public final CharSequence f4236f;

    /* renamed from: g  reason: collision with root package name */
    public final CharSequence f4237g;

    /* renamed from: h  reason: collision with root package name */
    public final Long f4238h;

    /* renamed from: i  reason: collision with root package name */
    public final Rating f4239i;

    /* renamed from: j  reason: collision with root package name */
    public final Rating f4240j;

    /* renamed from: k  reason: collision with root package name */
    public final byte[] f4241k;

    /* renamed from: l  reason: collision with root package name */
    public final Integer f4242l;

    /* renamed from: m  reason: collision with root package name */
    public final Uri f4243m;

    /* renamed from: n  reason: collision with root package name */
    public final Integer f4244n;

    /* renamed from: o  reason: collision with root package name */
    public final Integer f4245o;
    @Deprecated

    /* renamed from: p  reason: collision with root package name */
    public final Integer f4246p;

    /* renamed from: q  reason: collision with root package name */
    public final Boolean f4247q;

    /* renamed from: r  reason: collision with root package name */
    public final Boolean f4248r;
    @Deprecated

    /* renamed from: s  reason: collision with root package name */
    public final Integer f4249s;

    /* renamed from: t  reason: collision with root package name */
    public final Integer f4250t;

    /* renamed from: u  reason: collision with root package name */
    public final Integer f4251u;

    /* renamed from: v  reason: collision with root package name */
    public final Integer f4252v;

    /* renamed from: w  reason: collision with root package name */
    public final Integer f4253w;

    /* renamed from: x  reason: collision with root package name */
    public final Integer f4254x;

    /* renamed from: y  reason: collision with root package name */
    public final Integer f4255y;

    /* renamed from: z  reason: collision with root package name */
    public final CharSequence f4256z;

    public static final class Builder {
        /* access modifiers changed from: private */
        public CharSequence A;
        /* access modifiers changed from: private */
        public Integer B;
        /* access modifiers changed from: private */
        public Integer C;
        /* access modifiers changed from: private */
        public CharSequence D;
        /* access modifiers changed from: private */
        public CharSequence E;
        /* access modifiers changed from: private */
        public CharSequence F;
        /* access modifiers changed from: private */
        public Integer G;
        /* access modifiers changed from: private */
        public Bundle H;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f4257a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f4258b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f4259c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f4260d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f4261e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f4262f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public CharSequence f4263g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public Long f4264h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public Rating f4265i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public Rating f4266j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public byte[] f4267k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public Integer f4268l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public Uri f4269m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public Integer f4270n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public Integer f4271o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public Integer f4272p;
        /* access modifiers changed from: private */

        /* renamed from: q  reason: collision with root package name */
        public Boolean f4273q;
        /* access modifiers changed from: private */

        /* renamed from: r  reason: collision with root package name */
        public Boolean f4274r;
        /* access modifiers changed from: private */

        /* renamed from: s  reason: collision with root package name */
        public Integer f4275s;
        /* access modifiers changed from: private */

        /* renamed from: t  reason: collision with root package name */
        public Integer f4276t;
        /* access modifiers changed from: private */

        /* renamed from: u  reason: collision with root package name */
        public Integer f4277u;
        /* access modifiers changed from: private */

        /* renamed from: v  reason: collision with root package name */
        public Integer f4278v;
        /* access modifiers changed from: private */

        /* renamed from: w  reason: collision with root package name */
        public Integer f4279w;
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public Integer f4280x;
        /* access modifiers changed from: private */

        /* renamed from: y  reason: collision with root package name */
        public CharSequence f4281y;
        /* access modifiers changed from: private */

        /* renamed from: z  reason: collision with root package name */
        public CharSequence f4282z;

        public MediaMetadata I() {
            return new MediaMetadata(this);
        }

        public Builder J(byte[] bArr, int i2) {
            if (this.f4267k == null || Util.c(Integer.valueOf(i2), 3) || !Util.c(this.f4268l, 3)) {
                this.f4267k = (byte[]) bArr.clone();
                this.f4268l = Integer.valueOf(i2);
            }
            return this;
        }

        public Builder K(MediaMetadata mediaMetadata) {
            if (mediaMetadata == null) {
                return this;
            }
            CharSequence charSequence = mediaMetadata.f4231a;
            if (charSequence != null) {
                o0(charSequence);
            }
            CharSequence charSequence2 = mediaMetadata.f4232b;
            if (charSequence2 != null) {
                P(charSequence2);
            }
            CharSequence charSequence3 = mediaMetadata.f4233c;
            if (charSequence3 != null) {
                O(charSequence3);
            }
            CharSequence charSequence4 = mediaMetadata.f4234d;
            if (charSequence4 != null) {
                N(charSequence4);
            }
            CharSequence charSequence5 = mediaMetadata.f4235e;
            if (charSequence5 != null) {
                X(charSequence5);
            }
            CharSequence charSequence6 = mediaMetadata.f4236f;
            if (charSequence6 != null) {
                n0(charSequence6);
            }
            CharSequence charSequence7 = mediaMetadata.f4237g;
            if (charSequence7 != null) {
                V(charSequence7);
            }
            Long l2 = mediaMetadata.f4238h;
            if (l2 != null) {
                Y(l2);
            }
            Rating rating = mediaMetadata.f4239i;
            if (rating != null) {
                s0(rating);
            }
            Rating rating2 = mediaMetadata.f4240j;
            if (rating2 != null) {
                f0(rating2);
            }
            Uri uri = mediaMetadata.f4243m;
            if (!(uri == null && mediaMetadata.f4241k == null)) {
                R(uri);
                Q(mediaMetadata.f4241k, mediaMetadata.f4242l);
            }
            Integer num = mediaMetadata.f4244n;
            if (num != null) {
                r0(num);
            }
            Integer num2 = mediaMetadata.f4245o;
            if (num2 != null) {
                q0(num2);
            }
            Integer num3 = mediaMetadata.f4246p;
            if (num3 != null) {
                a0(num3);
            }
            Boolean bool = mediaMetadata.f4247q;
            if (bool != null) {
                c0(bool);
            }
            Boolean bool2 = mediaMetadata.f4248r;
            if (bool2 != null) {
                d0(bool2);
            }
            Integer num4 = mediaMetadata.f4249s;
            if (num4 != null) {
                i0(num4);
            }
            Integer num5 = mediaMetadata.f4250t;
            if (num5 != null) {
                i0(num5);
            }
            Integer num6 = mediaMetadata.f4251u;
            if (num6 != null) {
                h0(num6);
            }
            Integer num7 = mediaMetadata.f4252v;
            if (num7 != null) {
                g0(num7);
            }
            Integer num8 = mediaMetadata.f4253w;
            if (num8 != null) {
                l0(num8);
            }
            Integer num9 = mediaMetadata.f4254x;
            if (num9 != null) {
                k0(num9);
            }
            Integer num10 = mediaMetadata.f4255y;
            if (num10 != null) {
                j0(num10);
            }
            CharSequence charSequence8 = mediaMetadata.f4256z;
            if (charSequence8 != null) {
                t0(charSequence8);
            }
            CharSequence charSequence9 = mediaMetadata.A;
            if (charSequence9 != null) {
                T(charSequence9);
            }
            CharSequence charSequence10 = mediaMetadata.B;
            if (charSequence10 != null) {
                U(charSequence10);
            }
            Integer num11 = mediaMetadata.C;
            if (num11 != null) {
                W(num11);
            }
            Integer num12 = mediaMetadata.D;
            if (num12 != null) {
                p0(num12);
            }
            CharSequence charSequence11 = mediaMetadata.E;
            if (charSequence11 != null) {
                b0(charSequence11);
            }
            CharSequence charSequence12 = mediaMetadata.F;
            if (charSequence12 != null) {
                S(charSequence12);
            }
            CharSequence charSequence13 = mediaMetadata.G;
            if (charSequence13 != null) {
                m0(charSequence13);
            }
            Integer num13 = mediaMetadata.H;
            if (num13 != null) {
                e0(num13);
            }
            Bundle bundle = mediaMetadata.I;
            if (bundle != null) {
                Z(bundle);
            }
            return this;
        }

        public Builder L(Metadata metadata) {
            for (int i2 = 0; i2 < metadata.f(); i2++) {
                metadata.e(i2).H(this);
            }
            return this;
        }

        public Builder M(List<Metadata> list) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                Metadata metadata = list.get(i2);
                for (int i3 = 0; i3 < metadata.f(); i3++) {
                    metadata.e(i3).H(this);
                }
            }
            return this;
        }

        public Builder N(CharSequence charSequence) {
            this.f4260d = charSequence;
            return this;
        }

        public Builder O(CharSequence charSequence) {
            this.f4259c = charSequence;
            return this;
        }

        public Builder P(CharSequence charSequence) {
            this.f4258b = charSequence;
            return this;
        }

        public Builder Q(byte[] bArr, Integer num) {
            byte[] bArr2;
            if (bArr == null) {
                bArr2 = null;
            } else {
                bArr2 = (byte[]) bArr.clone();
            }
            this.f4267k = bArr2;
            this.f4268l = num;
            return this;
        }

        public Builder R(Uri uri) {
            this.f4269m = uri;
            return this;
        }

        public Builder S(CharSequence charSequence) {
            this.E = charSequence;
            return this;
        }

        public Builder T(CharSequence charSequence) {
            this.f4282z = charSequence;
            return this;
        }

        public Builder U(CharSequence charSequence) {
            this.A = charSequence;
            return this;
        }

        public Builder V(CharSequence charSequence) {
            this.f4263g = charSequence;
            return this;
        }

        public Builder W(Integer num) {
            this.B = num;
            return this;
        }

        public Builder X(CharSequence charSequence) {
            this.f4261e = charSequence;
            return this;
        }

        public Builder Y(Long l2) {
            boolean z2;
            if (l2 == null || l2.longValue() >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            this.f4264h = l2;
            return this;
        }

        public Builder Z(Bundle bundle) {
            this.H = bundle;
            return this;
        }

        @Deprecated
        public Builder a0(Integer num) {
            this.f4272p = num;
            return this;
        }

        public Builder b0(CharSequence charSequence) {
            this.D = charSequence;
            return this;
        }

        public Builder c0(Boolean bool) {
            this.f4273q = bool;
            return this;
        }

        public Builder d0(Boolean bool) {
            this.f4274r = bool;
            return this;
        }

        public Builder e0(Integer num) {
            this.G = num;
            return this;
        }

        public Builder f0(Rating rating) {
            this.f4266j = rating;
            return this;
        }

        public Builder g0(Integer num) {
            this.f4277u = num;
            return this;
        }

        public Builder h0(Integer num) {
            this.f4276t = num;
            return this;
        }

        public Builder i0(Integer num) {
            this.f4275s = num;
            return this;
        }

        public Builder j0(Integer num) {
            this.f4280x = num;
            return this;
        }

        public Builder k0(Integer num) {
            this.f4279w = num;
            return this;
        }

        public Builder l0(Integer num) {
            this.f4278v = num;
            return this;
        }

        public Builder m0(CharSequence charSequence) {
            this.F = charSequence;
            return this;
        }

        public Builder n0(CharSequence charSequence) {
            this.f4262f = charSequence;
            return this;
        }

        public Builder o0(CharSequence charSequence) {
            this.f4257a = charSequence;
            return this;
        }

        public Builder p0(Integer num) {
            this.C = num;
            return this;
        }

        public Builder q0(Integer num) {
            this.f4271o = num;
            return this;
        }

        public Builder r0(Integer num) {
            this.f4270n = num;
            return this;
        }

        public Builder s0(Rating rating) {
            this.f4265i = rating;
            return this;
        }

        public Builder t0(CharSequence charSequence) {
            this.f4281y = charSequence;
            return this;
        }

        public Builder() {
        }

        private Builder(MediaMetadata mediaMetadata) {
            this.f4257a = mediaMetadata.f4231a;
            this.f4258b = mediaMetadata.f4232b;
            this.f4259c = mediaMetadata.f4233c;
            this.f4260d = mediaMetadata.f4234d;
            this.f4261e = mediaMetadata.f4235e;
            this.f4262f = mediaMetadata.f4236f;
            this.f4263g = mediaMetadata.f4237g;
            this.f4264h = mediaMetadata.f4238h;
            this.f4265i = mediaMetadata.f4239i;
            this.f4266j = mediaMetadata.f4240j;
            this.f4267k = mediaMetadata.f4241k;
            this.f4268l = mediaMetadata.f4242l;
            this.f4269m = mediaMetadata.f4243m;
            this.f4270n = mediaMetadata.f4244n;
            this.f4271o = mediaMetadata.f4245o;
            this.f4272p = mediaMetadata.f4246p;
            this.f4273q = mediaMetadata.f4247q;
            this.f4274r = mediaMetadata.f4248r;
            this.f4275s = mediaMetadata.f4250t;
            this.f4276t = mediaMetadata.f4251u;
            this.f4277u = mediaMetadata.f4252v;
            this.f4278v = mediaMetadata.f4253w;
            this.f4279w = mediaMetadata.f4254x;
            this.f4280x = mediaMetadata.f4255y;
            this.f4281y = mediaMetadata.f4256z;
            this.f4282z = mediaMetadata.A;
            this.A = mediaMetadata.B;
            this.B = mediaMetadata.C;
            this.C = mediaMetadata.D;
            this.D = mediaMetadata.E;
            this.E = mediaMetadata.F;
            this.F = mediaMetadata.G;
            this.G = mediaMetadata.H;
            this.H = mediaMetadata.I;
        }
    }

    private static int b(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                return 1;
            case 21:
                return 2;
            case 22:
                return 3;
            case 23:
                return 4;
            case 24:
                return 5;
            case 25:
                return 6;
            default:
                return 0;
        }
    }

    private static int c(int i2) {
        switch (i2) {
            case 1:
                return 0;
            case 2:
                return 21;
            case 3:
                return 22;
            case 4:
                return 23;
            case 5:
                return 24;
            case 6:
                return 25;
            default:
                return 20;
        }
    }

    public Builder a() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        boolean z2;
        boolean z3;
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaMetadata.class != obj.getClass()) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        if (Util.c(this.f4231a, mediaMetadata.f4231a) && Util.c(this.f4232b, mediaMetadata.f4232b) && Util.c(this.f4233c, mediaMetadata.f4233c) && Util.c(this.f4234d, mediaMetadata.f4234d) && Util.c(this.f4235e, mediaMetadata.f4235e) && Util.c(this.f4236f, mediaMetadata.f4236f) && Util.c(this.f4237g, mediaMetadata.f4237g) && Util.c(this.f4238h, mediaMetadata.f4238h) && Util.c(this.f4239i, mediaMetadata.f4239i) && Util.c(this.f4240j, mediaMetadata.f4240j) && Arrays.equals(this.f4241k, mediaMetadata.f4241k) && Util.c(this.f4242l, mediaMetadata.f4242l) && Util.c(this.f4243m, mediaMetadata.f4243m) && Util.c(this.f4244n, mediaMetadata.f4244n) && Util.c(this.f4245o, mediaMetadata.f4245o) && Util.c(this.f4246p, mediaMetadata.f4246p) && Util.c(this.f4247q, mediaMetadata.f4247q) && Util.c(this.f4248r, mediaMetadata.f4248r) && Util.c(this.f4250t, mediaMetadata.f4250t) && Util.c(this.f4251u, mediaMetadata.f4251u) && Util.c(this.f4252v, mediaMetadata.f4252v) && Util.c(this.f4253w, mediaMetadata.f4253w) && Util.c(this.f4254x, mediaMetadata.f4254x) && Util.c(this.f4255y, mediaMetadata.f4255y) && Util.c(this.f4256z, mediaMetadata.f4256z) && Util.c(this.A, mediaMetadata.A) && Util.c(this.B, mediaMetadata.B) && Util.c(this.C, mediaMetadata.C) && Util.c(this.D, mediaMetadata.D) && Util.c(this.E, mediaMetadata.E) && Util.c(this.F, mediaMetadata.F) && Util.c(this.G, mediaMetadata.G) && Util.c(this.H, mediaMetadata.H)) {
            if (this.I == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (mediaMetadata.I == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 == z3) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Object[] objArr = new Object[34];
        boolean z2 = false;
        objArr[0] = this.f4231a;
        objArr[1] = this.f4232b;
        objArr[2] = this.f4233c;
        objArr[3] = this.f4234d;
        objArr[4] = this.f4235e;
        objArr[5] = this.f4236f;
        objArr[6] = this.f4237g;
        objArr[7] = this.f4238h;
        objArr[8] = this.f4239i;
        objArr[9] = this.f4240j;
        objArr[10] = Integer.valueOf(Arrays.hashCode(this.f4241k));
        objArr[11] = this.f4242l;
        objArr[12] = this.f4243m;
        objArr[13] = this.f4244n;
        objArr[14] = this.f4245o;
        objArr[15] = this.f4246p;
        objArr[16] = this.f4247q;
        objArr[17] = this.f4248r;
        objArr[18] = this.f4250t;
        objArr[19] = this.f4251u;
        objArr[20] = this.f4252v;
        objArr[21] = this.f4253w;
        objArr[22] = this.f4254x;
        objArr[23] = this.f4255y;
        objArr[24] = this.f4256z;
        objArr[25] = this.A;
        objArr[26] = this.B;
        objArr[27] = this.C;
        objArr[28] = this.D;
        objArr[29] = this.E;
        objArr[30] = this.F;
        objArr[31] = this.G;
        objArr[32] = this.H;
        if (this.I == null) {
            z2 = true;
        }
        objArr[33] = Boolean.valueOf(z2);
        return Objects.b(objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private MediaMetadata(androidx.media3.common.MediaMetadata.Builder r7) {
        /*
            r6 = this;
            r6.<init>()
            java.lang.Boolean r0 = r7.f4273q
            java.lang.Integer r1 = r7.f4272p
            java.lang.Integer r2 = r7.G
            r3 = 0
            r4 = -1
            if (r0 == 0) goto L_0x0035
            boolean r5 = r0.booleanValue()
            if (r5 != 0) goto L_0x001e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0056
        L_0x001e:
            if (r1 == 0) goto L_0x0026
            int r5 = r1.intValue()
            if (r5 != r4) goto L_0x0056
        L_0x0026:
            if (r2 == 0) goto L_0x0030
            int r1 = r2.intValue()
            int r3 = b(r1)
        L_0x0030:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x0056
        L_0x0035:
            if (r1 == 0) goto L_0x0056
            int r0 = r1.intValue()
            if (r0 == r4) goto L_0x003e
            r3 = 1
        L_0x003e:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            boolean r3 = r0.booleanValue()
            if (r3 == 0) goto L_0x0056
            if (r2 != 0) goto L_0x0056
            int r2 = r1.intValue()
            int r2 = c(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0056:
            java.lang.CharSequence r3 = r7.f4257a
            r6.f4231a = r3
            java.lang.CharSequence r3 = r7.f4258b
            r6.f4232b = r3
            java.lang.CharSequence r3 = r7.f4259c
            r6.f4233c = r3
            java.lang.CharSequence r3 = r7.f4260d
            r6.f4234d = r3
            java.lang.CharSequence r3 = r7.f4261e
            r6.f4235e = r3
            java.lang.CharSequence r3 = r7.f4262f
            r6.f4236f = r3
            java.lang.CharSequence r3 = r7.f4263g
            r6.f4237g = r3
            java.lang.Long r3 = r7.f4264h
            r6.f4238h = r3
            androidx.media3.common.Rating r3 = r7.f4265i
            r6.f4239i = r3
            androidx.media3.common.Rating r3 = r7.f4266j
            r6.f4240j = r3
            byte[] r3 = r7.f4267k
            r6.f4241k = r3
            java.lang.Integer r3 = r7.f4268l
            r6.f4242l = r3
            android.net.Uri r3 = r7.f4269m
            r6.f4243m = r3
            java.lang.Integer r3 = r7.f4270n
            r6.f4244n = r3
            java.lang.Integer r3 = r7.f4271o
            r6.f4245o = r3
            r6.f4246p = r1
            r6.f4247q = r0
            java.lang.Boolean r0 = r7.f4274r
            r6.f4248r = r0
            java.lang.Integer r0 = r7.f4275s
            r6.f4249s = r0
            java.lang.Integer r0 = r7.f4275s
            r6.f4250t = r0
            java.lang.Integer r0 = r7.f4276t
            r6.f4251u = r0
            java.lang.Integer r0 = r7.f4277u
            r6.f4252v = r0
            java.lang.Integer r0 = r7.f4278v
            r6.f4253w = r0
            java.lang.Integer r0 = r7.f4279w
            r6.f4254x = r0
            java.lang.Integer r0 = r7.f4280x
            r6.f4255y = r0
            java.lang.CharSequence r0 = r7.f4281y
            r6.f4256z = r0
            java.lang.CharSequence r0 = r7.f4282z
            r6.A = r0
            java.lang.CharSequence r0 = r7.A
            r6.B = r0
            java.lang.Integer r0 = r7.B
            r6.C = r0
            java.lang.Integer r0 = r7.C
            r6.D = r0
            java.lang.CharSequence r0 = r7.D
            r6.E = r0
            java.lang.CharSequence r0 = r7.E
            r6.F = r0
            java.lang.CharSequence r0 = r7.F
            r6.G = r0
            r6.H = r2
            android.os.Bundle r7 = r7.H
            r6.I = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.MediaMetadata.<init>(androidx.media3.common.MediaMetadata$Builder):void");
    }
}
