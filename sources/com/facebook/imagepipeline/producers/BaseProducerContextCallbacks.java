package com.facebook.imagepipeline.producers;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class BaseProducerContextCallbacks implements ProducerContextCallbacks {
    public void onCancellationRequested() {
    }

    public void onIsIntermediateResultExpectedChanged() {
    }

    public void onIsPrefetchChanged() {
    }

    public void onPriorityChanged() {
    }
}
