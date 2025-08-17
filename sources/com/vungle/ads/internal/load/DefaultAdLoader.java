package com.vungle.ads.internal.load;

import android.content.Context;
import com.vungle.ads.AdRetryActiveError;
import com.vungle.ads.NetworkTimeoutError;
import com.vungle.ads.NetworkUnreachable;
import com.vungle.ads.VungleAdSize;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.util.PathProvider;
import java.net.SocketTimeoutException;
import kotlin.jvm.internal.Intrinsics;

public final class DefaultAdLoader extends BaseAdLoader {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultAdLoader(Context context, VungleApiClient vungleApiClient, Executors executors, OMInjector oMInjector, Downloader downloader, PathProvider pathProvider, AdRequest adRequest) {
        super(context, vungleApiClient, executors, oMInjector, downloader, pathProvider, adRequest);
        Intrinsics.f(context, "context");
        Intrinsics.f(vungleApiClient, "vungleApiClient");
        Intrinsics.f(executors, "sdkExecutors");
        Intrinsics.f(oMInjector, "omInjector");
        Intrinsics.f(downloader, "downloader");
        Intrinsics.f(pathProvider, "pathProvider");
        Intrinsics.f(adRequest, "adRequest");
    }

    private final void fetchAdMetadata(VungleAdSize vungleAdSize, Placement placement) {
        if (getVungleApiClient().checkIsRetryAfterActive(placement.getReferenceId())) {
            onAdLoadFailed(new AdRetryActiveError().setLogEntry$vungle_ads_release(getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
            return;
        }
        Call<AdPayload> requestAd = getVungleApiClient().requestAd(placement.getReferenceId(), vungleAdSize);
        if (requestAd == null) {
            onAdLoadFailed(new NetworkUnreachable("adsCall is null").setLogEntry$vungle_ads_release(getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
        } else {
            requestAd.enqueue(new DefaultAdLoader$fetchAdMetadata$1(this, placement));
        }
    }

    /* access modifiers changed from: private */
    public final VungleError retrofitToVungleError(Throwable th) {
        String str;
        if (th instanceof SocketTimeoutException) {
            return new NetworkTimeoutError();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ads request fail: ");
        if (th != null) {
            str = th.getMessage();
        } else {
            str = null;
        }
        sb.append(str);
        return new NetworkUnreachable(sb.toString());
    }

    public void onAdLoadReady() {
    }

    /* access modifiers changed from: protected */
    public void requestAd() {
        fetchAdMetadata(getAdRequest().getRequestAdSize(), getAdRequest().getPlacement());
    }
}
