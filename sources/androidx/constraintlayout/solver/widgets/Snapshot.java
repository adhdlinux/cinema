package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

public class Snapshot {

    /* renamed from: a  reason: collision with root package name */
    private int f1976a;

    /* renamed from: b  reason: collision with root package name */
    private int f1977b;

    /* renamed from: c  reason: collision with root package name */
    private int f1978c;

    /* renamed from: d  reason: collision with root package name */
    private int f1979d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Connection> f1980e = new ArrayList<>();

    static class Connection {

        /* renamed from: a  reason: collision with root package name */
        private ConstraintAnchor f1981a;

        /* renamed from: b  reason: collision with root package name */
        private ConstraintAnchor f1982b;

        /* renamed from: c  reason: collision with root package name */
        private int f1983c;

        /* renamed from: d  reason: collision with root package name */
        private ConstraintAnchor.Strength f1984d;

        /* renamed from: e  reason: collision with root package name */
        private int f1985e;

        public Connection(ConstraintAnchor constraintAnchor) {
            this.f1981a = constraintAnchor;
            this.f1982b = constraintAnchor.i();
            this.f1983c = constraintAnchor.d();
            this.f1984d = constraintAnchor.h();
            this.f1985e = constraintAnchor.c();
        }

        public void a(ConstraintWidget constraintWidget) {
            constraintWidget.h(this.f1981a.j()).b(this.f1982b, this.f1983c, this.f1984d, this.f1985e);
        }

        public void b(ConstraintWidget constraintWidget) {
            ConstraintAnchor h2 = constraintWidget.h(this.f1981a.j());
            this.f1981a = h2;
            if (h2 != null) {
                this.f1982b = h2.i();
                this.f1983c = this.f1981a.d();
                this.f1984d = this.f1981a.h();
                this.f1985e = this.f1981a.c();
                return;
            }
            this.f1982b = null;
            this.f1983c = 0;
            this.f1984d = ConstraintAnchor.Strength.STRONG;
            this.f1985e = 0;
        }
    }

    public Snapshot(ConstraintWidget constraintWidget) {
        this.f1976a = constraintWidget.G();
        this.f1977b = constraintWidget.H();
        this.f1978c = constraintWidget.D();
        this.f1979d = constraintWidget.r();
        ArrayList<ConstraintAnchor> i2 = constraintWidget.i();
        int size = i2.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f1980e.add(new Connection(i2.get(i3)));
        }
    }

    public void a(ConstraintWidget constraintWidget) {
        constraintWidget.C0(this.f1976a);
        constraintWidget.D0(this.f1977b);
        constraintWidget.y0(this.f1978c);
        constraintWidget.b0(this.f1979d);
        int size = this.f1980e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1980e.get(i2).a(constraintWidget);
        }
    }

    public void b(ConstraintWidget constraintWidget) {
        this.f1976a = constraintWidget.G();
        this.f1977b = constraintWidget.H();
        this.f1978c = constraintWidget.D();
        this.f1979d = constraintWidget.r();
        int size = this.f1980e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1980e.get(i2).b(constraintWidget);
        }
    }
}
