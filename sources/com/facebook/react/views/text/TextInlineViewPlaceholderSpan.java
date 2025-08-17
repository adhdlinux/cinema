package com.facebook.react.views.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

public class TextInlineViewPlaceholderSpan extends ReplacementSpan implements ReactSpan {
    private int mHeight;
    private int mReactTag;
    private int mWidth;

    public TextInlineViewPlaceholderSpan(int i2, int i3, int i4) {
        this.mReactTag = i2;
        this.mWidth = i3;
        this.mHeight = i4;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getReactTag() {
        return this.mReactTag;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            int i4 = -this.mHeight;
            fontMetricsInt.ascent = i4;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i4;
            fontMetricsInt.bottom = 0;
        }
        return this.mWidth;
    }

    public int getWidth() {
        return this.mWidth;
    }
}
