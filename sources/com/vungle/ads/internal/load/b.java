package com.vungle.ads.internal.load;

import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DownloadRequest;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseAdLoader f37862b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DownloadRequest f37863c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetDownloadListener.DownloadError f37864d;

    public /* synthetic */ b(BaseAdLoader baseAdLoader, DownloadRequest downloadRequest, AssetDownloadListener.DownloadError downloadError) {
        this.f37862b = baseAdLoader;
        this.f37863c = downloadRequest;
        this.f37864d = downloadError;
    }

    public final void run() {
        BaseAdLoader$assetDownloadListener$1.m180onError$lambda0(this.f37862b, this.f37863c, this.f37864d);
    }
}
