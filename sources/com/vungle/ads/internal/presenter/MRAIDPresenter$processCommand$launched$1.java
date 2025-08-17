package com.vungle.ads.internal.presenter;

import com.vungle.ads.LinkError;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import java.util.List;

public final class MRAIDPresenter$processCommand$launched$1 implements PresenterAdOpenCallback {
    final /* synthetic */ String $deeplinkUrl;
    final /* synthetic */ MRAIDPresenter this$0;

    MRAIDPresenter$processCommand$launched$1(String str, MRAIDPresenter mRAIDPresenter) {
        this.$deeplinkUrl = str;
        this.this$0 = mRAIDPresenter;
    }

    public void onDeeplinkClick(boolean z2) {
        if (!z2) {
            Sdk$SDKError.Reason reason = Sdk$SDKError.Reason.DEEPLINK_OPEN_FAILED;
            new LinkError(reason, "Fail to open " + this.$deeplinkUrl).setLogEntry$vungle_ads_release(this.this$0.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
        }
        List<String> tpatUrls$default = AdPayload.getTpatUrls$default(this.this$0.advertisement, Constants.DEEPLINK_CLICK, String.valueOf(z2), (String) null, 4, (Object) null);
        TpatSender tpatSender = new TpatSender(this.this$0.getVungleApiClient$vungle_ads_release(), this.this$0.getLogEntry(), this.this$0.getExecutors().getIoExecutor(), this.this$0.getPathProvider(), this.this$0.getSignalManager());
        if (tpatUrls$default != null) {
            MRAIDPresenter mRAIDPresenter = this.this$0;
            for (String sendTpat : tpatUrls$default) {
                tpatSender.sendTpat(sendTpat, mRAIDPresenter.executor);
            }
        }
    }
}
