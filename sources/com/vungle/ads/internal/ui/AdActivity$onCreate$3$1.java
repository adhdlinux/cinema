package com.vungle.ads.internal.ui;

import com.vungle.ads.internal.model.UnclosedAd;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import kotlin.Lazy;

public final class AdActivity$onCreate$3$1 implements MRAIDAdWidget.CloseDelegate {
    final /* synthetic */ Lazy<SignalManager> $signalManager$delegate;
    final /* synthetic */ AdActivity this$0;

    AdActivity$onCreate$3$1(AdActivity adActivity, Lazy<SignalManager> lazy) {
        this.this$0 = adActivity;
        this.$signalManager$delegate = lazy;
    }

    public void close() {
        UnclosedAd access$getUnclosedAd$p = this.this$0.unclosedAd;
        if (access$getUnclosedAd$p != null) {
            AdActivity.m213onCreate$lambda0(this.$signalManager$delegate).removeUnclosedAd(access$getUnclosedAd$p);
        }
        this.this$0.finish();
    }
}
