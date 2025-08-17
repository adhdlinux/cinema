package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpecDao;

public class StopWorkRunnable implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    private static final String f12600e = Logger.f("StopWorkRunnable");

    /* renamed from: b  reason: collision with root package name */
    private final WorkManagerImpl f12601b;

    /* renamed from: c  reason: collision with root package name */
    private final String f12602c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f12603d;

    public StopWorkRunnable(WorkManagerImpl workManagerImpl, String str, boolean z2) {
        this.f12601b = workManagerImpl;
        this.f12602c = str;
        this.f12603d = z2;
    }

    public void run() {
        boolean z2;
        WorkDatabase o2 = this.f12601b.o();
        Processor m2 = this.f12601b.m();
        WorkSpecDao D = o2.D();
        o2.c();
        try {
            boolean h2 = m2.h(this.f12602c);
            if (this.f12603d) {
                z2 = this.f12601b.m().n(this.f12602c);
            } else {
                if (!h2 && D.f(this.f12602c) == WorkInfo.State.RUNNING) {
                    D.a(WorkInfo.State.ENQUEUED, this.f12602c);
                }
                z2 = this.f12601b.m().o(this.f12602c);
            }
            Logger.c().a(f12600e, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", new Object[]{this.f12602c, Boolean.valueOf(z2)}), new Throwable[0]);
            o2.t();
        } finally {
            o2.g();
        }
    }
}
