package androidx.work.impl.utils;

import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.LinkedList;
import java.util.UUID;

public abstract class CancelWorkRunnable implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final OperationImpl f12570b = new OperationImpl();

    public static CancelWorkRunnable b(final UUID uuid, final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: package-private */
            public void h() {
                WorkDatabase o2 = WorkManagerImpl.this.o();
                o2.c();
                try {
                    a(WorkManagerImpl.this, uuid.toString());
                    o2.t();
                    o2.g();
                    g(WorkManagerImpl.this);
                } catch (Throwable th) {
                    o2.g();
                    throw th;
                }
            }
        };
    }

    public static CancelWorkRunnable c(final String str, final WorkManagerImpl workManagerImpl, final boolean z2) {
        return new CancelWorkRunnable() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: package-private */
            public void h() {
                WorkDatabase o2 = WorkManagerImpl.this.o();
                o2.c();
                try {
                    for (String a2 : o2.D().e(str)) {
                        a(WorkManagerImpl.this, a2);
                    }
                    o2.t();
                    o2.g();
                    if (z2) {
                        g(WorkManagerImpl.this);
                    }
                } catch (Throwable th) {
                    o2.g();
                    throw th;
                }
            }
        };
    }

    public static CancelWorkRunnable d(final String str, final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: package-private */
            public void h() {
                WorkDatabase o2 = WorkManagerImpl.this.o();
                o2.c();
                try {
                    for (String a2 : o2.D().h(str)) {
                        a(WorkManagerImpl.this, a2);
                    }
                    o2.t();
                    o2.g();
                    g(WorkManagerImpl.this);
                } catch (Throwable th) {
                    o2.g();
                    throw th;
                }
            }
        };
    }

    private void f(WorkDatabase workDatabase, String str) {
        WorkSpecDao D = workDatabase.D();
        DependencyDao v2 = workDatabase.v();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State f2 = D.f(str2);
            if (!(f2 == WorkInfo.State.SUCCEEDED || f2 == WorkInfo.State.FAILED)) {
                D.a(WorkInfo.State.CANCELLED, str2);
            }
            linkedList.addAll(v2.b(str2));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(WorkManagerImpl workManagerImpl, String str) {
        f(workManagerImpl.o(), str);
        workManagerImpl.m().l(str);
        for (Scheduler a2 : workManagerImpl.n()) {
            a2.a(str);
        }
    }

    public Operation e() {
        return this.f12570b;
    }

    /* access modifiers changed from: package-private */
    public void g(WorkManagerImpl workManagerImpl) {
        Schedulers.b(workManagerImpl.i(), workManagerImpl.o(), workManagerImpl.n());
    }

    /* access modifiers changed from: package-private */
    public abstract void h();

    public void run() {
        try {
            h();
            this.f12570b.a(Operation.f12194a);
        } catch (Throwable th) {
            this.f12570b.a(new Operation.State.FAILURE(th));
        }
    }
}
