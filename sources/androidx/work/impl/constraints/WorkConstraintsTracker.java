package androidx.work.impl.constraints;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

public class WorkConstraintsTracker implements ConstraintController.OnConstraintUpdatedCallback {

    /* renamed from: d  reason: collision with root package name */
    private static final String f12418d = Logger.f("WorkConstraintsTracker");

    /* renamed from: a  reason: collision with root package name */
    private final WorkConstraintsCallback f12419a;

    /* renamed from: b  reason: collision with root package name */
    private final ConstraintController<?>[] f12420b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f12421c = new Object();

    public WorkConstraintsTracker(Context context, TaskExecutor taskExecutor, WorkConstraintsCallback workConstraintsCallback) {
        Context applicationContext = context.getApplicationContext();
        this.f12419a = workConstraintsCallback;
        this.f12420b = new ConstraintController[]{new BatteryChargingController(applicationContext, taskExecutor), new BatteryNotLowController(applicationContext, taskExecutor), new StorageNotLowController(applicationContext, taskExecutor), new NetworkConnectedController(applicationContext, taskExecutor), new NetworkUnmeteredController(applicationContext, taskExecutor), new NetworkNotRoamingController(applicationContext, taskExecutor), new NetworkMeteredController(applicationContext, taskExecutor)};
    }

    public void a(List<String> list) {
        synchronized (this.f12421c) {
            ArrayList arrayList = new ArrayList();
            for (String next : list) {
                if (c(next)) {
                    Logger.c().a(f12418d, String.format("Constraints met for %s", new Object[]{next}), new Throwable[0]);
                    arrayList.add(next);
                }
            }
            WorkConstraintsCallback workConstraintsCallback = this.f12419a;
            if (workConstraintsCallback != null) {
                workConstraintsCallback.f(arrayList);
            }
        }
    }

    public void b(List<String> list) {
        synchronized (this.f12421c) {
            WorkConstraintsCallback workConstraintsCallback = this.f12419a;
            if (workConstraintsCallback != null) {
                workConstraintsCallback.b(list);
            }
        }
    }

    public boolean c(String str) {
        synchronized (this.f12421c) {
            for (ConstraintController<?> constraintController : this.f12420b) {
                if (constraintController.d(str)) {
                    Logger.c().a(f12418d, String.format("Work %s constrained by %s", new Object[]{str, constraintController.getClass().getSimpleName()}), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void d(Iterable<WorkSpec> iterable) {
        synchronized (this.f12421c) {
            for (ConstraintController<?> g2 : this.f12420b) {
                g2.g((ConstraintController.OnConstraintUpdatedCallback) null);
            }
            for (ConstraintController<?> e2 : this.f12420b) {
                e2.e(iterable);
            }
            for (ConstraintController<?> g3 : this.f12420b) {
                g3.g(this);
            }
        }
    }

    public void e() {
        synchronized (this.f12421c) {
            for (ConstraintController<?> f2 : this.f12420b) {
                f2.f();
            }
        }
    }
}
