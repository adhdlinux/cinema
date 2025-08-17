package com.vungle.ads.internal.presenter;

import com.vungle.ads.internal.util.LogEntry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class MRAIDPresenter$logEntry$2 extends Lambda implements Function0<LogEntry> {
    final /* synthetic */ MRAIDPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MRAIDPresenter$logEntry$2(MRAIDPresenter mRAIDPresenter) {
        super(0);
        this.this$0 = mRAIDPresenter;
    }

    public final LogEntry invoke() {
        return this.this$0.advertisement.getLogEntry$vungle_ads_release();
    }
}
