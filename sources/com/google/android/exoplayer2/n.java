package com.google.android.exoplayer2;

import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.Clock;
import com.google.common.base.Function;

public final /* synthetic */ class n implements Function {
    public final Object apply(Object obj) {
        return new DefaultAnalyticsCollector((Clock) obj);
    }
}
