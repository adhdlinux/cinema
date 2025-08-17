package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {

    /* renamed from: a  reason: collision with root package name */
    final Callback f11027a;

    /* renamed from: b  reason: collision with root package name */
    final Bucket f11028b = new Bucket();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f11029c = new ArrayList();

    static class Bucket {

        /* renamed from: a  reason: collision with root package name */
        long f11030a = 0;

        /* renamed from: b  reason: collision with root package name */
        Bucket f11031b;

        Bucket() {
        }

        private void c() {
            if (this.f11031b == null) {
                this.f11031b = new Bucket();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if (i2 >= 64) {
                Bucket bucket = this.f11031b;
                if (bucket != null) {
                    bucket.a(i2 - 64);
                    return;
                }
                return;
            }
            this.f11030a &= ~(1 << i2);
        }

        /* access modifiers changed from: package-private */
        public int b(int i2) {
            Bucket bucket = this.f11031b;
            if (bucket == null) {
                if (i2 >= 64) {
                    return Long.bitCount(this.f11030a);
                }
                return Long.bitCount(this.f11030a & ((1 << i2) - 1));
            } else if (i2 < 64) {
                return Long.bitCount(this.f11030a & ((1 << i2) - 1));
            } else {
                return bucket.b(i2 - 64) + Long.bitCount(this.f11030a);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i2) {
            if (i2 >= 64) {
                c();
                return this.f11031b.d(i2 - 64);
            } else if ((this.f11030a & (1 << i2)) != 0) {
                return true;
            } else {
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, boolean z2) {
            boolean z3;
            if (i2 >= 64) {
                c();
                this.f11031b.e(i2 - 64, z2);
                return;
            }
            long j2 = this.f11030a;
            if ((Long.MIN_VALUE & j2) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            long j3 = (1 << i2) - 1;
            this.f11030a = ((j2 & (~j3)) << 1) | (j2 & j3);
            if (z2) {
                h(i2);
            } else {
                a(i2);
            }
            if (z3 || this.f11031b != null) {
                c();
                this.f11031b.e(0, z3);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean f(int i2) {
            boolean z2;
            if (i2 >= 64) {
                c();
                return this.f11031b.f(i2 - 64);
            }
            long j2 = 1 << i2;
            long j3 = this.f11030a;
            if ((j3 & j2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            long j4 = j3 & (~j2);
            this.f11030a = j4;
            long j5 = j2 - 1;
            this.f11030a = (j4 & j5) | Long.rotateRight((~j5) & j4, 1);
            Bucket bucket = this.f11031b;
            if (bucket != null) {
                if (bucket.d(0)) {
                    h(63);
                }
                this.f11031b.f(0);
            }
            return z2;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            this.f11030a = 0;
            Bucket bucket = this.f11031b;
            if (bucket != null) {
                bucket.g();
            }
        }

        /* access modifiers changed from: package-private */
        public void h(int i2) {
            if (i2 >= 64) {
                c();
                this.f11031b.h(i2 - 64);
                return;
            }
            this.f11030a |= 1 << i2;
        }

        public String toString() {
            if (this.f11031b == null) {
                return Long.toBinaryString(this.f11030a);
            }
            return this.f11031b.toString() + "xx" + Long.toBinaryString(this.f11030a);
        }
    }

    interface Callback {
        void a(View view);

        RecyclerView.ViewHolder b(View view);

        void c(int i2);

        void d(View view, int i2);

        void e();

        int f(View view);

        void g(View view);

        View getChildAt(int i2);

        int getChildCount();

        void h(int i2);

        void i(View view, int i2, ViewGroup.LayoutParams layoutParams);
    }

    ChildHelper(Callback callback) {
        this.f11027a = callback;
    }

    private int h(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int childCount = this.f11027a.getChildCount();
        int i3 = i2;
        while (i3 < childCount) {
            int b2 = i2 - (i3 - this.f11028b.b(i3));
            if (b2 == 0) {
                while (this.f11028b.d(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += b2;
        }
        return -1;
    }

    private void l(View view) {
        this.f11029c.add(view);
        this.f11027a.a(view);
    }

    private boolean t(View view) {
        if (!this.f11029c.remove(view)) {
            return false;
        }
        this.f11027a.g(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2, boolean z2) {
        int i3;
        if (i2 < 0) {
            i3 = this.f11027a.getChildCount();
        } else {
            i3 = h(i2);
        }
        this.f11028b.e(i3, z2);
        if (z2) {
            l(view);
        }
        this.f11027a.d(view, i3);
    }

    /* access modifiers changed from: package-private */
    public void b(View view, boolean z2) {
        a(view, -1, z2);
    }

    /* access modifiers changed from: package-private */
    public void c(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z2) {
        int i3;
        if (i2 < 0) {
            i3 = this.f11027a.getChildCount();
        } else {
            i3 = h(i2);
        }
        this.f11028b.e(i3, z2);
        if (z2) {
            l(view);
        }
        this.f11027a.i(view, i3, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        int h2 = h(i2);
        this.f11028b.f(h2);
        this.f11027a.c(h2);
    }

    /* access modifiers changed from: package-private */
    public View e(int i2) {
        int size = this.f11029c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f11029c.get(i3);
            RecyclerView.ViewHolder b2 = this.f11027a.b(view);
            if (b2.getLayoutPosition() == i2 && !b2.isInvalid() && !b2.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View f(int i2) {
        return this.f11027a.getChildAt(h(i2));
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f11027a.getChildCount() - this.f11029c.size();
    }

    /* access modifiers changed from: package-private */
    public View i(int i2) {
        return this.f11027a.getChildAt(i2);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f11027a.getChildCount();
    }

    /* access modifiers changed from: package-private */
    public void k(View view) {
        int f2 = this.f11027a.f(view);
        if (f2 >= 0) {
            this.f11028b.h(f2);
            l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    public int m(View view) {
        int f2 = this.f11027a.f(view);
        if (f2 != -1 && !this.f11028b.d(f2)) {
            return f2 - this.f11028b.b(f2);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f11029c.contains(view);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f11028b.g();
        for (int size = this.f11029c.size() - 1; size >= 0; size--) {
            this.f11027a.g(this.f11029c.get(size));
            this.f11029c.remove(size);
        }
        this.f11027a.e();
    }

    /* access modifiers changed from: package-private */
    public void p(View view) {
        int f2 = this.f11027a.f(view);
        if (f2 >= 0) {
            if (this.f11028b.f(f2)) {
                t(view);
            }
            this.f11027a.h(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void q(int i2) {
        int h2 = h(i2);
        View childAt = this.f11027a.getChildAt(h2);
        if (childAt != null) {
            if (this.f11028b.f(h2)) {
                t(childAt);
            }
            this.f11027a.h(h2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r(View view) {
        int f2 = this.f11027a.f(view);
        if (f2 == -1) {
            t(view);
            return true;
        } else if (!this.f11028b.d(f2)) {
            return false;
        } else {
            this.f11028b.f(f2);
            t(view);
            this.f11027a.h(f2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void s(View view) {
        int f2 = this.f11027a.f(view);
        if (f2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f11028b.d(f2)) {
            this.f11028b.a(f2);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f11028b.toString() + ", hidden list:" + this.f11029c.size();
    }
}
