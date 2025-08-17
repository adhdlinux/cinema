package com.vungle.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.ViewUtility;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class NativeAdOptionsView extends FrameLayout {
    private static final int AD_OPTIONS_VIEW_SIZE = 20;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ImageView icon;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeAdOptionsView(Context context) {
        super(context);
        Intrinsics.f(context, "context");
        initView(context);
    }

    private final void initView(Context context) {
        this.icon = new ImageView(context);
        int dpToPixels = ViewUtility.INSTANCE.dpToPixels(context, 20);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPixels, dpToPixels);
        ImageView imageView = this.icon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.x("icon");
            imageView = null;
        }
        imageView.setLayoutParams(layoutParams);
        ImageView imageView3 = this.icon;
        if (imageView3 == null) {
            Intrinsics.x("icon");
        } else {
            imageView2 = imageView3;
        }
        addView(imageView2);
    }

    public final void destroy() {
        try {
            ImageView imageView = this.icon;
            if (imageView == null) {
                Intrinsics.x("icon");
                imageView = null;
            }
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        } catch (Exception e2) {
            Logger.Companion.w("NativeAd", "error msg: " + e2.getLocalizedMessage());
        }
        ImageView imageView2 = this.icon;
        if (imageView2 == null) {
            Intrinsics.x("icon");
            imageView2 = null;
        }
        imageView2.setImageDrawable((Drawable) null);
        removeAllViews();
        if (getParent() != null) {
            ViewParent parent = getParent();
            Intrinsics.d(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
    }

    public final ImageView getPrivacyIcon$vungle_ads_release() {
        ImageView imageView = this.icon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.x("icon");
        return null;
    }

    public final void renderTo(FrameLayout frameLayout, int i2) {
        Intrinsics.f(frameLayout, "rootView");
        if (getParent() != null) {
            ViewParent parent = getParent();
            Intrinsics.d(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
        frameLayout.addView(this);
        ViewUtility viewUtility = ViewUtility.INSTANCE;
        Context context = getContext();
        Intrinsics.e(context, "context");
        int dpToPixels = viewUtility.dpToPixels(context, 20);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPixels, dpToPixels);
        if (i2 == 0) {
            layoutParams.gravity = 8388659;
        } else if (i2 == 1) {
            layoutParams.gravity = 8388661;
        } else if (i2 == 2) {
            layoutParams.gravity = 8388691;
        } else if (i2 != 3) {
            layoutParams.gravity = 8388661;
        } else {
            layoutParams.gravity = 8388693;
        }
        setLayoutParams(layoutParams);
        frameLayout.requestLayout();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeAdOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        initView(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeAdOptionsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.f(context, "context");
        initView(context);
    }
}
