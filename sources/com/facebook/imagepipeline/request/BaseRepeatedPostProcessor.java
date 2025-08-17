package com.facebook.imagepipeline.request;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public abstract class BaseRepeatedPostProcessor extends BasePostprocessor implements RepeatedPostprocessor {
    private RepeatedPostprocessorRunner mCallback;

    private synchronized RepeatedPostprocessorRunner getCallback() {
        return this.mCallback;
    }

    public synchronized void setCallback(RepeatedPostprocessorRunner repeatedPostprocessorRunner) {
        this.mCallback = repeatedPostprocessorRunner;
    }

    public void update() {
        RepeatedPostprocessorRunner callback = getCallback();
        if (callback != null) {
            callback.update();
        }
    }
}
