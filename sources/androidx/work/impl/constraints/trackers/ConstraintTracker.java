package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class ConstraintTracker<T> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f12433f = Logger.f("ConstraintTracker");

    /* renamed from: a  reason: collision with root package name */
    protected final TaskExecutor f12434a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f12435b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f12436c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Set<ConstraintListener<T>> f12437d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    T f12438e;

    ConstraintTracker(Context context, TaskExecutor taskExecutor) {
        this.f12435b = context.getApplicationContext();
        this.f12434a = taskExecutor;
    }

    public void a(ConstraintListener<T> constraintListener) {
        synchronized (this.f12436c) {
            if (this.f12437d.add(constraintListener)) {
                if (this.f12437d.size() == 1) {
                    this.f12438e = b();
                    Logger.c().a(f12433f, String.format("%s: initial state = %s", new Object[]{getClass().getSimpleName(), this.f12438e}), new Throwable[0]);
                    e();
                }
                constraintListener.a(this.f12438e);
            }
        }
    }

    public abstract T b();

    public void c(ConstraintListener<T> constraintListener) {
        synchronized (this.f12436c) {
            if (this.f12437d.remove(constraintListener) && this.f12437d.isEmpty()) {
                f();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(T r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f12436c
            monitor-enter(r0)
            T r1 = r3.f12438e     // Catch:{ all -> 0x002b }
            if (r1 == r4) goto L_0x0029
            if (r1 == 0) goto L_0x0010
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0010
            goto L_0x0029
        L_0x0010:
            r3.f12438e = r4     // Catch:{ all -> 0x002b }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x002b }
            java.util.Set<androidx.work.impl.constraints.ConstraintListener<T>> r1 = r3.f12437d     // Catch:{ all -> 0x002b }
            r4.<init>(r1)     // Catch:{ all -> 0x002b }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r1 = r3.f12434a     // Catch:{ all -> 0x002b }
            java.util.concurrent.Executor r1 = r1.a()     // Catch:{ all -> 0x002b }
            androidx.work.impl.constraints.trackers.ConstraintTracker$1 r2 = new androidx.work.impl.constraints.trackers.ConstraintTracker$1     // Catch:{ all -> 0x002b }
            r2.<init>(r4)     // Catch:{ all -> 0x002b }
            r1.execute(r2)     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.ConstraintTracker.d(java.lang.Object):void");
    }

    public abstract void e();

    public abstract void f();
}
