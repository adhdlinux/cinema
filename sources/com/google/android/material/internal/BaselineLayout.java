package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private int f29811b = -1;

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public int getBaseline() {
        return this.f29811b;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i4 - i2) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                if (this.f29811b == -1 || childAt.getBaseline() == -1) {
                    i6 = paddingTop;
                } else {
                    i6 = (this.f29811b + paddingTop) - childAt.getBaseline();
                }
                childAt.layout(i8, i6, measuredWidth + i8, measuredHeight + i6);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, i3);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    i7 = Math.max(i7, baseline);
                    i8 = Math.max(i8, childAt.getMeasuredHeight() - baseline);
                }
                i5 = Math.max(i5, childAt.getMeasuredWidth());
                i4 = Math.max(i4, childAt.getMeasuredHeight());
                i6 = View.combineMeasuredStates(i6, childAt.getMeasuredState());
            }
        }
        if (i7 != -1) {
            i4 = Math.max(i4, Math.max(i8, getPaddingBottom()) + i7);
            this.f29811b = i7;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i5, getSuggestedMinimumWidth()), i2, i6), View.resolveSizeAndState(Math.max(i4, getSuggestedMinimumHeight()), i3, i6 << 16));
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
