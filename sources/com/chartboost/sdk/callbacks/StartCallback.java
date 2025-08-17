package com.chartboost.sdk.callbacks;

import com.chartboost.sdk.events.StartError;

public interface StartCallback {
    void onStartCompleted(StartError startError);
}
