package io.reactivex.internal.operators.flowable;

import com.facebook.common.time.Clock;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscription;

public enum FlowableInternalHelper$RequestMax implements Consumer<Subscription> {
    INSTANCE;

    /* renamed from: a */
    public void accept(Subscription subscription) throws Exception {
        subscription.request(Clock.MAX_TIME);
    }
}
