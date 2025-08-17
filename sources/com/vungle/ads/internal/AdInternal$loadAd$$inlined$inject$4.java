package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.downloader.Downloader;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class AdInternal$loadAd$$inlined$inject$4 extends Lambda implements Function0<Downloader> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdInternal$loadAd$$inlined$inject$4(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.vungle.ads.internal.downloader.Downloader, java.lang.Object] */
    public final Downloader invoke() {
        return ServiceLocator.Companion.getInstance(this.$context).getService(Downloader.class);
    }
}
