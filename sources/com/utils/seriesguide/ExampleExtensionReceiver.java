package com.utils.seriesguide;

import com.battlelancer.seriesguide.api.SeriesGuideExtension;
import com.battlelancer.seriesguide.api.SeriesGuideExtensionReceiver;

public class ExampleExtensionReceiver extends SeriesGuideExtensionReceiver {
    /* access modifiers changed from: protected */
    public Class<? extends SeriesGuideExtension> a() {
        return ExampleExtensionService.class;
    }

    /* access modifiers changed from: protected */
    public int b() {
        return 2018;
    }
}
