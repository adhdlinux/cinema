package com.facebook.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.n.g;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.b.d;
import com.facebook.ads.internal.view.b.e;

public class AdIconView extends g {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f19409a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19410b;

    public AdIconView(Context context) {
        super(context);
        a();
    }

    public AdIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public AdIconView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    @TargetApi(21)
    public AdIconView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a();
    }

    private void a() {
        x.b(this.f19409a);
        ImageView imageView = new ImageView(getContext());
        this.f19409a = imageView;
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.f19409a);
        this.f19410b = true;
    }

    private void a(final NativeAdBase nativeAdBase, boolean z2) {
        bringChildToFront(this.f19409a);
        nativeAdBase.a(this);
        d a2 = new d(this.f19409a).a();
        if (z2) {
            a2.a((e) new e() {
                public void a(boolean z2) {
                    nativeAdBase.g().a(z2, true);
                }
            });
        }
        a2.a(nativeAdBase.g().j().a());
    }

    public void addView(View view) {
        if (!this.f19410b) {
            super.addView(view);
        }
    }

    public void addView(View view, int i2) {
        if (!this.f19410b) {
            super.addView(view, i2);
        }
    }

    public void addView(View view, int i2, int i3) {
        if (!this.f19410b) {
            super.addView(view, i2, i3);
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f19410b) {
            super.addView(view, layoutParams);
        }
    }

    public void bringChildToFront(View view) {
        if (view == this.f19409a) {
            super.bringChildToFront(view);
        }
    }

    public void forceAddview(View view, ViewGroup.LayoutParams layoutParams) {
        this.f19410b = false;
        addView(view, layoutParams);
        this.f19410b = true;
    }

    /* access modifiers changed from: protected */
    public View getAdContentsView() {
        return this.f19409a;
    }

    /* access modifiers changed from: package-private */
    public void setNativeAd(NativeAd nativeAd) {
        a(nativeAd, false);
    }

    /* access modifiers changed from: package-private */
    public void setNativeBannerAd(NativeBannerAd nativeBannerAd) {
        a(nativeBannerAd, true);
    }
}
