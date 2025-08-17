package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.List;

public class EnqueueRunnable implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    private static final String f12578d = Logger.f("EnqueueRunnable");

    /* renamed from: b  reason: collision with root package name */
    private final WorkContinuationImpl f12579b;

    /* renamed from: c  reason: collision with root package name */
    private final OperationImpl f12580c = new OperationImpl();

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this.f12579b = workContinuationImpl;
    }

    private static boolean b(WorkContinuationImpl workContinuationImpl) {
        boolean c2 = c(workContinuationImpl.g(), workContinuationImpl.f(), (String[]) WorkContinuationImpl.l(workContinuationImpl).toArray(new String[0]), workContinuationImpl.d(), workContinuationImpl.b());
        workContinuationImpl.k();
        return c2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01e1 A[LOOP:7: B:120:0x01db->B:122:0x01e1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x020a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(androidx.work.impl.WorkManagerImpl r19, java.util.List<? extends androidx.work.WorkRequest> r20, java.lang.String[] r21, java.lang.String r22, androidx.work.ExistingWorkPolicy r23) {
        /*
            r0 = r19
            r1 = r21
            r2 = r22
            r3 = r23
            long r4 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r6 = r19.o()
            r7 = 1
            if (r1 == 0) goto L_0x0018
            int r9 = r1.length
            if (r9 <= 0) goto L_0x0018
            r9 = 1
            goto L_0x0019
        L_0x0018:
            r9 = 0
        L_0x0019:
            if (r9 == 0) goto L_0x005d
            int r10 = r1.length
            r11 = 0
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0020:
            if (r11 >= r10) goto L_0x0060
            r15 = r1[r11]
            androidx.work.impl.model.WorkSpecDao r8 = r6.D()
            androidx.work.impl.model.WorkSpec r8 = r8.g(r15)
            if (r8 != 0) goto L_0x0045
            androidx.work.Logger r0 = androidx.work.Logger.c()
            java.lang.String r1 = f12578d
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r3 = 0
            r2[r3] = r15
            java.lang.String r4 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.String r2 = java.lang.String.format(r4, r2)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r3]
            r0.b(r1, r2, r4)
            return r3
        L_0x0045:
            androidx.work.WorkInfo$State r8 = r8.f12517b
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r8 != r15) goto L_0x004d
            r15 = 1
            goto L_0x004e
        L_0x004d:
            r15 = 0
        L_0x004e:
            r12 = r12 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r8 != r15) goto L_0x0055
            r14 = 1
            goto L_0x005a
        L_0x0055:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r8 != r15) goto L_0x005a
            r13 = 1
        L_0x005a:
            int r11 = r11 + 1
            goto L_0x0020
        L_0x005d:
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0060:
            boolean r8 = android.text.TextUtils.isEmpty(r22)
            r8 = r8 ^ r7
            if (r8 == 0) goto L_0x006b
            if (r9 != 0) goto L_0x006b
            r10 = 1
            goto L_0x006c
        L_0x006b:
            r10 = 0
        L_0x006c:
            if (r10 == 0) goto L_0x014e
            androidx.work.impl.model.WorkSpecDao r10 = r6.D()
            java.util.List r10 = r10.m(r2)
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x014e
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.APPEND
            if (r3 == r11) goto L_0x00ca
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r3 != r11) goto L_0x0085
            goto L_0x00ca
        L_0x0085:
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.KEEP
            if (r3 != r11) goto L_0x00a5
            java.util.Iterator r3 = r10.iterator()
        L_0x008d:
            boolean r11 = r3.hasNext()
            if (r11 == 0) goto L_0x00a5
            java.lang.Object r11 = r3.next()
            androidx.work.impl.model.WorkSpec$IdAndState r11 = (androidx.work.impl.model.WorkSpec.IdAndState) r11
            androidx.work.WorkInfo$State r11 = r11.f12535b
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.ENQUEUED
            if (r11 == r15) goto L_0x00a3
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.RUNNING
            if (r11 != r15) goto L_0x008d
        L_0x00a3:
            r11 = 0
            return r11
        L_0x00a5:
            r11 = 0
            androidx.work.impl.utils.CancelWorkRunnable r3 = androidx.work.impl.utils.CancelWorkRunnable.c(r2, r0, r11)
            r3.run()
            androidx.work.impl.model.WorkSpecDao r3 = r6.D()
            java.util.Iterator r10 = r10.iterator()
        L_0x00b5:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x00c7
            java.lang.Object r15 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r15 = (androidx.work.impl.model.WorkSpec.IdAndState) r15
            java.lang.String r15 = r15.f12534a
            r3.delete(r15)
            goto L_0x00b5
        L_0x00c7:
            r3 = 1
            goto L_0x014f
        L_0x00ca:
            r11 = 0
            androidx.work.impl.model.DependencyDao r9 = r6.v()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00d8:
            boolean r16 = r10.hasNext()
            if (r16 == 0) goto L_0x0113
            java.lang.Object r16 = r10.next()
            r7 = r16
            androidx.work.impl.model.WorkSpec$IdAndState r7 = (androidx.work.impl.model.WorkSpec.IdAndState) r7
            java.lang.String r11 = r7.f12534a
            boolean r11 = r9.d(r11)
            if (r11 != 0) goto L_0x010c
            androidx.work.WorkInfo$State r11 = r7.f12535b
            r17 = r9
            androidx.work.WorkInfo$State r9 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r11 != r9) goto L_0x00f8
            r9 = 1
            goto L_0x00f9
        L_0x00f8:
            r9 = 0
        L_0x00f9:
            r9 = r9 & r12
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo.State.FAILED
            if (r11 != r12) goto L_0x0100
            r14 = 1
            goto L_0x0105
        L_0x0100:
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo.State.CANCELLED
            if (r11 != r12) goto L_0x0105
            r13 = 1
        L_0x0105:
            java.lang.String r7 = r7.f12534a
            r15.add(r7)
            r12 = r9
            goto L_0x010e
        L_0x010c:
            r17 = r9
        L_0x010e:
            r9 = r17
            r7 = 1
            r11 = 0
            goto L_0x00d8
        L_0x0113:
            androidx.work.ExistingWorkPolicy r7 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r3 != r7) goto L_0x0140
            if (r13 != 0) goto L_0x011b
            if (r14 == 0) goto L_0x0140
        L_0x011b:
            androidx.work.impl.model.WorkSpecDao r3 = r6.D()
            java.util.List r7 = r3.m(r2)
            java.util.Iterator r7 = r7.iterator()
        L_0x0127:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0139
            java.lang.Object r9 = r7.next()
            androidx.work.impl.model.WorkSpec$IdAndState r9 = (androidx.work.impl.model.WorkSpec.IdAndState) r9
            java.lang.String r9 = r9.f12534a
            r3.delete(r9)
            goto L_0x0127
        L_0x0139:
            java.util.List r15 = java.util.Collections.emptyList()
            r3 = 0
            r13 = 0
            goto L_0x0141
        L_0x0140:
            r3 = r14
        L_0x0141:
            java.lang.Object[] r1 = r15.toArray(r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r7 = r1.length
            if (r7 <= 0) goto L_0x014c
            r9 = 1
            goto L_0x014d
        L_0x014c:
            r9 = 0
        L_0x014d:
            r14 = r3
        L_0x014e:
            r3 = 0
        L_0x014f:
            java.util.Iterator r7 = r20.iterator()
        L_0x0153:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x0210
            java.lang.Object r10 = r7.next()
            androidx.work.WorkRequest r10 = (androidx.work.WorkRequest) r10
            androidx.work.impl.model.WorkSpec r11 = r10.c()
            if (r9 == 0) goto L_0x017a
            if (r12 != 0) goto L_0x017a
            if (r14 == 0) goto L_0x016e
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            r11.f12517b = r15
            goto L_0x0182
        L_0x016e:
            if (r13 == 0) goto L_0x0175
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            r11.f12517b = r15
            goto L_0x0182
        L_0x0175:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.BLOCKED
            r11.f12517b = r15
            goto L_0x0182
        L_0x017a:
            boolean r15 = r11.d()
            if (r15 != 0) goto L_0x0185
            r11.f12529n = r4
        L_0x0182:
            r17 = r4
            goto L_0x018b
        L_0x0185:
            r17 = r4
            r4 = 0
            r11.f12529n = r4
        L_0x018b:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 < r5) goto L_0x0199
            r5 = 25
            if (r4 > r5) goto L_0x0199
            g(r11)
            goto L_0x01a8
        L_0x0199:
            r5 = 22
            if (r4 > r5) goto L_0x01a8
            java.lang.String r4 = "androidx.work.impl.background.gcm.GcmScheduler"
            boolean r4 = h(r0, r4)
            if (r4 == 0) goto L_0x01a8
            g(r11)
        L_0x01a8:
            androidx.work.WorkInfo$State r4 = r11.f12517b
            androidx.work.WorkInfo$State r5 = androidx.work.WorkInfo.State.ENQUEUED
            if (r4 != r5) goto L_0x01af
            r3 = 1
        L_0x01af:
            androidx.work.impl.model.WorkSpecDao r4 = r6.D()
            r4.c(r11)
            if (r9 == 0) goto L_0x01d3
            int r4 = r1.length
            r5 = 0
        L_0x01ba:
            if (r5 >= r4) goto L_0x01d3
            r11 = r1[r5]
            androidx.work.impl.model.Dependency r15 = new androidx.work.impl.model.Dependency
            java.lang.String r0 = r10.a()
            r15.<init>(r0, r11)
            androidx.work.impl.model.DependencyDao r0 = r6.v()
            r0.a(r15)
            int r5 = r5 + 1
            r0 = r19
            goto L_0x01ba
        L_0x01d3:
            java.util.Set r0 = r10.b()
            java.util.Iterator r0 = r0.iterator()
        L_0x01db:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x01f8
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            androidx.work.impl.model.WorkTagDao r5 = r6.E()
            androidx.work.impl.model.WorkTag r11 = new androidx.work.impl.model.WorkTag
            java.lang.String r15 = r10.a()
            r11.<init>(r4, r15)
            r5.b(r11)
            goto L_0x01db
        L_0x01f8:
            if (r8 == 0) goto L_0x020a
            androidx.work.impl.model.WorkNameDao r0 = r6.B()
            androidx.work.impl.model.WorkName r4 = new androidx.work.impl.model.WorkName
            java.lang.String r5 = r10.a()
            r4.<init>(r2, r5)
            r0.a(r4)
        L_0x020a:
            r0 = r19
            r4 = r17
            goto L_0x0153
        L_0x0210:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.c(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static boolean e(WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> e2 = workContinuationImpl.e();
        boolean z2 = false;
        if (e2 != null) {
            boolean z3 = false;
            for (WorkContinuationImpl next : e2) {
                if (!next.j()) {
                    z3 |= e(next);
                } else {
                    Logger.c().h(f12578d, String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(", ", next.c())}), new Throwable[0]);
                }
            }
            z2 = z3;
        }
        return b(workContinuationImpl) | z2;
    }

    private static void g(WorkSpec workSpec) {
        Constraints constraints = workSpec.f12525j;
        String str = workSpec.f12518c;
        Class<ConstraintTrackingWorker> cls = ConstraintTrackingWorker.class;
        if (str.equals(cls.getName())) {
            return;
        }
        if (constraints.f() || constraints.i()) {
            Data.Builder builder = new Data.Builder();
            builder.c(workSpec.f12520e).f("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            workSpec.f12518c = cls.getName();
            workSpec.f12520e = builder.a();
        }
    }

    private static boolean h(WorkManagerImpl workManagerImpl, String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (Scheduler scheduler : workManagerImpl.n()) {
                if (cls.isAssignableFrom(scheduler.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    public boolean a() {
        WorkDatabase o2 = this.f12579b.g().o();
        o2.c();
        try {
            boolean e2 = e(this.f12579b);
            o2.t();
            return e2;
        } finally {
            o2.g();
        }
    }

    public Operation d() {
        return this.f12580c;
    }

    public void f() {
        WorkManagerImpl g2 = this.f12579b.g();
        Schedulers.b(g2.i(), g2.o(), g2.n());
    }

    public void run() {
        try {
            if (!this.f12579b.h()) {
                if (a()) {
                    PackageManagerHelper.a(this.f12579b.g().h(), RescheduleReceiver.class, true);
                    f();
                }
                this.f12580c.a(Operation.f12194a);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.f12579b}));
        } catch (Throwable th) {
            this.f12580c.a(new Operation.State.FAILURE(th));
        }
    }
}
