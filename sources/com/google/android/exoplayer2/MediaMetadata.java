package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;

public final class MediaMetadata implements Bundleable {
    public static final MediaMetadata J = new Builder().H();
    private static final String K = Util.u0(0);
    private static final String L = Util.u0(1);
    private static final String M = Util.u0(2);
    private static final String N = Util.u0(3);
    private static final String O = Util.u0(4);
    private static final String P = Util.u0(5);
    private static final String Q = Util.u0(6);
    private static final String R = Util.u0(8);
    private static final String S = Util.u0(9);
    private static final String T = Util.u0(10);
    private static final String U = Util.u0(11);
    private static final String V = Util.u0(12);
    private static final String W = Util.u0(13);
    private static final String X = Util.u0(14);
    private static final String Y = Util.u0(15);
    private static final String Z = Util.u0(16);

    /* renamed from: a0  reason: collision with root package name */
    private static final String f23235a0 = Util.u0(17);

    /* renamed from: b0  reason: collision with root package name */
    private static final String f23236b0 = Util.u0(18);

    /* renamed from: c0  reason: collision with root package name */
    private static final String f23237c0 = Util.u0(19);

    /* renamed from: d0  reason: collision with root package name */
    private static final String f23238d0 = Util.u0(20);

    /* renamed from: e0  reason: collision with root package name */
    private static final String f23239e0 = Util.u0(21);

    /* renamed from: f0  reason: collision with root package name */
    private static final String f23240f0 = Util.u0(22);

    /* renamed from: g0  reason: collision with root package name */
    private static final String f23241g0 = Util.u0(23);

    /* renamed from: h0  reason: collision with root package name */
    private static final String f23242h0 = Util.u0(24);

    /* renamed from: i0  reason: collision with root package name */
    private static final String f23243i0 = Util.u0(25);

    /* renamed from: j0  reason: collision with root package name */
    private static final String f23244j0 = Util.u0(26);

    /* renamed from: k0  reason: collision with root package name */
    private static final String f23245k0 = Util.u0(27);

    /* renamed from: l0  reason: collision with root package name */
    private static final String f23246l0 = Util.u0(28);

    /* renamed from: m0  reason: collision with root package name */
    private static final String f23247m0 = Util.u0(29);

    /* renamed from: n0  reason: collision with root package name */
    private static final String f23248n0 = Util.u0(30);

    /* renamed from: o0  reason: collision with root package name */
    private static final String f23249o0 = Util.u0(31);

    /* renamed from: p0  reason: collision with root package name */
    private static final String f23250p0 = Util.u0(32);

    /* renamed from: q0  reason: collision with root package name */
    private static final String f23251q0 = Util.u0(1000);

    /* renamed from: r0  reason: collision with root package name */
    public static final Bundleable.Creator<MediaMetadata> f23252r0 = new e1();
    public final CharSequence A;
    public final CharSequence B;
    public final Integer C;
    public final Integer D;
    public final CharSequence E;
    public final CharSequence F;
    public final CharSequence G;
    public final Integer H;
    public final Bundle I;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f23253b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f23254c;

    /* renamed from: d  reason: collision with root package name */
    public final CharSequence f23255d;

    /* renamed from: e  reason: collision with root package name */
    public final CharSequence f23256e;

    /* renamed from: f  reason: collision with root package name */
    public final CharSequence f23257f;

    /* renamed from: g  reason: collision with root package name */
    public final CharSequence f23258g;

    /* renamed from: h  reason: collision with root package name */
    public final CharSequence f23259h;

    /* renamed from: i  reason: collision with root package name */
    public final Rating f23260i;

    /* renamed from: j  reason: collision with root package name */
    public final Rating f23261j;

    /* renamed from: k  reason: collision with root package name */
    public final byte[] f23262k;

    /* renamed from: l  reason: collision with root package name */
    public final Integer f23263l;

    /* renamed from: m  reason: collision with root package name */
    public final Uri f23264m;

    /* renamed from: n  reason: collision with root package name */
    public final Integer f23265n;

    /* renamed from: o  reason: collision with root package name */
    public final Integer f23266o;

    /* renamed from: p  reason: collision with root package name */
    public final Integer f23267p;

    /* renamed from: q  reason: collision with root package name */
    public final Boolean f23268q;

    /* renamed from: r  reason: collision with root package name */
    public final Boolean f23269r;
    @Deprecated

    /* renamed from: s  reason: collision with root package name */
    public final Integer f23270s;

    /* renamed from: t  reason: collision with root package name */
    public final Integer f23271t;

    /* renamed from: u  reason: collision with root package name */
    public final Integer f23272u;

    /* renamed from: v  reason: collision with root package name */
    public final Integer f23273v;

    /* renamed from: w  reason: collision with root package name */
    public final Integer f23274w;

    /* renamed from: x  reason: collision with root package name */
    public final Integer f23275x;

    /* renamed from: y  reason: collision with root package name */
    public final Integer f23276y;

    /* renamed from: z  reason: collision with root package name */
    public final CharSequence f23277z;

    public static final class Builder {
        /* access modifiers changed from: private */
        public Integer A;
        /* access modifiers changed from: private */
        public Integer B;
        /* access modifiers changed from: private */
        public CharSequence C;
        /* access modifiers changed from: private */
        public CharSequence D;
        /* access modifiers changed from: private */
        public CharSequence E;
        /* access modifiers changed from: private */
        public Integer F;
        /* access modifiers changed from: private */
        public Bundle G;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f23278a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f23279b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f23280c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f23281d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f23282e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f23283f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public CharSequence f23284g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public Rating f23285h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public Rating f23286i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public byte[] f23287j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public Integer f23288k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public Uri f23289l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public Integer f23290m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public Integer f23291n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public Integer f23292o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public Boolean f23293p;
        /* access modifiers changed from: private */

        /* renamed from: q  reason: collision with root package name */
        public Boolean f23294q;
        /* access modifiers changed from: private */

        /* renamed from: r  reason: collision with root package name */
        public Integer f23295r;
        /* access modifiers changed from: private */

        /* renamed from: s  reason: collision with root package name */
        public Integer f23296s;
        /* access modifiers changed from: private */

        /* renamed from: t  reason: collision with root package name */
        public Integer f23297t;
        /* access modifiers changed from: private */

        /* renamed from: u  reason: collision with root package name */
        public Integer f23298u;
        /* access modifiers changed from: private */

        /* renamed from: v  reason: collision with root package name */
        public Integer f23299v;
        /* access modifiers changed from: private */

        /* renamed from: w  reason: collision with root package name */
        public Integer f23300w;
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public CharSequence f23301x;
        /* access modifiers changed from: private */

        /* renamed from: y  reason: collision with root package name */
        public CharSequence f23302y;
        /* access modifiers changed from: private */

        /* renamed from: z  reason: collision with root package name */
        public CharSequence f23303z;

        public MediaMetadata H() {
            return new MediaMetadata(this);
        }

        public Builder I(byte[] bArr, int i2) {
            if (this.f23287j == null || Util.c(Integer.valueOf(i2), 3) || !Util.c(this.f23288k, 3)) {
                this.f23287j = (byte[]) bArr.clone();
                this.f23288k = Integer.valueOf(i2);
            }
            return this;
        }

        public Builder J(MediaMetadata mediaMetadata) {
            if (mediaMetadata == null) {
                return this;
            }
            CharSequence charSequence = mediaMetadata.f23253b;
            if (charSequence != null) {
                m0(charSequence);
            }
            CharSequence charSequence2 = mediaMetadata.f23254c;
            if (charSequence2 != null) {
                O(charSequence2);
            }
            CharSequence charSequence3 = mediaMetadata.f23255d;
            if (charSequence3 != null) {
                N(charSequence3);
            }
            CharSequence charSequence4 = mediaMetadata.f23256e;
            if (charSequence4 != null) {
                M(charSequence4);
            }
            CharSequence charSequence5 = mediaMetadata.f23257f;
            if (charSequence5 != null) {
                W(charSequence5);
            }
            CharSequence charSequence6 = mediaMetadata.f23258g;
            if (charSequence6 != null) {
                l0(charSequence6);
            }
            CharSequence charSequence7 = mediaMetadata.f23259h;
            if (charSequence7 != null) {
                U(charSequence7);
            }
            Rating rating = mediaMetadata.f23260i;
            if (rating != null) {
                q0(rating);
            }
            Rating rating2 = mediaMetadata.f23261j;
            if (rating2 != null) {
                d0(rating2);
            }
            byte[] bArr = mediaMetadata.f23262k;
            if (bArr != null) {
                P(bArr, mediaMetadata.f23263l);
            }
            Uri uri = mediaMetadata.f23264m;
            if (uri != null) {
                Q(uri);
            }
            Integer num = mediaMetadata.f23265n;
            if (num != null) {
                p0(num);
            }
            Integer num2 = mediaMetadata.f23266o;
            if (num2 != null) {
                o0(num2);
            }
            Integer num3 = mediaMetadata.f23267p;
            if (num3 != null) {
                Y(num3);
            }
            Boolean bool = mediaMetadata.f23268q;
            if (bool != null) {
                a0(bool);
            }
            Boolean bool2 = mediaMetadata.f23269r;
            if (bool2 != null) {
                b0(bool2);
            }
            Integer num4 = mediaMetadata.f23270s;
            if (num4 != null) {
                g0(num4);
            }
            Integer num5 = mediaMetadata.f23271t;
            if (num5 != null) {
                g0(num5);
            }
            Integer num6 = mediaMetadata.f23272u;
            if (num6 != null) {
                f0(num6);
            }
            Integer num7 = mediaMetadata.f23273v;
            if (num7 != null) {
                e0(num7);
            }
            Integer num8 = mediaMetadata.f23274w;
            if (num8 != null) {
                j0(num8);
            }
            Integer num9 = mediaMetadata.f23275x;
            if (num9 != null) {
                i0(num9);
            }
            Integer num10 = mediaMetadata.f23276y;
            if (num10 != null) {
                h0(num10);
            }
            CharSequence charSequence8 = mediaMetadata.f23277z;
            if (charSequence8 != null) {
                r0(charSequence8);
            }
            CharSequence charSequence9 = mediaMetadata.A;
            if (charSequence9 != null) {
                S(charSequence9);
            }
            CharSequence charSequence10 = mediaMetadata.B;
            if (charSequence10 != null) {
                T(charSequence10);
            }
            Integer num11 = mediaMetadata.C;
            if (num11 != null) {
                V(num11);
            }
            Integer num12 = mediaMetadata.D;
            if (num12 != null) {
                n0(num12);
            }
            CharSequence charSequence11 = mediaMetadata.E;
            if (charSequence11 != null) {
                Z(charSequence11);
            }
            CharSequence charSequence12 = mediaMetadata.F;
            if (charSequence12 != null) {
                R(charSequence12);
            }
            CharSequence charSequence13 = mediaMetadata.G;
            if (charSequence13 != null) {
                k0(charSequence13);
            }
            Integer num13 = mediaMetadata.H;
            if (num13 != null) {
                c0(num13);
            }
            Bundle bundle = mediaMetadata.I;
            if (bundle != null) {
                X(bundle);
            }
            return this;
        }

        public Builder K(Metadata metadata) {
            for (int i2 = 0; i2 < metadata.f(); i2++) {
                metadata.e(i2).a(this);
            }
            return this;
        }

        public Builder L(List<Metadata> list) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                Metadata metadata = list.get(i2);
                for (int i3 = 0; i3 < metadata.f(); i3++) {
                    metadata.e(i3).a(this);
                }
            }
            return this;
        }

        public Builder M(CharSequence charSequence) {
            this.f23281d = charSequence;
            return this;
        }

        public Builder N(CharSequence charSequence) {
            this.f23280c = charSequence;
            return this;
        }

        public Builder O(CharSequence charSequence) {
            this.f23279b = charSequence;
            return this;
        }

        public Builder P(byte[] bArr, Integer num) {
            byte[] bArr2;
            if (bArr == null) {
                bArr2 = null;
            } else {
                bArr2 = (byte[]) bArr.clone();
            }
            this.f23287j = bArr2;
            this.f23288k = num;
            return this;
        }

        public Builder Q(Uri uri) {
            this.f23289l = uri;
            return this;
        }

        public Builder R(CharSequence charSequence) {
            this.D = charSequence;
            return this;
        }

        public Builder S(CharSequence charSequence) {
            this.f23302y = charSequence;
            return this;
        }

        public Builder T(CharSequence charSequence) {
            this.f23303z = charSequence;
            return this;
        }

        public Builder U(CharSequence charSequence) {
            this.f23284g = charSequence;
            return this;
        }

        public Builder V(Integer num) {
            this.A = num;
            return this;
        }

        public Builder W(CharSequence charSequence) {
            this.f23282e = charSequence;
            return this;
        }

        public Builder X(Bundle bundle) {
            this.G = bundle;
            return this;
        }

        public Builder Y(Integer num) {
            this.f23292o = num;
            return this;
        }

        public Builder Z(CharSequence charSequence) {
            this.C = charSequence;
            return this;
        }

        public Builder a0(Boolean bool) {
            this.f23293p = bool;
            return this;
        }

        public Builder b0(Boolean bool) {
            this.f23294q = bool;
            return this;
        }

        public Builder c0(Integer num) {
            this.F = num;
            return this;
        }

        public Builder d0(Rating rating) {
            this.f23286i = rating;
            return this;
        }

        public Builder e0(Integer num) {
            this.f23297t = num;
            return this;
        }

        public Builder f0(Integer num) {
            this.f23296s = num;
            return this;
        }

        public Builder g0(Integer num) {
            this.f23295r = num;
            return this;
        }

        public Builder h0(Integer num) {
            this.f23300w = num;
            return this;
        }

        public Builder i0(Integer num) {
            this.f23299v = num;
            return this;
        }

        public Builder j0(Integer num) {
            this.f23298u = num;
            return this;
        }

        public Builder k0(CharSequence charSequence) {
            this.E = charSequence;
            return this;
        }

        public Builder l0(CharSequence charSequence) {
            this.f23283f = charSequence;
            return this;
        }

        public Builder m0(CharSequence charSequence) {
            this.f23278a = charSequence;
            return this;
        }

        public Builder n0(Integer num) {
            this.B = num;
            return this;
        }

        public Builder o0(Integer num) {
            this.f23291n = num;
            return this;
        }

        public Builder p0(Integer num) {
            this.f23290m = num;
            return this;
        }

        public Builder q0(Rating rating) {
            this.f23285h = rating;
            return this;
        }

        public Builder r0(CharSequence charSequence) {
            this.f23301x = charSequence;
            return this;
        }

        public Builder() {
        }

        private Builder(MediaMetadata mediaMetadata) {
            this.f23278a = mediaMetadata.f23253b;
            this.f23279b = mediaMetadata.f23254c;
            this.f23280c = mediaMetadata.f23255d;
            this.f23281d = mediaMetadata.f23256e;
            this.f23282e = mediaMetadata.f23257f;
            this.f23283f = mediaMetadata.f23258g;
            this.f23284g = mediaMetadata.f23259h;
            this.f23285h = mediaMetadata.f23260i;
            this.f23286i = mediaMetadata.f23261j;
            this.f23287j = mediaMetadata.f23262k;
            this.f23288k = mediaMetadata.f23263l;
            this.f23289l = mediaMetadata.f23264m;
            this.f23290m = mediaMetadata.f23265n;
            this.f23291n = mediaMetadata.f23266o;
            this.f23292o = mediaMetadata.f23267p;
            this.f23293p = mediaMetadata.f23268q;
            this.f23294q = mediaMetadata.f23269r;
            this.f23295r = mediaMetadata.f23271t;
            this.f23296s = mediaMetadata.f23272u;
            this.f23297t = mediaMetadata.f23273v;
            this.f23298u = mediaMetadata.f23274w;
            this.f23299v = mediaMetadata.f23275x;
            this.f23300w = mediaMetadata.f23276y;
            this.f23301x = mediaMetadata.f23277z;
            this.f23302y = mediaMetadata.A;
            this.f23303z = mediaMetadata.B;
            this.A = mediaMetadata.C;
            this.B = mediaMetadata.D;
            this.C = mediaMetadata.E;
            this.D = mediaMetadata.F;
            this.E = mediaMetadata.G;
            this.F = mediaMetadata.H;
            this.G = mediaMetadata.I;
        }
    }

    /* access modifiers changed from: private */
    public static MediaMetadata c(Bundle bundle) {
        Integer num;
        Bundle bundle2;
        Bundle bundle3;
        Builder builder = new Builder();
        Builder U2 = builder.m0(bundle.getCharSequence(K)).O(bundle.getCharSequence(L)).N(bundle.getCharSequence(M)).M(bundle.getCharSequence(N)).W(bundle.getCharSequence(O)).l0(bundle.getCharSequence(P)).U(bundle.getCharSequence(Q));
        byte[] byteArray = bundle.getByteArray(T);
        String str = f23247m0;
        if (bundle.containsKey(str)) {
            num = Integer.valueOf(bundle.getInt(str));
        } else {
            num = null;
        }
        U2.P(byteArray, num).Q((Uri) bundle.getParcelable(U)).r0(bundle.getCharSequence(f23240f0)).S(bundle.getCharSequence(f23241g0)).T(bundle.getCharSequence(f23242h0)).Z(bundle.getCharSequence(f23245k0)).R(bundle.getCharSequence(f23246l0)).k0(bundle.getCharSequence(f23248n0)).X(bundle.getBundle(f23251q0));
        String str2 = R;
        if (bundle.containsKey(str2) && (bundle3 = bundle.getBundle(str2)) != null) {
            builder.q0(Rating.f23449c.a(bundle3));
        }
        String str3 = S;
        if (bundle.containsKey(str3) && (bundle2 = bundle.getBundle(str3)) != null) {
            builder.d0(Rating.f23449c.a(bundle2));
        }
        String str4 = V;
        if (bundle.containsKey(str4)) {
            builder.p0(Integer.valueOf(bundle.getInt(str4)));
        }
        String str5 = W;
        if (bundle.containsKey(str5)) {
            builder.o0(Integer.valueOf(bundle.getInt(str5)));
        }
        String str6 = X;
        if (bundle.containsKey(str6)) {
            builder.Y(Integer.valueOf(bundle.getInt(str6)));
        }
        String str7 = f23250p0;
        if (bundle.containsKey(str7)) {
            builder.a0(Boolean.valueOf(bundle.getBoolean(str7)));
        }
        String str8 = Y;
        if (bundle.containsKey(str8)) {
            builder.b0(Boolean.valueOf(bundle.getBoolean(str8)));
        }
        String str9 = Z;
        if (bundle.containsKey(str9)) {
            builder.g0(Integer.valueOf(bundle.getInt(str9)));
        }
        String str10 = f23235a0;
        if (bundle.containsKey(str10)) {
            builder.f0(Integer.valueOf(bundle.getInt(str10)));
        }
        String str11 = f23236b0;
        if (bundle.containsKey(str11)) {
            builder.e0(Integer.valueOf(bundle.getInt(str11)));
        }
        String str12 = f23237c0;
        if (bundle.containsKey(str12)) {
            builder.j0(Integer.valueOf(bundle.getInt(str12)));
        }
        String str13 = f23238d0;
        if (bundle.containsKey(str13)) {
            builder.i0(Integer.valueOf(bundle.getInt(str13)));
        }
        String str14 = f23239e0;
        if (bundle.containsKey(str14)) {
            builder.h0(Integer.valueOf(bundle.getInt(str14)));
        }
        String str15 = f23243i0;
        if (bundle.containsKey(str15)) {
            builder.V(Integer.valueOf(bundle.getInt(str15)));
        }
        String str16 = f23244j0;
        if (bundle.containsKey(str16)) {
            builder.n0(Integer.valueOf(bundle.getInt(str16)));
        }
        String str17 = f23249o0;
        if (bundle.containsKey(str17)) {
            builder.c0(Integer.valueOf(bundle.getInt(str17)));
        }
        return builder.H();
    }

    private static int d(int i2) {
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

    private static int e(int i2) {
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

    public Builder b() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaMetadata.class != obj.getClass()) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        if (!Util.c(this.f23253b, mediaMetadata.f23253b) || !Util.c(this.f23254c, mediaMetadata.f23254c) || !Util.c(this.f23255d, mediaMetadata.f23255d) || !Util.c(this.f23256e, mediaMetadata.f23256e) || !Util.c(this.f23257f, mediaMetadata.f23257f) || !Util.c(this.f23258g, mediaMetadata.f23258g) || !Util.c(this.f23259h, mediaMetadata.f23259h) || !Util.c(this.f23260i, mediaMetadata.f23260i) || !Util.c(this.f23261j, mediaMetadata.f23261j) || !Arrays.equals(this.f23262k, mediaMetadata.f23262k) || !Util.c(this.f23263l, mediaMetadata.f23263l) || !Util.c(this.f23264m, mediaMetadata.f23264m) || !Util.c(this.f23265n, mediaMetadata.f23265n) || !Util.c(this.f23266o, mediaMetadata.f23266o) || !Util.c(this.f23267p, mediaMetadata.f23267p) || !Util.c(this.f23268q, mediaMetadata.f23268q) || !Util.c(this.f23269r, mediaMetadata.f23269r) || !Util.c(this.f23271t, mediaMetadata.f23271t) || !Util.c(this.f23272u, mediaMetadata.f23272u) || !Util.c(this.f23273v, mediaMetadata.f23273v) || !Util.c(this.f23274w, mediaMetadata.f23274w) || !Util.c(this.f23275x, mediaMetadata.f23275x) || !Util.c(this.f23276y, mediaMetadata.f23276y) || !Util.c(this.f23277z, mediaMetadata.f23277z) || !Util.c(this.A, mediaMetadata.A) || !Util.c(this.B, mediaMetadata.B) || !Util.c(this.C, mediaMetadata.C) || !Util.c(this.D, mediaMetadata.D) || !Util.c(this.E, mediaMetadata.E) || !Util.c(this.F, mediaMetadata.F) || !Util.c(this.G, mediaMetadata.G) || !Util.c(this.H, mediaMetadata.H)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.b(this.f23253b, this.f23254c, this.f23255d, this.f23256e, this.f23257f, this.f23258g, this.f23259h, this.f23260i, this.f23261j, Integer.valueOf(Arrays.hashCode(this.f23262k)), this.f23263l, this.f23264m, this.f23265n, this.f23266o, this.f23267p, this.f23268q, this.f23269r, this.f23271t, this.f23272u, this.f23273v, this.f23274w, this.f23275x, this.f23276y, this.f23277z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.f23253b;
        if (charSequence != null) {
            bundle.putCharSequence(K, charSequence);
        }
        CharSequence charSequence2 = this.f23254c;
        if (charSequence2 != null) {
            bundle.putCharSequence(L, charSequence2);
        }
        CharSequence charSequence3 = this.f23255d;
        if (charSequence3 != null) {
            bundle.putCharSequence(M, charSequence3);
        }
        CharSequence charSequence4 = this.f23256e;
        if (charSequence4 != null) {
            bundle.putCharSequence(N, charSequence4);
        }
        CharSequence charSequence5 = this.f23257f;
        if (charSequence5 != null) {
            bundle.putCharSequence(O, charSequence5);
        }
        CharSequence charSequence6 = this.f23258g;
        if (charSequence6 != null) {
            bundle.putCharSequence(P, charSequence6);
        }
        CharSequence charSequence7 = this.f23259h;
        if (charSequence7 != null) {
            bundle.putCharSequence(Q, charSequence7);
        }
        byte[] bArr = this.f23262k;
        if (bArr != null) {
            bundle.putByteArray(T, bArr);
        }
        Uri uri = this.f23264m;
        if (uri != null) {
            bundle.putParcelable(U, uri);
        }
        CharSequence charSequence8 = this.f23277z;
        if (charSequence8 != null) {
            bundle.putCharSequence(f23240f0, charSequence8);
        }
        CharSequence charSequence9 = this.A;
        if (charSequence9 != null) {
            bundle.putCharSequence(f23241g0, charSequence9);
        }
        CharSequence charSequence10 = this.B;
        if (charSequence10 != null) {
            bundle.putCharSequence(f23242h0, charSequence10);
        }
        CharSequence charSequence11 = this.E;
        if (charSequence11 != null) {
            bundle.putCharSequence(f23245k0, charSequence11);
        }
        CharSequence charSequence12 = this.F;
        if (charSequence12 != null) {
            bundle.putCharSequence(f23246l0, charSequence12);
        }
        CharSequence charSequence13 = this.G;
        if (charSequence13 != null) {
            bundle.putCharSequence(f23248n0, charSequence13);
        }
        Rating rating = this.f23260i;
        if (rating != null) {
            bundle.putBundle(R, rating.toBundle());
        }
        Rating rating2 = this.f23261j;
        if (rating2 != null) {
            bundle.putBundle(S, rating2.toBundle());
        }
        Integer num = this.f23265n;
        if (num != null) {
            bundle.putInt(V, num.intValue());
        }
        Integer num2 = this.f23266o;
        if (num2 != null) {
            bundle.putInt(W, num2.intValue());
        }
        Integer num3 = this.f23267p;
        if (num3 != null) {
            bundle.putInt(X, num3.intValue());
        }
        Boolean bool = this.f23268q;
        if (bool != null) {
            bundle.putBoolean(f23250p0, bool.booleanValue());
        }
        Boolean bool2 = this.f23269r;
        if (bool2 != null) {
            bundle.putBoolean(Y, bool2.booleanValue());
        }
        Integer num4 = this.f23271t;
        if (num4 != null) {
            bundle.putInt(Z, num4.intValue());
        }
        Integer num5 = this.f23272u;
        if (num5 != null) {
            bundle.putInt(f23235a0, num5.intValue());
        }
        Integer num6 = this.f23273v;
        if (num6 != null) {
            bundle.putInt(f23236b0, num6.intValue());
        }
        Integer num7 = this.f23274w;
        if (num7 != null) {
            bundle.putInt(f23237c0, num7.intValue());
        }
        Integer num8 = this.f23275x;
        if (num8 != null) {
            bundle.putInt(f23238d0, num8.intValue());
        }
        Integer num9 = this.f23276y;
        if (num9 != null) {
            bundle.putInt(f23239e0, num9.intValue());
        }
        Integer num10 = this.C;
        if (num10 != null) {
            bundle.putInt(f23243i0, num10.intValue());
        }
        Integer num11 = this.D;
        if (num11 != null) {
            bundle.putInt(f23244j0, num11.intValue());
        }
        Integer num12 = this.f23263l;
        if (num12 != null) {
            bundle.putInt(f23247m0, num12.intValue());
        }
        Integer num13 = this.H;
        if (num13 != null) {
            bundle.putInt(f23249o0, num13.intValue());
        }
        Bundle bundle2 = this.I;
        if (bundle2 != null) {
            bundle.putBundle(f23251q0, bundle2);
        }
        return bundle;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private MediaMetadata(com.google.android.exoplayer2.MediaMetadata.Builder r7) {
        /*
            r6 = this;
            r6.<init>()
            java.lang.Boolean r0 = r7.f23293p
            java.lang.Integer r1 = r7.f23292o
            java.lang.Integer r2 = r7.F
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
            int r3 = d(r1)
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
            int r2 = e(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0056:
            java.lang.CharSequence r3 = r7.f23278a
            r6.f23253b = r3
            java.lang.CharSequence r3 = r7.f23279b
            r6.f23254c = r3
            java.lang.CharSequence r3 = r7.f23280c
            r6.f23255d = r3
            java.lang.CharSequence r3 = r7.f23281d
            r6.f23256e = r3
            java.lang.CharSequence r3 = r7.f23282e
            r6.f23257f = r3
            java.lang.CharSequence r3 = r7.f23283f
            r6.f23258g = r3
            java.lang.CharSequence r3 = r7.f23284g
            r6.f23259h = r3
            com.google.android.exoplayer2.Rating r3 = r7.f23285h
            r6.f23260i = r3
            com.google.android.exoplayer2.Rating r3 = r7.f23286i
            r6.f23261j = r3
            byte[] r3 = r7.f23287j
            r6.f23262k = r3
            java.lang.Integer r3 = r7.f23288k
            r6.f23263l = r3
            android.net.Uri r3 = r7.f23289l
            r6.f23264m = r3
            java.lang.Integer r3 = r7.f23290m
            r6.f23265n = r3
            java.lang.Integer r3 = r7.f23291n
            r6.f23266o = r3
            r6.f23267p = r1
            r6.f23268q = r0
            java.lang.Boolean r0 = r7.f23294q
            r6.f23269r = r0
            java.lang.Integer r0 = r7.f23295r
            r6.f23270s = r0
            java.lang.Integer r0 = r7.f23295r
            r6.f23271t = r0
            java.lang.Integer r0 = r7.f23296s
            r6.f23272u = r0
            java.lang.Integer r0 = r7.f23297t
            r6.f23273v = r0
            java.lang.Integer r0 = r7.f23298u
            r6.f23274w = r0
            java.lang.Integer r0 = r7.f23299v
            r6.f23275x = r0
            java.lang.Integer r0 = r7.f23300w
            r6.f23276y = r0
            java.lang.CharSequence r0 = r7.f23301x
            r6.f23277z = r0
            java.lang.CharSequence r0 = r7.f23302y
            r6.A = r0
            java.lang.CharSequence r0 = r7.f23303z
            r6.B = r0
            java.lang.Integer r0 = r7.A
            r6.C = r0
            java.lang.Integer r0 = r7.B
            r6.D = r0
            java.lang.CharSequence r0 = r7.C
            r6.E = r0
            java.lang.CharSequence r0 = r7.D
            r6.F = r0
            java.lang.CharSequence r0 = r7.E
            r6.G = r0
            r6.H = r2
            android.os.Bundle r7 = r7.G
            r6.I = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.MediaMetadata.<init>(com.google.android.exoplayer2.MediaMetadata$Builder):void");
    }
}
