package com.github.rubensousa.previewseekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.github.rubensousa.previewseekbar.animator.PreviewAnimator;

public class PreviewSeekBar extends AppCompatSeekBar implements PreviewBar {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public PreviewDelegate f22202b;

    /* renamed from: c  reason: collision with root package name */
    private int f22203c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f22204d = 0;

    public PreviewSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f22202b = new PreviewDelegate(this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.f22206a, 0, 0);
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(new int[]{R$attr.f109t});
        int color = obtainStyledAttributes2.getColor(0, 0);
        obtainStyledAttributes2.recycle();
        this.f22203c = obtainStyledAttributes.getResourceId(R$styleable.f22210e, -1);
        int color2 = obtainStyledAttributes.getColor(R$styleable.f22211f, color);
        this.f22204d = color2;
        setPreviewThumbTint(color2);
        this.f22202b.j(obtainStyledAttributes.getBoolean(R$styleable.f22207b, true));
        this.f22202b.m(obtainStyledAttributes.getBoolean(R$styleable.f22209d, true));
        this.f22202b.l(obtainStyledAttributes.getBoolean(R$styleable.f22208c, true));
        obtainStyledAttributes.recycle();
        super.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
                PreviewSeekBar.this.f22202b.g(i2, z2);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                PreviewSeekBar.this.f22202b.h();
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                PreviewSeekBar.this.f22202b.i();
            }
        });
    }

    public int getScrubberColor() {
        return this.f22204d;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        FrameLayout b2;
        super.onLayout(z2, i2, i3, i4, i5);
        if (!this.f22202b.d() && !isInEditMode() && (b2 = PreviewDelegate.b((ViewGroup) getParent(), this.f22203c)) != null) {
            this.f22202b.a(b2);
        }
    }

    public void setAutoHidePreview(boolean z2) {
        this.f22202b.l(z2);
    }

    public synchronized void setMax(int i2) {
        super.setMax(i2);
        PreviewDelegate previewDelegate = this.f22202b;
        if (previewDelegate != null) {
            previewDelegate.q(getProgress(), getMax());
        }
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
    }

    public void setPreviewAnimationEnabled(boolean z2) {
        this.f22202b.j(z2);
    }

    public void setPreviewAnimator(PreviewAnimator previewAnimator) {
        this.f22202b.k(previewAnimator);
    }

    public void setPreviewEnabled(boolean z2) {
        this.f22202b.m(z2);
    }

    public void setPreviewLoader(PreviewLoader previewLoader) {
        this.f22202b.n(previewLoader);
    }

    public void setPreviewThumbTint(int i2) {
        Drawable r2 = DrawableCompat.r(getThumb());
        DrawableCompat.n(r2, i2);
        setThumb(r2);
        this.f22204d = i2;
    }

    public void setPreviewThumbTintResource(int i2) {
        setPreviewThumbTint(ContextCompat.getColor(getContext(), i2));
    }

    public synchronized void setProgress(int i2) {
        super.setProgress(i2);
        PreviewDelegate previewDelegate = this.f22202b;
        if (previewDelegate != null) {
            previewDelegate.q(i2, getMax());
        }
    }

    public void setProgressTint(int i2) {
        Drawable r2 = DrawableCompat.r(getProgressDrawable());
        DrawableCompat.n(r2, i2);
        setProgressDrawable(r2);
    }

    public void setProgressTintResource(int i2) {
        setProgressTint(ContextCompat.getColor(getContext(), i2));
    }
}
