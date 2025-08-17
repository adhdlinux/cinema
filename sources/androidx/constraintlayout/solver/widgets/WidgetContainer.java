package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import java.util.ArrayList;

public class WidgetContainer extends ConstraintWidget {

    /* renamed from: v0  reason: collision with root package name */
    protected ArrayList<ConstraintWidget> f1986v0 = new ArrayList<>();

    public void F0() {
        super.F0();
        ArrayList<ConstraintWidget> arrayList = this.f1986v0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = this.f1986v0.get(i2);
                constraintWidget.n0(p(), q());
                if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                    constraintWidget.F0();
                }
            }
        }
    }

    public void I0(ConstraintWidget constraintWidget) {
        this.f1986v0.add(constraintWidget);
        if (constraintWidget.u() != null) {
            ((WidgetContainer) constraintWidget.u()).L0(constraintWidget);
        }
        constraintWidget.p0(this);
    }

    public ConstraintWidgetContainer J0() {
        ConstraintWidgetContainer constraintWidgetContainer;
        ConstraintWidget u2 = u();
        if (this instanceof ConstraintWidgetContainer) {
            constraintWidgetContainer = (ConstraintWidgetContainer) this;
        } else {
            constraintWidgetContainer = null;
        }
        while (u2 != null) {
            ConstraintWidget u3 = u2.u();
            if (u2 instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) u2;
            }
            u2 = u3;
        }
        return constraintWidgetContainer;
    }

    public void K0() {
        F0();
        ArrayList<ConstraintWidget> arrayList = this.f1986v0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = this.f1986v0.get(i2);
                if (constraintWidget instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget).K0();
                }
            }
        }
    }

    public void L0(ConstraintWidget constraintWidget) {
        this.f1986v0.remove(constraintWidget);
        constraintWidget.p0((ConstraintWidget) null);
    }

    public void M0() {
        this.f1986v0.clear();
    }

    public void Q() {
        this.f1986v0.clear();
        super.Q();
    }

    public void T(Cache cache) {
        super.T(cache);
        int size = this.f1986v0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1986v0.get(i2).T(cache);
        }
    }

    public void n0(int i2, int i3) {
        super.n0(i2, i3);
        int size = this.f1986v0.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f1986v0.get(i4).n0(z(), A());
        }
    }
}
