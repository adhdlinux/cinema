package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class GenericDraweeHierarchy implements SettableDraweeHierarchy {
    private static final int ACTUAL_IMAGE_INDEX = 2;
    private static final int BACKGROUND_IMAGE_INDEX = 0;
    private static final int FAILURE_IMAGE_INDEX = 5;
    private static final int OVERLAY_IMAGES_INDEX = 6;
    private static final int PLACEHOLDER_IMAGE_INDEX = 1;
    private static final int PROGRESS_BAR_IMAGE_INDEX = 3;
    private static final int RETRY_IMAGE_INDEX = 4;
    private final ForwardingDrawable mActualImageWrapper;
    private final Drawable mEmptyActualImageDrawable;
    private final FadeDrawable mFadeDrawable;
    private final Resources mResources;
    private RoundingParams mRoundingParams;
    private final RootDrawable mTopLevelDrawable;

    GenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        int i2;
        int i3;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.mEmptyActualImageDrawable = colorDrawable;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("GenericDraweeHierarchy()");
        }
        this.mResources = genericDraweeHierarchyBuilder.getResources();
        this.mRoundingParams = genericDraweeHierarchyBuilder.getRoundingParams();
        ForwardingDrawable forwardingDrawable = new ForwardingDrawable(colorDrawable);
        this.mActualImageWrapper = forwardingDrawable;
        int i4 = 1;
        if (genericDraweeHierarchyBuilder.getOverlays() != null) {
            i2 = genericDraweeHierarchyBuilder.getOverlays().size();
        } else {
            i2 = 1;
        }
        i2 = i2 == 0 ? 1 : i2;
        if (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i5 = i2 + i3;
        Drawable[] drawableArr = new Drawable[(i5 + 6)];
        drawableArr[0] = buildBranch(genericDraweeHierarchyBuilder.getBackground(), (ScalingUtils.ScaleType) null);
        drawableArr[1] = buildBranch(genericDraweeHierarchyBuilder.getPlaceholderImage(), genericDraweeHierarchyBuilder.getPlaceholderImageScaleType());
        drawableArr[2] = buildActualImageBranch(forwardingDrawable, genericDraweeHierarchyBuilder.getActualImageScaleType(), genericDraweeHierarchyBuilder.getActualImageFocusPoint(), genericDraweeHierarchyBuilder.getActualImageColorFilter());
        drawableArr[3] = buildBranch(genericDraweeHierarchyBuilder.getProgressBarImage(), genericDraweeHierarchyBuilder.getProgressBarImageScaleType());
        drawableArr[4] = buildBranch(genericDraweeHierarchyBuilder.getRetryImage(), genericDraweeHierarchyBuilder.getRetryImageScaleType());
        drawableArr[5] = buildBranch(genericDraweeHierarchyBuilder.getFailureImage(), genericDraweeHierarchyBuilder.getFailureImageScaleType());
        if (i5 > 0) {
            if (genericDraweeHierarchyBuilder.getOverlays() != null) {
                i4 = 0;
                for (Drawable buildBranch : genericDraweeHierarchyBuilder.getOverlays()) {
                    drawableArr[i4 + 6] = buildBranch(buildBranch, (ScalingUtils.ScaleType) null);
                    i4++;
                }
            }
            if (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null) {
                drawableArr[i4 + 6] = buildBranch(genericDraweeHierarchyBuilder.getPressedStateOverlay(), (ScalingUtils.ScaleType) null);
            }
        }
        FadeDrawable fadeDrawable = new FadeDrawable(drawableArr, false, 2);
        this.mFadeDrawable = fadeDrawable;
        fadeDrawable.setTransitionDuration(genericDraweeHierarchyBuilder.getFadeDuration());
        RootDrawable rootDrawable = new RootDrawable(WrappingUtils.maybeWrapWithRoundedOverlayColor(fadeDrawable, this.mRoundingParams));
        this.mTopLevelDrawable = rootDrawable;
        rootDrawable.mutate();
        resetFade();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    private Drawable buildActualImageBranch(Drawable drawable, ScalingUtils.ScaleType scaleType, PointF pointF, ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return WrappingUtils.maybeWrapWithScaleType(drawable, scaleType, pointF);
    }

    private Drawable buildBranch(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        return WrappingUtils.maybeWrapWithScaleType(WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources), scaleType);
    }

    private void fadeInLayer(int i2) {
        if (i2 >= 0) {
            this.mFadeDrawable.fadeInLayer(i2);
        }
    }

    private void fadeOutBranches() {
        fadeOutLayer(1);
        fadeOutLayer(2);
        fadeOutLayer(3);
        fadeOutLayer(4);
        fadeOutLayer(5);
    }

    private void fadeOutLayer(int i2) {
        if (i2 >= 0) {
            this.mFadeDrawable.fadeOutLayer(i2);
        }
    }

    private DrawableParent getParentDrawableAtIndex(int i2) {
        DrawableParent drawableParentForIndex = this.mFadeDrawable.getDrawableParentForIndex(i2);
        if (drawableParentForIndex.getDrawable() instanceof MatrixDrawable) {
            drawableParentForIndex = (MatrixDrawable) drawableParentForIndex.getDrawable();
        }
        if (drawableParentForIndex.getDrawable() instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawableParentForIndex.getDrawable();
        }
        return drawableParentForIndex;
    }

    private ScaleTypeDrawable getScaleTypeDrawableAtIndex(int i2) {
        DrawableParent parentDrawableAtIndex = getParentDrawableAtIndex(i2);
        if (parentDrawableAtIndex instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) parentDrawableAtIndex;
        }
        return WrappingUtils.wrapChildWithScaleType(parentDrawableAtIndex, ScalingUtils.ScaleType.FIT_XY);
    }

    private boolean hasScaleTypeDrawableAtIndex(int i2) {
        return getParentDrawableAtIndex(i2) instanceof ScaleTypeDrawable;
    }

    private void resetActualImages() {
        this.mActualImageWrapper.setDrawable(this.mEmptyActualImageDrawable);
    }

    private void resetFade() {
        FadeDrawable fadeDrawable = this.mFadeDrawable;
        if (fadeDrawable != null) {
            fadeDrawable.beginBatchMode();
            this.mFadeDrawable.fadeInAllLayers();
            fadeOutBranches();
            fadeInLayer(1);
            this.mFadeDrawable.finishTransitionImmediately();
            this.mFadeDrawable.endBatchMode();
        }
    }

    private void setChildDrawableAtIndex(int i2, Drawable drawable) {
        if (drawable == null) {
            this.mFadeDrawable.setDrawable(i2, (Drawable) null);
            return;
        }
        getParentDrawableAtIndex(i2).setDrawable(WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources));
    }

    private void setProgress(float f2) {
        Drawable drawable = this.mFadeDrawable.getDrawable(3);
        if (drawable != null) {
            if (f2 >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                fadeOutLayer(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                fadeInLayer(3);
            }
            drawable.setLevel(Math.round(f2 * 10000.0f));
        }
    }

    public void getActualImageBounds(RectF rectF) {
        this.mActualImageWrapper.getTransformedBounds(rectF);
    }

    public PointF getActualImageFocusPoint() {
        if (!hasScaleTypeDrawableAtIndex(2)) {
            return null;
        }
        return getScaleTypeDrawableAtIndex(2).getFocusPoint();
    }

    public ScalingUtils.ScaleType getActualImageScaleType() {
        if (!hasScaleTypeDrawableAtIndex(2)) {
            return null;
        }
        return getScaleTypeDrawableAtIndex(2).getScaleType();
    }

    public Rect getBounds() {
        return this.mTopLevelDrawable.getBounds();
    }

    public int getFadeDuration() {
        return this.mFadeDrawable.getTransitionDuration();
    }

    public RoundingParams getRoundingParams() {
        return this.mRoundingParams;
    }

    public Drawable getTopLevelDrawable() {
        return this.mTopLevelDrawable;
    }

    public boolean hasImage() {
        return this.mActualImageWrapper.getDrawable() != this.mEmptyActualImageDrawable;
    }

    public boolean hasPlaceholderImage() {
        return this.mFadeDrawable.getDrawable(1) != null;
    }

    public void reset() {
        resetActualImages();
        resetFade();
    }

    public void setActualImageColorFilter(ColorFilter colorFilter) {
        this.mActualImageWrapper.setColorFilter(colorFilter);
    }

    public void setActualImageFocusPoint(PointF pointF) {
        Preconditions.checkNotNull(pointF);
        getScaleTypeDrawableAtIndex(2).setFocusPoint(pointF);
    }

    public void setActualImageScaleType(ScalingUtils.ScaleType scaleType) {
        Preconditions.checkNotNull(scaleType);
        getScaleTypeDrawableAtIndex(2).setScaleType(scaleType);
    }

    public void setBackgroundImage(Drawable drawable) {
        setChildDrawableAtIndex(0, drawable);
    }

    public void setControllerOverlay(Drawable drawable) {
        this.mTopLevelDrawable.setControllerOverlay(drawable);
    }

    public void setFadeDuration(int i2) {
        this.mFadeDrawable.setTransitionDuration(i2);
    }

    public void setFailure(Throwable th) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(5) != null) {
            fadeInLayer(5);
        } else {
            fadeInLayer(1);
        }
        this.mFadeDrawable.endBatchMode();
    }

    public void setFailureImage(Drawable drawable) {
        setChildDrawableAtIndex(5, drawable);
    }

    public void setImage(Drawable drawable, float f2, boolean z2) {
        Drawable maybeApplyLeafRounding = WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources);
        maybeApplyLeafRounding.mutate();
        this.mActualImageWrapper.setDrawable(maybeApplyLeafRounding);
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        fadeInLayer(2);
        setProgress(f2);
        if (z2) {
            this.mFadeDrawable.finishTransitionImmediately();
        }
        this.mFadeDrawable.endBatchMode();
    }

    public void setOnFadeListener(FadeDrawable.OnFadeListener onFadeListener) {
        this.mFadeDrawable.setOnFadeListener(onFadeListener);
    }

    public void setOverlayImage(int i2, Drawable drawable) {
        Preconditions.checkArgument(i2 >= 0 && i2 + 6 < this.mFadeDrawable.getNumberOfLayers(), "The given index does not correspond to an overlay image.");
        setChildDrawableAtIndex(i2 + 6, drawable);
    }

    public void setPlaceholderImage(Drawable drawable) {
        setChildDrawableAtIndex(1, drawable);
    }

    public void setPlaceholderImageFocusPoint(PointF pointF) {
        Preconditions.checkNotNull(pointF);
        getScaleTypeDrawableAtIndex(1).setFocusPoint(pointF);
    }

    public void setProgressBarImage(Drawable drawable) {
        setChildDrawableAtIndex(3, drawable);
    }

    public void setRetry(Throwable th) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(4) != null) {
            fadeInLayer(4);
        } else {
            fadeInLayer(1);
        }
        this.mFadeDrawable.endBatchMode();
    }

    public void setRetryImage(Drawable drawable) {
        setChildDrawableAtIndex(4, drawable);
    }

    public void setRoundingParams(RoundingParams roundingParams) {
        this.mRoundingParams = roundingParams;
        WrappingUtils.updateOverlayColorRounding(this.mTopLevelDrawable, roundingParams);
        for (int i2 = 0; i2 < this.mFadeDrawable.getNumberOfLayers(); i2++) {
            WrappingUtils.updateLeafRounding(getParentDrawableAtIndex(i2), this.mRoundingParams, this.mResources);
        }
    }

    public void setFailureImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        setChildDrawableAtIndex(5, drawable);
        getScaleTypeDrawableAtIndex(5).setScaleType(scaleType);
    }

    public void setPlaceholderImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        setChildDrawableAtIndex(1, drawable);
        getScaleTypeDrawableAtIndex(1).setScaleType(scaleType);
    }

    public void setProgressBarImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        setChildDrawableAtIndex(3, drawable);
        getScaleTypeDrawableAtIndex(3).setScaleType(scaleType);
    }

    public void setRetryImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        setChildDrawableAtIndex(4, drawable);
        getScaleTypeDrawableAtIndex(4).setScaleType(scaleType);
    }

    public void setFailureImage(int i2) {
        setFailureImage(this.mResources.getDrawable(i2));
    }

    public void setPlaceholderImage(int i2) {
        setPlaceholderImage(this.mResources.getDrawable(i2));
    }

    public void setProgressBarImage(int i2) {
        setProgressBarImage(this.mResources.getDrawable(i2));
    }

    public void setRetryImage(int i2) {
        setRetryImage(this.mResources.getDrawable(i2));
    }

    public void setFailureImage(int i2, ScalingUtils.ScaleType scaleType) {
        setFailureImage(this.mResources.getDrawable(i2), scaleType);
    }

    public void setOverlayImage(Drawable drawable) {
        setOverlayImage(0, drawable);
    }

    public void setPlaceholderImage(int i2, ScalingUtils.ScaleType scaleType) {
        setPlaceholderImage(this.mResources.getDrawable(i2), scaleType);
    }

    public void setProgressBarImage(int i2, ScalingUtils.ScaleType scaleType) {
        setProgressBarImage(this.mResources.getDrawable(i2), scaleType);
    }

    public void setRetryImage(int i2, ScalingUtils.ScaleType scaleType) {
        setRetryImage(this.mResources.getDrawable(i2), scaleType);
    }

    public void setProgress(float f2, boolean z2) {
        if (this.mFadeDrawable.getDrawable(3) != null) {
            this.mFadeDrawable.beginBatchMode();
            setProgress(f2);
            if (z2) {
                this.mFadeDrawable.finishTransitionImmediately();
            }
            this.mFadeDrawable.endBatchMode();
        }
    }
}
