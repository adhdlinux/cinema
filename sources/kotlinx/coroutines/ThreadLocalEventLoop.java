package kotlinx.coroutines;

import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadLocalKt;

public final class ThreadLocalEventLoop {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocalEventLoop f40685a = new ThreadLocalEventLoop();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<EventLoop> f40686b = ThreadLocalKt.a(new Symbol("ThreadLocalEventLoop"));

    private ThreadLocalEventLoop() {
    }

    public final EventLoop a() {
        return f40686b.get();
    }

    public final EventLoop b() {
        ThreadLocal<EventLoop> threadLocal = f40686b;
        EventLoop eventLoop = threadLocal.get();
        if (eventLoop != null) {
            return eventLoop;
        }
        EventLoop a2 = EventLoopKt.a();
        threadLocal.set(a2);
        return a2;
    }

    public final void c() {
        f40686b.set((Object) null);
    }

    public final void d(EventLoop eventLoop) {
        f40686b.set(eventLoop);
    }
}
