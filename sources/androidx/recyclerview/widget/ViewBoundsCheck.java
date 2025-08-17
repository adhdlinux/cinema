package androidx.recyclerview.widget;

import android.view.View;

class ViewBoundsCheck {

    /* renamed from: a  reason: collision with root package name */
    final Callback f11369a;

    /* renamed from: b  reason: collision with root package name */
    BoundFlags f11370b = new BoundFlags();

    static class BoundFlags {

        /* renamed from: a  reason: collision with root package name */
        int f11371a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f11372b;

        /* renamed from: c  reason: collision with root package name */
        int f11373c;

        /* renamed from: d  reason: collision with root package name */
        int f11374d;

        /* renamed from: e  reason: collision with root package name */
        int f11375e;

        BoundFlags() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f11371a = i2 | this.f11371a;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            int i2 = this.f11371a;
            if ((i2 & 7) != 0 && (i2 & (c(this.f11374d, this.f11372b) << 0)) == 0) {
                return false;
            }
            int i3 = this.f11371a;
            if ((i3 & 112) != 0 && (i3 & (c(this.f11374d, this.f11373c) << 4)) == 0) {
                return false;
            }
            int i4 = this.f11371a;
            if ((i4 & 1792) != 0 && (i4 & (c(this.f11375e, this.f11372b) << 8)) == 0) {
                return false;
            }
            int i5 = this.f11371a;
            if ((i5 & 28672) == 0 || (i5 & (c(this.f11375e, this.f11373c) << 12)) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int c(int i2, int i3) {
            if (i2 > i3) {
                return 1;
            }
            return i2 == i3 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f11371a = 0;
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, int i3, int i4, int i5) {
            this.f11372b = i2;
            this.f11373c = i3;
            this.f11374d = i4;
            this.f11375e = i5;
        }
    }

    interface Callback {
        int a(View view);

        int b();

        int c();

        int d(View view);

        View getChildAt(int i2);
    }

    ViewBoundsCheck(Callback callback) {
        this.f11369a = callback;
    }

    /* access modifiers changed from: package-private */
    public View a(int i2, int i3, int i4, int i5) {
        int i6;
        int b2 = this.f11369a.b();
        int c2 = this.f11369a.c();
        if (i3 > i2) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        View view = null;
        while (i2 != i3) {
            View childAt = this.f11369a.getChildAt(i2);
            this.f11370b.e(b2, c2, this.f11369a.a(childAt), this.f11369a.d(childAt));
            if (i4 != 0) {
                this.f11370b.d();
                this.f11370b.a(i4);
                if (this.f11370b.b()) {
                    return childAt;
                }
            }
            if (i5 != 0) {
                this.f11370b.d();
                this.f11370b.a(i5);
                if (this.f11370b.b()) {
                    view = childAt;
                }
            }
            i2 += i6;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public boolean b(View view, int i2) {
        this.f11370b.e(this.f11369a.b(), this.f11369a.c(), this.f11369a.a(view), this.f11369a.d(view));
        if (i2 == 0) {
            return false;
        }
        this.f11370b.d();
        this.f11370b.a(i2);
        return this.f11370b.b();
    }
}
