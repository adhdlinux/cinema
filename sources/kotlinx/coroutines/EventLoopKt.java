package kotlinx.coroutines;

public final class EventLoopKt {
    public static final EventLoop a() {
        return new BlockingEventLoop(Thread.currentThread());
    }
}
