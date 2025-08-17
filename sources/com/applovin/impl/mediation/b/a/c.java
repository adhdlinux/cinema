package com.applovin.impl.mediation.b.a;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap<View, Integer> f14358a = new WeakHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f14359b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Handler f14360c = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f14361d = false;

    /* renamed from: e  reason: collision with root package name */
    private final WeakReference<View> f14362e;

    /* renamed from: f  reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f14363f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public a f14364g;

    public interface a {
        void a(int i2, int i3);
    }

    public c(View view) {
        this.f14362e = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            AnonymousClass1 r02 = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    c.this.b();
                    return true;
                }
            };
            this.f14363f = r02;
            viewTreeObserver.addOnPreDrawListener(r02);
            return;
        }
        this.f14363f = null;
    }

    /* access modifiers changed from: private */
    public void b() {
        if (!this.f14361d) {
            this.f14361d = true;
            this.f14360c.postDelayed(new Runnable() {
                public void run() {
                    synchronized (c.this.f14359b) {
                        boolean unused = c.this.f14361d = false;
                        int i2 = -1;
                        int i3 = -1;
                        for (Map.Entry entry : c.this.f14358a.entrySet()) {
                            if (c.this.b((View) entry.getKey())) {
                                Integer num = (Integer) entry.getValue();
                                if (i2 == -1 && i3 == -1) {
                                    i2 = num.intValue();
                                    i3 = num.intValue();
                                } else {
                                    i2 = Math.min(i2, ((Integer) entry.getValue()).intValue());
                                    i3 = Math.max(i3, ((Integer) entry.getValue()).intValue());
                                }
                            }
                        }
                        if (c.this.f14364g != null) {
                            c.this.f14364g.a(i2, i3);
                        }
                    }
                }
            }, 100);
        }
    }

    /* access modifiers changed from: private */
    public boolean b(View view) {
        return (view == null || view.getVisibility() != 0 || view.getParent() == null) ? false : true;
    }

    public void a() {
        ViewTreeObserver.OnPreDrawListener onPreDrawListener;
        this.f14364g = null;
        View view = this.f14362e.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive() && (onPreDrawListener = this.f14363f) != null) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            }
            this.f14362e.clear();
        }
    }

    public void a(View view) {
        synchronized (this.f14359b) {
            this.f14358a.remove(view);
        }
    }

    public void a(View view, int i2) {
        synchronized (this.f14359b) {
            this.f14358a.put(view, Integer.valueOf(i2));
            b();
        }
    }

    public void a(a aVar) {
        this.f14364g = aVar;
    }
}
