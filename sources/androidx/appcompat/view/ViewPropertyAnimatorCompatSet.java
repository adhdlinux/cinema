package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewPropertyAnimatorCompatSet {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<ViewPropertyAnimatorCompat> f719a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private long f720b = -1;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f721c;

    /* renamed from: d  reason: collision with root package name */
    ViewPropertyAnimatorListener f722d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f723e;

    /* renamed from: f  reason: collision with root package name */
    private final ViewPropertyAnimatorListenerAdapter f724f = new ViewPropertyAnimatorListenerAdapter() {

        /* renamed from: a  reason: collision with root package name */
        private boolean f725a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f726b = 0;

        public void b(View view) {
            int i2 = this.f726b + 1;
            this.f726b = i2;
            if (i2 == ViewPropertyAnimatorCompatSet.this.f719a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f722d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.b((View) null);
                }
                d();
            }
        }

        public void c(View view) {
            if (!this.f725a) {
                this.f725a = true;
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f722d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.c((View) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f726b = 0;
            this.f725a = false;
            ViewPropertyAnimatorCompatSet.this.b();
        }
    };

    public void a() {
        if (this.f723e) {
            Iterator<ViewPropertyAnimatorCompat> it2 = this.f719a.iterator();
            while (it2.hasNext()) {
                it2.next().c();
            }
            this.f723e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f723e = false;
    }

    public ViewPropertyAnimatorCompatSet c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f723e) {
            this.f719a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f719a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.j(viewPropertyAnimatorCompat.d());
        this.f719a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet e(long j2) {
        if (!this.f723e) {
            this.f720b = j2;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet f(Interpolator interpolator) {
        if (!this.f723e) {
            this.f721c = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet g(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f723e) {
            this.f722d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void h() {
        if (!this.f723e) {
            Iterator<ViewPropertyAnimatorCompat> it2 = this.f719a.iterator();
            while (it2.hasNext()) {
                ViewPropertyAnimatorCompat next = it2.next();
                long j2 = this.f720b;
                if (j2 >= 0) {
                    next.f(j2);
                }
                Interpolator interpolator = this.f721c;
                if (interpolator != null) {
                    next.g(interpolator);
                }
                if (this.f722d != null) {
                    next.h(this.f724f);
                }
                next.l();
            }
            this.f723e = true;
        }
    }
}
