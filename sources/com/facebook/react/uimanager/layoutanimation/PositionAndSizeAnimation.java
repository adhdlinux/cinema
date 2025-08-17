package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class PositionAndSizeAnimation extends Animation implements LayoutHandlingAnimation {
    private int mDeltaHeight;
    private int mDeltaWidth;
    private float mDeltaX;
    private float mDeltaY;
    private int mStartHeight;
    private int mStartWidth;
    private float mStartX;
    private float mStartY;
    private final View mView;

    public PositionAndSizeAnimation(View view, int i2, int i3, int i4, int i5) {
        this.mView = view;
        calculateAnimation(i2, i3, i4, i5);
    }

    private void calculateAnimation(int i2, int i3, int i4, int i5) {
        this.mStartX = this.mView.getX() - this.mView.getTranslationX();
        this.mStartY = this.mView.getY() - this.mView.getTranslationY();
        this.mStartWidth = this.mView.getWidth();
        int height = this.mView.getHeight();
        this.mStartHeight = height;
        this.mDeltaX = ((float) i2) - this.mStartX;
        this.mDeltaY = ((float) i3) - this.mStartY;
        this.mDeltaWidth = i4 - this.mStartWidth;
        this.mDeltaHeight = i5 - height;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, Transformation transformation) {
        float f3 = this.mStartX + (this.mDeltaX * f2);
        float f4 = this.mStartY + (this.mDeltaY * f2);
        this.mView.layout(Math.round(f3), Math.round(f4), Math.round(f3 + ((float) this.mStartWidth) + (((float) this.mDeltaWidth) * f2)), Math.round(f4 + ((float) this.mStartHeight) + (((float) this.mDeltaHeight) * f2)));
    }

    public void onLayoutUpdate(int i2, int i3, int i4, int i5) {
        calculateAnimation(i2, i3, i4, i5);
    }

    public boolean willChangeBounds() {
        return true;
    }
}
