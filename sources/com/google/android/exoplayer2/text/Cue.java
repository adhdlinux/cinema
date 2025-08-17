package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import org.checkerframework.dataflow.qual.Pure;

public final class Cue implements Bundleable {
    private static final String A = Util.u0(7);
    private static final String B = Util.u0(8);
    private static final String C = Util.u0(9);
    private static final String D = Util.u0(10);
    private static final String E = Util.u0(11);
    private static final String F = Util.u0(12);
    private static final String G = Util.u0(13);
    private static final String H = Util.u0(14);
    private static final String I = Util.u0(15);
    private static final String J = Util.u0(16);
    public static final Bundleable.Creator<Cue> K = new a();

    /* renamed from: s  reason: collision with root package name */
    public static final Cue f27194s = new Builder().o("").a();

    /* renamed from: t  reason: collision with root package name */
    private static final String f27195t = Util.u0(0);

    /* renamed from: u  reason: collision with root package name */
    private static final String f27196u = Util.u0(1);

    /* renamed from: v  reason: collision with root package name */
    private static final String f27197v = Util.u0(2);

    /* renamed from: w  reason: collision with root package name */
    private static final String f27198w = Util.u0(3);

    /* renamed from: x  reason: collision with root package name */
    private static final String f27199x = Util.u0(4);

    /* renamed from: y  reason: collision with root package name */
    private static final String f27200y = Util.u0(5);

    /* renamed from: z  reason: collision with root package name */
    private static final String f27201z = Util.u0(6);

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f27202b;

    /* renamed from: c  reason: collision with root package name */
    public final Layout.Alignment f27203c;

    /* renamed from: d  reason: collision with root package name */
    public final Layout.Alignment f27204d;

    /* renamed from: e  reason: collision with root package name */
    public final Bitmap f27205e;

    /* renamed from: f  reason: collision with root package name */
    public final float f27206f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27207g;

    /* renamed from: h  reason: collision with root package name */
    public final int f27208h;

    /* renamed from: i  reason: collision with root package name */
    public final float f27209i;

    /* renamed from: j  reason: collision with root package name */
    public final int f27210j;

    /* renamed from: k  reason: collision with root package name */
    public final float f27211k;

    /* renamed from: l  reason: collision with root package name */
    public final float f27212l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f27213m;

    /* renamed from: n  reason: collision with root package name */
    public final int f27214n;

    /* renamed from: o  reason: collision with root package name */
    public final int f27215o;

    /* renamed from: p  reason: collision with root package name */
    public final float f27216p;

    /* renamed from: q  reason: collision with root package name */
    public final int f27217q;

    /* renamed from: r  reason: collision with root package name */
    public final float f27218r;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private CharSequence f27219a;

        /* renamed from: b  reason: collision with root package name */
        private Bitmap f27220b;

        /* renamed from: c  reason: collision with root package name */
        private Layout.Alignment f27221c;

        /* renamed from: d  reason: collision with root package name */
        private Layout.Alignment f27222d;

        /* renamed from: e  reason: collision with root package name */
        private float f27223e;

        /* renamed from: f  reason: collision with root package name */
        private int f27224f;

        /* renamed from: g  reason: collision with root package name */
        private int f27225g;

        /* renamed from: h  reason: collision with root package name */
        private float f27226h;

        /* renamed from: i  reason: collision with root package name */
        private int f27227i;

        /* renamed from: j  reason: collision with root package name */
        private int f27228j;

        /* renamed from: k  reason: collision with root package name */
        private float f27229k;

        /* renamed from: l  reason: collision with root package name */
        private float f27230l;

        /* renamed from: m  reason: collision with root package name */
        private float f27231m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f27232n;

        /* renamed from: o  reason: collision with root package name */
        private int f27233o;

        /* renamed from: p  reason: collision with root package name */
        private int f27234p;

        /* renamed from: q  reason: collision with root package name */
        private float f27235q;

        public Cue a() {
            return new Cue(this.f27219a, this.f27221c, this.f27222d, this.f27220b, this.f27223e, this.f27224f, this.f27225g, this.f27226h, this.f27227i, this.f27228j, this.f27229k, this.f27230l, this.f27231m, this.f27232n, this.f27233o, this.f27234p, this.f27235q);
        }

        public Builder b() {
            this.f27232n = false;
            return this;
        }

        @Pure
        public int c() {
            return this.f27225g;
        }

        @Pure
        public int d() {
            return this.f27227i;
        }

        @Pure
        public CharSequence e() {
            return this.f27219a;
        }

        public Builder f(Bitmap bitmap) {
            this.f27220b = bitmap;
            return this;
        }

        public Builder g(float f2) {
            this.f27231m = f2;
            return this;
        }

        public Builder h(float f2, int i2) {
            this.f27223e = f2;
            this.f27224f = i2;
            return this;
        }

        public Builder i(int i2) {
            this.f27225g = i2;
            return this;
        }

        public Builder j(Layout.Alignment alignment) {
            this.f27222d = alignment;
            return this;
        }

        public Builder k(float f2) {
            this.f27226h = f2;
            return this;
        }

        public Builder l(int i2) {
            this.f27227i = i2;
            return this;
        }

        public Builder m(float f2) {
            this.f27235q = f2;
            return this;
        }

        public Builder n(float f2) {
            this.f27230l = f2;
            return this;
        }

        public Builder o(CharSequence charSequence) {
            this.f27219a = charSequence;
            return this;
        }

        public Builder p(Layout.Alignment alignment) {
            this.f27221c = alignment;
            return this;
        }

        public Builder q(float f2, int i2) {
            this.f27229k = f2;
            this.f27228j = i2;
            return this;
        }

        public Builder r(int i2) {
            this.f27234p = i2;
            return this;
        }

        public Builder s(int i2) {
            this.f27233o = i2;
            this.f27232n = true;
            return this;
        }

        public Builder() {
            this.f27219a = null;
            this.f27220b = null;
            this.f27221c = null;
            this.f27222d = null;
            this.f27223e = -3.4028235E38f;
            this.f27224f = Integer.MIN_VALUE;
            this.f27225g = Integer.MIN_VALUE;
            this.f27226h = -3.4028235E38f;
            this.f27227i = Integer.MIN_VALUE;
            this.f27228j = Integer.MIN_VALUE;
            this.f27229k = -3.4028235E38f;
            this.f27230l = -3.4028235E38f;
            this.f27231m = -3.4028235E38f;
            this.f27232n = false;
            this.f27233o = -16777216;
            this.f27234p = Integer.MIN_VALUE;
        }

        private Builder(Cue cue) {
            this.f27219a = cue.f27202b;
            this.f27220b = cue.f27205e;
            this.f27221c = cue.f27203c;
            this.f27222d = cue.f27204d;
            this.f27223e = cue.f27206f;
            this.f27224f = cue.f27207g;
            this.f27225g = cue.f27208h;
            this.f27226h = cue.f27209i;
            this.f27227i = cue.f27210j;
            this.f27228j = cue.f27215o;
            this.f27229k = cue.f27216p;
            this.f27230l = cue.f27211k;
            this.f27231m = cue.f27212l;
            this.f27232n = cue.f27213m;
            this.f27233o = cue.f27214n;
            this.f27234p = cue.f27217q;
            this.f27235q = cue.f27218r;
        }
    }

    /* access modifiers changed from: private */
    public static final Cue c(Bundle bundle) {
        Builder builder = new Builder();
        CharSequence charSequence = bundle.getCharSequence(f27195t);
        if (charSequence != null) {
            builder.o(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(f27196u);
        if (alignment != null) {
            builder.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(f27197v);
        if (alignment2 != null) {
            builder.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(f27198w);
        if (bitmap != null) {
            builder.f(bitmap);
        }
        String str = f27199x;
        if (bundle.containsKey(str)) {
            String str2 = f27200y;
            if (bundle.containsKey(str2)) {
                builder.h(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = f27201z;
        if (bundle.containsKey(str3)) {
            builder.i(bundle.getInt(str3));
        }
        String str4 = A;
        if (bundle.containsKey(str4)) {
            builder.k(bundle.getFloat(str4));
        }
        String str5 = B;
        if (bundle.containsKey(str5)) {
            builder.l(bundle.getInt(str5));
        }
        String str6 = D;
        if (bundle.containsKey(str6)) {
            String str7 = C;
            if (bundle.containsKey(str7)) {
                builder.q(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = E;
        if (bundle.containsKey(str8)) {
            builder.n(bundle.getFloat(str8));
        }
        String str9 = F;
        if (bundle.containsKey(str9)) {
            builder.g(bundle.getFloat(str9));
        }
        String str10 = G;
        if (bundle.containsKey(str10)) {
            builder.s(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(H, false)) {
            builder.b();
        }
        String str11 = I;
        if (bundle.containsKey(str11)) {
            builder.r(bundle.getInt(str11));
        }
        String str12 = J;
        if (bundle.containsKey(str12)) {
            builder.m(bundle.getFloat(str12));
        }
        return builder.a();
    }

    public Builder b() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || Cue.class != obj.getClass()) {
            return false;
        }
        Cue cue = (Cue) obj;
        if (TextUtils.equals(this.f27202b, cue.f27202b) && this.f27203c == cue.f27203c && this.f27204d == cue.f27204d && ((bitmap = this.f27205e) != null ? !((bitmap2 = cue.f27205e) == null || !bitmap.sameAs(bitmap2)) : cue.f27205e == null) && this.f27206f == cue.f27206f && this.f27207g == cue.f27207g && this.f27208h == cue.f27208h && this.f27209i == cue.f27209i && this.f27210j == cue.f27210j && this.f27211k == cue.f27211k && this.f27212l == cue.f27212l && this.f27213m == cue.f27213m && this.f27214n == cue.f27214n && this.f27215o == cue.f27215o && this.f27216p == cue.f27216p && this.f27217q == cue.f27217q && this.f27218r == cue.f27218r) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(this.f27202b, this.f27203c, this.f27204d, this.f27205e, Float.valueOf(this.f27206f), Integer.valueOf(this.f27207g), Integer.valueOf(this.f27208h), Float.valueOf(this.f27209i), Integer.valueOf(this.f27210j), Float.valueOf(this.f27211k), Float.valueOf(this.f27212l), Boolean.valueOf(this.f27213m), Integer.valueOf(this.f27214n), Integer.valueOf(this.f27215o), Float.valueOf(this.f27216p), Integer.valueOf(this.f27217q), Float.valueOf(this.f27218r));
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(f27195t, this.f27202b);
        bundle.putSerializable(f27196u, this.f27203c);
        bundle.putSerializable(f27197v, this.f27204d);
        bundle.putParcelable(f27198w, this.f27205e);
        bundle.putFloat(f27199x, this.f27206f);
        bundle.putInt(f27200y, this.f27207g);
        bundle.putInt(f27201z, this.f27208h);
        bundle.putFloat(A, this.f27209i);
        bundle.putInt(B, this.f27210j);
        bundle.putInt(C, this.f27215o);
        bundle.putFloat(D, this.f27216p);
        bundle.putFloat(E, this.f27211k);
        bundle.putFloat(F, this.f27212l);
        bundle.putBoolean(H, this.f27213m);
        bundle.putInt(G, this.f27214n);
        bundle.putInt(I, this.f27217q);
        bundle.putFloat(J, this.f27218r);
        return bundle;
    }

    private Cue(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f2, int i2, int i3, float f3, int i4, int i5, float f4, float f5, float f6, boolean z2, int i6, int i7, float f7) {
        CharSequence charSequence2 = charSequence;
        Bitmap bitmap2 = bitmap;
        if (charSequence2 == null) {
            Assertions.e(bitmap);
        } else {
            Assertions.a(bitmap2 == null);
        }
        if (charSequence2 instanceof Spanned) {
            this.f27202b = SpannedString.valueOf(charSequence);
        } else if (charSequence2 != null) {
            this.f27202b = charSequence.toString();
        } else {
            this.f27202b = null;
        }
        this.f27203c = alignment;
        this.f27204d = alignment2;
        this.f27205e = bitmap2;
        this.f27206f = f2;
        this.f27207g = i2;
        this.f27208h = i3;
        this.f27209i = f3;
        this.f27210j = i4;
        this.f27211k = f5;
        this.f27212l = f6;
        this.f27213m = z2;
        this.f27214n = i6;
        this.f27215o = i5;
        this.f27216p = f4;
        this.f27217q = i7;
        this.f27218r = f7;
    }
}
