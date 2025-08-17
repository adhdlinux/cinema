package com.vungle.ads.internal.downloader;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDownloader f37848b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DownloadRequest f37849c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetDownloadListener f37850d;

    public /* synthetic */ a(AssetDownloader assetDownloader, DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        this.f37848b = assetDownloader;
        this.f37849c = downloadRequest;
        this.f37850d = assetDownloadListener;
    }

    public final void run() {
        AssetDownloader.m172download$lambda0(this.f37848b, this.f37849c, this.f37850d);
    }
}
