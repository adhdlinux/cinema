package com.facebook.react.views.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import androidx.core.view.ViewCompat;

public class ReactViewBackgroundManager {
    private int mColor = 0;
    private ReactViewBackgroundDrawable mReactBackgroundDrawable;
    private View mView;

    public ReactViewBackgroundManager(View view) {
        this.mView = view;
    }

    private ReactViewBackgroundDrawable getOrCreateReactViewBackground() {
        if (this.mReactBackgroundDrawable == null) {
            this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable(this.mView.getContext());
            Drawable background = this.mView.getBackground();
            ViewCompat.v0(this.mView, (Drawable) null);
            if (background == null) {
                ViewCompat.v0(this.mView, this.mReactBackgroundDrawable);
            } else {
                ViewCompat.v0(this.mView, new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, background}));
            }
        }
        return this.mReactBackgroundDrawable;
    }

    public int getBackgroundColor() {
        return this.mColor;
    }

    public int getBorderColor(int i2) {
        return getOrCreateReactViewBackground().getBorderColor(i2);
    }

    public void setBackgroundColor(int i2) {
        if (i2 != 0 || this.mReactBackgroundDrawable != null) {
            getOrCreateReactViewBackground().setColor(i2);
        }
    }

    public void setBorderColor(int i2, float f2, float f3) {
        getOrCreateReactViewBackground().setBorderColor(i2, f2, f3);
    }

    public void setBorderRadius(float f2) {
        getOrCreateReactViewBackground().setRadius(f2);
    }

    public void setBorderStyle(String str) {
        getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public void setBorderWidth(int i2, float f2) {
        getOrCreateReactViewBackground().setBorderWidth(i2, f2);
    }

    public void setBorderRadius(float f2, int i2) {
        getOrCreateReactViewBackground().setRadius(f2, i2);
    }
}
