package com.chartboost.sdk.callbacks;

import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.CacheEvent;
import com.chartboost.sdk.events.ClickError;
import com.chartboost.sdk.events.ClickEvent;
import com.chartboost.sdk.events.ImpressionEvent;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.events.ShowEvent;

public interface AdCallback {
    void onAdClicked(ClickEvent clickEvent, ClickError clickError);

    void onAdLoaded(CacheEvent cacheEvent, CacheError cacheError);

    void onAdRequestedToShow(ShowEvent showEvent);

    void onAdShown(ShowEvent showEvent, ShowError showError);

    void onImpressionRecorded(ImpressionEvent impressionEvent);
}
