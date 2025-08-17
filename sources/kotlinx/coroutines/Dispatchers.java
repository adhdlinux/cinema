package kotlinx.coroutines;

import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

public final class Dispatchers {

    /* renamed from: a  reason: collision with root package name */
    public static final Dispatchers f40630a = new Dispatchers();

    /* renamed from: b  reason: collision with root package name */
    private static final CoroutineDispatcher f40631b = DefaultScheduler.f40816i;

    /* renamed from: c  reason: collision with root package name */
    private static final CoroutineDispatcher f40632c = Unconfined.f40694c;

    /* renamed from: d  reason: collision with root package name */
    private static final CoroutineDispatcher f40633d = DefaultIoScheduler.f40814d;

    private Dispatchers() {
    }

    public static final CoroutineDispatcher a() {
        return f40631b;
    }

    public static final CoroutineDispatcher b() {
        return f40633d;
    }

    public static final MainCoroutineDispatcher c() {
        return MainDispatcherLoader.f40763c;
    }
}
