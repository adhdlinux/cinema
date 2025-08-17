package com.github.rubensousa.previewseekbar.media3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.R$styleable;
import androidx.media3.ui.TimeBar;
import com.github.rubensousa.previewseekbar.PreviewBar;
import com.github.rubensousa.previewseekbar.PreviewDelegate;
import com.github.rubensousa.previewseekbar.PreviewLoader;
import com.github.rubensousa.previewseekbar.animator.PreviewAnimator;

public class PreviewTimeBar extends DefaultTimeBar implements PreviewBar {
    /* access modifiers changed from: private */
    public PreviewDelegate Q;
    /* access modifiers changed from: private */
    public int R;
    private int S;
    private int T;
    private int U;
    private int V;

    private class TimeBarDefaultOnScrubListener implements TimeBar.OnScrubListener {
        private TimeBarDefaultOnScrubListener() {
        }

        public void p(TimeBar timeBar, long j2) {
            int unused = PreviewTimeBar.this.R = (int) j2;
            PreviewTimeBar.this.Q.h();
        }

        public void u(TimeBar timeBar, long j2) {
            int i2 = (int) j2;
            int unused = PreviewTimeBar.this.R = i2;
            PreviewTimeBar.this.Q.g(i2, true);
        }

        public void v(TimeBar timeBar, long j2, boolean z2) {
            int unused = PreviewTimeBar.this.R = (int) j2;
            PreviewTimeBar.this.Q.i();
        }
    }

    public PreviewTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.f10063e, 0, 0);
        this.T = obtainStyledAttributes.getInt(R$styleable.f10079m, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.f10085p);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10087q, C(context.getResources().getDisplayMetrics(), 12));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10081n, C(context.getResources().getDisplayMetrics(), 0));
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10083o, C(context.getResources().getDisplayMetrics(), 16));
        if (drawable != null) {
            this.V = (drawable.getMinimumWidth() + 1) / 2;
        } else {
            this.V = (Math.max(dimensionPixelSize2, Math.max(dimensionPixelSize, dimensionPixelSize3)) + 1) / 2;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.f22240a, 0, 0);
        this.U = obtainStyledAttributes2.getResourceId(R$styleable.f22244e, -1);
        PreviewDelegate previewDelegate = new PreviewDelegate(this);
        this.Q = previewDelegate;
        previewDelegate.m(isEnabled());
        this.Q.j(obtainStyledAttributes2.getBoolean(R$styleable.f22241b, true));
        this.Q.m(obtainStyledAttributes2.getBoolean(R$styleable.f22243d, true));
        this.Q.l(obtainStyledAttributes2.getBoolean(R$styleable.f22242c, true));
        obtainStyledAttributes2.recycle();
        b(new TimeBarDefaultOnScrubListener());
    }

    private int C(DisplayMetrics displayMetrics, int i2) {
        return (int) ((((float) i2) * displayMetrics.density) + 0.5f);
    }

    public int getMax() {
        return this.S;
    }

    public int getProgress() {
        return this.R;
    }

    public int getScrubberColor() {
        return this.T;
    }

    public int getThumbOffset() {
        return this.V;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        FrameLayout b2;
        super.onLayout(z2, i2, i3, i4, i5);
        if (!this.Q.d() && !isInEditMode() && (b2 = PreviewDelegate.b((ViewGroup) getParent(), this.U)) != null) {
            this.Q.a(b2);
        }
    }

    public void setAutoHidePreview(boolean z2) {
        this.Q.l(z2);
    }

    public void setDuration(long j2) {
        super.setDuration(j2);
        int i2 = (int) j2;
        if (i2 != this.S) {
            this.S = i2;
            this.Q.q(getProgress(), i2);
        }
    }

    public void setPosition(long j2) {
        super.setPosition(j2);
        int i2 = (int) j2;
        if (i2 != this.R) {
            this.R = i2;
            this.Q.q(i2, this.S);
        }
    }

    public void setPreviewAnimationEnabled(boolean z2) {
        this.Q.j(z2);
    }

    public void setPreviewAnimator(PreviewAnimator previewAnimator) {
        this.Q.k(previewAnimator);
    }

    public void setPreviewEnabled(boolean z2) {
        this.Q.m(z2);
    }

    public void setPreviewLoader(PreviewLoader previewLoader) {
        this.Q.n(previewLoader);
    }

    public void setPreviewThumbTint(int i2) {
        setScrubberColor(i2);
        this.T = i2;
    }

    public void setPreviewThumbTintResource(int i2) {
        setPreviewThumbTint(ContextCompat.getColor(getContext(), i2));
    }

    public void setScrubberColor(int i2) {
        super.setScrubberColor(i2);
        this.T = i2;
    }
}
