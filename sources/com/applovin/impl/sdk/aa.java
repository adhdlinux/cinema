package com.applovin.impl.sdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.applovin.impl.mediation.a.d;
import com.applovin.impl.mediation.a.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

public class aa {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final v f15054a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f15055b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Rect f15056c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    private final Handler f15057d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f15058e;

    /* renamed from: f  reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f15059f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference<View> f15060g;

    /* renamed from: h  reason: collision with root package name */
    private final long f15061h;

    /* renamed from: i  reason: collision with root package name */
    private WeakReference<ViewTreeObserver> f15062i = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public WeakReference<View> f15063j = new WeakReference<>((Object) null);

    /* renamed from: k  reason: collision with root package name */
    private int f15064k;

    /* renamed from: l  reason: collision with root package name */
    private long f15065l;

    /* renamed from: m  reason: collision with root package name */
    private long f15066m = Long.MIN_VALUE;

    public interface a {
        void onLogVisibilityImpression();
    }

    public aa(final View view, m mVar, a aVar) {
        this.f15054a = mVar.A();
        this.f15061h = ((Long) mVar.a(b.bT)).longValue();
        this.f15057d = new Handler(Looper.getMainLooper());
        this.f15060g = new WeakReference<>(view);
        final WeakReference weakReference = new WeakReference(aVar);
        this.f15058e = new Runnable() {
            public void run() {
                View view = (View) aa.this.f15060g.get();
                ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                View view2 = (View) aa.this.f15063j.get();
                if (viewGroup != null && view2 != null) {
                    if (aa.this.b(viewGroup, view2)) {
                        if (v.a()) {
                            aa.this.f15054a.b("VisibilityTracker", "View met visibility requirements. Logging visibility impression..");
                        }
                        aa.this.a();
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.onLogVisibilityImpression();
                            return;
                        }
                        return;
                    }
                    aa.this.b();
                }
            }
        };
        this.f15059f = new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                aa.this.b();
                aa.this.b(view);
                return true;
            }
        };
    }

    private void a(View view) {
        View rootView = Utils.getRootView(this.f15060g.get());
        if (rootView == null) {
            rootView = Utils.getRootView(view);
        }
        if (rootView != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                this.f15062i = new WeakReference<>(viewTreeObserver);
                viewTreeObserver.addOnPreDrawListener(this.f15059f);
            } else if (v.a()) {
                this.f15054a.d("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
            }
        } else if (v.a()) {
            this.f15054a.b("VisibilityTracker", "Unable to set view tree observer due to no root view.");
        }
    }

    private boolean a(View view, View view2) {
        return view2 != null && view2.getVisibility() == 0 && view.getParent() != null && view2.getWidth() > 0 && view2.getHeight() > 0 && view2.getGlobalVisibleRect(this.f15056c) && ((long) (AppLovinSdkUtils.pxToDp(view2.getContext(), this.f15056c.width()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.f15056c.height()))) >= ((long) this.f15064k);
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f15057d.postDelayed(this.f15058e, this.f15061h);
    }

    /* access modifiers changed from: private */
    public void b(View view) {
        ViewTreeObserver viewTreeObserver = this.f15062i.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f15059f);
        } else if (view != null) {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnPreDrawListener(this.f15059f);
            }
        }
        this.f15062i.clear();
    }

    /* access modifiers changed from: private */
    public boolean b(View view, View view2) {
        if (!a(view, view2)) {
            return false;
        }
        if (this.f15066m == Long.MIN_VALUE) {
            this.f15066m = SystemClock.uptimeMillis();
        }
        return SystemClock.uptimeMillis() - this.f15066m >= this.f15065l;
    }

    public void a() {
        synchronized (this.f15055b) {
            this.f15057d.removeMessages(0);
            b(this.f15060g.get());
            this.f15066m = Long.MIN_VALUE;
            this.f15063j.clear();
        }
    }

    public void a(e eVar) {
        WeakReference<View> weakReference;
        synchronized (this.f15055b) {
            if (v.a()) {
                this.f15054a.b("VisibilityTracker", "Tracking Visibility...");
            }
            a();
            if (eVar instanceof com.applovin.impl.mediation.a.b) {
                weakReference = new WeakReference<>(((com.applovin.impl.mediation.a.b) eVar).w());
            } else if (eVar instanceof d) {
                weakReference = new WeakReference<>(((d) eVar).u());
            } else {
                return;
            }
            this.f15063j = weakReference;
            this.f15064k = eVar.F();
            this.f15065l = eVar.H();
            a(this.f15063j.get());
        }
    }
}
