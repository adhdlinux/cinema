package com.facebook.imagepipeline.producers;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class DelegatingConsumer<I, O> extends BaseConsumer<I> {
    private final Consumer<O> mConsumer;

    public DelegatingConsumer(Consumer<O> consumer) {
        this.mConsumer = consumer;
    }

    public Consumer<O> getConsumer() {
        return this.mConsumer;
    }

    /* access modifiers changed from: protected */
    public void onCancellationImpl() {
        this.mConsumer.onCancellation();
    }

    /* access modifiers changed from: protected */
    public void onFailureImpl(Throwable th) {
        this.mConsumer.onFailure(th);
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdateImpl(float f2) {
        this.mConsumer.onProgressUpdate(f2);
    }
}
