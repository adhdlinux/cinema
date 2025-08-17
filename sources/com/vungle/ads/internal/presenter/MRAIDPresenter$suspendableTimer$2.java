package com.vungle.ads.internal.presenter;

import com.vungle.ads.HeartbeatMissingError;
import com.vungle.ads.internal.util.SuspendableTimer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

final class MRAIDPresenter$suspendableTimer$2 extends Lambda implements Function0<SuspendableTimer> {
    final /* synthetic */ MRAIDPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MRAIDPresenter$suspendableTimer$2(MRAIDPresenter mRAIDPresenter) {
        super(0);
        this.this$0 = mRAIDPresenter;
    }

    public final SuspendableTimer invoke() {
        final MRAIDPresenter mRAIDPresenter = this.this$0;
        return new SuspendableTimer(6.0d, true, (Function0) null, new Function0<Unit>() {
            public final void invoke() {
                mRAIDPresenter.reportErrorAndCloseAd(new HeartbeatMissingError().setLogEntry$vungle_ads_release(mRAIDPresenter.getLogEntry()).logError$vungle_ads_release());
            }
        }, 4, (DefaultConstructorMarker) null);
    }
}
