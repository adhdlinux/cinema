package kotlinx.coroutines.scheduling;

public abstract class Task implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public long f40823b;

    /* renamed from: c  reason: collision with root package name */
    public TaskContext f40824c;

    public Task(long j2, TaskContext taskContext) {
        this.f40823b = j2;
        this.f40824c = taskContext;
    }

    public Task() {
        this(0, TasksKt.f40833g);
    }
}
