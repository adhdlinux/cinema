package androidx.media3.common.util;

public class ConditionVariable {

    /* renamed from: a  reason: collision with root package name */
    private final Clock f4623a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4624b;

    public ConditionVariable() {
        this(Clock.f4616a);
    }

    public synchronized void a() throws InterruptedException {
        while (!this.f4624b) {
            wait();
        }
    }

    public synchronized void b() {
        boolean z2 = false;
        while (!this.f4624b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean c() {
        boolean z2;
        z2 = this.f4624b;
        this.f4624b = false;
        return z2;
    }

    public synchronized boolean d() {
        return this.f4624b;
    }

    public synchronized boolean e() {
        if (this.f4624b) {
            return false;
        }
        this.f4624b = true;
        notifyAll();
        return true;
    }

    public ConditionVariable(Clock clock) {
        this.f4623a = clock;
    }
}
