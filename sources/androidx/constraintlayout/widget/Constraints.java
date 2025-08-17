package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Constraints extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    ConstraintSet f2107b;

    public Constraints(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(attributeSet);
        super.setVisibility(8);
    }

    private void c(AttributeSet attributeSet) {
        Log.v("Constraints", " ################# init");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ConstraintSet getConstraintSet() {
        if (this.f2107b == null) {
            this.f2107b = new ConstraintSet();
        }
        this.f2107b.b(this);
        return this.f2107b;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {

        /* renamed from: n0  reason: collision with root package name */
        public float f2108n0;

        /* renamed from: o0  reason: collision with root package name */
        public boolean f2109o0;

        /* renamed from: p0  reason: collision with root package name */
        public float f2110p0;

        /* renamed from: q0  reason: collision with root package name */
        public float f2111q0;

        /* renamed from: r0  reason: collision with root package name */
        public float f2112r0;

        /* renamed from: s0  reason: collision with root package name */
        public float f2113s0;

        /* renamed from: t0  reason: collision with root package name */
        public float f2114t0;

        /* renamed from: u0  reason: collision with root package name */
        public float f2115u0;

        /* renamed from: v0  reason: collision with root package name */
        public float f2116v0;

        /* renamed from: w0  reason: collision with root package name */
        public float f2117w0;

        /* renamed from: x0  reason: collision with root package name */
        public float f2118x0;

        /* renamed from: y0  reason: collision with root package name */
        public float f2119y0;

        /* renamed from: z0  reason: collision with root package name */
        public float f2120z0;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f2108n0 = 1.0f;
            this.f2109o0 = false;
            this.f2110p0 = 0.0f;
            this.f2111q0 = 0.0f;
            this.f2112r0 = 0.0f;
            this.f2113s0 = 0.0f;
            this.f2114t0 = 1.0f;
            this.f2115u0 = 1.0f;
            this.f2116v0 = 0.0f;
            this.f2117w0 = 0.0f;
            this.f2118x0 = 0.0f;
            this.f2119y0 = 0.0f;
            this.f2120z0 = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2108n0 = 1.0f;
            this.f2109o0 = false;
            this.f2110p0 = 0.0f;
            this.f2111q0 = 0.0f;
            this.f2112r0 = 0.0f;
            this.f2113s0 = 0.0f;
            this.f2114t0 = 1.0f;
            this.f2115u0 = 1.0f;
            this.f2116v0 = 0.0f;
            this.f2117w0 = 0.0f;
            this.f2118x0 = 0.0f;
            this.f2119y0 = 0.0f;
            this.f2120z0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f2158l0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.f2186v0) {
                    this.f2108n0 = obtainStyledAttributes.getFloat(index, this.f2108n0);
                } else if (index == R$styleable.I0) {
                    this.f2110p0 = obtainStyledAttributes.getFloat(index, this.f2110p0);
                    this.f2109o0 = true;
                } else if (index == R$styleable.D0) {
                    this.f2112r0 = obtainStyledAttributes.getFloat(index, this.f2112r0);
                } else if (index == R$styleable.E0) {
                    this.f2113s0 = obtainStyledAttributes.getFloat(index, this.f2113s0);
                } else if (index == R$styleable.C0) {
                    this.f2111q0 = obtainStyledAttributes.getFloat(index, this.f2111q0);
                } else if (index == R$styleable.A0) {
                    this.f2114t0 = obtainStyledAttributes.getFloat(index, this.f2114t0);
                } else if (index == R$styleable.B0) {
                    this.f2115u0 = obtainStyledAttributes.getFloat(index, this.f2115u0);
                } else if (index == R$styleable.f2188w0) {
                    this.f2116v0 = obtainStyledAttributes.getFloat(index, this.f2116v0);
                } else if (index == R$styleable.f2190x0) {
                    this.f2117w0 = obtainStyledAttributes.getFloat(index, this.f2117w0);
                } else if (index == R$styleable.f2192y0) {
                    this.f2118x0 = obtainStyledAttributes.getFloat(index, this.f2118x0);
                } else if (index == R$styleable.f2194z0) {
                    this.f2119y0 = obtainStyledAttributes.getFloat(index, this.f2119y0);
                } else if (index == R$styleable.H0) {
                    this.f2118x0 = obtainStyledAttributes.getFloat(index, this.f2120z0);
                }
            }
        }
    }
}
