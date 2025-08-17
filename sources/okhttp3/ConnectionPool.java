package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;

public final class ConnectionPool {
    private final RealConnectionPool delegate;

    public ConnectionPool(RealConnectionPool realConnectionPool) {
        Intrinsics.f(realConnectionPool, "delegate");
        this.delegate = realConnectionPool;
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i2, long j2, TimeUnit timeUnit) {
        this(new RealConnectionPool(TaskRunner.INSTANCE, i2, j2, timeUnit));
        Intrinsics.f(timeUnit, "timeUnit");
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }
}
