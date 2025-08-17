package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;

public class FlowLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private int f29859b;

    /* renamed from: c  reason: collision with root package name */
    private int f29860c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29861d = false;

    public FlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context, attributeSet);
    }

    private static int a(int i2, int i3, int i4) {
        return i3 != Integer.MIN_VALUE ? i3 != 1073741824 ? i4 : i2 : Math.min(i4, i2);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.B1, 0, 0);
        this.f29859b = obtainStyledAttributes.getDimensionPixelSize(R$styleable.D1, 0);
        this.f29860c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.C1, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return this.f29861d;
    }

    /* access modifiers changed from: protected */
    public int getItemSpacing() {
        return this.f29860c;
    }

    /* access modifiers changed from: protected */
    public int getLineSpacing() {
        return this.f29859b;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        if (getChildCount() != 0) {
            boolean z3 = true;
            if (ViewCompat.D(this) != 1) {
                z3 = false;
            }
            if (z3) {
                i6 = getPaddingRight();
            } else {
                i6 = getPaddingLeft();
            }
            if (z3) {
                i7 = getPaddingLeft();
            } else {
                i7 = getPaddingRight();
            }
            int paddingTop = getPaddingTop();
            int i10 = (i4 - i2) - i7;
            int i11 = i6;
            int i12 = paddingTop;
            for (int i13 = 0; i13 < getChildCount(); i13++) {
                View childAt = getChildAt(i13);
                if (childAt.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i8 = MarginLayoutParamsCompat.b(marginLayoutParams);
                        i9 = MarginLayoutParamsCompat.a(marginLayoutParams);
                    } else {
                        i9 = 0;
                        i8 = 0;
                    }
                    int measuredWidth = i11 + i8 + childAt.getMeasuredWidth();
                    if (!this.f29861d && measuredWidth > i10) {
                        i12 = this.f29859b + paddingTop;
                        i11 = i6;
                    }
                    int i14 = i11 + i8;
                    int measuredWidth2 = childAt.getMeasuredWidth() + i14;
                    int measuredHeight = childAt.getMeasuredHeight() + i12;
                    if (z3) {
                        childAt.layout(i10 - measuredWidth2, i12, (i10 - i11) - i8, measuredHeight);
                    } else {
                        childAt.layout(i14, i12, measuredWidth2, measuredHeight);
                    }
                    i11 += i8 + i9 + childAt.getMeasuredWidth() + this.f29860c;
                    paddingTop = measuredHeight;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i4 = size;
        } else {
            i4 = Integer.MAX_VALUE;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i4 - getPaddingRight();
        int i8 = paddingTop;
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                int i11 = i2;
                int i12 = i3;
            } else {
                measureChild(childAt, i2, i3);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i6 = marginLayoutParams.leftMargin + 0;
                    i5 = marginLayoutParams.rightMargin + 0;
                } else {
                    i6 = 0;
                    i5 = 0;
                }
                int i13 = paddingLeft;
                if (paddingLeft + i6 + childAt.getMeasuredWidth() <= paddingRight || b()) {
                    i7 = i13;
                } else {
                    i7 = getPaddingLeft();
                    i8 = this.f29859b + paddingTop;
                }
                int measuredWidth = i7 + i6 + childAt.getMeasuredWidth();
                int measuredHeight = i8 + childAt.getMeasuredHeight();
                if (measuredWidth > i9) {
                    i9 = measuredWidth;
                }
                paddingLeft = i7 + i6 + i5 + childAt.getMeasuredWidth() + this.f29860c;
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i9), a(size2, mode2, paddingTop));
    }

    /* access modifiers changed from: protected */
    public void setItemSpacing(int i2) {
        this.f29860c = i2;
    }

    /* access modifiers changed from: protected */
    public void setLineSpacing(int i2) {
        this.f29859b = i2;
    }

    public void setSingleLine(boolean z2) {
        this.f29861d = z2;
    }
}
