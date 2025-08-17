package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class WebvttCssStyle {

    /* renamed from: a  reason: collision with root package name */
    private String f27574a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f27575b = "";

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f27576c = Collections.emptySet();

    /* renamed from: d  reason: collision with root package name */
    private String f27577d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f27578e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f27579f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f27580g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f27581h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f27582i = false;

    /* renamed from: j  reason: collision with root package name */
    private int f27583j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f27584k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f27585l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f27586m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f27587n = -1;

    /* renamed from: o  reason: collision with root package name */
    private float f27588o;

    /* renamed from: p  reason: collision with root package name */
    private int f27589p = -1;

    /* renamed from: q  reason: collision with root package name */
    private boolean f27590q = false;

    private static int B(int i2, String str, String str2, int i3) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }

    public WebvttCssStyle A(boolean z2) {
        this.f27584k = z2 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f27582i) {
            return this.f27581h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f27590q;
    }

    public int c() {
        if (this.f27580g) {
            return this.f27579f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public String d() {
        return this.f27578e;
    }

    public float e() {
        return this.f27588o;
    }

    public int f() {
        return this.f27587n;
    }

    public int g() {
        return this.f27589p;
    }

    public int h(String str, String str2, Set<String> set, String str3) {
        if (this.f27574a.isEmpty() && this.f27575b.isEmpty() && this.f27576c.isEmpty() && this.f27577d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int B = B(B(B(0, this.f27574a, str, 1073741824), this.f27575b, str2, 2), this.f27577d, str3, 4);
        if (B == -1 || !set.containsAll(this.f27576c)) {
            return 0;
        }
        return B + (this.f27576c.size() * 4);
    }

    public int i() {
        int i2;
        int i3 = this.f27585l;
        if (i3 == -1 && this.f27586m == -1) {
            return -1;
        }
        int i4 = 0;
        if (i3 == 1) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.f27586m == 1) {
            i4 = 2;
        }
        return i2 | i4;
    }

    public boolean j() {
        return this.f27582i;
    }

    public boolean k() {
        return this.f27580g;
    }

    public boolean l() {
        return this.f27583j == 1;
    }

    public boolean m() {
        return this.f27584k == 1;
    }

    public WebvttCssStyle n(int i2) {
        this.f27581h = i2;
        this.f27582i = true;
        return this;
    }

    public WebvttCssStyle o(boolean z2) {
        this.f27585l = z2 ? 1 : 0;
        return this;
    }

    public WebvttCssStyle p(boolean z2) {
        this.f27590q = z2;
        return this;
    }

    public WebvttCssStyle q(int i2) {
        this.f27579f = i2;
        this.f27580g = true;
        return this;
    }

    public WebvttCssStyle r(String str) {
        this.f27578e = str == null ? null : Ascii.e(str);
        return this;
    }

    public WebvttCssStyle s(float f2) {
        this.f27588o = f2;
        return this;
    }

    public WebvttCssStyle t(int i2) {
        this.f27587n = i2;
        return this;
    }

    public WebvttCssStyle u(boolean z2) {
        this.f27586m = z2 ? 1 : 0;
        return this;
    }

    public WebvttCssStyle v(int i2) {
        this.f27589p = i2;
        return this;
    }

    public void w(String[] strArr) {
        this.f27576c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f27574a = str;
    }

    public void y(String str) {
        this.f27575b = str;
    }

    public void z(String str) {
        this.f27577d = str;
    }
}
