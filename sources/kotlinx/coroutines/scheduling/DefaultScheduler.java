package kotlinx.coroutines.scheduling;

public final class DefaultScheduler extends SchedulerCoroutineDispatcher {

    /* renamed from: i  reason: collision with root package name */
    public static final DefaultScheduler f40816i = new DefaultScheduler();

    private DefaultScheduler() {
        super(TasksKt.f40829c, TasksKt.f40830d, TasksKt.f40831e, TasksKt.f40827a);
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public String toString() {
        return "Dispatchers.Default";
    }
}
