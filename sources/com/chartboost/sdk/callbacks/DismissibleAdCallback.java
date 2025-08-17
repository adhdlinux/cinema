package com.chartboost.sdk.callbacks;

import com.chartboost.sdk.events.DismissEvent;

public interface DismissibleAdCallback extends AdCallback {
    void onAdDismiss(DismissEvent dismissEvent);
}
