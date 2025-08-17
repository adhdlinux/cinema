package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

public class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {

    /* renamed from: d  reason: collision with root package name */
    private final int f40818d;

    /* renamed from: e  reason: collision with root package name */
    private final int f40819e;

    /* renamed from: f  reason: collision with root package name */
    private final long f40820f;

    /* renamed from: g  reason: collision with root package name */
    private final String f40821g;

    /* renamed from: h  reason: collision with root package name */
    private CoroutineScheduler f40822h;

    public SchedulerCoroutineDispatcher() {
        this(0, 0, 0, (String) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SchedulerCoroutineDispatcher(int r4, int r5, long r6, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            int r4 = kotlinx.coroutines.scheduling.TasksKt.f40829c
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000c
            int r5 = kotlinx.coroutines.scheduling.TasksKt.f40830d
        L_0x000c:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            long r6 = kotlinx.coroutines.scheduling.TasksKt.f40831e
        L_0x0013:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001a
            java.lang.String r8 = "CoroutineScheduler"
        L_0x001a:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r10 = r2
            r5.<init>(r6, r7, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher.<init>(int, int, long, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private final CoroutineScheduler s0() {
        return new CoroutineScheduler(this.f40818d, this.f40819e, this.f40820f, this.f40821g);
    }

    public void close() {
        this.f40822h.close();
    }

    public void o0(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.v(this.f40822h, runnable, (TaskContext) null, false, 6, (Object) null);
    }

    public Executor r0() {
        return this.f40822h;
    }

    public final void t0(Runnable runnable, TaskContext taskContext, boolean z2) {
        this.f40822h.s(runnable, taskContext, z2);
    }

    public SchedulerCoroutineDispatcher(int i2, int i3, long j2, String str) {
        this.f40818d = i2;
        this.f40819e = i3;
        this.f40820f = j2;
        this.f40821g = str;
        this.f40822h = s0();
    }
}
