package androidx.work;

import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

public final class JobListenableFuture<R> implements ListenableFuture<R> {

    /* renamed from: b  reason: collision with root package name */
    private final Job f12179b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final SettableFuture<R> f12180c;

    public JobListenableFuture(Job job, SettableFuture<R> settableFuture) {
        Intrinsics.f(job, "job");
        Intrinsics.f(settableFuture, "underlying");
        this.f12179b = job;
        this.f12180c = settableFuture;
        job.z(new Function1<Throwable, Unit>(this) {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ JobListenableFuture<R> f12181f;

            {
                this.f12181f = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f40298a;
            }

            public final void invoke(Throwable th) {
                if (th == null) {
                    if (!this.f12181f.f12180c.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else if (th instanceof CancellationException) {
                    this.f12181f.f12180c.cancel(true);
                } else {
                    SettableFuture a2 = this.f12181f.f12180c;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    a2.p(th);
                }
            }
        });
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.f12180c.addListener(runnable, executor);
    }

    public final void b(R r2) {
        this.f12180c.o(r2);
    }

    public boolean cancel(boolean z2) {
        return this.f12180c.cancel(z2);
    }

    public R get() {
        return this.f12180c.get();
    }

    public R get(long j2, TimeUnit timeUnit) {
        return this.f12180c.get(j2, timeUnit);
    }

    public boolean isCancelled() {
        return this.f12180c.isCancelled();
    }

    public boolean isDone() {
        return this.f12180c.isDone();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ JobListenableFuture(kotlinx.coroutines.Job r1, androidx.work.impl.utils.futures.SettableFuture r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000d
            androidx.work.impl.utils.futures.SettableFuture r2 = androidx.work.impl.utils.futures.SettableFuture.s()
            java.lang.String r3 = "create()"
            kotlin.jvm.internal.Intrinsics.e(r2, r3)
        L_0x000d:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.JobListenableFuture.<init>(kotlinx.coroutines.Job, androidx.work.impl.utils.futures.SettableFuture, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
