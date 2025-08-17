package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class ConstraintController<T> implements ConstraintListener<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f12422a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private T f12423b;

    /* renamed from: c  reason: collision with root package name */
    private ConstraintTracker<T> f12424c;

    /* renamed from: d  reason: collision with root package name */
    private OnConstraintUpdatedCallback f12425d;

    public interface OnConstraintUpdatedCallback {
        void a(List<String> list);

        void b(List<String> list);
    }

    ConstraintController(ConstraintTracker<T> constraintTracker) {
        this.f12424c = constraintTracker;
    }

    private void h(OnConstraintUpdatedCallback onConstraintUpdatedCallback, T t2) {
        if (!this.f12422a.isEmpty() && onConstraintUpdatedCallback != null) {
            if (t2 == null || c(t2)) {
                onConstraintUpdatedCallback.b(this.f12422a);
            } else {
                onConstraintUpdatedCallback.a(this.f12422a);
            }
        }
    }

    public void a(T t2) {
        this.f12423b = t2;
        h(this.f12425d, t2);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean b(WorkSpec workSpec);

    /* access modifiers changed from: package-private */
    public abstract boolean c(T t2);

    public boolean d(String str) {
        T t2 = this.f12423b;
        if (t2 == null || !c(t2) || !this.f12422a.contains(str)) {
            return false;
        }
        return true;
    }

    public void e(Iterable<WorkSpec> iterable) {
        this.f12422a.clear();
        for (WorkSpec next : iterable) {
            if (b(next)) {
                this.f12422a.add(next.f12516a);
            }
        }
        if (this.f12422a.isEmpty()) {
            this.f12424c.c(this);
        } else {
            this.f12424c.a(this);
        }
        h(this.f12425d, this.f12423b);
    }

    public void f() {
        if (!this.f12422a.isEmpty()) {
            this.f12422a.clear();
            this.f12424c.c(this);
        }
    }

    public void g(OnConstraintUpdatedCallback onConstraintUpdatedCallback) {
        if (this.f12425d != onConstraintUpdatedCallback) {
            this.f12425d = onConstraintUpdatedCallback;
            h(onConstraintUpdatedCallback, this.f12423b);
        }
    }
}
