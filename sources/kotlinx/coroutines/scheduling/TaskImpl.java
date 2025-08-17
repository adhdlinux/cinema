package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.DebugStringsKt;

public final class TaskImpl extends Task {

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f40826d;

    public TaskImpl(Runnable runnable, long j2, TaskContext taskContext) {
        super(j2, taskContext);
        this.f40826d = runnable;
    }

    public void run() {
        try {
            this.f40826d.run();
        } finally {
            this.f40824c.a();
        }
    }

    public String toString() {
        return "Task[" + DebugStringsKt.a(this.f40826d) + '@' + DebugStringsKt.b(this.f40826d) + ", " + this.f40823b + ", " + this.f40824c + ']';
    }
}
