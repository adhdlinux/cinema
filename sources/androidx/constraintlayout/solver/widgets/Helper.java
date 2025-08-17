package androidx.constraintlayout.solver.widgets;

import java.util.Arrays;

public class Helper extends ConstraintWidget {

    /* renamed from: v0  reason: collision with root package name */
    protected ConstraintWidget[] f1957v0 = new ConstraintWidget[4];

    /* renamed from: w0  reason: collision with root package name */
    protected int f1958w0 = 0;

    public void I0(ConstraintWidget constraintWidget) {
        int i2 = this.f1958w0 + 1;
        ConstraintWidget[] constraintWidgetArr = this.f1957v0;
        if (i2 > constraintWidgetArr.length) {
            this.f1957v0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.f1957v0;
        int i3 = this.f1958w0;
        constraintWidgetArr2[i3] = constraintWidget;
        this.f1958w0 = i3 + 1;
    }

    public void J0() {
        this.f1958w0 = 0;
    }
}
