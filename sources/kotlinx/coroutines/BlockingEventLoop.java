package kotlinx.coroutines;

public final class BlockingEventLoop extends EventLoopImplBase {

    /* renamed from: i  reason: collision with root package name */
    private final Thread f40589i;

    public BlockingEventLoop(Thread thread) {
        this.f40589i = thread;
    }

    /* access modifiers changed from: protected */
    public Thread D0() {
        return this.f40589i;
    }
}
