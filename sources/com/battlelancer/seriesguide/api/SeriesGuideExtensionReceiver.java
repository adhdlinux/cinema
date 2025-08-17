package com.battlelancer.seriesguide.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class SeriesGuideExtensionReceiver extends BroadcastReceiver {
    /* access modifiers changed from: protected */
    public abstract Class<? extends SeriesGuideExtension> a();

    /* access modifiers changed from: protected */
    public abstract int b();

    public void onReceive(Context context, Intent intent) {
        SeriesGuideExtension.k(context, a(), b(), intent);
    }
}
