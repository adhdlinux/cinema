package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;
import java.util.List;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class GenericDraweeHierarchyBuilder {
    public static final ScalingUtils.ScaleType DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_CROP;
    public static final int DEFAULT_FADE_DURATION = 300;
    public static final ScalingUtils.ScaleType DEFAULT_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_INSIDE;
    private ColorFilter mActualImageColorFilter;
    private PointF mActualImageFocusPoint;
    private Matrix mActualImageMatrix;
    private ScalingUtils.ScaleType mActualImageScaleType;
    private Drawable mBackground;
    private float mDesiredAspectRatio;
    private int mFadeDuration;
    private Drawable mFailureImage;
    private ScalingUtils.ScaleType mFailureImageScaleType;
    private List<Drawable> mOverlays;
    private Drawable mPlaceholderImage;
    private ScalingUtils.ScaleType mPlaceholderImageScaleType;
    private Drawable mPressedStateOverlay;
    private Drawable mProgressBarImage;
    private ScalingUtils.ScaleType mProgressBarImageScaleType;
    private Resources mResources;
    private Drawable mRetryImage;
    private ScalingUtils.ScaleType mRetryImageScaleType;
    private RoundingParams mRoundingParams;

    public GenericDraweeHierarchyBuilder(Resources resources) {
        this.mResources = resources;
        init();
    }

    private void init() {
        this.mFadeDuration = 300;
        this.mDesiredAspectRatio = 0.0f;
        this.mPlaceholderImage = null;
        ScalingUtils.ScaleType scaleType = DEFAULT_SCALE_TYPE;
        this.mPlaceholderImageScaleType = scaleType;
        this.mRetryImage = null;
        this.mRetryImageScaleType = scaleType;
        this.mFailureImage = null;
        this.mFailureImageScaleType = scaleType;
        this.mProgressBarImage = null;
        this.mProgressBarImageScaleType = scaleType;
        this.mActualImageScaleType = DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
        this.mActualImageMatrix = null;
        this.mActualImageFocusPoint = null;
        this.mActualImageColorFilter = null;
        this.mBackground = null;
        this.mOverlays = null;
        this.mPressedStateOverlay = null;
        this.mRoundingParams = null;
    }

    public static GenericDraweeHierarchyBuilder newInstance(Resources resources) {
        return new GenericDraweeHierarchyBuilder(resources);
    }

    private void validate() {
        List<Drawable> list = this.mOverlays;
        if (list != null) {
            for (Drawable checkNotNull : list) {
                Preconditions.checkNotNull(checkNotNull);
            }
        }
    }

    public GenericDraweeHierarchy build() {
        validate();
        return new GenericDraweeHierarchy(this);
    }

    public ColorFilter getActualImageColorFilter() {
        return this.mActualImageColorFilter;
    }

    public PointF getActualImageFocusPoint() {
        return this.mActualImageFocusPoint;
    }

    public ScalingUtils.ScaleType getActualImageScaleType() {
        return this.mActualImageScaleType;
    }

    public Drawable getBackground() {
        return this.mBackground;
    }

    public float getDesiredAspectRatio() {
        return this.mDesiredAspectRatio;
    }

    public int getFadeDuration() {
        return this.mFadeDuration;
    }

    public Drawable getFailureImage() {
        return this.mFailureImage;
    }

    public ScalingUtils.ScaleType getFailureImageScaleType() {
        return this.mFailureImageScaleType;
    }

    public List<Drawable> getOverlays() {
        return this.mOverlays;
    }

    public Drawable getPlaceholderImage() {
        return this.mPlaceholderImage;
    }

    public ScalingUtils.ScaleType getPlaceholderImageScaleType() {
        return this.mPlaceholderImageScaleType;
    }

    public Drawable getPressedStateOverlay() {
        return this.mPressedStateOverlay;
    }

    public Drawable getProgressBarImage() {
        return this.mProgressBarImage;
    }

    public ScalingUtils.ScaleType getProgressBarImageScaleType() {
        return this.mProgressBarImageScaleType;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public Drawable getRetryImage() {
        return this.mRetryImage;
    }

    public ScalingUtils.ScaleType getRetryImageScaleType() {
        return this.mRetryImageScaleType;
    }

    public RoundingParams getRoundingParams() {
        return this.mRoundingParams;
    }

    public GenericDraweeHierarchyBuilder reset() {
        init();
        return this;
    }

    public GenericDraweeHierarchyBuilder setActualImageColorFilter(ColorFilter colorFilter) {
        this.mActualImageColorFilter = colorFilter;
        return this;
    }

    public GenericDraweeHierarchyBuilder setActualImageFocusPoint(PointF pointF) {
        this.mActualImageFocusPoint = pointF;
        return this;
    }

    public GenericDraweeHierarchyBuilder setActualImageScaleType(ScalingUtils.ScaleType scaleType) {
        this.mActualImageScaleType = scaleType;
        this.mActualImageMatrix = null;
        return this;
    }

    public GenericDraweeHierarchyBuilder setBackground(Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setDesiredAspectRatio(float f2) {
        this.mDesiredAspectRatio = f2;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFadeDuration(int i2) {
        this.mFadeDuration = i2;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(Drawable drawable) {
        this.mFailureImage = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImageScaleType(ScalingUtils.ScaleType scaleType) {
        this.mFailureImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setOverlay(Drawable drawable) {
        if (drawable == null) {
            this.mOverlays = null;
        } else {
            this.mOverlays = Arrays.asList(new Drawable[]{drawable});
        }
        return this;
    }

    public GenericDraweeHierarchyBuilder setOverlays(List<Drawable> list) {
        this.mOverlays = list;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(Drawable drawable) {
        this.mPlaceholderImage = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImageScaleType(ScalingUtils.ScaleType scaleType) {
        this.mPlaceholderImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPressedStateOverlay(Drawable drawable) {
        if (drawable == null) {
            this.mPressedStateOverlay = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.mPressedStateOverlay = stateListDrawable;
        }
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(Drawable drawable) {
        this.mProgressBarImage = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImageScaleType(ScalingUtils.ScaleType scaleType) {
        this.mProgressBarImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(Drawable drawable) {
        this.mRetryImage = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImageScaleType(ScalingUtils.ScaleType scaleType) {
        this.mRetryImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRoundingParams(RoundingParams roundingParams) {
        this.mRoundingParams = roundingParams;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(int i2) {
        this.mFailureImage = this.mResources.getDrawable(i2);
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(int i2) {
        this.mPlaceholderImage = this.mResources.getDrawable(i2);
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(int i2) {
        this.mProgressBarImage = this.mResources.getDrawable(i2);
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(int i2) {
        this.mRetryImage = this.mResources.getDrawable(i2);
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        this.mFailureImage = drawable;
        this.mFailureImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        this.mPlaceholderImage = drawable;
        this.mPlaceholderImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        this.mProgressBarImage = drawable;
        this.mProgressBarImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        this.mRetryImage = drawable;
        this.mRetryImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(int i2, ScalingUtils.ScaleType scaleType) {
        this.mFailureImage = this.mResources.getDrawable(i2);
        this.mFailureImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(int i2, ScalingUtils.ScaleType scaleType) {
        this.mPlaceholderImage = this.mResources.getDrawable(i2);
        this.mPlaceholderImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(int i2, ScalingUtils.ScaleType scaleType) {
        this.mProgressBarImage = this.mResources.getDrawable(i2);
        this.mProgressBarImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(int i2, ScalingUtils.ScaleType scaleType) {
        this.mRetryImage = this.mResources.getDrawable(i2);
        this.mRetryImageScaleType = scaleType;
        return this;
    }
}
