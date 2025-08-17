package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;

final class TtmlStyle {

    /* renamed from: a  reason: collision with root package name */
    private String f27535a;

    /* renamed from: b  reason: collision with root package name */
    private int f27536b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27537c;

    /* renamed from: d  reason: collision with root package name */
    private int f27538d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27539e;

    /* renamed from: f  reason: collision with root package name */
    private int f27540f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f27541g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f27542h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f27543i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f27544j = -1;

    /* renamed from: k  reason: collision with root package name */
    private float f27545k;

    /* renamed from: l  reason: collision with root package name */
    private String f27546l;

    /* renamed from: m  reason: collision with root package name */
    private int f27547m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f27548n = -1;

    /* renamed from: o  reason: collision with root package name */
    private Layout.Alignment f27549o;

    /* renamed from: p  reason: collision with root package name */
    private Layout.Alignment f27550p;

    /* renamed from: q  reason: collision with root package name */
    private int f27551q = -1;

    /* renamed from: r  reason: collision with root package name */
    private TextEmphasis f27552r;

    /* renamed from: s  reason: collision with root package name */
    private float f27553s = Float.MAX_VALUE;

    private TtmlStyle r(TtmlStyle ttmlStyle, boolean z2) {
        int i2;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (ttmlStyle != null) {
            if (!this.f27537c && ttmlStyle.f27537c) {
                w(ttmlStyle.f27536b);
            }
            if (this.f27542h == -1) {
                this.f27542h = ttmlStyle.f27542h;
            }
            if (this.f27543i == -1) {
                this.f27543i = ttmlStyle.f27543i;
            }
            if (this.f27535a == null && (str = ttmlStyle.f27535a) != null) {
                this.f27535a = str;
            }
            if (this.f27540f == -1) {
                this.f27540f = ttmlStyle.f27540f;
            }
            if (this.f27541g == -1) {
                this.f27541g = ttmlStyle.f27541g;
            }
            if (this.f27548n == -1) {
                this.f27548n = ttmlStyle.f27548n;
            }
            if (this.f27549o == null && (alignment2 = ttmlStyle.f27549o) != null) {
                this.f27549o = alignment2;
            }
            if (this.f27550p == null && (alignment = ttmlStyle.f27550p) != null) {
                this.f27550p = alignment;
            }
            if (this.f27551q == -1) {
                this.f27551q = ttmlStyle.f27551q;
            }
            if (this.f27544j == -1) {
                this.f27544j = ttmlStyle.f27544j;
                this.f27545k = ttmlStyle.f27545k;
            }
            if (this.f27552r == null) {
                this.f27552r = ttmlStyle.f27552r;
            }
            if (this.f27553s == Float.MAX_VALUE) {
                this.f27553s = ttmlStyle.f27553s;
            }
            if (z2 && !this.f27539e && ttmlStyle.f27539e) {
                u(ttmlStyle.f27538d);
            }
            if (z2 && this.f27547m == -1 && (i2 = ttmlStyle.f27547m) != -1) {
                this.f27547m = i2;
            }
        }
        return this;
    }

    public TtmlStyle A(String str) {
        this.f27546l = str;
        return this;
    }

    public TtmlStyle B(boolean z2) {
        this.f27543i = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle C(boolean z2) {
        this.f27540f = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle D(Layout.Alignment alignment) {
        this.f27550p = alignment;
        return this;
    }

    public TtmlStyle E(int i2) {
        this.f27548n = i2;
        return this;
    }

    public TtmlStyle F(int i2) {
        this.f27547m = i2;
        return this;
    }

    public TtmlStyle G(float f2) {
        this.f27553s = f2;
        return this;
    }

    public TtmlStyle H(Layout.Alignment alignment) {
        this.f27549o = alignment;
        return this;
    }

    public TtmlStyle I(boolean z2) {
        this.f27551q = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle J(TextEmphasis textEmphasis) {
        this.f27552r = textEmphasis;
        return this;
    }

    public TtmlStyle K(boolean z2) {
        this.f27541g = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle a(TtmlStyle ttmlStyle) {
        return r(ttmlStyle, true);
    }

    public int b() {
        if (this.f27539e) {
            return this.f27538d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f27537c) {
            return this.f27536b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String d() {
        return this.f27535a;
    }

    public float e() {
        return this.f27545k;
    }

    public int f() {
        return this.f27544j;
    }

    public String g() {
        return this.f27546l;
    }

    public Layout.Alignment h() {
        return this.f27550p;
    }

    public int i() {
        return this.f27548n;
    }

    public int j() {
        return this.f27547m;
    }

    public float k() {
        return this.f27553s;
    }

    public int l() {
        int i2;
        int i3 = this.f27542h;
        if (i3 == -1 && this.f27543i == -1) {
            return -1;
        }
        int i4 = 0;
        if (i3 == 1) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.f27543i == 1) {
            i4 = 2;
        }
        return i2 | i4;
    }

    public Layout.Alignment m() {
        return this.f27549o;
    }

    public boolean n() {
        return this.f27551q == 1;
    }

    public TextEmphasis o() {
        return this.f27552r;
    }

    public boolean p() {
        return this.f27539e;
    }

    public boolean q() {
        return this.f27537c;
    }

    public boolean s() {
        return this.f27540f == 1;
    }

    public boolean t() {
        return this.f27541g == 1;
    }

    public TtmlStyle u(int i2) {
        this.f27538d = i2;
        this.f27539e = true;
        return this;
    }

    public TtmlStyle v(boolean z2) {
        this.f27542h = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle w(int i2) {
        this.f27536b = i2;
        this.f27537c = true;
        return this;
    }

    public TtmlStyle x(String str) {
        this.f27535a = str;
        return this;
    }

    public TtmlStyle y(float f2) {
        this.f27545k = f2;
        return this;
    }

    public TtmlStyle z(int i2) {
        this.f27544j = i2;
        return this;
    }
}
