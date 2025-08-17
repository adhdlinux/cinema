package com.vungle.ads.internal.downloader;

import com.vungle.ads.internal.downloader.AssetDownloader;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

final class AssetDownloader$okHttpClient$2 extends Lambda implements Function0<OkHttpClient> {
    final /* synthetic */ AssetDownloader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssetDownloader$okHttpClient$2(AssetDownloader assetDownloader) {
        super(0);
        this.this$0 = assetDownloader;
    }

    public final OkHttpClient invoke() {
        return AssetDownloader.OkHttpSingleton.INSTANCE.createOkHttpClient(this.this$0.pathProvider);
    }
}
