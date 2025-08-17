package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {
    private final Consumer<T> mConsumer;
    private final ProducerContext mProducerContext;
    private final ProducerListener2 mProducerListener;
    private final String mProducerName;

    public StatefulProducerRunnable(Consumer<T> consumer, ProducerListener2 producerListener2, ProducerContext producerContext, String str) {
        this.mConsumer = consumer;
        this.mProducerListener = producerListener2;
        this.mProducerName = str;
        this.mProducerContext = producerContext;
        producerListener2.onProducerStart(producerContext, str);
    }

    /* access modifiers changed from: protected */
    public abstract void disposeResult(T t2);

    /* access modifiers changed from: protected */
    public Map<String, String> getExtraMapOnCancellation() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getExtraMapOnFailure(Exception exc) {
        return null;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getExtraMapOnSuccess(T t2) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCancellation() {
        Map<String, String> map;
        ProducerListener2 producerListener2 = this.mProducerListener;
        ProducerContext producerContext = this.mProducerContext;
        String str = this.mProducerName;
        if (producerListener2.requiresExtraMap(producerContext, str)) {
            map = getExtraMapOnCancellation();
        } else {
            map = null;
        }
        producerListener2.onProducerFinishWithCancellation(producerContext, str, map);
        this.mConsumer.onCancellation();
    }

    /* access modifiers changed from: protected */
    public void onFailure(Exception exc) {
        Map<String, String> map;
        ProducerListener2 producerListener2 = this.mProducerListener;
        ProducerContext producerContext = this.mProducerContext;
        String str = this.mProducerName;
        if (producerListener2.requiresExtraMap(producerContext, str)) {
            map = getExtraMapOnFailure(exc);
        } else {
            map = null;
        }
        producerListener2.onProducerFinishWithFailure(producerContext, str, exc, map);
        this.mConsumer.onFailure(exc);
    }

    /* access modifiers changed from: protected */
    public void onSuccess(T t2) {
        Map<String, String> map;
        ProducerListener2 producerListener2 = this.mProducerListener;
        ProducerContext producerContext = this.mProducerContext;
        String str = this.mProducerName;
        if (producerListener2.requiresExtraMap(producerContext, str)) {
            map = getExtraMapOnSuccess(t2);
        } else {
            map = null;
        }
        producerListener2.onProducerFinishWithSuccess(producerContext, str, map);
        this.mConsumer.onNewResult(t2, 1);
    }
}
