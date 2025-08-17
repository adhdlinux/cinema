package com.facebook.react.views.text;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

public class CustomLineHeightSpan implements LineHeightSpan, ReactSpan {
    private final int mHeight;

    public CustomLineHeightSpan(float f2) {
        this.mHeight = (int) Math.ceil((double) f2);
    }

    public void chooseHeight(CharSequence charSequence, int i2, int i3, int i4, int i5, Paint.FontMetricsInt fontMetricsInt) {
        int i6 = fontMetricsInt.descent;
        int i7 = this.mHeight;
        if (i6 > i7) {
            int min = Math.min(i7, i6);
            fontMetricsInt.descent = min;
            fontMetricsInt.bottom = min;
            fontMetricsInt.ascent = 0;
            fontMetricsInt.top = 0;
            return;
        }
        int i8 = fontMetricsInt.ascent;
        if ((-i8) + i6 > i7) {
            fontMetricsInt.bottom = i6;
            int i9 = (-i7) + i6;
            fontMetricsInt.ascent = i9;
            fontMetricsInt.top = i9;
            return;
        }
        int i10 = fontMetricsInt.bottom;
        if ((-i8) + i10 > i7) {
            fontMetricsInt.top = i8;
            fontMetricsInt.bottom = i8 + i7;
            return;
        }
        int i11 = fontMetricsInt.top;
        if ((-i11) + i10 > i7) {
            fontMetricsInt.top = i10 - i7;
            return;
        }
        double d2 = (double) i11;
        double d3 = (double) (((float) (i7 - ((-i11) + i10))) / 2.0f);
        fontMetricsInt.top = (int) (d2 - Math.ceil(d3));
        int floor = (int) (((double) fontMetricsInt.bottom) + Math.floor(d3));
        fontMetricsInt.bottom = floor;
        fontMetricsInt.ascent = fontMetricsInt.top;
        fontMetricsInt.descent = floor;
    }
}
