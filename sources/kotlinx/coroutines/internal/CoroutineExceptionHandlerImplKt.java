package kotlinx.coroutines.internal;

import java.util.Collection;
import java.util.ServiceLoader;
import kotlinx.coroutines.CoroutineExceptionHandler;

public final class CoroutineExceptionHandlerImplKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Collection<CoroutineExceptionHandler> f40725a;

    static {
        Class<CoroutineExceptionHandler> cls = CoroutineExceptionHandler.class;
        f40725a = SequencesKt___SequencesKt.l(SequencesKt__SequencesKt.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }

    public static final Collection<CoroutineExceptionHandler> a() {
        return f40725a;
    }

    public static final void b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
