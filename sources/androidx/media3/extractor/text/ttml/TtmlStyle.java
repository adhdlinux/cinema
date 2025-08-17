package androidx.media3.extractor.text.ttml;

import android.text.Layout;

final class TtmlStyle {

    /* renamed from: a  reason: collision with root package name */
    private String f9065a;

    /* renamed from: b  reason: collision with root package name */
    private int f9066b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9067c;

    /* renamed from: d  reason: collision with root package name */
    private int f9068d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9069e;

    /* renamed from: f  reason: collision with root package name */
    private int f9070f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f9071g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f9072h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f9073i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f9074j = -1;

    /* renamed from: k  reason: collision with root package name */
    private float f9075k;

    /* renamed from: l  reason: collision with root package name */
    private String f9076l;

    /* renamed from: m  reason: collision with root package name */
    private int f9077m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f9078n = -1;

    /* renamed from: o  reason: collision with root package name */
    private Layout.Alignment f9079o;

    /* renamed from: p  reason: collision with root package name */
    private Layout.Alignment f9080p;

    /* renamed from: q  reason: collision with root package name */
    private int f9081q = -1;

    /* renamed from: r  reason: collision with root package name */
    private TextEmphasis f9082r;

    /* renamed from: s  reason: collision with root package name */
    private float f9083s = Float.MAX_VALUE;

    private TtmlStyle r(TtmlStyle ttmlStyle, boolean z2) {
        int i2;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (ttmlStyle != null) {
            if (!this.f9067c && ttmlStyle.f9067c) {
                w(ttmlStyle.f9066b);
            }
            if (this.f9072h == -1) {
                this.f9072h = ttmlStyle.f9072h;
            }
            if (this.f9073i == -1) {
                this.f9073i = ttmlStyle.f9073i;
            }
            if (this.f9065a == null && (str = ttmlStyle.f9065a) != null) {
                this.f9065a = str;
            }
            if (this.f9070f == -1) {
                this.f9070f = ttmlStyle.f9070f;
            }
            if (this.f9071g == -1) {
                this.f9071g = ttmlStyle.f9071g;
            }
            if (this.f9078n == -1) {
                this.f9078n = ttmlStyle.f9078n;
            }
            if (this.f9079o == null && (alignment2 = ttmlStyle.f9079o) != null) {
                this.f9079o = alignment2;
            }
            if (this.f9080p == null && (alignment = ttmlStyle.f9080p) != null) {
                this.f9080p = alignment;
            }
            if (this.f9081q == -1) {
                this.f9081q = ttmlStyle.f9081q;
            }
            if (this.f9074j == -1) {
                this.f9074j = ttmlStyle.f9074j;
                this.f9075k = ttmlStyle.f9075k;
            }
            if (this.f9082r == null) {
                this.f9082r = ttmlStyle.f9082r;
            }
            if (this.f9083s == Float.MAX_VALUE) {
                this.f9083s = ttmlStyle.f9083s;
            }
            if (z2 && !this.f9069e && ttmlStyle.f9069e) {
                u(ttmlStyle.f9068d);
            }
            if (z2 && this.f9077m == -1 && (i2 = ttmlStyle.f9077m) != -1) {
                this.f9077m = i2;
            }
        }
        return this;
    }

    public TtmlStyle A(String str) {
        this.f9076l = str;
        return this;
    }

    public TtmlStyle B(boolean z2) {
        this.f9073i = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle C(boolean z2) {
        this.f9070f = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle D(Layout.Alignment alignment) {
        this.f9080p = alignment;
        return this;
    }

    public TtmlStyle E(int i2) {
        this.f9078n = i2;
        return this;
    }

    public TtmlStyle F(int i2) {
        this.f9077m = i2;
        return this;
    }

    public TtmlStyle G(float f2) {
        this.f9083s = f2;
        return this;
    }

    public TtmlStyle H(Layout.Alignment alignment) {
        this.f9079o = alignment;
        return this;
    }

    public TtmlStyle I(boolean z2) {
        this.f9081q = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle J(TextEmphasis textEmphasis) {
        this.f9082r = textEmphasis;
        return this;
    }

    public TtmlStyle K(boolean z2) {
        this.f9071g = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle a(TtmlStyle ttmlStyle) {
        return r(ttmlStyle, true);
    }

    public int b() {
        if (this.f9069e) {
            return this.f9068d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f9067c) {
            return this.f9066b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String d() {
        return this.f9065a;
    }

    public float e() {
        return this.f9075k;
    }

    public int f() {
        return this.f9074j;
    }

    public String g() {
        return this.f9076l;
    }

    public Layout.Alignment h() {
        return this.f9080p;
    }

    public int i() {
        return this.f9078n;
    }

    public int j() {
        return this.f9077m;
    }

    public float k() {
        return this.f9083s;
    }

    public int l() {
        int i2;
        int i3 = this.f9072h;
        if (i3 == -1 && this.f9073i == -1) {
            return -1;
        }
        int i4 = 0;
        if (i3 == 1) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.f9073i == 1) {
            i4 = 2;
        }
        return i2 | i4;
    }

    public Layout.Alignment m() {
        return this.f9079o;
    }

    public boolean n() {
        return this.f9081q == 1;
    }

    public TextEmphasis o() {
        return this.f9082r;
    }

    public boolean p() {
        return this.f9069e;
    }

    public boolean q() {
        return this.f9067c;
    }

    public boolean s() {
        return this.f9070f == 1;
    }

    public boolean t() {
        return this.f9071g == 1;
    }

    public TtmlStyle u(int i2) {
        this.f9068d = i2;
        this.f9069e = true;
        return this;
    }

    public TtmlStyle v(boolean z2) {
        this.f9072h = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle w(int i2) {
        this.f9066b = i2;
        this.f9067c = true;
        return this;
    }

    public TtmlStyle x(String str) {
        this.f9065a = str;
        return this;
    }

    public TtmlStyle y(float f2) {
        this.f9075k = f2;
        return this;
    }

    public TtmlStyle z(int i2) {
        this.f9074j = i2;
        return this;
    }
}
