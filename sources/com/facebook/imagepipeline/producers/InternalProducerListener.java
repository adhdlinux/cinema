package com.facebook.imagepipeline.producers;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class InternalProducerListener implements ProducerListener2 {
    private final ProducerListener mProducerListener;
    private final ProducerListener2 mProducerListener2;

    public InternalProducerListener(ProducerListener producerListener, ProducerListener2 producerListener2) {
        this.mProducerListener = producerListener;
        this.mProducerListener2 = producerListener2;
    }

    public ProducerListener getProducerListener() {
        return this.mProducerListener;
    }

    public ProducerListener2 getProducerListener2() {
        return this.mProducerListener2;
    }

    public void onProducerEvent(ProducerContext producerContext, String str, String str2) {
        ProducerListener producerListener = this.mProducerListener;
        if (producerListener != null) {
            producerListener.onProducerEvent(producerContext.getId(), str, str2);
        }
        ProducerListener2 producerListener2 = this.mProducerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerEvent(producerContext, str, str2);
        }
    }

    public void onProducerFinishWithCancellation(ProducerContext producerContext, String str, Map<String, String> map) {
        ProducerListener producerListener = this.mProducerListener;
        if (producerListener != null) {
            producerListener.onProducerFinishWithCancellation(producerContext.getId(), str, map);
        }
        ProducerListener2 producerListener2 = this.mProducerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerFinishWithCancellation(producerContext, str, map);
        }
    }

    public void onProducerFinishWithFailure(ProducerContext producerContext, String str, Throwable th, Map<String, String> map) {
        ProducerListener producerListener = this.mProducerListener;
        if (producerListener != null) {
            producerListener.onProducerFinishWithFailure(producerContext.getId(), str, th, map);
        }
        ProducerListener2 producerListener2 = this.mProducerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerFinishWithFailure(producerContext, str, th, map);
        }
    }

    public void onProducerFinishWithSuccess(ProducerContext producerContext, String str, Map<String, String> map) {
        ProducerListener producerListener = this.mProducerListener;
        if (producerListener != null) {
            producerListener.onProducerFinishWithSuccess(producerContext.getId(), str, map);
        }
        ProducerListener2 producerListener2 = this.mProducerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerFinishWithSuccess(producerContext, str, map);
        }
    }

    public void onProducerStart(ProducerContext producerContext, String str) {
        ProducerListener producerListener = this.mProducerListener;
        if (producerListener != null) {
            producerListener.onProducerStart(producerContext.getId(), str);
        }
        ProducerListener2 producerListener2 = this.mProducerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerStart(producerContext, str);
        }
    }

    public void onUltimateProducerReached(ProducerContext producerContext, String str, boolean z2) {
        ProducerListener producerListener = this.mProducerListener;
        if (producerListener != null) {
            producerListener.onUltimateProducerReached(producerContext.getId(), str, z2);
        }
        ProducerListener2 producerListener2 = this.mProducerListener2;
        if (producerListener2 != null) {
            producerListener2.onUltimateProducerReached(producerContext, str, z2);
        }
    }

    public boolean requiresExtraMap(ProducerContext producerContext, String str) {
        boolean z2;
        ProducerListener2 producerListener2;
        ProducerListener producerListener = this.mProducerListener;
        if (producerListener != null) {
            z2 = producerListener.requiresExtraMap(producerContext.getId());
        } else {
            z2 = false;
        }
        if (z2 || (producerListener2 = this.mProducerListener2) == null) {
            return z2;
        }
        return producerListener2.requiresExtraMap(producerContext, str);
    }
}
