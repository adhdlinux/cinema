package com.facebook.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.internal.n.d;
import com.facebook.ads.internal.n.f;
import java.lang.ref.WeakReference;

public final class DefaultMediaViewVideoRenderer extends MediaViewVideoRenderer {

    /* renamed from: d  reason: collision with root package name */
    private d f19453d;

    private static class a implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<f> f19455a;

        public a(f fVar) {
            this.f19455a = new WeakReference<>(fVar);
        }

        public void a(boolean z2) {
            if (this.f19455a.get() != null) {
                this.f19455a.get().a(z2, false);
            }
        }
    }

    public DefaultMediaViewVideoRenderer(Context context) {
        super(context);
        this.f19453d = new d(context, this);
        b();
    }

    public DefaultMediaViewVideoRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19453d = new d(context, this);
        b();
    }

    public DefaultMediaViewVideoRenderer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19453d = new d(context, this);
        b();
    }

    @TargetApi(21)
    public DefaultMediaViewVideoRenderer(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f19453d = new d(context, this);
        b();
    }

    private void b() {
        setVolume(0.0f);
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.f19453d.a();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f19453d.c();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f19453d.d();
        super.onDetachedFromWindow();
    }

    public void onPrepared() {
        super.onPrepared();
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f19453d.b();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        this.f19453d.e();
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        this.f19453d.f();
    }

    /* access modifiers changed from: protected */
    public void setNativeAd(NativeAd nativeAd) {
        super.setNativeAd(nativeAd);
        this.f19453d.a(nativeAd.g(), (d.a) new a(nativeAd.g()));
    }
}
