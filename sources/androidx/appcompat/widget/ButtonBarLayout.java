package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

public class ButtonBarLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private boolean f1233b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1234c;

    /* renamed from: d  reason: collision with root package name */
    private int f1235d = -1;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] iArr = R$styleable.P0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.p0(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.f1233b = obtainStyledAttributes.getBoolean(R$styleable.Q0, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f1233b);
        }
    }

    private int a(int i2) {
        int childCount = getChildCount();
        while (i2 < childCount) {
            if (getChildAt(i2).getVisibility() == 0) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private boolean b() {
        return this.f1234c;
    }

    private void setStacked(boolean z2) {
        int i2;
        int i3;
        if (this.f1234c == z2) {
            return;
        }
        if (!z2 || this.f1233b) {
            this.f1234c = z2;
            setOrientation(z2 ? 1 : 0);
            if (z2) {
                i2 = 8388613;
            } else {
                i2 = 80;
            }
            setGravity(i2);
            View findViewById = findViewById(R$id.M);
            if (findViewById != null) {
                if (z2) {
                    i3 = 8;
                } else {
                    i3 = 4;
                }
                findViewById.setVisibility(i3);
            }
            for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                bringChildToFront(getChildAt(childCount));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z2;
        int i4;
        boolean z3;
        int size = View.MeasureSpec.getSize(i2);
        int i5 = 0;
        if (this.f1233b) {
            if (size > this.f1235d && b()) {
                setStacked(false);
            }
            this.f1235d = size;
        }
        if (b() || View.MeasureSpec.getMode(i2) != 1073741824) {
            i4 = i2;
            z2 = false;
        } else {
            i4 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z2 = true;
        }
        super.onMeasure(i4, i3);
        if (this.f1233b && !b()) {
            if ((getMeasuredWidthAndState() & -16777216) == 16777216) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                setStacked(true);
                z2 = true;
            }
        }
        if (z2) {
            super.onMeasure(i2, i3);
        }
        int a2 = a(0);
        if (a2 >= 0) {
            View childAt = getChildAt(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (b()) {
                int a3 = a(a2 + 1);
                if (a3 >= 0) {
                    paddingTop += getChildAt(a3).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i5 = paddingTop;
            } else {
                i5 = paddingTop + getPaddingBottom();
            }
        }
        if (ViewCompat.E(this) != i5) {
            setMinimumHeight(i5);
            if (i3 == 0) {
                super.onMeasure(i2, i3);
            }
        }
    }

    public void setAllowStacking(boolean z2) {
        if (this.f1233b != z2) {
            this.f1233b = z2;
            if (!z2 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
