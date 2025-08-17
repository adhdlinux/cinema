package com.vungle.ads.internal.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.Intrinsics;

public final class MediaView extends RelativeLayout {
    private ImageView imageView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaView(Context context) {
        super(context);
        Intrinsics.f(context, "context");
        initView(context);
    }

    private final void initView(Context context) {
        this.imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ImageView imageView2 = this.imageView;
        ImageView imageView3 = null;
        if (imageView2 == null) {
            Intrinsics.x("imageView");
            imageView2 = null;
        }
        imageView2.setLayoutParams(layoutParams);
        ImageView imageView4 = this.imageView;
        if (imageView4 == null) {
            Intrinsics.x("imageView");
            imageView4 = null;
        }
        imageView4.setAdjustViewBounds(true);
        ImageView imageView5 = this.imageView;
        if (imageView5 == null) {
            Intrinsics.x("imageView");
        } else {
            imageView3 = imageView5;
        }
        addView(imageView3);
        requestLayout();
    }

    public final void destroy() {
        ImageView imageView2 = null;
        try {
            ImageView imageView3 = this.imageView;
            if (imageView3 == null) {
                Intrinsics.x("imageView");
                imageView3 = null;
            }
            Drawable drawable = imageView3.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        } catch (Exception e2) {
            Logger.Companion.w("NativeAd", "error msg: " + e2.getLocalizedMessage());
        }
        ImageView imageView4 = this.imageView;
        if (imageView4 == null) {
            Intrinsics.x("imageView");
            imageView4 = null;
        }
        imageView4.setImageDrawable((Drawable) null);
        ImageView imageView5 = this.imageView;
        if (imageView5 == null) {
            Intrinsics.x("imageView");
            imageView5 = null;
        }
        if (imageView5.getParent() != null) {
            ImageView imageView6 = this.imageView;
            if (imageView6 == null) {
                Intrinsics.x("imageView");
                imageView6 = null;
            }
            ViewParent parent = imageView6.getParent();
            Intrinsics.d(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            ImageView imageView7 = this.imageView;
            if (imageView7 == null) {
                Intrinsics.x("imageView");
            } else {
                imageView2 = imageView7;
            }
            viewGroup.removeView(imageView2);
        }
    }

    public final ImageView getMainImage$vungle_ads_release() {
        ImageView imageView2 = this.imageView;
        if (imageView2 != null) {
            return imageView2;
        }
        Intrinsics.x("imageView");
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        initView(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.f(context, "context");
        initView(context);
    }
}
