package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.SystemPropsKt;

public final class TasksKt {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40827a = SystemPropsKt.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* renamed from: b  reason: collision with root package name */
    public static final long f40828b = SystemPropsKt__SystemProps_commonKt.f("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);

    /* renamed from: c  reason: collision with root package name */
    public static final int f40829c = SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.scheduler.core.pool.size", RangesKt___RangesKt.b(SystemPropsKt.a(), 2), 1, 0, 8, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    public static final int f40830d = SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, (Object) null);

    /* renamed from: e  reason: collision with root package name */
    public static final long f40831e = TimeUnit.SECONDS.toNanos(SystemPropsKt__SystemProps_commonKt.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));

    /* renamed from: f  reason: collision with root package name */
    public static SchedulerTimeSource f40832f = NanoTimeSource.f40817a;

    /* renamed from: g  reason: collision with root package name */
    public static final TaskContext f40833g = new TaskContextImpl(0);

    /* renamed from: h  reason: collision with root package name */
    public static final TaskContext f40834h = new TaskContextImpl(1);
}
