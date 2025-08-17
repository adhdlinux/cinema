package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    public final boolean offer(T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
