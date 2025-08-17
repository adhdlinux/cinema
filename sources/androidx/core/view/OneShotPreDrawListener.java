package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    private final View f2763b;

    /* renamed from: c  reason: collision with root package name */
    private ViewTreeObserver f2764c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f2765d;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.f2763b = view;
        this.f2764c = view.getViewTreeObserver();
        this.f2765d = runnable;
    }

    public static OneShotPreDrawListener a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
            view.addOnAttachStateChangeListener(oneShotPreDrawListener);
            return oneShotPreDrawListener;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public void b() {
        if (this.f2764c.isAlive()) {
            this.f2764c.removeOnPreDrawListener(this);
        } else {
            this.f2763b.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f2763b.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.f2765d.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f2764c = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
