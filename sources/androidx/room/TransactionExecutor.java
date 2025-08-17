package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

class TransactionExecutor implements Executor {

    /* renamed from: b  reason: collision with root package name */
    private final Executor f11522b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<Runnable> f11523c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    private Runnable f11524d;

    TransactionExecutor(Executor executor) {
        this.f11522b = executor;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        Runnable poll = this.f11523c.poll();
        this.f11524d = poll;
        if (poll != null) {
            this.f11522b.execute(poll);
        }
    }

    public synchronized void execute(final Runnable runnable) {
        this.f11523c.offer(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } finally {
                    TransactionExecutor.this.a();
                }
            }
        });
        if (this.f11524d == null) {
            a();
        }
    }
}
