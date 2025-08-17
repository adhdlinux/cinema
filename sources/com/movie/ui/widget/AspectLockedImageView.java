package com.movie.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.yoku.marumovie.R$styleable;

public final class AspectLockedImageView extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    private float f33646b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private AspectRatioSource f33647c = null;

    public interface AspectRatioSource {
        int getHeight();

        int getWidth();
    }

    private static class ViewAspectRatioSource implements AspectRatioSource {

        /* renamed from: a  reason: collision with root package name */
        private View f33648a;

        ViewAspectRatioSource(View view) {
            this.f33648a = view;
        }

        public int getHeight() {
            return this.f33648a.getHeight();
        }

        public int getWidth() {
            return this.f33648a.getWidth();
        }
    }

    public AspectLockedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f38105x);
        this.f33646b = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AspectRatioSource aspectRatioSource;
        float f2 = this.f33646b;
        if (((double) f2) == 0.0d && (aspectRatioSource = this.f33647c) != null && aspectRatioSource.getHeight() > 0) {
            f2 = ((float) this.f33647c.getWidth()) / ((float) this.f33647c.getHeight());
        }
        if (((double) f2) == 0.0d) {
            super.onMeasure(i2, i3);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (size == 0 && size2 == 0) {
            super.onMeasure(0, 0);
            return;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i4 = size - paddingLeft;
        int i5 = size2 - paddingTop;
        if (i5 > 0) {
            float f3 = ((float) i5) * f2;
            if (((float) i4) > f3) {
                i4 = (int) (((double) f3) + 0.5d);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4 + paddingLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(i5 + paddingTop, 1073741824));
            }
        }
        i5 = (int) (((double) (((float) i4) / f2)) + 0.5d);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4 + paddingLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(i5 + paddingTop, 1073741824));
    }

    public void setAspectRatio(float f2) {
        if (((double) f2) <= 0.0d) {
            throw new IllegalArgumentException("aspect ratio must be positive");
        } else if (this.f33646b != f2) {
            this.f33646b = f2;
            requestLayout();
        }
    }

    public void setAspectRatioSource(View view) {
        this.f33647c = new ViewAspectRatioSource(view);
    }

    public void setAspectRatioSource(AspectRatioSource aspectRatioSource) {
        this.f33647c = aspectRatioSource;
    }
}
