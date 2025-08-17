package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import java.util.Map;

abstract class AbstractLayoutAnimation {
    private static final Map<InterpolatorType, BaseInterpolator> INTERPOLATOR = MapBuilder.of(InterpolatorType.LINEAR, new LinearInterpolator(), InterpolatorType.EASE_IN, new AccelerateInterpolator(), InterpolatorType.EASE_OUT, new DecelerateInterpolator(), InterpolatorType.EASE_IN_EASE_OUT, new AccelerateDecelerateInterpolator());
    private static final boolean SLOWDOWN_ANIMATION_MODE = false;
    protected AnimatedPropertyType mAnimatedProperty;
    private int mDelayMs;
    protected int mDurationMs;
    private Interpolator mInterpolator;

    AbstractLayoutAnimation() {
    }

    private static Interpolator getInterpolator(InterpolatorType interpolatorType, ReadableMap readableMap) {
        Interpolator interpolator;
        if (interpolatorType.equals(InterpolatorType.SPRING)) {
            interpolator = new SimpleSpringInterpolator(SimpleSpringInterpolator.getSpringDamping(readableMap));
        } else {
            interpolator = INTERPOLATOR.get(interpolatorType);
        }
        if (interpolator != null) {
            return interpolator;
        }
        throw new IllegalArgumentException("Missing interpolator for type : " + interpolatorType);
    }

    public final Animation createAnimation(View view, int i2, int i3, int i4, int i5) {
        if (!isValid()) {
            return null;
        }
        Animation createAnimationImpl = createAnimationImpl(view, i2, i3, i4, i5);
        if (createAnimationImpl != null) {
            createAnimationImpl.setDuration((long) (this.mDurationMs * 1));
            createAnimationImpl.setStartOffset((long) (this.mDelayMs * 1));
            createAnimationImpl.setInterpolator(this.mInterpolator);
        }
        return createAnimationImpl;
    }

    /* access modifiers changed from: package-private */
    public abstract Animation createAnimationImpl(View view, int i2, int i3, int i4, int i5);

    public void initializeFromConfig(ReadableMap readableMap, int i2) {
        AnimatedPropertyType animatedPropertyType;
        int i3;
        if (readableMap.hasKey("property")) {
            animatedPropertyType = AnimatedPropertyType.fromString(readableMap.getString("property"));
        } else {
            animatedPropertyType = null;
        }
        this.mAnimatedProperty = animatedPropertyType;
        if (readableMap.hasKey("duration")) {
            i2 = readableMap.getInt("duration");
        }
        this.mDurationMs = i2;
        if (readableMap.hasKey("delay")) {
            i3 = readableMap.getInt("delay");
        } else {
            i3 = 0;
        }
        this.mDelayMs = i3;
        if (readableMap.hasKey("type")) {
            this.mInterpolator = getInterpolator(InterpolatorType.fromString(readableMap.getString("type")), readableMap);
            if (!isValid()) {
                throw new IllegalViewOperationException("Invalid layout animation : " + readableMap);
            }
            return;
        }
        throw new IllegalArgumentException("Missing interpolation type.");
    }

    /* access modifiers changed from: package-private */
    public abstract boolean isValid();

    public void reset() {
        this.mAnimatedProperty = null;
        this.mDurationMs = 0;
        this.mDelayMs = 0;
        this.mInterpolator = null;
    }
}
