package kotlinx.coroutines;

import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;

public final class DefaultExecutorKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f40625a = SystemPropsKt.f("kotlinx.coroutines.main.delay", false);

    /* renamed from: b  reason: collision with root package name */
    private static final Delay f40626b = b();

    public static final Delay a() {
        return f40626b;
    }

    private static final Delay b() {
        if (!f40625a) {
            return DefaultExecutor.f40623i;
        }
        MainCoroutineDispatcher c2 = Dispatchers.c();
        if (MainDispatchersKt.c(c2) || !(c2 instanceof Delay)) {
            return DefaultExecutor.f40623i;
        }
        return (Delay) c2;
    }
}
