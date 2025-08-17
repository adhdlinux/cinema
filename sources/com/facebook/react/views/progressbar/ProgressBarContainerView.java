package com.facebook.react.views.progressbar;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;

class ProgressBarContainerView extends FrameLayout {
    private static final int MAX_PROGRESS = 1000;
    private boolean mAnimating = true;
    private Integer mColor;
    private boolean mIndeterminate = true;
    private double mProgress;
    private ProgressBar mProgressBar;

    public ProgressBarContainerView(Context context) {
        super(context);
    }

    public void apply() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(this.mIndeterminate);
            setColor(this.mProgressBar);
            this.mProgressBar.setProgress((int) (this.mProgress * 1000.0d));
            if (this.mAnimating) {
                this.mProgressBar.setVisibility(0);
            } else {
                this.mProgressBar.setVisibility(4);
            }
        } else {
            throw new JSApplicationIllegalArgumentException("setStyle() not called");
        }
    }

    public void setAnimating(boolean z2) {
        this.mAnimating = z2;
    }

    public void setColor(Integer num) {
        this.mColor = num;
    }

    public void setIndeterminate(boolean z2) {
        this.mIndeterminate = z2;
    }

    public void setProgress(double d2) {
        this.mProgress = d2;
    }

    public void setStyle(String str) {
        ProgressBar createProgressBar = ReactProgressBarViewManager.createProgressBar(getContext(), ReactProgressBarViewManager.getStyleFromString(str));
        this.mProgressBar = createProgressBar;
        createProgressBar.setMax(1000);
        removeAllViews();
        addView(this.mProgressBar, new ViewGroup.LayoutParams(-1, -1));
    }

    private void setColor(ProgressBar progressBar) {
        Drawable drawable;
        if (progressBar.isIndeterminate()) {
            drawable = progressBar.getIndeterminateDrawable();
        } else {
            drawable = progressBar.getProgressDrawable();
        }
        if (drawable != null) {
            Integer num = this.mColor;
            if (num != null) {
                drawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
            } else {
                drawable.clearColorFilter();
            }
        }
    }
}
