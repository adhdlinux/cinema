package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.AspectRatioMeasure;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class DraweeView<DH extends DraweeHierarchy> extends ImageView {
    private static boolean sGlobalLegacyVisibilityHandlingEnabled = false;
    private float mAspectRatio = 0.0f;
    private DraweeHolder<DH> mDraweeHolder;
    private boolean mInitialised = false;
    private boolean mLegacyVisibilityHandlingEnabled = false;
    private final AspectRatioMeasure.Spec mMeasureSpec = new AspectRatioMeasure.Spec();

    public DraweeView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DraweeView#init");
            }
            if (!this.mInitialised) {
                boolean z2 = true;
                this.mInitialised = true;
                this.mDraweeHolder = DraweeHolder.create(null, context);
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                    if (!sGlobalLegacyVisibilityHandlingEnabled || context.getApplicationInfo().targetSdkVersion < 24) {
                        z2 = false;
                    }
                    this.mLegacyVisibilityHandlingEnabled = z2;
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } else if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    private void maybeOverrideVisibilityHandling() {
        Drawable drawable;
        boolean z2;
        if (this.mLegacyVisibilityHandlingEnabled && (drawable = getDrawable()) != null) {
            if (getVisibility() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            drawable.setVisible(z2, false);
        }
    }

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z2) {
        sGlobalLegacyVisibilityHandlingEnabled = z2;
    }

    /* access modifiers changed from: protected */
    public void doAttach() {
        this.mDraweeHolder.onAttach();
    }

    /* access modifiers changed from: protected */
    public void doDetach() {
        this.mDraweeHolder.onDetach();
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public DraweeController getController() {
        return this.mDraweeHolder.getController();
    }

    public DH getHierarchy() {
        return this.mDraweeHolder.getHierarchy();
    }

    public Drawable getTopLevelDrawable() {
        return this.mDraweeHolder.getTopLevelDrawable();
    }

    public boolean hasController() {
        return this.mDraweeHolder.getController() != null;
    }

    public boolean hasHierarchy() {
        return this.mDraweeHolder.hasHierarchy();
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
        doAttach();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeOverrideVisibilityHandling();
        onAttach();
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
        doDetach();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        maybeOverrideVisibilityHandling();
        onDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        maybeOverrideVisibilityHandling();
        onAttach();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AspectRatioMeasure.Spec spec = this.mMeasureSpec;
        spec.width = i2;
        spec.height = i3;
        AspectRatioMeasure.updateMeasureSpec(spec, this.mAspectRatio, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        AspectRatioMeasure.Spec spec2 = this.mMeasureSpec;
        super.onMeasure(spec2.width, spec2.height);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        maybeOverrideVisibilityHandling();
        onDetach();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mDraweeHolder.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        maybeOverrideVisibilityHandling();
    }

    public void setAspectRatio(float f2) {
        if (f2 != this.mAspectRatio) {
            this.mAspectRatio = f2;
            requestLayout();
        }
    }

    public void setController(DraweeController draweeController) {
        this.mDraweeHolder.setController(draweeController);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    public void setHierarchy(DH dh) {
        this.mDraweeHolder.setHierarchy(dh);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mDraweeHolder.setController((DraweeController) null);
        super.setImageBitmap(bitmap);
    }

    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mDraweeHolder.setController((DraweeController) null);
        super.setImageDrawable(drawable);
    }

    @Deprecated
    public void setImageResource(int i2) {
        init(getContext());
        this.mDraweeHolder.setController((DraweeController) null);
        super.setImageResource(i2);
    }

    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mDraweeHolder.setController((DraweeController) null);
        super.setImageURI(uri);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z2) {
        this.mLegacyVisibilityHandlingEnabled = z2;
    }

    public String toString() {
        String str;
        Objects.ToStringHelper stringHelper = Objects.toStringHelper((Object) this);
        DraweeHolder<DH> draweeHolder = this.mDraweeHolder;
        if (draweeHolder != null) {
            str = draweeHolder.toString();
        } else {
            str = "<no holder set>";
        }
        return stringHelper.add("holder", (Object) str).toString();
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        init(context);
    }
}
