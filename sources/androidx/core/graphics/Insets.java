package androidx.core.graphics;

import android.graphics.Rect;

public final class Insets {

    /* renamed from: e  reason: collision with root package name */
    public static final Insets f2541e = new Insets(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f2542a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2543b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2544c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2545d;

    static class Api29Impl {
        private Api29Impl() {
        }

        static android.graphics.Insets a(int i2, int i3, int i4, int i5) {
            return android.graphics.Insets.of(i2, i3, i4, i5);
        }
    }

    private Insets(int i2, int i3, int i4, int i5) {
        this.f2542a = i2;
        this.f2543b = i3;
        this.f2544c = i4;
        this.f2545d = i5;
    }

    public static Insets a(Insets insets, Insets insets2) {
        return b(Math.max(insets.f2542a, insets2.f2542a), Math.max(insets.f2543b, insets2.f2543b), Math.max(insets.f2544c, insets2.f2544c), Math.max(insets.f2545d, insets2.f2545d));
    }

    public static Insets b(int i2, int i3, int i4, int i5) {
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return f2541e;
        }
        return new Insets(i2, i3, i4, i5);
    }

    public static Insets c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static Insets d(android.graphics.Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public android.graphics.Insets e() {
        return Api29Impl.a(this.f2542a, this.f2543b, this.f2544c, this.f2545d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        if (this.f2545d == insets.f2545d && this.f2542a == insets.f2542a && this.f2544c == insets.f2544c && this.f2543b == insets.f2543b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f2542a * 31) + this.f2543b) * 31) + this.f2544c) * 31) + this.f2545d;
    }

    public String toString() {
        return "Insets{left=" + this.f2542a + ", top=" + this.f2543b + ", right=" + this.f2544c + ", bottom=" + this.f2545d + '}';
    }
}
