package androidx.media3.extractor.text.webvtt;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class WebvttCssStyle {

    /* renamed from: a  reason: collision with root package name */
    private String f9101a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f9102b = "";

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f9103c = Collections.emptySet();

    /* renamed from: d  reason: collision with root package name */
    private String f9104d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f9105e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f9106f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9107g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f9108h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9109i = false;

    /* renamed from: j  reason: collision with root package name */
    private int f9110j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f9111k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f9112l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f9113m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f9114n = -1;

    /* renamed from: o  reason: collision with root package name */
    private float f9115o;

    /* renamed from: p  reason: collision with root package name */
    private int f9116p = -1;

    /* renamed from: q  reason: collision with root package name */
    private boolean f9117q = false;

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
        this.f9111k = z2 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f9109i) {
            return this.f9108h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f9117q;
    }

    public int c() {
        if (this.f9107g) {
            return this.f9106f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public String d() {
        return this.f9105e;
    }

    public float e() {
        return this.f9115o;
    }

    public int f() {
        return this.f9114n;
    }

    public int g() {
        return this.f9116p;
    }

    public int h(String str, String str2, Set<String> set, String str3) {
        if (this.f9101a.isEmpty() && this.f9102b.isEmpty() && this.f9103c.isEmpty() && this.f9104d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int B = B(B(B(0, this.f9101a, str, 1073741824), this.f9102b, str2, 2), this.f9104d, str3, 4);
        if (B == -1 || !set.containsAll(this.f9103c)) {
            return 0;
        }
        return B + (this.f9103c.size() * 4);
    }

    public int i() {
        int i2;
        int i3 = this.f9112l;
        if (i3 == -1 && this.f9113m == -1) {
            return -1;
        }
        int i4 = 0;
        if (i3 == 1) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.f9113m == 1) {
            i4 = 2;
        }
        return i2 | i4;
    }

    public boolean j() {
        return this.f9109i;
    }

    public boolean k() {
        return this.f9107g;
    }

    public boolean l() {
        return this.f9110j == 1;
    }

    public boolean m() {
        return this.f9111k == 1;
    }

    public WebvttCssStyle n(int i2) {
        this.f9108h = i2;
        this.f9109i = true;
        return this;
    }

    public WebvttCssStyle o(boolean z2) {
        this.f9112l = z2 ? 1 : 0;
        return this;
    }

    public WebvttCssStyle p(boolean z2) {
        this.f9117q = z2;
        return this;
    }

    public WebvttCssStyle q(int i2) {
        this.f9106f = i2;
        this.f9107g = true;
        return this;
    }

    public WebvttCssStyle r(String str) {
        this.f9105e = str == null ? null : Ascii.e(str);
        return this;
    }

    public WebvttCssStyle s(float f2) {
        this.f9115o = f2;
        return this;
    }

    public WebvttCssStyle t(int i2) {
        this.f9114n = i2;
        return this;
    }

    public WebvttCssStyle u(boolean z2) {
        this.f9113m = z2 ? 1 : 0;
        return this;
    }

    public WebvttCssStyle v(int i2) {
        this.f9116p = i2;
        return this;
    }

    public void w(String[] strArr) {
        this.f9103c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f9101a = str;
    }

    public void y(String str) {
        this.f9102b = str;
    }

    public void z(String str) {
        this.f9104d = str;
    }
}
