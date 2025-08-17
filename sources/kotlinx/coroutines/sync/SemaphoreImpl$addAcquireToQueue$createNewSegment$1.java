package kotlinx.coroutines.sync;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* synthetic */ class SemaphoreImpl$addAcquireToQueue$createNewSegment$1 extends FunctionReferenceImpl implements Function2<Long, SemaphoreSegment, SemaphoreSegment> {

    /* renamed from: c  reason: collision with root package name */
    public static final SemaphoreImpl$addAcquireToQueue$createNewSegment$1 f40862c = new SemaphoreImpl$addAcquireToQueue$createNewSegment$1();

    SemaphoreImpl$addAcquireToQueue$createNewSegment$1() {
        super(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    public final SemaphoreSegment a(long j2, SemaphoreSegment semaphoreSegment) {
        return SemaphoreKt.h(j2, semaphoreSegment);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a(((Number) obj).longValue(), (SemaphoreSegment) obj2);
    }
}
