package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class Barrier extends ConstraintHelper {

    /* renamed from: h  reason: collision with root package name */
    private int f1987h;

    /* renamed from: i  reason: collision with root package name */
    private int f1988i;

    /* renamed from: j  reason: collision with root package name */
    private androidx.constraintlayout.solver.widgets.Barrier f1989j;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void b(AttributeSet attributeSet) {
        super.b(attributeSet);
        this.f1989j = new androidx.constraintlayout.solver.widgets.Barrier();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f2124a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.f2145h) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.f2142g) {
                    this.f1989j.K0(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f1993e = this.f1989j;
        f();
    }

    public int getType() {
        return this.f1987h;
    }

    public void setAllowsGoneWidget(boolean z2) {
        this.f1989j.K0(z2);
    }

    public void setType(int i2) {
        boolean z2;
        this.f1987h = i2;
        this.f1988i = i2;
        if (1 == getResources().getConfiguration().getLayoutDirection()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            int i3 = this.f1987h;
            if (i3 == 5) {
                this.f1988i = 1;
            } else if (i3 == 6) {
                this.f1988i = 0;
            }
        } else {
            int i4 = this.f1987h;
            if (i4 == 5) {
                this.f1988i = 0;
            } else if (i4 == 6) {
                this.f1988i = 1;
            }
        }
        this.f1989j.L0(this.f1988i);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
    }
}
