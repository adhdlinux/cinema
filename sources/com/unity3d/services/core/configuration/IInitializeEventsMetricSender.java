package com.unity3d.services.core.configuration;

import com.unity3d.services.core.request.metrics.Metric;
import java.util.Map;

public interface IInitializeEventsMetricSender {
    Long configRequestDuration();

    void didConfigRequestEnd(boolean z2);

    void didConfigRequestStart();

    void didInitStart();

    void didPrivacyConfigRequestEnd(boolean z2);

    void didPrivacyConfigRequestStart();

    Long duration();

    Map<String, String> getRetryTags();

    Long initializationStartTimeStamp();

    void onRetryConfig();

    void onRetryWebview();

    Long privacyConfigDuration();

    void sdkDidInitialize();

    void sdkInitializeFailed(String str, ErrorState errorState);

    void sdkTokenDidBecomeAvailableWithConfig(boolean z2);

    void sendMetric(Metric metric);

    Long tokenDuration();
}
